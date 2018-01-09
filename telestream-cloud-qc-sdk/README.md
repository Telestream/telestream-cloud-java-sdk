# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import net.telestream.cloud.qc.*;
import net.telestream.cloud.qc.auth.*;
import net.telestream.cloud.qc.*;
import net.telestream.cloud.qc.QcApi;

import java.io.File;
import java.util.*;

public class QcApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: apiKey
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKey.setApiKeyPrefix("Token");

        QcApi apiInstance = new QcApi();
        String project = "project_example"; // String | A unique identifier of a Project.
        String job = "job_example"; // String | A unique identifier of a Job.
        try {
            apiInstance.cancelJob(project, job);
        } catch (ApiException e) {
            System.err.println("Exception when calling QcApi#cancelJob");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/qc/v1.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*QcApi* | [**cancelJob**](docs/QcApi.md#cancelJob) | **PUT** /projects/{project}/jobs/{job}/cancel.json | 
*QcApi* | [**createJob**](docs/QcApi.md#createJob) | **POST** /projects/{project}/jobs.json | Create a new job
*QcApi* | [**createProject**](docs/QcApi.md#createProject) | **POST** /projects.json | Create a new project
*QcApi* | [**getJob**](docs/QcApi.md#getJob) | **GET** /projects/{project}/jobs/{job}.json | Get QC job
*QcApi* | [**getProject**](docs/QcApi.md#getProject) | **GET** /projects/{project}.json | Get project by Id
*QcApi* | [**listJobs**](docs/QcApi.md#listJobs) | **GET** /projects/{project}/jobs.json | Get jobs form projects
*QcApi* | [**listProjects**](docs/QcApi.md#listProjects) | **GET** /projects.json | List all projects for an account
*QcApi* | [**modifyProject**](docs/QcApi.md#modifyProject) | **PUT** /projects/{project}.json | Modify project
*QcApi* | [**proxy**](docs/QcApi.md#proxy) | **GET** /projects/{project}/jobs/{job}/proxy.json | 
*QcApi* | [**removeJob**](docs/QcApi.md#removeJob) | **DELETE** /projects/{project}/jobs/{job}.json | 
*QcApi* | [**removeProject**](docs/QcApi.md#removeProject) | **DELETE** /projects/{project}.json | 
*QcApi* | [**signedUrls**](docs/QcApi.md#signedUrls) | **GET** /projects/{project}/jobs/{job}/signed-urls.json | 
*QcApi* | [**uploadVideo**](docs/QcApi.md#uploadVideo) | **POST** /projects/{project}/upload.json | Creates an upload session


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
 - [Project](docs/Project.md)
 - [Proxy](docs/Proxy.md)
 - [UploadSession](docs/UploadSession.md)
 - [VideoStream](docs/VideoStream.md)
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

