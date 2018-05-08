
# Params

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addresses** | **List&lt;String&gt;** | [required] #email;  E-mail addresses  |  [optional]
**url** | **String** | [required] #webhook;  Webhook URL  |  [optional]
**method** | [**MethodEnum**](#MethodEnum) | [optional] #webhook;  HTTP method; default: POST (GET, POST)  |  [optional]
**retries** | **Integer** | [optional] #webhook;  Number of retries before forgetting the notification; default: 0  |  [optional]
**contentType** | **String** | [optional] #webhook; default: application/json (application/json, application/x-www-form-urlencoded)  |  [optional]


<a name="MethodEnum"></a>
## Enum: MethodEnum
Name | Value
---- | -----
GET | &quot;GET&quot;
POST | &quot;POST&quot;



