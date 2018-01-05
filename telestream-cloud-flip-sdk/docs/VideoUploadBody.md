
# VideoUploadBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**fileSize** | **Long** | Size of the file that will be uploaded in &#x60;bytes&#x60;. | 
**fileName** | **String** | Name of the file that will be uploaded. | 
**extraFiles** | [**List&lt;ExtraFile&gt;**](ExtraFile.md) | A list of names of additional files that will be uploaded. |  [optional]
**profiles** | **String** | A comma-separated list of profile names or IDs to be used during encoding. Alternatively, specify none so no encodings will created right away. |  [optional]
**pathFormat** | **String** |  |  [optional]
**payload** | **String** | Payload is an arbitrary text of length 256 or shorter that you can store along the Video. It is typically used to retain an association with one of your own DB record ID. |  [optional]
**extraVariables** | **Map&lt;String, String&gt;** |  |  [optional]
**watermarkUrl** | **String** | URL pointing to an image that will be used asa watermark. |  [optional]
**watermarkLeft** | **String** | Determines distance between the left edge of a video and the left edge of a watermark image. Can be specified in pixels or percents. This parameter can be set only if watermark_right is not. |  [optional]
**watermarkTop** | **String** | Determines distance between the top edge of a video and the top edge of a watermark image. Can be specified in pixels or percents. This parameter can be set only if watermark_bottom is not. |  [optional]
**watermarkRight** | **String** | Determines distance between the right edge of a video and the right edge of a watermark image. Can be specified in pixels or percents. This parameter can be set only if watermark_left is not. |  [optional]
**watermarkBottom** | **String** | Determines distance between the bottom edge of a video and the bottom edge of a watermark image. Can be specified in pixels or percents. This parameter can be set only if watermark_top is not. |  [optional]
**watermarkWidth** | **String** | Determines width of the watermark image. Should be specified in pixels. |  [optional]
**watermarkHeight** | **String** | Determines width of the watermark image. Should be specified in pixels. |  [optional]
**clipLength** | **String** | Length of the uploaded video. Should be formatted as follows: HH:MM:SS |  [optional]
**clipOffset** | **String** | Clip starts at a specific offset. |  [optional]
**multiChunk** | **Boolean** |  |  [optional]



