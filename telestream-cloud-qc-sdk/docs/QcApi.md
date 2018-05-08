# QcApi

All URIs are relative to *https://api.cloud.telestream.net/qc/v1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**cancelJob**](QcApi.md#cancelJob) | **PUT** /projects/{project_id}/jobs/{job_id}/cancel.json | 
[**createJob**](QcApi.md#createJob) | **POST** /projects/{project_id}/jobs.json | Create a new job
[**createProject**](QcApi.md#createProject) | **POST** /projects.json | Create a new project
[**getJob**](QcApi.md#getJob) | **GET** /projects/{project_id}/jobs/{job_id}.json | Get QC job
[**getProject**](QcApi.md#getProject) | **GET** /projects/{project_id}.json | Get project by Id
[**listJobs**](QcApi.md#listJobs) | **GET** /projects/{project_id}/jobs.json | Get jobs form projects
[**listProjects**](QcApi.md#listProjects) | **GET** /projects.json | List all projects for an account
[**modifyProject**](QcApi.md#modifyProject) | **PUT** /projects/{project_id}.json | Modify project
[**proxy**](QcApi.md#proxy) | **GET** /projects/{project_id}/jobs/{job_id}/proxy.json | 
[**removeJob**](QcApi.md#removeJob) | **DELETE** /projects/{project_id}/jobs/{job_id}.json | 
[**removeProject**](QcApi.md#removeProject) | **DELETE** /projects/{project_id}.json | 
[**signedUrls**](QcApi.md#signedUrls) | **GET** /projects/{project_id}/jobs/{job_id}/signed-urls.json | 
[**templates**](QcApi.md#templates) | **GET** /templates.json | List all templates
[**uploadVideo**](QcApi.md#uploadVideo) | **POST** /projects/{project_id}/upload.json | Creates an upload session


<a name="cancelJob"></a>
# **cancelJob**
> cancelJob(projectId, jobId)



### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
String jobId = "jobId_example"; // String | A unique identifier of a Job.
try {
    apiInstance.cancelJob(projectId, jobId);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#cancelJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **jobId** | **String**| A unique identifier of a Job. |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createJob"></a>
# **createJob**
> Job createJob(projectId, data)

Create a new job

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
JobData data = new JobData(); // JobData | 
try {
    Job result = apiInstance.createJob(projectId, data);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#createJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **data** | [**JobData**](JobData.md)|  |

### Return type

[**Job**](Job.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createProject"></a>
# **createProject**
> Project createProject(data)

Create a new project

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
Data data = new Data(); // Data | 
try {
    Project result = apiInstance.createProject(data);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#createProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **data** | [**Data**](Data.md)|  | [optional]

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getJob"></a>
# **getJob**
> Job getJob(projectId, jobId)

Get QC job

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
String jobId = "jobId_example"; // String | A unique identifier of a Job.
try {
    Job result = apiInstance.getJob(projectId, jobId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#getJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **jobId** | **String**| A unique identifier of a Job. |

### Return type

[**Job**](Job.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getProject"></a>
# **getProject**
> Project getProject(projectId)

Get project by Id

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
try {
    Project result = apiInstance.getProject(projectId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#getProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listJobs"></a>
# **listJobs**
> JobsCollection listJobs(projectId, expand, status, perPage, page)

Get jobs form projects

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
Boolean expand = true; // Boolean | Expand details of job
String status = "status_example"; // String | Filter jobs by status
Integer perPage = 30; // Integer | Limit number of listed jobs
Integer page = 56; // Integer | Index of jobs page to be listed
try {
    JobsCollection result = apiInstance.listJobs(projectId, expand, status, perPage, page);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#listJobs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **expand** | **Boolean**| Expand details of job | [optional]
 **status** | **String**| Filter jobs by status | [optional]
 **perPage** | **Integer**| Limit number of listed jobs | [optional] [default to 30]
 **page** | **Integer**| Index of jobs page to be listed | [optional]

### Return type

[**JobsCollection**](JobsCollection.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listProjects"></a>
# **listProjects**
> List&lt;Project&gt; listProjects()

List all projects for an account

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
try {
    List<Project> result = apiInstance.listProjects();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#listProjects");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Project&gt;**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="modifyProject"></a>
# **modifyProject**
> Project modifyProject(projectId, data)

Modify project

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | 
Data1 data = new Data1(); // Data1 | 
try {
    Project result = apiInstance.modifyProject(projectId, data);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#modifyProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**|  |
 **data** | [**Data1**](Data1.md)|  | [optional]

### Return type

[**Project**](Project.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="proxy"></a>
# **proxy**
> Proxy proxy(projectId, jobId)



### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
String jobId = "jobId_example"; // String | A unique identifier of a Job.
try {
    Proxy result = apiInstance.proxy(projectId, jobId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#proxy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **jobId** | **String**| A unique identifier of a Job. |

### Return type

[**Proxy**](Proxy.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeJob"></a>
# **removeJob**
> removeJob(projectId, jobId)



### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
String jobId = "jobId_example"; // String | A unique identifier of a Job.
try {
    apiInstance.removeJob(projectId, jobId);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#removeJob");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **jobId** | **String**| A unique identifier of a Job. |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="removeProject"></a>
# **removeProject**
> removeProject(projectId)



### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | 
try {
    apiInstance.removeProject(projectId);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#removeProject");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**|  |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="signedUrls"></a>
# **signedUrls**
> Map&lt;String, String&gt; signedUrls(projectId, jobId)



### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
String jobId = "jobId_example"; // String | A unique identifier of a Job.
try {
    Map<String, String> result = apiInstance.signedUrls(projectId, jobId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#signedUrls");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **jobId** | **String**| A unique identifier of a Job. |

### Return type

**Map&lt;String, String&gt;**

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="templates"></a>
# **templates**
> List&lt;Template&gt; templates()

List all templates

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
try {
    List<Template> result = apiInstance.templates();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#templates");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Template&gt;**](Template.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="uploadVideo"></a>
# **uploadVideo**
> UploadSession uploadVideo(projectId, videoUploadBody)

Creates an upload session

### Example
```java
// Import classes:
//import net.telestream.cloud.qc.ApiClient;
//import net.telestream.cloud.qc.ApiException;
//import net.telestream.cloud.qc.Configuration;
//import net.telestream.cloud.qc.auth.*;
//import net.telestream.cloud.qc.QcApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

QcApi apiInstance = new QcApi();
String projectId = "projectId_example"; // String | A unique identifier of a Project.
VideoUploadBody videoUploadBody = new VideoUploadBody(); // VideoUploadBody | 
try {
    UploadSession result = apiInstance.uploadVideo(projectId, videoUploadBody);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling QcApi#uploadVideo");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **projectId** | **String**| A unique identifier of a Project. |
 **videoUploadBody** | [**VideoUploadBody**](VideoUploadBody.md)|  |

### Return type

[**UploadSession**](UploadSession.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

