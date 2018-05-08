
# Subscription

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | [read-only] Subscription identifier  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | [required] Type of subscription (email, webhook)  |  [optional]
**topic** | [**Topic**](Topic.md) | [required]  |  [optional]
**params** | [**Params**](Params.md) | [required]  |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
EMAIL | &quot;email&quot;
WEBHOOK | &quot;webhook&quot;



