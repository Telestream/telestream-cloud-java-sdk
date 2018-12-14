
# Job

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | The ID of the job. |  [optional]
**name** | **String** | The name of the job. |  [optional]
**originalFilename** | **String** | The name of the input file |  [optional]
**projectId** | **String** | The ID of the project. |  [optional]
**sourceUrl** | **String** | The URL of source file. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Determines the state of transcription job. |  [optional]
**error** | **String** | If the status of the job is &#39;error&#39;, returns the state of job. |  [optional]
**progress** | **Integer** | A percentage that indicates the progress of the job. |  [optional]
**confidence** | **Integer** | The confidence score of the job in the range of 0 to 100. |  [optional]
**duration** | **Integer** | The duration of the input audio in milliseconds. |  [optional]
**bitrate** | **Integer** | The bitrate of the input audio. |  [optional]
**sampleRate** | **Integer** | The sample rate of the input audio. |  [optional]
**format** | **String** | The format of the input audio. |  [optional]
**fileSize** | **Long** | The file size of the input file. |  [optional]
**customWords** | **String** | Words used for model training, separated by space. |  [optional]
**createdAt** | **String** | A date and time when the job was created |  [optional]
**updatedAt** | **String** | A date and time when the job was updated |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
PREPARING | &quot;preparing&quot;
PROCESSING | &quot;processing&quot;
SUCCESS | &quot;success&quot;
ERROR | &quot;error&quot;



