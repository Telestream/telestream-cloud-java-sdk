
# Video

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | A unique identifier of the Video. |  [optional]
**audioBitrate** | **Integer** | audio bitrate (in bits/s) |  [optional]
**audioChannels** | **Integer** | A number of audio channels. |  [optional]
**audioCodec** | **String** | A codec that has been used to encode audio streams. |  [optional]
**audioSampleRate** | **Integer** | A number of samples of audio carried per second. |  [optional]
**createdAt** | **String** | A date and time when the Video has been created. |  [optional]
**duration** | **Integer** | A duration of the video in seconds. |  [optional]
**encodingsCount** | **Integer** | A number of related Encoding objects. |  [optional]
**errorClass** | **String** | A class of an error that has occurred during the encoding process. It is present only if the encoding status is equal to &#x60;fail&#x60;. |  [optional]
**errorMessage** | **String** | A message that explains why the encoding process has resulted in an error. It is present only if the encoding status is equal to &#x60;fail&#x60;. |  [optional]
**extname** | **String** | Extension of the source file. |  [optional]
**fileSize** | **Integer** | A size of the source file. |  [optional]
**fps** | [**BigDecimal**](BigDecimal.md) | Number of frames per second. |  [optional]
**height** | **Integer** | Height of the output video. |  [optional]
**width** | **Integer** | Width of the output video. |  [optional]
**mimeType** | **String** | A mime type of the source file. |  [optional]
**originalFilename** | **String** | A name of the source file. |  [optional]
**path** | **String** |  |  [optional]
**payload** | **String** | Payload is an arbitrary text of length 256 or shorter that you can store along the Video. It is typically used to retain an association with one of your own DB record ID. |  [optional]
**sourceUrl** | **String** | An URL pointing to the source file. |  [optional]
**status** | **String** | Determines at what stage of importing process the Video is at the moment. |  [optional]
**updatedAt** | **String** | A date and time when a Video has been updated last time. |  [optional]
**videoBitrate** | **String** | video bitrate (in bits/s) |  [optional]
**videoCodec** | **String** | A codec that has been used to encode the input file&#39;s video streams. |  [optional]



