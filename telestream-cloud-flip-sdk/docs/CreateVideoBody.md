
# CreateVideoBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**sourceUrl** | **String** | An URL pointing to a source file. |  [optional]
**profiles** | **String** | Comma-separated list of profile names or IDs to be used during encoding. Alternatively, specify none so no encodings are created yet. |  [optional]
**payload** | **String** | Arbitrary string stored along the Video object. |  [optional]
**pipeline** | **String** | String-encoded JSON describing profiles pipeline. |  [optional]
**subtitleFiles** | **List&lt;String&gt;** | A list of urls pointing to remote subtitle files. |  [optional]
**extraFiles** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**extraVariables** | **Map&lt;String, String&gt;** |  |  [optional]
**pathFormat** | **String** |  |  [optional]
**clipEnd** | **String** | Clip ends at a specific time (timecode). |  [optional]
**pixelFormat** | **String** |  |  [optional]
**clipLength** | **String** | A clip’s duration. |  [optional]
**clipOffset** | **String** | Clip starts at a specific offset. |  [optional]
**startingTimecode** | **String** |  |  [optional]
**storeId** | **String** | An individual store_id for this video processing. If provided will replace store_id from cloud factory but must match underlying cloud provider and region. |  [optional]



