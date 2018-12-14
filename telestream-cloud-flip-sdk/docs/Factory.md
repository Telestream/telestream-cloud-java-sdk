
# Factory

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | A unique identifier of a Factory. |  [optional]
**name** | **String** | Human-readable identifier of a Factory. |  [optional]
**factoryRegion** | **String** | A region where the factory is located. |  [optional]
**outputBucketName** | **String** | A bucket where processed files will be stored. |  [optional]
**acl** | [**AclEnum**](#AclEnum) | Specify if your files are public or private (private files need authorization url to access). By default this is not set. |  [optional]
**createdAt** | **String** | A date and time when a Factory has been created. |  [optional]
**updatedAt** | **String** | A date and time when a Factory has been updated last time. |  [optional]
**url** | **String** | An URL pointing to the output_bucket_name. |  [optional]
**serverSideEncryption** | **Boolean** | Specify if you want to use multi-factor server-side 256-bit AES-256 data encryption with Amazon S3-managed encryption keys (SSE-S3). Each object is encrypted using a unique key which as an additional safeguard is encrypted itself with a master key that S3 regularly rotates. By default this is not set. |  [optional]
**inputBucketName** | **String** | A name of an input bucket. |  [optional]
**inputBucketWatch** | **Boolean** | Determines whether the Factory should be notified about new files added to the input bucket. |  [optional]
**inputBucketFilesMap** | **Object** |  |  [optional]
**inputBucketSyncEveryNMin** | **String** | Determines how often the input bucket is synchronised. |  [optional]
**inputBucketRecursive** | **String** |  |  [optional]
**inputBucketFilePattern** | **String** | A pattern that will be used to locate files in the input bucket. Valid wildcards might be used. |  [optional]
**outputsPathFormat** | **String** |  |  [optional]
**storageProvider** | **Integer** | Specifies which storage provider the factory should use. Available options: S3: 0, Google Cloud Storage: 1, FTP storage: 2, Google Cloud Interoperability Storage: 5, Flip storage: 7, FASP storage: 8, Azure Blob Storage: 9 |  [optional]
**providerSpecificSettings** | **Object** |  |  [optional]


<a name="AclEnum"></a>
## Enum: AclEnum
Name | Value
---- | -----
PUBLIC | &quot;public&quot;
PRIVATE | &quot;private&quot;



