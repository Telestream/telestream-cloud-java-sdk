# NotificationsApi

All URIs are relative to *https://api.cloud.telestream.net/notifications/v1.0*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createSubscription**](NotificationsApi.md#createSubscription) | **POST** /subscriptions | Create a new subscription
[**deleteSubscription**](NotificationsApi.md#deleteSubscription) | **DELETE** /subscriptions/{id} | 
[**listSubscriptions**](NotificationsApi.md#listSubscriptions) | **GET** /subscriptions | 


<a name="createSubscription"></a>
# **createSubscription**
> createSubscription(subscription)

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

// Configure API key authorization: apiKey
ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
apiKey.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKey.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
Subscription subscription = new Subscription(); // Subscription | 
try {
    apiInstance.createSubscription(subscription);
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

null (empty response body)

### Authorization

[apiKey](../README.md#apiKey)

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

// Configure API key authorization: apiKey
ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
apiKey.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKey.setApiKeyPrefix("Token");

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

[apiKey](../README.md#apiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="listSubscriptions"></a>
# **listSubscriptions**
> List&lt;Subscription&gt; listSubscriptions()



### Example
```java
// Import classes:
//import net.telestream.cloud.notifications.ApiClient;
//import net.telestream.cloud.notifications.ApiException;
//import net.telestream.cloud.notifications.Configuration;
//import net.telestream.cloud.notifications.auth.*;
//import net.telestream.cloud.notifications.NotificationsApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: apiKey
ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
apiKey.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//apiKey.setApiKeyPrefix("Token");

NotificationsApi apiInstance = new NotificationsApi();
try {
    List<Subscription> result = apiInstance.listSubscriptions();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling NotificationsApi#listSubscriptions");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Subscription&gt;**](Subscription.md)

### Authorization

[apiKey](../README.md#apiKey)

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

