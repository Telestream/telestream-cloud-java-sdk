# Telestream Cloud Quality Control Java SDK

This library provides a low-level interface to the REST API of Telestream Cloud, the online video encoding service.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Getting Started
```java
ApiClient defaultClient = Configuration.getDefaultApiClient();
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("tcs_4d2fda530099e32ace0b9fa8");

QcApi apiInstance = new QcApi();

Data data = new Data();
data.setName("test project");
data.setTemplate("ard_zdf_1_a");
Project project = null;
try {
   project = apiInstance.createProject(data);
} catch (ApiException e) {
   e.printStackTrace();
}

String filePath = "/Users/rafalrozak/Downloads/newdemo.mp4";
Uploader uploader = new Uploader(apiInstance, project.getId(), filePath);
uploader.setup();
uploader.start();
System.out.println(uploader.getStatus());
System.out.println(uploader.getMediaId());


// POST jobs
JobData jobData = new JobData();
jobData.setUrl("sourceurl.test/video.mp4");

try {
   Job job = apiInstance.createJob(project.getId(), jobData);
   System.out.println(job);
} catch (ApiException e) {
   System.err.println("Exception when calling QCApi#createJob");
   e.printStackTrace();
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/qc/v1.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*QcApi* | [**cancelJob**](docs/QcApi.md#cancelJob) | **PUT** /projects/{project_id}/jobs/{job_id}/cancel.json | 
*QcApi* | [**createJob**](docs/QcApi.md#createJob) | **POST** /projects/{project_id}/jobs.json | Create a new job
*QcApi* | [**createProject**](docs/QcApi.md#createProject) | **POST** /projects.json | Create a new project
*QcApi* | [**getJob**](docs/QcApi.md#getJob) | **GET** /projects/{project_id}/jobs/{job_id}.json | Get QC job
*QcApi* | [**getProject**](docs/QcApi.md#getProject) | **GET** /projects/{project_id}.json | Get project by Id
*QcApi* | [**listJobs**](docs/QcApi.md#listJobs) | **GET** /projects/{project_id}/jobs.json | Get jobs form projects
*QcApi* | [**listProjects**](docs/QcApi.md#listProjects) | **GET** /projects.json | List all projects for an account
*QcApi* | [**modifyProject**](docs/QcApi.md#modifyProject) | **PUT** /projects/{project_id}.json | Modify project
*QcApi* | [**proxy**](docs/QcApi.md#proxy) | **GET** /projects/{project_id}/jobs/{job_id}/proxy.json | 
*QcApi* | [**removeJob**](docs/QcApi.md#removeJob) | **DELETE** /projects/{project_id}/jobs/{job_id}.json | 
*QcApi* | [**removeProject**](docs/QcApi.md#removeProject) | **DELETE** /projects/{project_id}.json | 
*QcApi* | [**signedUrls**](docs/QcApi.md#signedUrls) | **GET** /projects/{project_id}/jobs/{job_id}/signed-urls.json | 
*QcApi* | [**templates**](docs/QcApi.md#templates) | **GET** /templates.json | List all templates
*QcApi* | [**uploadVideo**](docs/QcApi.md#uploadVideo) | **POST** /projects/{project_id}/upload.json | Creates an upload session


## Documentation for Models

 - [Alert](docs/Alert.md)
 - [AudioStream](docs/AudioStream.md)
 - [Container](docs/Container.md)
 - [Data](docs/Data.md)
 - [Data1](docs/Data1.md)
 - [ExtraFile](docs/ExtraFile.md)
 - [Job](docs/Job.md)
 - [JobData](docs/JobData.md)
 - [JobDetails](docs/JobDetails.md)
 - [JobDetailsResult](docs/JobDetailsResult.md)
 - [JobsCollection](docs/JobsCollection.md)
 - [Media](docs/Media.md)
 - [Options](docs/Options.md)
 - [Project](docs/Project.md)
 - [Proxy](docs/Proxy.md)
 - [Template](docs/Template.md)
 - [UploadSession](docs/UploadSession.md)
 - [VideoStream](docs/VideoStream.md)
 - [VideoUploadBody](docs/VideoUploadBody.md)


## Documentation for Authorization

Authentication schemes defined for the API:
### api_key

- **Type**: API key
- **API key parameter name**: X-Api-Key
- **Location**: HTTP header


## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

cloudsupport@telestream.net

