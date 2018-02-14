# Telestream Cloud Timed Text Speech Java SDK

This library provides a low-level interface to the REST API of Telestream Cloud, the online video encoding service.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Getting Started
## Initialize client

```java
ApiClient defaultClient = Configuration.getDefaultApiClient();
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("tcs_api_key");

String projectId = "project_id";
```

### Create project

```java
Project project = new Project();
project.setName("Example project name");
project.setDescription("Example project description");
project.setLanguage("en-US");

try {
    Project createdProject = apiInstance.createProject(project);
    System.out.println(createdProject);
} catch (ApiException e) {
    e.printStackTrace();
}
```


### Create job from source URL

```java
Job jobPayload = new Job();
jobPayload.setSourceUrl("http://url/to/video.mp4");

try {
    Job createdJob = apiInstance.createJob(projectId, jobPayload);
    System.out.println(createdJob);
} catch (ApiException e) {
    e.printStackTrace();
}

```

### Create job from file

```java
Uploader uploader = new Uploader(apiInstance, projectId, "/path/to/video/demo.mp4");
uploader.setup();
uploader.start();

String mediaId = uploader.getMediaId();

if (mediaId != null) {
    try {
        Job createdJob = apiInstance.job(projectId, mediaId);
        System.out.println(createdJob);
    } catch (ApiException e) {
        e.printStackTrace();
    }

}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/tts/v1.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*TtsApi* | [**corpora**](docs/TtsApi.md#corpora) | **GET** /projects/{projectID}/corpora | Returns a collection of Corpora
*TtsApi* | [**corpus**](docs/TtsApi.md#corpus) | **GET** /projects/{projectID}/corpora/{name} | Returns the Corpus
*TtsApi* | [**createCorpus**](docs/TtsApi.md#createCorpus) | **POST** /projects/{projectID}/corpora/{name} | Creates a new Corpus
*TtsApi* | [**createJob**](docs/TtsApi.md#createJob) | **POST** /projects/{projectID}/jobs | Creates a new Job
*TtsApi* | [**createProject**](docs/TtsApi.md#createProject) | **POST** /projects | Creates a new Project
*TtsApi* | [**deleteCorpus**](docs/TtsApi.md#deleteCorpus) | **DELETE** /projects/{projectID}/corpora/{name} | Creates a new Corpus
*TtsApi* | [**deleteJob**](docs/TtsApi.md#deleteJob) | **DELETE** /projects/{projectID}/jobs/{id} | Deletes the Job
*TtsApi* | [**deleteProject**](docs/TtsApi.md#deleteProject) | **DELETE** /projects/{projectID} | Deletes the Project
*TtsApi* | [**job**](docs/TtsApi.md#job) | **GET** /projects/{projectID}/jobs/{id} | Returns the Job
*TtsApi* | [**jobResult**](docs/TtsApi.md#jobResult) | **GET** /projects/{projectID}/jobs/{id}/result | Returns the Job Result
*TtsApi* | [**jobs**](docs/TtsApi.md#jobs) | **GET** /projects/{projectID}/jobs | Returns a collection of Jobs
*TtsApi* | [**project**](docs/TtsApi.md#project) | **GET** /projects/{projectID} | Returns the Project
*TtsApi* | [**projects**](docs/TtsApi.md#projects) | **GET** /projects | Returns a collection of Projects
*TtsApi* | [**trainProject**](docs/TtsApi.md#trainProject) | **POST** /projects/{projectID}/train | Queues training
*TtsApi* | [**updateProject**](docs/TtsApi.md#updateProject) | **PUT** /projects/{projectID} | Updates an existing Project
*TtsApi* | [**uploadVideo**](docs/TtsApi.md#uploadVideo) | **POST** /projects/{projectID}/jobs/upload | Creates an upload session


## Documentation for Models

 - [CorporaCollection](docs/CorporaCollection.md)
 - [Corpus](docs/Corpus.md)
 - [ErrorResponse](docs/ErrorResponse.md)
 - [ExtraFile](docs/ExtraFile.md)
 - [Fragment](docs/Fragment.md)
 - [FragmentVariant](docs/FragmentVariant.md)
 - [Job](docs/Job.md)
 - [JobResult](docs/JobResult.md)
 - [JobsCollection](docs/JobsCollection.md)
 - [Project](docs/Project.md)
 - [ProjectsCollection](docs/ProjectsCollection.md)
 - [Result](docs/Result.md)
 - [UploadSession](docs/UploadSession.md)
 - [VideoUploadBody](docs/VideoUploadBody.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### apiKey

- **Type**: API key
- **API key parameter name**: X-Api-Key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

cloudsupport@telestream.net

