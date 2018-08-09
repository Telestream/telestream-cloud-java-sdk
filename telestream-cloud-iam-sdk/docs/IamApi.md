# IamApi

All URIs are relative to *https://api.cloud.telestream.net/iam/v1.0/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**deleteCredential**](IamApi.md#deleteCredential) | **DELETE** /credentials/{id} | 
[**getCredential**](IamApi.md#getCredential) | **GET** /credentials/{id} | 
[**getCredentials**](IamApi.md#getCredentials) | **GET** /credentials | 
[**getPolicy**](IamApi.md#getPolicy) | **POST** /credentials/policy | 
[**postCredentials**](IamApi.md#postCredentials) | **POST** /credentials | 
[**updateCredential**](IamApi.md#updateCredential) | **PATCH** /credentials/{id} | 


<a name="deleteCredential"></a>
# **deleteCredential**
> deleteCredential(id)



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
String id = "id_example"; // String | 
try {
    apiInstance.deleteCredential(id);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#deleteCredential");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

null (empty response body)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCredential"></a>
# **getCredential**
> Credential getCredential(id)



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
String id = "id_example"; // String | 
try {
    Credential result = apiInstance.getCredential(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#getCredential");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**Credential**](Credential.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getCredentials"></a>
# **getCredentials**
> CredentialsResponse getCredentials()



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
try {
    CredentialsResponse result = apiInstance.getCredentials();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#getCredentials");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**CredentialsResponse**](CredentialsResponse.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getPolicy"></a>
# **getPolicy**
> Map&lt;String, Boolean&gt; getPolicy(policy)



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
StatementsList policy = new StatementsList(); // StatementsList | 
try {
    Map<String, Boolean> result = apiInstance.getPolicy(policy);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#getPolicy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **policy** | [**StatementsList**](StatementsList.md)|  |

### Return type

**Map&lt;String, Boolean&gt;**

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="postCredentials"></a>
# **postCredentials**
> Credential postCredentials(createCredential)



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
Credential createCredential = new Credential(); // Credential | 
try {
    Credential result = apiInstance.postCredentials(createCredential);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#postCredentials");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createCredential** | [**Credential**](Credential.md)|  |

### Return type

[**Credential**](Credential.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCredential"></a>
# **updateCredential**
> Credential updateCredential(id, updateCredential)



### Example
```java
// Import classes:
//import net.telestream.cloud.iam.ApiClient;
//import net.telestream.cloud.iam.ApiException;
//import net.telestream.cloud.iam.Configuration;
//import net.telestream.cloud.iam.auth.*;
//import net.telestream.cloud.iam.IamApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

IamApi apiInstance = new IamApi();
String id = "id_example"; // String | 
Credential updateCredential = new Credential(); // Credential | 
try {
    Credential result = apiInstance.updateCredential(id, updateCredential);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling IamApi#updateCredential");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **updateCredential** | [**Credential**](Credential.md)|  |

### Return type

[**Credential**](Credential.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

