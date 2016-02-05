Telestream Cloud Java SDK
====================

This library provides a low-level interface to the REST API of [**Telestream Cloud**](http://cloud.telestream.net), the online video encoding service.

Usage
-----
You need to initialize TelestreamCloud client instance with your credentials (you can obtain them from your account in [**Telestream Cloud console**](https://cloud.telestream.net/console/login)).

```java
TelestreamCloud tc = new TelestreamCloud("your-access-key", "your-secret-key");
```

Now you need to specify which resource you would like to use. Currently supported resources are:
* `Flip`
* additional resources will be available soon, stay tuned ;)

```java
Flip flip = (Flip) tc.getResource(TelestreamCloud.ResourceType.FLIP);
```

Services
-------

In order to access Telestream data, objects called "services" are being used.

The main services are:
* `FactoryService`
* `VideoService`
* `EncodingService`
* `ProfileService`

All Services can be used to:

* get all coresponding objects
```java
List<Factory> factories = factoryService.all();
Factory factory = factoryService.find("factory-id");

List<Video> videos = videoService.all();
Video video = videoService.find("video-id");

List<Encoding> encodings = encodingService.all();
Encoding encoding = encodingService.find("encoding-id");

List<Profile> profiles = profileService.all();
Profile profile = profileService.find("profile-id");
```

* find an object by id
```java
Factory factory = factoryService.find("factory-id");
Video video = videoService.find("video-id");
Encoding encoding = encodingService.find("encoding-id");
Profile profile = profileService.find("profile-id");
```

* create object
```java
factoryService.create(mapWithData);
videoService.create(mapWithData);
encodingService.create(mapWithData);
profileService.create(mapWithData);
```

* delete object
```java
factoryService.delete("factory-id");
videoService.delete("video-id");
encodingService.delete("encoding-id");
profileService.delete("profile-id");
```

FactoryService
-------

The easiest way to get `FactoryService` is to use `Flip` resource:

```java
Flip flip = (Flip) tc.getResource(TelestreamCloud.ResourceType.FLIP);
FactoryService factoryService = flip.factoryService();
```

FactoryService can be used in many ways:

```java
// Update Factory
Factory factory = factoryService.all().get(0);
factory.setName("New name");
factory.setUploadOriginalVideo(true);
factoryService.save(factory);

// Get Notifications
Notifications notifications = factoryService.getNotifications(factory.getId());

// Update Notifications
notifications.enableForVideoCreated(true);
notifications.enableForVideoEncoded(true);
notifications.enableForEncodingProgress(true);
notifications.enableForEncodingCompleted(true);
notifications.setDelay(delay);
notifications.setUrl(url);
factoryService.updateNotifications(factory.getId(), notifications);

// Get Factory's VideoService
VideoService videoService = factoryService.videoService(factory.getId());

// Get Factory's EncodingService
EncodingService encodingService = factoryService.encodingService(factory.getId());

// Get Factory's ProfileService
ProfileService profileService = factoryService.profileService(factory.getId());
```

VideoService
-------

`VideoService` can be used in many ways:

```java
// Delete source file
videoService.deleteSourceFile("video-id");

// Get metadata
String metadata = videoService.getMetadata("video-id");

// Get Video's encoding service
EncodingService encodingService = videoService.encodingService("video-id");
```

ProfileService
-------

```java
// Update profile
Profile profile = profileService.find("profile-id");
profile.setName("aspect-mode-name");
profile.setFps(29.97f);
profile.setPresetName("h264");
profileService.save(profile);
```

EncodingService
-------

```java
// Cancel encoding
encodingService.cancel("encoding-id");

// Retry encoding
encodingService.retry("encoding-id");
```

REST API Examples
----------------

`TelestreamCloud` object can be used in a RESTful manner;

```java
TelestreamCloud tc = new TelestreamCloud(ACCESS_KEY, SECRET_KEY);
List<Video> videos = tc.getVideos("factory-id");
Profile profile = tc.getProfile("factory-id", "profile-id");
Encoding newEncoding = tc.createEncoding("factory-id", dataMap);
tc.deleteVideo("factory-id", "video-id");
```

Resumable uploads
---------------------

You can upload a local video using `videoService.create()`. It will attempt to upload the entire file using a single POST request. This is not the best solution for big files, because if the connections brakes right when you reach 95% mark, the entire upload process fails.
This is where reasumable uploads come in handy. First you need create a session object using `factoryService.initUploadSession()`. You can start uploading using `start()` method. If the connection brakes, an exception will be raised. You can decide what to do with your session object using `abort()` or `resume()` methods. Current status of the process will be stored in `status` attribute and can have one of following values:
* `initialized` - session ready to start
* `uploading` - upload started
* `error` - something went wrong. You can see the details using `error_message` attribute
* `uploaded` - upload completed
* `aborted` - upload canceled
* `interrupted` - stopped by user during an interactive session

Usage example:

```java
int retryCount = 0;
try {
    uploadSession.start();
} catch (IOException ioException) {
    while (retryCount < 5 && uploadSession.getUploadStatus() != UploadSession.UploadStatus.UPLOADED) {
        try {
            Thread.sleep(5000);
            uploadSession.resume();
        } catch (Exception exception) {
            retryCount++;
        }
    }
}
```

Generating signatures
---------------------

All requests to your Telestream Cloud are signed using HMAC-SHA256, based on a timestamp and your secret key. This is handled transparently. However, sometimes you will want to generate only this signature, in order to make a request by means other than this library. This is the case when using the [JavaScript panda_uploader](https://github.com/pandastream/panda_uploader).

To do this, a method `signedParams()` is provided:

```java
TelestreamCloud tc = new TelestreamCloud(ACCESS_KEY, SECRET_KEY);
String signedParams = tc.signedParams("POST", "/videos.json");

// => {'access_key': '8df50af4-074f-11df-b278-1231350015b1',
// 'factory_id': 'your-factory-id',
// 'signature': 'LejCdm0O83+jk6/Q5SfGmk14WTO1pB6Sh6Z5eA2w5C0=',
// 'timestamp': '2010-02-26T15:01:46.221513'}
```
