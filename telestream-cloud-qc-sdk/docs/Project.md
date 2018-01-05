
# Project

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | A unique identifier of a Project. |  [optional]
**name** | **String** | Human-readable identifier of a Project. |  [optional]
**status** | [**StatusEnum**](#StatusEnum) | Project status. |  [optional]
**template** | **String** | Name of QC template. |  [optional]
**options** | **String** | JSON with specific options |  [optional]


<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
ACTIVE | &quot;active&quot;
PENDING | &quot;pending&quot;
ARCHIVED | &quot;archived&quot;
SUSPENDED | &quot;suspended&quot;



