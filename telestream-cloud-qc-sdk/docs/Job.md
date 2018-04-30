
# Job

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** |  |  [optional]
**projectId** | **String** |  |  [optional]
**status** | [**StatusEnum**](#StatusEnum) |  |  [optional]
**state** | **String** |  |  [optional]
**duration** | **Integer** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**progress** | **Integer** |  |  [optional]
**filename** | **String** |  |  [optional]
**sourceUrl** | **String** |  |  [optional]
**createdAt** | **String** |  |  [optional]
**updatedAt** | **String** |  |  [optional]
**errorClass** | **String** |  |  [optional]
**errorMessage** | **String** |  |  [optional]
**details** | [**JobDetails**](JobDetails.md) |  |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
PENDING | &quot;pending&quot;
TRANSFERING | &quot;transfering&quot;
QUEUED | &quot;queued&quot;
DOWNLOADING | &quot;downloading&quot;
UPLOADING | &quot;uploading&quot;
PROCESSING | &quot;processing&quot;
SUCCESS | &quot;success&quot;
ERROR | &quot;error&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
VIDCHECKER | &quot;vidchecker&quot;
LIPSYNC | &quot;lipsync&quot;



