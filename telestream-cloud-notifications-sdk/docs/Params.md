
# Params

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**addresses** | **List&lt;String&gt;** | (for email subscription type);  E-mail addresses  |  [optional]
**url** | **String** | (for webhook subscription type);  Webhook URL  |  [optional]
**method** | [**MethodEnum**](#MethodEnum) | (for webhook subscription type);  HTTP method; default: POST (GET, POST)  |  [optional]
**retries** | **Integer** | (for webhook subscription type);  Number of retries before forgetting the notification; default: 0  |  [optional]
**contentType** | [**ContentTypeEnum**](#ContentTypeEnum) | (for webhook subscription type); default: application/json (application/json, application/x-www-form-urlencoded)  |  [optional]
**topicArn** | **String** | (for sns subscription type) identifier of an AWS SNS Topic that events will be posted to.  |  [optional]
**roleArn** | **String** | (for sns subscription type) identifier of an AWS IAM Role that will be used for authorization.  |  [optional]
**topicEndpoint** | **String** | (for aeg subscription type) address of an Azure Event Grid Topic that events will be posted to.  |  [optional]
**accessKey** | **String** | (for aeg subscription type) secret access key that authorizes Telestream Cloud to write to an Azure Event Grid Topic.  |  [optional]
**projectId** | **String** | (for pubsub subscription type) id of a Google Cloud project that hosts the topic.  |  [optional]
**topicName** | **String** | (for pubsub subscription type) name of a Google Cloud Pub/Sub topic to which notifications will be published.  |  [optional]


<a name="MethodEnum"></a>
## Enum: MethodEnum
Name | Value
---- | -----
GET | &quot;GET&quot;
POST | &quot;POST&quot;


<a name="ContentTypeEnum"></a>
## Enum: ContentTypeEnum
Name | Value
---- | -----
JSON | &quot;application/json&quot;
X_WWW_FORM_URLENCODED | &quot;application/x-www-form-urlencoded&quot;



