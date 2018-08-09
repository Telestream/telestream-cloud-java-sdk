
# Encoding

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | A unique identifier of an Encoding. |  [optional]
**audioBitrate** | **Integer** | Audio bitrate (in bits/s). |  [optional]
**audioChannels** | **Integer** | A number of audio channels. |  [optional]
**audioCodec** | **String** | A codec that is used to encode audio streams. |  [optional]
**audioSampleRate** | **Integer** | A number of samples of audio carried per second. |  [optional]
**createdAt** | **String** | A date and time when the Encoding has been created. |  [optional]
**duration** | **Integer** |  |  [optional]
**encodingProgress** | **Integer** |  |  [optional]
**encodingTime** | **Integer** |  |  [optional]
**errorClass** | **String** | A class of an error that has occurred during the encoding process. It is present only if the encoding status is equal to &#x60;fail&#x60;. |  [optional]
**errorMessage** | **String** | A message that explains why the encoding process has resulted in an error. It is present only if the encoding status is equal to &#x60;fail&#x60;. |  [optional]
**externalId** | **String** |  |  [optional]
**extname** | **String** | Extension of the output file. |  [optional]
**fileSize** | **Long** | A size of the output file. |  [optional]
**files** | **List&lt;String&gt;** | An array of output file names. |  [optional]
**fps** | [**BigDecimal**](BigDecimal.md) | Number of frames per second. |  [optional]
**height** | **Integer** | Height of the output video. |  [optional]
**width** | **Integer** | Width of the output video. |  [optional]
**logfileUrl** | **String** | An URL pointing to a logfile. |  [optional]
**mimeType** | **String** | A mime type of the encoded file. |  [optional]
**parentEncodingId** | **String** |  |  [optional]
**path** | **String** |  |  [optional]
**profileId** | **String** | An id of a related Profile. |  [optional]
**profileName** | **String** | A name of the used Profile. |  [optional]
**screenshots** | **List&lt;String&gt;** |  |  [optional]
**startedEncodingAt** | **String** | A date and time when the encoding process has been started |  [optional]
**status** | **String** | Determines at what stage the encoding process is at the moment. |  [optional]
**updatedAt** | **String** | A date and time when a Encoding has been updated last time. |  [optional]
**videoBitrate** | **Integer** | video bitrate (in bits/s) |  [optional]
**videoCodec** | **String** | A codec that is used to encode video streams. |  [optional]
**videoId** | **String** | An id of a related Video object |  [optional]



