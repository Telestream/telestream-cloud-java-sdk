# Telestream Cloud IAM Java SDK

This library provides a low-level interface to the REST API of Telestream Cloud, the online video encoding service.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Getting Started

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/iam/v1.0/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*IamApi* | [**deleteCredential**](docs/IamApi.md#deleteCredential) | **DELETE** /credentials/{id} | 
*IamApi* | [**getCredential**](docs/IamApi.md#getCredential) | **GET** /credentials/{id} | 
*IamApi* | [**getCredentials**](docs/IamApi.md#getCredentials) | **GET** /credentials | 
*IamApi* | [**getPolicy**](docs/IamApi.md#getPolicy) | **POST** /credentials/policy | 
*IamApi* | [**postCredentials**](docs/IamApi.md#postCredentials) | **POST** /credentials | 
*IamApi* | [**updateCredential**](docs/IamApi.md#updateCredential) | **PATCH** /credentials/{id} | 


## Documentation for Models

 - [Credential](docs/Credential.md)
 - [CredentialsResponse](docs/CredentialsResponse.md)
 - [Error](docs/Error.md)
 - [Policy](docs/Policy.md)
 - [Statement](docs/Statement.md)
 - [StatementsList](docs/StatementsList.md)


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

