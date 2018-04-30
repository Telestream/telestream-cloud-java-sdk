
# Topic

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | **String** | [read-only] Account identifier connected to subscription notification  |  [optional]
**service** | [**ServiceEnum**](#ServiceEnum) |  |  [optional]
**events** | [**List&lt;EventsEnum&gt;**](#List&lt;EventsEnum&gt;) | Name of the event  Quality Control - video-passed - video-error - video-warning - video-rejected - video-canceled  |  [optional]
**project** | **String** | Project ID |  [optional]


<a name="ServiceEnum"></a>
## Enum: ServiceEnum
Name | Value
---- | -----
QC | &quot;qc&quot;


<a name="List<EventsEnum>"></a>
## Enum: List&lt;EventsEnum&gt;
Name | Value
---- | -----
PASSED | &quot;video-passed&quot;
ERROR | &quot;video-error&quot;
WARNING | &quot;video-warning&quot;
REJECTED | &quot;video-rejected&quot;
CANCELED | &quot;video-canceled&quot;



