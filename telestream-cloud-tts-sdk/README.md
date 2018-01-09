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

import net.telestream.cloud.tts.*;
import net.telestream.cloud.tts.auth.*;
import net.telestream.cloud.tts.*;
import net.telestream.cloud.tts.TtsApi;

import java.io.File;
import java.util.*;

public class TtsApiExample {

    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        
        // Configure API key authorization: apiKey
        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("apiKey");
        apiKey.setApiKey("YOUR API KEY");
        // Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
        //apiKey.setApiKeyPrefix("Token");

        TtsApi apiInstance = new TtsApi();
        String projectID = "projectID_example"; // String | ID of the Project
        try {
            CorporaCollection result = apiInstance.corpora(projectID);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TtsApi#corpora");
            e.printStackTrace();
        }
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

