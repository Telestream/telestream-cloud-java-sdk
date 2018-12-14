
# Project

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the Project. |  [optional]
**name** | **String** | The name of the Project. |  [optional]
**description** | **String** | The description of the Project. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Determines a stage of training. |  [optional]
**language** | **String** | The language code of model. |  [optional]
**sampleRate** | **Integer** | The sample rate of model. |  [optional]
**profanityFilter** | **Boolean** | If true, the service replaces profanity from output with asterisks. |  [optional]
**generateProxy** | **Boolean** | Indicates whether video preview should be generated. |  [optional]
**customWords** | **String** | Words used for model training, separated by space. |  [optional]
**capabilities** | **List&lt;String&gt;** |  |  [optional]
**createdAt** | **String** | A date and time when the project was created |  [optional]
**updatedAt** | **String** | A date and time when the project was updated |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
AVAILABLE | &quot;available&quot;
MODIFIED | &quot;modified&quot;
TRAINING | &quot;training&quot;
FAILED | &quot;failed&quot;



