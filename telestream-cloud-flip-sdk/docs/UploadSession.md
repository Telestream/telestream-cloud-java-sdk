
# UploadSession

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | An unique identifier of the UploadSession. | 
**location** | **String** | An URL to which chunks of the uploaded file should be sent | 
**parts** | **Integer** | A number of chunks that are expected by the upstream. |  [optional]
**partSize** | **Integer** | An expected size of uploaded chunks. |  [optional]
**maxConnections** | **Integer** | A maximum number of concurrent connections. |  [optional]
**extraFiles** | **Object** | An object containing additional files uploaded using the session. |  [optional]



