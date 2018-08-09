/*
 * Notifications API
 * Notifications API V2
 *
 * OpenAPI spec version: 2.1.0
 * Contact: cloudsupport@telestream.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.telestream.cloud.notifications;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Params
 */

public class Params {
  @SerializedName("addresses")
  private List<String> addresses = null;

  @SerializedName("url")
  private String url = null;

  /**
   * (for webhook subscription type);  HTTP method; default: POST (GET, POST) 
   */
  @JsonAdapter(MethodEnum.Adapter.class)
  public enum MethodEnum {
    GET("GET"),
    
    POST("POST");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<MethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MethodEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("method")
  private MethodEnum method = null;

  @SerializedName("retries")
  private Integer retries = null;

  /**
   * (for webhook subscription type); default: application/json (application/json, application/x-www-form-urlencoded) 
   */
  @JsonAdapter(ContentTypeEnum.Adapter.class)
  public enum ContentTypeEnum {
    JSON("application/json"),
    
    X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded");

    private String value;

    ContentTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static ContentTypeEnum fromValue(String text) {
      for (ContentTypeEnum b : ContentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<ContentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ContentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ContentTypeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ContentTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("content_type")
  private ContentTypeEnum contentType = null;

  @SerializedName("topic_arn")
  private String topicArn = null;

  @SerializedName("role_arn")
  private String roleArn = null;

  @SerializedName("topic_endpoint")
  private String topicEndpoint = null;

  @SerializedName("access_key")
  private String accessKey = null;

  @SerializedName("project_id")
  private String projectId = null;

  @SerializedName("topic_name")
  private String topicName = null;

  public Params addresses(List<String> addresses) {
    this.addresses = addresses;
    return this;
  }

  public Params addAddressesItem(String addressesItem) {
    if (this.addresses == null) {
      this.addresses = new ArrayList<String>();
    }
    this.addresses.add(addressesItem);
    return this;
  }

   /**
   * (for email subscription type);  E-mail addresses 
   * @return addresses
  **/
  @ApiModelProperty(value = "(for email subscription type);  E-mail addresses ")
  public List<String> getAddresses() {
    return addresses;
  }

  public void setAddresses(List<String> addresses) {
    this.addresses = addresses;
  }

  public Params url(String url) {
    this.url = url;
    return this;
  }

   /**
   * (for webhook subscription type);  Webhook URL 
   * @return url
  **/
  @ApiModelProperty(value = "(for webhook subscription type);  Webhook URL ")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Params method(MethodEnum method) {
    this.method = method;
    return this;
  }

   /**
   * (for webhook subscription type);  HTTP method; default: POST (GET, POST) 
   * @return method
  **/
  @ApiModelProperty(value = "(for webhook subscription type);  HTTP method; default: POST (GET, POST) ")
  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }

  public Params retries(Integer retries) {
    this.retries = retries;
    return this;
  }

   /**
   * (for webhook subscription type);  Number of retries before forgetting the notification; default: 0 
   * @return retries
  **/
  @ApiModelProperty(value = "(for webhook subscription type);  Number of retries before forgetting the notification; default: 0 ")
  public Integer getRetries() {
    return retries;
  }

  public void setRetries(Integer retries) {
    this.retries = retries;
  }

  public Params contentType(ContentTypeEnum contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * (for webhook subscription type); default: application/json (application/json, application/x-www-form-urlencoded) 
   * @return contentType
  **/
  @ApiModelProperty(value = "(for webhook subscription type); default: application/json (application/json, application/x-www-form-urlencoded) ")
  public ContentTypeEnum getContentType() {
    return contentType;
  }

  public void setContentType(ContentTypeEnum contentType) {
    this.contentType = contentType;
  }

  public Params topicArn(String topicArn) {
    this.topicArn = topicArn;
    return this;
  }

   /**
   * (for sns subscription type) identifier of an AWS SNS Topic that events will be posted to. 
   * @return topicArn
  **/
  @ApiModelProperty(value = "(for sns subscription type) identifier of an AWS SNS Topic that events will be posted to. ")
  public String getTopicArn() {
    return topicArn;
  }

  public void setTopicArn(String topicArn) {
    this.topicArn = topicArn;
  }

  public Params roleArn(String roleArn) {
    this.roleArn = roleArn;
    return this;
  }

   /**
   * (for sns subscription type) identifier of an AWS IAM Role that will be used for authorization. 
   * @return roleArn
  **/
  @ApiModelProperty(value = "(for sns subscription type) identifier of an AWS IAM Role that will be used for authorization. ")
  public String getRoleArn() {
    return roleArn;
  }

  public void setRoleArn(String roleArn) {
    this.roleArn = roleArn;
  }

  public Params topicEndpoint(String topicEndpoint) {
    this.topicEndpoint = topicEndpoint;
    return this;
  }

   /**
   * (for aeg subscription type) address of an Azure Event Grid Topic that events will be posted to. 
   * @return topicEndpoint
  **/
  @ApiModelProperty(value = "(for aeg subscription type) address of an Azure Event Grid Topic that events will be posted to. ")
  public String getTopicEndpoint() {
    return topicEndpoint;
  }

  public void setTopicEndpoint(String topicEndpoint) {
    this.topicEndpoint = topicEndpoint;
  }

  public Params accessKey(String accessKey) {
    this.accessKey = accessKey;
    return this;
  }

   /**
   * (for aeg subscription type) secret access key that authorizes Telestream Cloud to write to an Azure Event Grid Topic. 
   * @return accessKey
  **/
  @ApiModelProperty(value = "(for aeg subscription type) secret access key that authorizes Telestream Cloud to write to an Azure Event Grid Topic. ")
  public String getAccessKey() {
    return accessKey;
  }

  public void setAccessKey(String accessKey) {
    this.accessKey = accessKey;
  }

  public Params projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

   /**
   * (for pubsub subscription type) id of a Google Cloud project that hosts the topic. 
   * @return projectId
  **/
  @ApiModelProperty(value = "(for pubsub subscription type) id of a Google Cloud project that hosts the topic. ")
  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public Params topicName(String topicName) {
    this.topicName = topicName;
    return this;
  }

   /**
   * (for pubsub subscription type) name of a Google Cloud Pub/Sub topic to which notifications will be published. 
   * @return topicName
  **/
  @ApiModelProperty(value = "(for pubsub subscription type) name of a Google Cloud Pub/Sub topic to which notifications will be published. ")
  public String getTopicName() {
    return topicName;
  }

  public void setTopicName(String topicName) {
    this.topicName = topicName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Params params = (Params) o;
    return Objects.equals(this.addresses, params.addresses) &&
        Objects.equals(this.url, params.url) &&
        Objects.equals(this.method, params.method) &&
        Objects.equals(this.retries, params.retries) &&
        Objects.equals(this.contentType, params.contentType) &&
        Objects.equals(this.topicArn, params.topicArn) &&
        Objects.equals(this.roleArn, params.roleArn) &&
        Objects.equals(this.topicEndpoint, params.topicEndpoint) &&
        Objects.equals(this.accessKey, params.accessKey) &&
        Objects.equals(this.projectId, params.projectId) &&
        Objects.equals(this.topicName, params.topicName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addresses, url, method, retries, contentType, topicArn, roleArn, topicEndpoint, accessKey, projectId, topicName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Params {\n");
    
    sb.append("    addresses: ").append(toIndentedString(addresses)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    retries: ").append(toIndentedString(retries)).append("\n");
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    topicArn: ").append(toIndentedString(topicArn)).append("\n");
    sb.append("    roleArn: ").append(toIndentedString(roleArn)).append("\n");
    sb.append("    topicEndpoint: ").append(toIndentedString(topicEndpoint)).append("\n");
    sb.append("    accessKey: ").append(toIndentedString(accessKey)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    topicName: ").append(toIndentedString(topicName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

