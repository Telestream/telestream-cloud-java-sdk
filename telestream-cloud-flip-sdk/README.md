# Telestream Cloud Java SDK
This library provides a low-level interface to the REST API of Telestream Cloud, the online video encoding service.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Getting Started
```java
ApiClient defaultClient = Configuration.getDefaultApiClient();
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("tcs_api_key");

FlipApi apiInstance = new FlipApi();

factoryId = "factoryId";


// Upload video
HashMap<String, ArrayList<String>> extraFiles = new HashMap<String, ArrayList<String>>();
ArrayList<String> subtitles = new ArrayList<String>();
subtitles.add("path/to/subtitles.srt");
extraFiles.put("subtitles", subtitles);

Uploader uploader = new Uploader(apiInstance, factoryId, "path/to/movie.mp4", "h264", extraFiles);
uploader.setup();
uploader.start();


// POST videos
CreateVideoBody createVideoBody = new CreateVideoBody();
createVideoBody.setSourceUrl("sourceurl.test/video.mp4");
createVideoBody.setProfiles("h264");

List<String> subtitles = new ArrayList<>();
subtitles.add("sourceurl.test/subtitles.srt");
createVideoBody.setSubtitleFiles(subtitles);

try {
    Video video = apiInstance.createVideo(factoryId, createVideoBody);
    System.out.println(video);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createVideo");
    e.printStackTrace();
}


// POST profiles
ProfileBody createProfileBody = new ProfileBody();
createProfileBody.setPresetName(ProfileBody.PresetNameEnum.H264_BASELINE);
createProfileBody.setAudioBitrate(100);
createProfileBody.setAudioCodec("ogg");

excludeAdvancedServices = true;
expand = true;

try {
   Profile createdProfile = apiInstance.createProfile(factoryId, createProfileBody, excludeAdvancedServices, expand);
   System.out.println(createdProfile);
} catch (ApiException e) {
   System.err.println("Exception when calling FlipApi#createProfile");
   e.printStackTrace();
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/flip/3.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FlipApi* | [**cancelEncoding**](docs/FlipApi.md#cancelEncoding) | **POST** /encodings/{id}/cancel.json | Cancels an Encoding.
*FlipApi* | [**cancelVideo**](docs/FlipApi.md#cancelVideo) | **POST** /videos/{id}/cancel.json | Cancel video and all encodings
*FlipApi* | [**copyProfile**](docs/FlipApi.md#copyProfile) | **POST** /profiles/{id}/copy.json | Copies a given Profile
*FlipApi* | [**createEncoding**](docs/FlipApi.md#createEncoding) | **POST** /encodings.json | Creates an Encoding
*FlipApi* | [**createFactory**](docs/FlipApi.md#createFactory) | **POST** /factories.json | Creates a new factory
*FlipApi* | [**createProfile**](docs/FlipApi.md#createProfile) | **POST** /profiles.json | Creates a Profile
*FlipApi* | [**createVideo**](docs/FlipApi.md#createVideo) | **POST** /videos.json | Creates a Video from a provided source_url.
*FlipApi* | [**createWorkorder**](docs/FlipApi.md#createWorkorder) | **POST** /workorders.json | Creates a Workorder.
*FlipApi* | [**deleteEncoding**](docs/FlipApi.md#deleteEncoding) | **DELETE** /encodings/{id}.json | Deletes an Encoding from both Telestream Cloud and your storage. Returns an information whether the operation was successful.
*FlipApi* | [**deleteProfile**](docs/FlipApi.md#deleteProfile) | **DELETE** /profiles/{id}.json | Deletes a given Profile
*FlipApi* | [**deleteVideo**](docs/FlipApi.md#deleteVideo) | **DELETE** /videos/{id}.json | Deletes a Video object.
*FlipApi* | [**deleteVideoSource**](docs/FlipApi.md#deleteVideoSource) | **DELETE** /videos/{id}/source.json | Delete a video&#39;s source file.
*FlipApi* | [**encoding**](docs/FlipApi.md#encoding) | **GET** /encodings/{id}.json | Returns an Encoding object.
*FlipApi* | [**encodings**](docs/FlipApi.md#encodings) | **GET** /encodings.json | Returns a list of Encoding objects
*FlipApi* | [**encodingsCount**](docs/FlipApi.md#encodingsCount) | **GET** /encodings/count.json | Returns a number of Encoding objects created using a given factory.
*FlipApi* | [**factories**](docs/FlipApi.md#factories) | **GET** /factories.json | Returns a collection of Factory objects.
*FlipApi* | [**factory**](docs/FlipApi.md#factory) | **GET** /factories/{id}.json | Returns a Factory object.
*FlipApi* | [**notifications**](docs/FlipApi.md#notifications) | **GET** /notifications.json | Returns a Factory&#39;s notification settings.
*FlipApi* | [**profile**](docs/FlipApi.md#profile) | **GET** /profiles/{id_or_name}.json | Returns a Profile object.
*FlipApi* | [**profileEncodings**](docs/FlipApi.md#profileEncodings) | **GET** /profiles/{id_or_name}/encodings.json | Returns a list of Encodings that belong to a Profile.
*FlipApi* | [**profiles**](docs/FlipApi.md#profiles) | **GET** /profiles.json | Returns a collection of Profile objects.
*FlipApi* | [**queuedVideos**](docs/FlipApi.md#queuedVideos) | **GET** /videos/queued.json | Returns a collection of Video objects queued for encoding.
*FlipApi* | [**resubmitVideo**](docs/FlipApi.md#resubmitVideo) | **POST** /videos/resubmit.json | Resubmits a video to encode.
*FlipApi* | [**retryEncoding**](docs/FlipApi.md#retryEncoding) | **POST** /encodings/{id}/retry.json | Retries a failed encoding.
*FlipApi* | [**signedEncodingUrl**](docs/FlipApi.md#signedEncodingUrl) | **GET** /encodings/{id}/signed-url.json | Returns a signed url pointing to an Encoding.
*FlipApi* | [**signedEncodingUrls**](docs/FlipApi.md#signedEncodingUrls) | **GET** /encodings/{id}/signed-urls.json | Returns a list of signed urls pointing to an Encoding&#39;s outputs.
*FlipApi* | [**signedVideoUrl**](docs/FlipApi.md#signedVideoUrl) | **GET** /videos/{id}/signed-url.json | Returns a signed url pointing to a Video.
*FlipApi* | [**toggleFactorySync**](docs/FlipApi.md#toggleFactorySync) | **POST** /factories/{id}/sync.json | Toggles synchronisation settings.
*FlipApi* | [**updateEncoding**](docs/FlipApi.md#updateEncoding) | **PUT** /encodings/{id}.json | Updates an Encoding
*FlipApi* | [**updateFactory**](docs/FlipApi.md#updateFactory) | **PATCH** /factories/{id}.json | Updates a Factory&#39;s settings. Returns a Factory object.
*FlipApi* | [**updateNotifications**](docs/FlipApi.md#updateNotifications) | **PUT** /notifications.json | Updates a Factory&#39;s notification settings.
*FlipApi* | [**updateProfile**](docs/FlipApi.md#updateProfile) | **PUT** /profiles/{id}.json | Updates a given Profile
*FlipApi* | [**uploadVideo**](docs/FlipApi.md#uploadVideo) | **POST** /videos/upload.json | Creates an upload session.
*FlipApi* | [**video**](docs/FlipApi.md#video) | **GET** /videos/{id}.json | Returns a Video object.
*FlipApi* | [**videoEncodings**](docs/FlipApi.md#videoEncodings) | **GET** /videos/{id}/encodings.json | Returns a list of Encodings that belong to a Video.
*FlipApi* | [**videoMetadata**](docs/FlipApi.md#videoMetadata) | **GET** /videos/{id}/metadata.json | Returns a Video&#39;s metadata
*FlipApi* | [**videos**](docs/FlipApi.md#videos) | **GET** /videos.json | Returns a collection of Video objects.
*FlipApi* | [**workflows**](docs/FlipApi.md#workflows) | **GET** /workflows.json | Returns a collection of Workflows that belong to a Factory.


## Documentation for Models

 - [CanceledResponse](docs/CanceledResponse.md)
 - [CloudNotificationSettings](docs/CloudNotificationSettings.md)
 - [CloudNotificationSettingsEvents](docs/CloudNotificationSettingsEvents.md)
 - [CopyProfileBody](docs/CopyProfileBody.md)
 - [CountResponse](docs/CountResponse.md)
 - [CreateEncodingBody](docs/CreateEncodingBody.md)
 - [CreateVideoBody](docs/CreateVideoBody.md)
 - [DeletedResponse](docs/DeletedResponse.md)
 - [Encoding](docs/Encoding.md)
 - [EncodingSignedUrl](docs/EncodingSignedUrl.md)
 - [EncodingSignedUrls](docs/EncodingSignedUrls.md)
 - [Error](docs/Error.md)
 - [ExtraFile](docs/ExtraFile.md)
 - [Factory](docs/Factory.md)
 - [FactoryBody](docs/FactoryBody.md)
 - [FactoryBodyStorageCredentialAttributes](docs/FactoryBodyStorageCredentialAttributes.md)
 - [FactorySync](docs/FactorySync.md)
 - [FactorySyncBody](docs/FactorySyncBody.md)
 - [PaginatedEncodingsCollection](docs/PaginatedEncodingsCollection.md)
 - [PaginatedFactoryCollection](docs/PaginatedFactoryCollection.md)
 - [PaginatedProfilesCollection](docs/PaginatedProfilesCollection.md)
 - [PaginatedVideoCollection](docs/PaginatedVideoCollection.md)
 - [PaginatedWorkflowsCollection](docs/PaginatedWorkflowsCollection.md)
 - [Profile](docs/Profile.md)
 - [ProfileBody](docs/ProfileBody.md)
 - [ResubmitVideoBody](docs/ResubmitVideoBody.md)
 - [RetriedResponse](docs/RetriedResponse.md)
 - [SignedVideoUrl](docs/SignedVideoUrl.md)
 - [UpdateEncodingBody](docs/UpdateEncodingBody.md)
 - [UploadSession](docs/UploadSession.md)
 - [Video](docs/Video.md)
 - [VideoExtraFile](docs/VideoExtraFile.md)
 - [VideoMetadata](docs/VideoMetadata.md)
 - [VideoUploadBody](docs/VideoUploadBody.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### api_key

- **Type**: API key
- **API key parameter name**: X-Api-Key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

cloudsupport@telestream.net

