# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import net.telestream.cloud.flip.*;
import net.telestream.cloud.flip.auth.*;
import net.telestream.cloud.flip.*;
import net.telestream.cloud.flip.FlipApi;

import java.io.File;
import java.util.*;

public class FlipApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: api_key
        ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
        api_key.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //api_key.setApiKeyPrefix("Token");

        FlipApi apiInstance = new FlipApi();
        String id = "id_example"; // String | Id of an Encoding.
        String factoryId = "factoryId_example"; // String | Id of a Factory.
        try {
            CanceledResponse result = apiInstance.cancelEncoding(id, factoryId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling FlipApi#cancelEncoding");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/api/flip/3.1*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*FlipApi* | [**cancelEncoding**](docs/FlipApi.md#cancelEncoding) | **POST** /encodings/{id}/cancel.json | Cancels an Encoding.
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

