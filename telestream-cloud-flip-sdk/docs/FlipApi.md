# FlipApi

All URIs are relative to *https://api.cloud.telestream.net/flip/3.1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cancelEncoding**](FlipApi.md#cancelEncoding) | **POST** /encodings/{id}/cancel.json | Cancels an Encoding.
[**copyProfile**](FlipApi.md#copyProfile) | **POST** /profiles/{id}/copy.json | Copies a given Profile
[**createEncoding**](FlipApi.md#createEncoding) | **POST** /encodings.json | Creates an Encoding
[**createFactory**](FlipApi.md#createFactory) | **POST** /factories.json | Creates a new factory
[**createProfile**](FlipApi.md#createProfile) | **POST** /profiles.json | Creates a Profile
[**createVideo**](FlipApi.md#createVideo) | **POST** /videos.json | Creates a Video from a provided source_url.
[**createWorkorder**](FlipApi.md#createWorkorder) | **POST** /workorders.json | Creates a Workorder.
[**deleteEncoding**](FlipApi.md#deleteEncoding) | **DELETE** /encodings/{id}.json | Deletes an Encoding from both Telestream Cloud and your storage. Returns an information whether the operation was successful.
[**deleteProfile**](FlipApi.md#deleteProfile) | **DELETE** /profiles/{id}.json | Deletes a given Profile
[**deleteVideo**](FlipApi.md#deleteVideo) | **DELETE** /videos/{id}.json | Deletes a Video object.
[**deleteVideoSource**](FlipApi.md#deleteVideoSource) | **DELETE** /videos/{id}/source.json | Delete a video&#39;s source file.
[**encoding**](FlipApi.md#encoding) | **GET** /encodings/{id}.json | Returns an Encoding object.
[**encodings**](FlipApi.md#encodings) | **GET** /encodings.json | Returns a list of Encoding objects
[**encodingsCount**](FlipApi.md#encodingsCount) | **GET** /encodings/count.json | Returns a number of Encoding objects created using a given factory.
[**factories**](FlipApi.md#factories) | **GET** /factories.json | Returns a collection of Factory objects.
[**factory**](FlipApi.md#factory) | **GET** /factories/{id}.json | Returns a Factory object.
[**notifications**](FlipApi.md#notifications) | **GET** /notifications.json | Returns a Factory&#39;s notification settings.
[**profile**](FlipApi.md#profile) | **GET** /profiles/{id_or_name}.json | Returns a Profile object.
[**profileEncodings**](FlipApi.md#profileEncodings) | **GET** /profiles/{id_or_name}/encodings.json | Returns a list of Encodings that belong to a Profile.
[**profiles**](FlipApi.md#profiles) | **GET** /profiles.json | Returns a collection of Profile objects.
[**queuedVideos**](FlipApi.md#queuedVideos) | **GET** /videos/queued.json | Returns a collection of Video objects queued for encoding.
[**resubmitVideo**](FlipApi.md#resubmitVideo) | **POST** /videos/resubmit.json | Resubmits a video to encode.
[**retryEncoding**](FlipApi.md#retryEncoding) | **POST** /encodings/{id}/retry.json | Retries a failed encoding.
[**signedEncodingUrl**](FlipApi.md#signedEncodingUrl) | **GET** /encodings/{id}/signed-url.json | Returns a signed url pointing to an Encoding.
[**signedEncodingUrls**](FlipApi.md#signedEncodingUrls) | **GET** /encodings/{id}/signed-urls.json | Returns a list of signed urls pointing to an Encoding&#39;s outputs.
[**signedVideoUrl**](FlipApi.md#signedVideoUrl) | **GET** /videos/{id}/signed-url.json | Returns a signed url pointing to a Video.
[**toggleFactorySync**](FlipApi.md#toggleFactorySync) | **POST** /factories/{id}/sync.json | Toggles synchronisation settings.
[**updateEncoding**](FlipApi.md#updateEncoding) | **PUT** /encodings/{id}.json | Updates an Encoding
[**updateFactory**](FlipApi.md#updateFactory) | **PATCH** /factories/{id}.json | Updates a Factory&#39;s settings. Returns a Factory object.
[**updateNotifications**](FlipApi.md#updateNotifications) | **PUT** /notifications.json | Updates a Factory&#39;s notification settings.
[**updateProfile**](FlipApi.md#updateProfile) | **PUT** /profiles/{id}.json | Updates a given Profile
[**uploadVideo**](FlipApi.md#uploadVideo) | **POST** /videos/upload.json | Creates an upload session.
[**video**](FlipApi.md#video) | **GET** /videos/{id}.json | Returns a Video object.
[**videoEncodings**](FlipApi.md#videoEncodings) | **GET** /videos/{id}/encodings.json | Returns a list of Encodings that belong to a Video.
[**videoMetadata**](FlipApi.md#videoMetadata) | **GET** /videos/{id}/metadata.json | Returns a Video&#39;s metadata
[**videos**](FlipApi.md#videos) | **GET** /videos.json | Returns a collection of Video objects.
[**workflows**](FlipApi.md#workflows) | **GET** /workflows.json | Returns a collection of Workflows that belong to a Factory.


<a name="cancelEncoding"></a>
# **cancelEncoding**
> CanceledResponse cancelEncoding(id, factoryId)

Cancels an Encoding.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

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
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**CanceledResponse**](CanceledResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="copyProfile"></a>
# **copyProfile**
> Profile copyProfile(id, factoryId, copyProfileBody, expand)

Copies a given Profile

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Profile.
String factoryId = "factoryId_example"; // String | Id of a Factory.
CopyProfileBody copyProfileBody = new CopyProfileBody(); // CopyProfileBody | 
Boolean expand = true; // Boolean | If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set.
try {
    Profile result = apiInstance.copyProfile(id, factoryId, copyProfileBody, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#copyProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Profile. |
 **factoryId** | **String**| Id of a Factory. |
 **copyProfileBody** | [**CopyProfileBody**](CopyProfileBody.md)|  |
 **expand** | **Boolean**| If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set. | [optional]

### Return type

[**Profile**](Profile.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createEncoding"></a>
# **createEncoding**
> Encoding createEncoding(factoryId, createEncodingBody, screenshots, preciseStatus)

Creates an Encoding

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
CreateEncodingBody createEncodingBody = new CreateEncodingBody(); // CreateEncodingBody | 
Boolean screenshots = true; // Boolean | Determines whether the response will include screenshots. By default this is not set.
Boolean preciseStatus = true; // Boolean | Determines whether the response will include a precise status. By default this is not set.
try {
    Encoding result = apiInstance.createEncoding(factoryId, createEncodingBody, screenshots, preciseStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createEncoding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **createEncodingBody** | [**CreateEncodingBody**](CreateEncodingBody.md)|  |
 **screenshots** | **Boolean**| Determines whether the response will include screenshots. By default this is not set. | [optional]
 **preciseStatus** | **Boolean**| Determines whether the response will include a precise status. By default this is not set. | [optional]

### Return type

[**Encoding**](Encoding.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createFactory"></a>
# **createFactory**
> Factory createFactory(createFactoryBody, withStorageProvider)

Creates a new factory

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
FactoryBody createFactoryBody = new FactoryBody(); // FactoryBody | 
Boolean withStorageProvider = true; // Boolean | if set to `true`, results will include a storage provider's id
try {
    Factory result = apiInstance.createFactory(createFactoryBody, withStorageProvider);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createFactory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createFactoryBody** | [**FactoryBody**](FactoryBody.md)|  |
 **withStorageProvider** | **Boolean**| if set to &#x60;true&#x60;, results will include a storage provider&#39;s id | [optional]

### Return type

[**Factory**](Factory.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createProfile"></a>
# **createProfile**
> Profile createProfile(factoryId, createProfileBody, excludeAdvancedServices, expand)

Creates a Profile

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
ProfileBody createProfileBody = new ProfileBody(); // ProfileBody | 
Boolean excludeAdvancedServices = true; // Boolean | 
Boolean expand = true; // Boolean | If expand option is set Profile objects will contain all command parameters, even if their value is default. By default it is not set.
try {
    Profile result = apiInstance.createProfile(factoryId, createProfileBody, excludeAdvancedServices, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **createProfileBody** | [**ProfileBody**](ProfileBody.md)|  |
 **excludeAdvancedServices** | **Boolean**|  | [optional]
 **expand** | **Boolean**| If expand option is set Profile objects will contain all command parameters, even if their value is default. By default it is not set. | [optional]

### Return type

[**Profile**](Profile.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createVideo"></a>
# **createVideo**
> Video createVideo(factoryId, createVideoBody)

Creates a Video from a provided source_url.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
CreateVideoBody createVideoBody = new CreateVideoBody(); // CreateVideoBody | 
try {
    Video result = apiInstance.createVideo(factoryId, createVideoBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **createVideoBody** | [**CreateVideoBody**](CreateVideoBody.md)|  |

### Return type

[**Video**](Video.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createWorkorder"></a>
# **createWorkorder**
> createWorkorder(factoryId, profileId, file, sourceUrl)

Creates a Workorder.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
String profileId = "profileId_example"; // String | Id of a Profile.
File file = new File("/path/to/file.txt"); // File | Input file.
String sourceUrl = "sourceUrl_example"; // String | URL pointing to an input file.
try {
    apiInstance.createWorkorder(factoryId, profileId, file, sourceUrl);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#createWorkorder");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **profileId** | **String**| Id of a Profile. | [optional]
 **file** | **File**| Input file. | [optional]
 **sourceUrl** | **String**| URL pointing to an input file. | [optional]

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: multipart/form-data
 - **Accept**: application/json

<a name="deleteEncoding"></a>
# **deleteEncoding**
> DeletedResponse deleteEncoding(id, factoryId)

Deletes an Encoding from both Telestream Cloud and your storage. Returns an information whether the operation was successful.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

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
    DeletedResponse result = apiInstance.deleteEncoding(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#deleteEncoding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**DeletedResponse**](DeletedResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProfile"></a>
# **deleteProfile**
> DeletedResponse deleteProfile(id, factoryId)

Deletes a given Profile

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Profile
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    DeletedResponse result = apiInstance.deleteProfile(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#deleteProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Profile |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**DeletedResponse**](DeletedResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideo"></a>
# **deleteVideo**
> DeletedResponse deleteVideo(id, factoryId)

Deletes a Video object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    DeletedResponse result = apiInstance.deleteVideo(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#deleteVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**DeletedResponse**](DeletedResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteVideoSource"></a>
# **deleteVideoSource**
> DeletedResponse deleteVideoSource(id, factoryId)

Delete a video&#39;s source file.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    DeletedResponse result = apiInstance.deleteVideoSource(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#deleteVideoSource");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**DeletedResponse**](DeletedResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="encoding"></a>
# **encoding**
> Encoding encoding(id, factoryId, screenshots, preciseStatus)

Returns an Encoding object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of an Encoding.
String factoryId = "factoryId_example"; // String | Id of a Factory.
Boolean screenshots = true; // Boolean | Determines whether the response will include screenshots. By default this is not set.
Boolean preciseStatus = true; // Boolean | Determines whether the response will include a precise status. By default this is not set.
try {
    Encoding result = apiInstance.encoding(id, factoryId, screenshots, preciseStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#encoding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |
 **screenshots** | **Boolean**| Determines whether the response will include screenshots. By default this is not set. | [optional]
 **preciseStatus** | **Boolean**| Determines whether the response will include a precise status. By default this is not set. | [optional]

### Return type

[**Encoding**](Encoding.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="encodings"></a>
# **encodings**
> PaginatedEncodingsCollection encodings(factoryId, videoId, status, profileId, profileName, page, perPage, screenshots, preciseStatus)

Returns a list of Encoding objects

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
String videoId = "videoId_example"; // String | Id of a Video. When specified, the resulting list will contain videos that belong to the Video.
String status = "status_example"; // String | One of `success`, `fail`, `processing`. When specified, the resulting list will contain ecodings filtered by status.
String profileId = "profileId_example"; // String | Filter by profile_id.
String profileName = "profileName_example"; // String | Filter by profile_name.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
Boolean screenshots = true; // Boolean | Determines whether the response will include screenshots. By default this is not set.
Boolean preciseStatus = true; // Boolean | Determines whether the response will include a precise status. By default this is not set.
try {
    PaginatedEncodingsCollection result = apiInstance.encodings(factoryId, videoId, status, profileId, profileName, page, perPage, screenshots, preciseStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#encodings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **videoId** | **String**| Id of a Video. When specified, the resulting list will contain videos that belong to the Video. | [optional]
 **status** | **String**| One of &#x60;success&#x60;, &#x60;fail&#x60;, &#x60;processing&#x60;. When specified, the resulting list will contain ecodings filtered by status. | [optional]
 **profileId** | **String**| Filter by profile_id. | [optional]
 **profileName** | **String**| Filter by profile_name. | [optional]
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]
 **screenshots** | **Boolean**| Determines whether the response will include screenshots. By default this is not set. | [optional]
 **preciseStatus** | **Boolean**| Determines whether the response will include a precise status. By default this is not set. | [optional]

### Return type

[**PaginatedEncodingsCollection**](PaginatedEncodingsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="encodingsCount"></a>
# **encodingsCount**
> CountResponse encodingsCount(factoryId)

Returns a number of Encoding objects created using a given factory.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    CountResponse result = apiInstance.encodingsCount(factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#encodingsCount");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**CountResponse**](CountResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="factories"></a>
# **factories**
> PaginatedFactoryCollection factories(page, perPage, withStorageProvider)

Returns a collection of Factory objects.

Returns a collection of Factory objects.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
Boolean withStorageProvider = true; // Boolean | if set to `true`, results will include a storage provider's id
try {
    PaginatedFactoryCollection result = apiInstance.factories(page, perPage, withStorageProvider);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#factories");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]
 **withStorageProvider** | **Boolean**| if set to &#x60;true&#x60;, results will include a storage provider&#39;s id | [optional]

### Return type

[**PaginatedFactoryCollection**](PaginatedFactoryCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="factory"></a>
# **factory**
> Factory factory(id, withStorageProvider)

Returns a Factory object.

Returns a Factory object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | id of a factory
Boolean withStorageProvider = true; // Boolean | if set to `true`, results will include a storage provider's id
try {
    Factory result = apiInstance.factory(id, withStorageProvider);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#factory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id of a factory |
 **withStorageProvider** | **Boolean**| if set to &#x60;true&#x60;, results will include a storage provider&#39;s id | [optional]

### Return type

[**Factory**](Factory.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="notifications"></a>
# **notifications**
> CloudNotificationSettings notifications(factoryId)

Returns a Factory&#39;s notification settings.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    CloudNotificationSettings result = apiInstance.notifications(factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#notifications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**CloudNotificationSettings**](CloudNotificationSettings.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="profile"></a>
# **profile**
> Profile profile(idOrName, factoryId, expand)

Returns a Profile object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String idOrName = "idOrName_example"; // String | A name or an id of a Profile.
String factoryId = "factoryId_example"; // String | Id of a Factory.
Boolean expand = true; // Boolean | If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set.
try {
    Profile result = apiInstance.profile(idOrName, factoryId, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#profile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idOrName** | **String**| A name or an id of a Profile. |
 **factoryId** | **String**| Id of a Factory. |
 **expand** | **Boolean**| If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set. | [optional]

### Return type

[**Profile**](Profile.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="profileEncodings"></a>
# **profileEncodings**
> PaginatedEncodingsCollection profileEncodings(idOrName, factoryId)

Returns a list of Encodings that belong to a Profile.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String idOrName = "idOrName_example"; // String | Id or name of a Profile.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    PaginatedEncodingsCollection result = apiInstance.profileEncodings(idOrName, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#profileEncodings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **idOrName** | **String**| Id or name of a Profile. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**PaginatedEncodingsCollection**](PaginatedEncodingsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="profiles"></a>
# **profiles**
> PaginatedProfilesCollection profiles(factoryId, excludeAdvancedServices, expand, page, perPage)

Returns a collection of Profile objects.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
Boolean excludeAdvancedServices = true; // Boolean | Determine whether exclude Advanced Services profiles from the results. By default this is not set.
Boolean expand = true; // Boolean | If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
try {
    PaginatedProfilesCollection result = apiInstance.profiles(factoryId, excludeAdvancedServices, expand, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#profiles");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **excludeAdvancedServices** | **Boolean**| Determine whether exclude Advanced Services profiles from the results. By default this is not set. | [optional]
 **expand** | **Boolean**| If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set. | [optional]
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]

### Return type

[**PaginatedProfilesCollection**](PaginatedProfilesCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="queuedVideos"></a>
# **queuedVideos**
> PaginatedVideoCollection queuedVideos(factoryId, page, perPage)

Returns a collection of Video objects queued for encoding.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
try {
    PaginatedVideoCollection result = apiInstance.queuedVideos(factoryId, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#queuedVideos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]

### Return type

[**PaginatedVideoCollection**](PaginatedVideoCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resubmitVideo"></a>
# **resubmitVideo**
> resubmitVideo(factoryId, resubmitVideoBody)

Resubmits a video to encode.

Resubmits the video to encode. Please note that this option will work only for videos in &#x60;success&#x60; status.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
ResubmitVideoBody resubmitVideoBody = new ResubmitVideoBody(); // ResubmitVideoBody | 
try {
    apiInstance.resubmitVideo(factoryId, resubmitVideoBody);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#resubmitVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **resubmitVideoBody** | [**ResubmitVideoBody**](ResubmitVideoBody.md)|  |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="retryEncoding"></a>
# **retryEncoding**
> RetriedResponse retryEncoding(id, factoryId)

Retries a failed encoding.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

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
    RetriedResponse result = apiInstance.retryEncoding(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#retryEncoding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**RetriedResponse**](RetriedResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="signedEncodingUrl"></a>
# **signedEncodingUrl**
> EncodingSignedUrl signedEncodingUrl(id, factoryId)

Returns a signed url pointing to an Encoding.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

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
    EncodingSignedUrl result = apiInstance.signedEncodingUrl(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#signedEncodingUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**EncodingSignedUrl**](EncodingSignedUrl.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="signedEncodingUrls"></a>
# **signedEncodingUrls**
> EncodingSignedUrls signedEncodingUrls(id, factoryId)

Returns a list of signed urls pointing to an Encoding&#39;s outputs.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

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
    EncodingSignedUrls result = apiInstance.signedEncodingUrls(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#signedEncodingUrls");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**EncodingSignedUrls**](EncodingSignedUrls.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="signedVideoUrl"></a>
# **signedVideoUrl**
> SignedVideoUrl signedVideoUrl(id, factoryId)

Returns a signed url pointing to a Video.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    SignedVideoUrl result = apiInstance.signedVideoUrl(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#signedVideoUrl");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**SignedVideoUrl**](SignedVideoUrl.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="toggleFactorySync"></a>
# **toggleFactorySync**
> FactorySync toggleFactorySync(id, factorySyncBody)

Toggles synchronisation settings.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | id of the factory
FactorySyncBody factorySyncBody = new FactorySyncBody(); // FactorySyncBody | 
try {
    FactorySync result = apiInstance.toggleFactorySync(id, factorySyncBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#toggleFactorySync");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id of the factory |
 **factorySyncBody** | [**FactorySyncBody**](FactorySyncBody.md)|  |

### Return type

[**FactorySync**](FactorySync.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateEncoding"></a>
# **updateEncoding**
> Encoding updateEncoding(id, factoryId, updateEncodingBody, screenshots, preciseStatus)

Updates an Encoding

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of an Encoding.
String factoryId = "factoryId_example"; // String | Id of a Factory.
UpdateEncodingBody updateEncodingBody = new UpdateEncodingBody(); // UpdateEncodingBody | 
Boolean screenshots = true; // Boolean | Determines whether the response will include screenshots. By default this is not set.
Boolean preciseStatus = true; // Boolean | Determines whether the response will include a precise status. By default this is not set.
try {
    Encoding result = apiInstance.updateEncoding(id, factoryId, updateEncodingBody, screenshots, preciseStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#updateEncoding");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of an Encoding. |
 **factoryId** | **String**| Id of a Factory. |
 **updateEncodingBody** | [**UpdateEncodingBody**](UpdateEncodingBody.md)|  |
 **screenshots** | **Boolean**| Determines whether the response will include screenshots. By default this is not set. | [optional]
 **preciseStatus** | **Boolean**| Determines whether the response will include a precise status. By default this is not set. | [optional]

### Return type

[**Encoding**](Encoding.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateFactory"></a>
# **updateFactory**
> Factory updateFactory(id, updateFactoryBody, withStorageProvider)

Updates a Factory&#39;s settings. Returns a Factory object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | id of the factory
FactoryBody updateFactoryBody = new FactoryBody(); // FactoryBody | 
Boolean withStorageProvider = true; // Boolean | if set to `true`, results will include a storage provider's id
try {
    Factory result = apiInstance.updateFactory(id, updateFactoryBody, withStorageProvider);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#updateFactory");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id of the factory |
 **updateFactoryBody** | [**FactoryBody**](FactoryBody.md)|  |
 **withStorageProvider** | **Boolean**| if set to &#x60;true&#x60;, results will include a storage provider&#39;s id | [optional]

### Return type

[**Factory**](Factory.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateNotifications"></a>
# **updateNotifications**
> CloudNotificationSettings updateNotifications(factoryId, cloudNotificationSettingsBody)

Updates a Factory&#39;s notification settings.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
CloudNotificationSettings cloudNotificationSettingsBody = new CloudNotificationSettings(); // CloudNotificationSettings | 
try {
    CloudNotificationSettings result = apiInstance.updateNotifications(factoryId, cloudNotificationSettingsBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#updateNotifications");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **cloudNotificationSettingsBody** | [**CloudNotificationSettings**](CloudNotificationSettings.md)|  |

### Return type

[**CloudNotificationSettings**](CloudNotificationSettings.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateProfile"></a>
# **updateProfile**
> Profile updateProfile(id, factoryId, updateProfileBody, excludeAdvancedServices, expand)

Updates a given Profile

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | 
String factoryId = "factoryId_example"; // String | Id of a Factory.
ProfileBody updateProfileBody = new ProfileBody(); // ProfileBody | 
Boolean excludeAdvancedServices = true; // Boolean | 
Boolean expand = true; // Boolean | If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set.
try {
    Profile result = apiInstance.updateProfile(id, factoryId, updateProfileBody, excludeAdvancedServices, expand);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#updateProfile");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **factoryId** | **String**| Id of a Factory. |
 **updateProfileBody** | [**ProfileBody**](ProfileBody.md)|  |
 **excludeAdvancedServices** | **Boolean**|  | [optional]
 **expand** | **Boolean**| If expand option is set Profile objects will contain all command parameters, even if their value is default. By default this is not set. | [optional]

### Return type

[**Profile**](Profile.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadVideo"></a>
# **uploadVideo**
> UploadSession uploadVideo(factoryId, videoUploadBody)

Creates an upload session.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
VideoUploadBody videoUploadBody = new VideoUploadBody(); // VideoUploadBody | 
try {
    UploadSession result = apiInstance.uploadVideo(factoryId, videoUploadBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#uploadVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **videoUploadBody** | [**VideoUploadBody**](VideoUploadBody.md)|  |

### Return type

[**UploadSession**](UploadSession.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="video"></a>
# **video**
> Video video(id, factoryId)

Returns a Video object.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    Video result = apiInstance.video(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#video");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**Video**](Video.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="videoEncodings"></a>
# **videoEncodings**
> PaginatedEncodingsCollection videoEncodings(id, factoryId, page, perPage, screenshots, preciseStatus)

Returns a list of Encodings that belong to a Video.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
Boolean screenshots = true; // Boolean | Determines whether the response will include screenshots. By default this is not set.
Boolean preciseStatus = true; // Boolean | Determines whether the response will include a precise status. By default this is not set.
try {
    PaginatedEncodingsCollection result = apiInstance.videoEncodings(id, factoryId, page, perPage, screenshots, preciseStatus);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#videoEncodings");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]
 **screenshots** | **Boolean**| Determines whether the response will include screenshots. By default this is not set. | [optional]
 **preciseStatus** | **Boolean**| Determines whether the response will include a precise status. By default this is not set. | [optional]

### Return type

[**PaginatedEncodingsCollection**](PaginatedEncodingsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="videoMetadata"></a>
# **videoMetadata**
> VideoMetadata videoMetadata(id, factoryId)

Returns a Video&#39;s metadata

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String id = "id_example"; // String | Id of a Video.
String factoryId = "factoryId_example"; // String | Id of a Factory.
try {
    VideoMetadata result = apiInstance.videoMetadata(id, factoryId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#videoMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Id of a Video. |
 **factoryId** | **String**| Id of a Factory. |

### Return type

[**VideoMetadata**](VideoMetadata.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="videos"></a>
# **videos**
> PaginatedVideoCollection videos(factoryId, page, perPage)

Returns a collection of Video objects.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
try {
    PaginatedVideoCollection result = apiInstance.videos(factoryId, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#videos");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]

### Return type

[**PaginatedVideoCollection**](PaginatedVideoCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="workflows"></a>
# **workflows**
> PaginatedWorkflowsCollection workflows(factoryId, page, perPage)

Returns a collection of Workflows that belong to a Factory.

### Example
```java
// Import classes:
//import net.telestream.cloud.flip.ApiClient;
//import net.telestream.cloud.flip.ApiException;
//import net.telestream.cloud.flip.Configuration;
//import net.telestream.cloud.flip.auth.*;
//import net.telestream.cloud.flip.FlipApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

FlipApi apiInstance = new FlipApi();
String factoryId = "factoryId_example"; // String | Id of a Factory.
Integer page = 56; // Integer | A page to be fetched. Default is `1`.
Integer perPage = 56; // Integer | A number of results per page. Default is `100`.
try {
    PaginatedWorkflowsCollection result = apiInstance.workflows(factoryId, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling FlipApi#workflows");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **factoryId** | **String**| Id of a Factory. |
 **page** | **Integer**| A page to be fetched. Default is &#x60;1&#x60;. | [optional]
 **perPage** | **Integer**| A number of results per page. Default is &#x60;100&#x60;. | [optional]

### Return type

[**PaginatedWorkflowsCollection**](PaginatedWorkflowsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

