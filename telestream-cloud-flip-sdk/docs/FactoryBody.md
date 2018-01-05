
# FactoryBody

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**awsAccessKey** | **String** | AWS access key. |  [optional]
**awsSecretKey** | **String** | AWS secret key. |  [optional]
**factoryRegion** | **String** | A region where the factory is located. |  [optional]
**inputBucketFilePattern** | **String** | A pattern that will be used to locate files in the input bucket. Valid wildcards might be used. |  [optional]
**inputBucketName** | **String** | A name of an input bucket. |  [optional]
**inputBucketRecursive** | **Boolean** |  |  [optional]
**inputBucketSyncEveryNMin** | **Integer** | Determines how often the input bucket is synchronised. |  [optional]
**inputBucketWatch** | **Boolean** | Determines whether the Factory should be notified about new files added to the input bucket. |  [optional]
**name** | **String** | Name of the Factory. | 
**outputsPathFormat** | **String** | Specify the directory where the output files should be stored. By default it is not set. More info [here](https://cloud.telestream.net/docs#path-format---know-how). |  [optional]
**providerSpecificSettings** | **Object** |  |  [optional]
**acl** | [**AclEnum**](#AclEnum) | Specify if your files are public or private (private files need authorization url to access). By default this is not set. |  [optional]
**outputBucketName** | **String** | A bucket where processed files will be stored. |  [optional]
**serverSideEncryption** | **Boolean** | Specify if you want to use multi-factor server-side 256-bit AES-256 data encryption with Amazon S3-managed encryption keys (SSE-S3). Each object is encrypted using a unique key which as an additional safeguard is encrypted itself with a master key that S3 regularly rotates. By default this is not set. |  [optional]
**storageCredentialAttributes** | [**FactoryBodyStorageCredentialAttributes**](FactoryBodyStorageCredentialAttributes.md) |  |  [optional]
**storageProvider** | **Integer** | Specifies which storage provider the factory should use. Available options: S3: 0, Google Cloud Storage: 1, FTP storage: 2, Google Cloud Interoperability Storage: 5, Flip storage: 7, FASP storage: 8, Azure Blob Storage: 9 |  [optional]


<a name="AclEnum"></a>
## Enum: AclEnum
Name | Value
---- | -----
PUBLIC | &quot;public&quot;
PRIVATE | &quot;private&quot;



