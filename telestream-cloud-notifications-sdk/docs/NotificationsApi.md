# NotificationsApi

All URIs are relative to *https://api.cloud.telestream.net/notifications/v2.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](NotificationsApi.md#createSubscription) | **POST** /subscriptions | Create a new subscription
[**deleteSubscription**](NotificationsApi.md#deleteSubscription) | **DELETE** /subscriptions/{id} | 
[**getSubscription**](NotificationsApi.md#getSubscription) | **GET** /subscriptions/{id} | 
[**listSubscriptions**](NotificationsApi.md#listSubscriptions) | **GET** /subscriptions | 
[**modifySubscription**](NotificationsApi.md#modifySubscription) | **PUT** /subscriptions/{id} | Modify subscription


<a name="createSubscription"></a>
# **createSubscription**
> Subscription createSubscription(subscription)

Create a new subscription



### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Subscription subscription = new Subscription(); // Subscription | 
try {
    Subscription result = apiInstance.createSubscription(subscription);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#createSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **subscription** | [**Subscription**](Subscription.md)|  | [optional]

### Return type

[**Subscription**](Subscription.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="deleteSubscription"></a>
# **deleteSubscription**
> deleteSubscription(id)



### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
String id = "id_example"; // String | 
try {
    apiInstance.deleteSubscription(id);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#deleteSubscription");
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

<a name="getSubscription"></a>
# **getSubscription**
> Subscription getSubscription(id)



### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
String id = "id_example"; // String | 
try {
    Subscription result = apiInstance.getSubscription(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#getSubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |

### Return type

[**Subscription**](Subscription.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listSubscriptions"></a>
# **listSubscriptions**
> List&lt;Subscription&gt; listSubscriptions(serviceType, type)



### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
String serviceType = "serviceType_example"; // String | Service type (qc, tts, flip)
String type = "type_example"; // String | Subscription type (email, webhook, sns, aeg, pubsub)
try {
    List<Subscription> result = apiInstance.listSubscriptions(serviceType, type);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#listSubscriptions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **serviceType** | **String**| Service type (qc, tts, flip) | [optional]
 **type** | **String**| Subscription type (email, webhook, sns, aeg, pubsub) | [optional]

### Return type

[**List&lt;Subscription&gt;**](Subscription.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="modifySubscription"></a>
# **modifySubscription**
> Subscription modifySubscription(id, updateData)

Modify subscription

### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
String id = "id_example"; // String | 
UpdateData updateData = new UpdateData(); // UpdateData | 
try {
    Subscription result = apiInstance.modifySubscription(id, updateData);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#modifySubscription");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**|  |
 **updateData** | [**UpdateData**](UpdateData.md)|  | [optional]

### Return type

[**Subscription**](Subscription.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

