# Telestream Cloud Notifications Java SDK

This library provides a low-level interface to the REST API of Telestream Cloud, the online video encoding service.

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Getting Started

## Documentation for API Endpoints

All URIs are relative to *https://api.cloud.telestream.net/notifications/v2.0*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*NotificationsApi* | [**createSubscription**](docs/NotificationsApi.md#createSubscription) | **POST** /subscriptions | Create a new subscription
*NotificationsApi* | [**deleteSubscription**](docs/NotificationsApi.md#deleteSubscription) | **DELETE** /subscriptions/{id} | 
*NotificationsApi* | [**getSubscription**](docs/NotificationsApi.md#getSubscription) | **GET** /subscriptions/{id} | 
*NotificationsApi* | [**listSubscriptions**](docs/NotificationsApi.md#listSubscriptions) | **GET** /subscriptions | 
*NotificationsApi* | [**modifySubscription**](docs/NotificationsApi.md#modifySubscription) | **PUT** /subscriptions/{id} | Modify subscription


## Documentation for Models

 - [Params](docs/Params.md)
 - [Subscription](docs/Subscription.md)
 - [Topic](docs/Topic.md)
 - [UpdateData](docs/UpdateData.md)
 - [UpdateTopic](docs/UpdateTopic.md)


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

