
# Topic

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | **String** | [read-only] Account identifier connected to subscription notification  |  [optional]
**service** | [**ServiceEnum**](#ServiceEnum) | [required] Name of service  |  [optional]
**event** | [**EventEnum**](#EventEnum) | [required] Name of the event;  Quality Control (video-passed,  video-error,  video-warning,  video-rejected,  video-canceled)  |  [optional]
**project** | **String** | [required] Project ID  |  [optional]


<a name="ServiceEnum"></a>
## Enum: ServiceEnum
Name | Value
---- | -----
QC | &quot;qc&quot;


<a name="EventEnum"></a>
## Enum: EventEnum
Name | Value
---- | -----
PASSED | &quot;video-passed&quot;
ERROR | &quot;video-error&quot;
WARNING | &quot;video-warning&quot;
REJECTED | &quot;video-rejected&quot;
CANCELED | &quot;video-canceled&quot;



