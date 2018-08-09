# TtsApi

All URIs are relative to *https://api.cloud.telestream.net/tts/v1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**corpora**](TtsApi.md#corpora) | **GET** /projects/{projectID}/corpora | Returns a collection of Corpora
[**corpus**](TtsApi.md#corpus) | **GET** /projects/{projectID}/corpora/{name} | Returns the Corpus
[**createCorpus**](TtsApi.md#createCorpus) | **POST** /projects/{projectID}/corpora/{name} | Creates a new Corpus
[**createJob**](TtsApi.md#createJob) | **POST** /projects/{projectID}/jobs | Creates a new Job
[**createProject**](TtsApi.md#createProject) | **POST** /projects | Creates a new Project
[**deleteCorpus**](TtsApi.md#deleteCorpus) | **DELETE** /projects/{projectID}/corpora/{name} | Creates a new Corpus
[**deleteJob**](TtsApi.md#deleteJob) | **DELETE** /projects/{projectID}/jobs/{jobID} | Deletes the Job
[**deleteProject**](TtsApi.md#deleteProject) | **DELETE** /projects/{projectID} | Deletes the Project
[**job**](TtsApi.md#job) | **GET** /projects/{projectID}/jobs/{jobID} | Returns the Job
[**jobOutputs**](TtsApi.md#jobOutputs) | **GET** /projects/{projectID}/jobs/{jobID}/outputs | Returns the Job Outputs
[**jobResult**](TtsApi.md#jobResult) | **GET** /projects/{projectID}/jobs/{jobID}/result | Returns the Job Result
[**jobs**](TtsApi.md#jobs) | **GET** /projects/{projectID}/jobs | Returns a collection of Jobs
[**project**](TtsApi.md#project) | **GET** /projects/{projectID} | Returns the Project
[**projects**](TtsApi.md#projects) | **GET** /projects | Returns a collection of Projects
[**trainProject**](TtsApi.md#trainProject) | **POST** /projects/{projectID}/train | Queues training
[**updateProject**](TtsApi.md#updateProject) | **PUT** /projects/{projectID} | Updates an existing Project
[**uploadVideo**](TtsApi.md#uploadVideo) | **POST** /projects/{projectID}/jobs/upload | Creates an upload session


<a name="corpora"></a>
# **corpora**
> CorporaCollection corpora(projectID)

Returns a collection of Corpora

Returns a collection of Corpora

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
try {
    CorporaCollection result = apiInstance.corpora(projectID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#corpora");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |

### Return type

[**CorporaCollection**](CorporaCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="corpus"></a>
# **corpus**
> Corpus corpus(projectID, name)

Returns the Corpus

Returns the Corpus

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String name = "name_example"; // String | Corpus name
try {
    Corpus result = apiInstance.corpus(projectID, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#corpus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **name** | **String**| Corpus name |

### Return type

[**Corpus**](Corpus.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createCorpus"></a>
# **createCorpus**
> createCorpus(projectID, name, body)

Creates a new Corpus

Creates a new Corpus

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String name = "name_example"; // String | Corpus name
String body = "body_example"; // String | 
try {
    apiInstance.createCorpus(projectID, name, body);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#createCorpus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **name** | **String**| Corpus name |
 **body** | **String**|  |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: application/json

<a name="createJob"></a>
# **createJob**
> Job createJob(projectID, job)

Creates a new Job

Creates a new Job

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
Job job = new Job(); // Job | 
try {
    Job result = apiInstance.createJob(projectID, job);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#createJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **job** | [**Job**](Job.md)|  |

### Return type

[**Job**](Job.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createProject"></a>
# **createProject**
> Project createProject(project)

Creates a new Project

Creates a new Project

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
Project project = new Project(); // Project | 
try {
    Project result = apiInstance.createProject(project);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#createProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project** | [**Project**](Project.md)|  |

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteCorpus"></a>
# **deleteCorpus**
> deleteCorpus(projectID, name)

Creates a new Corpus

Creates a new Corpus

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String name = "name_example"; // String | Corpus name
try {
    apiInstance.deleteCorpus(projectID, name);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#deleteCorpus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **name** | **String**| Corpus name |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteJob"></a>
# **deleteJob**
> deleteJob(projectID, jobID)

Deletes the Job

Deletes the Job

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String jobID = "jobID_example"; // String | 
try {
    apiInstance.deleteJob(projectID, jobID);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#deleteJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **jobID** | **String**|  |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteProject"></a>
# **deleteProject**
> deleteProject()

Deletes the Project

Deletes the Project

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
try {
    apiInstance.deleteProject();
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#deleteProject");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="job"></a>
# **job**
> Job job(projectID, jobID)

Returns the Job

Returns the Job

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String jobID = "jobID_example"; // String | 
try {
    Job result = apiInstance.job(projectID, jobID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#job");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **jobID** | **String**|  |

### Return type

[**Job**](Job.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jobOutputs"></a>
# **jobOutputs**
> List&lt;JobOutput&gt; jobOutputs(projectID, jobID)

Returns the Job Outputs

Returns the Job Outputs

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String jobID = "jobID_example"; // String | 
try {
    List<JobOutput> result = apiInstance.jobOutputs(projectID, jobID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#jobOutputs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **jobID** | **String**|  |

### Return type

[**List&lt;JobOutput&gt;**](JobOutput.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jobResult"></a>
# **jobResult**
> JobResult jobResult(projectID, jobID)

Returns the Job Result

Returns the Job Result

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
String jobID = "jobID_example"; // String | 
try {
    JobResult result = apiInstance.jobResult(projectID, jobID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#jobResult");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **jobID** | **String**|  |

### Return type

[**JobResult**](JobResult.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="jobs"></a>
# **jobs**
> JobsCollection jobs(projectID, page, perPage)

Returns a collection of Jobs

Returns a collection of Jobs

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
Integer page = 56; // Integer | page number
Integer perPage = 56; // Integer | number of records per page
try {
    JobsCollection result = apiInstance.jobs(projectID, page, perPage);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#jobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **page** | **Integer**| page number | [optional]
 **perPage** | **Integer**| number of records per page | [optional]

### Return type

[**JobsCollection**](JobsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="project"></a>
# **project**
> Project project(projectID)

Returns the Project

Returns the Project

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
try {
    Project result = apiInstance.project(projectID);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#project");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="projects"></a>
# **projects**
> ProjectsCollection projects()

Returns a collection of Projects

Returns a collection of Projects

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
try {
    ProjectsCollection result = apiInstance.projects();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#projects");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**ProjectsCollection**](ProjectsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="trainProject"></a>
# **trainProject**
> trainProject(projectID)

Queues training

Queues training

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
try {
    apiInstance.trainProject(projectID);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#trainProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateProject"></a>
# **updateProject**
> Project updateProject(project)

Updates an existing Project

Updates an existing Project

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
Project project = new Project(); // Project | 
try {
    Project result = apiInstance.updateProject(project);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#updateProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **project** | [**Project**](Project.md)|  |

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadVideo"></a>
# **uploadVideo**
> UploadSession uploadVideo(projectID, videoUploadBody)

Creates an upload session

### Example
```java
// Import classes:
//import net.telestream.cloud.tts.ApiClient;
//import net.telestream.cloud.tts.ApiException;
//import net.telestream.cloud.tts.Configuration;
//import net.telestream.cloud.tts.auth.*;
//import net.telestream.cloud.tts.TtsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

TtsApi apiInstance = new TtsApi();
String projectID = "projectID_example"; // String | ID of the Project
VideoUploadBody videoUploadBody = new VideoUploadBody(); // VideoUploadBody | 
try {
    UploadSession result = apiInstance.uploadVideo(projectID, videoUploadBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TtsApi#uploadVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectID** | **String**| ID of the Project |
 **videoUploadBody** | [**VideoUploadBody**](VideoUploadBody.md)|  |

### Return type

[**UploadSession**](UploadSession.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

