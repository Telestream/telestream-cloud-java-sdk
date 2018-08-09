
# Topic

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**account** | **String** | [read-only] Account identifier connected to subscription notification  |  [optional]
**service** | **String** | Name of service (qc, flip, tts)  | 
**event** | **String** | Name of the event;  Quality Control (media-passed, media-error, media-warning, media-rejected, media-canceled, job-created, job-progress), Flip (video-created, video-encoded, encoding-complete, encoding-progress), Transcription (job-created, job-completed, job-error, job-progress)  | 
**project** | **String** | (for tts, qc service); Project ID  |  [optional]
**factory** | **String** | (for flip service); Factory ID  |  [optional]



