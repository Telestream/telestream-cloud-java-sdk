/*
 * Flip API
 * Description
 *
 * OpenAPI spec version: 2.0.0
 * Contact: cloudsupport@telestream.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.telestream.cloud.flip;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import net.telestream.cloud.flip.CloudNotificationSettingsEvents;

/**
 * CloudNotificationSettings
 */

public class CloudNotificationSettings {
  @SerializedName("url")
  private String url = null;

  @SerializedName("delay")
  private Integer delay = null;

  @SerializedName("send_video_payload")
  private Boolean sendVideoPayload = null;

  @SerializedName("events")
  private CloudNotificationSettingsEvents events = null;

  public CloudNotificationSettings url(String url) {
    this.url = url;
    return this;
  }

   /**
   * Notifications will be sent to this endpoint.
   * @return url
  **/
  @ApiModelProperty(required = true, value = "Notifications will be sent to this endpoint.")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public CloudNotificationSettings delay(Integer delay) {
    this.delay = delay;
    return this;
  }

   /**
   * Get delay
   * @return delay
  **/
  @ApiModelProperty(required = true, value = "")
  public Integer getDelay() {
    return delay;
  }

  public void setDelay(Integer delay) {
    this.delay = delay;
  }

  public CloudNotificationSettings sendVideoPayload(Boolean sendVideoPayload) {
    this.sendVideoPayload = sendVideoPayload;
    return this;
  }

   /**
   * Determines whether a video payload will be included in notification messages.
   * @return sendVideoPayload
  **/
  @ApiModelProperty(required = true, value = "Determines whether a video payload will be included in notification messages.")
  public Boolean isSendVideoPayload() {
    return sendVideoPayload;
  }

  public void setSendVideoPayload(Boolean sendVideoPayload) {
    this.sendVideoPayload = sendVideoPayload;
  }

  public CloudNotificationSettings events(CloudNotificationSettingsEvents events) {
    this.events = events;
    return this;
  }

   /**
   * Get events
   * @return events
  **/
  @ApiModelProperty(required = true, value = "")
  public CloudNotificationSettingsEvents getEvents() {
    return events;
  }

  public void setEvents(CloudNotificationSettingsEvents events) {
    this.events = events;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CloudNotificationSettings cloudNotificationSettings = (CloudNotificationSettings) o;
    return Objects.equals(this.url, cloudNotificationSettings.url) &&
        Objects.equals(this.delay, cloudNotificationSettings.delay) &&
        Objects.equals(this.sendVideoPayload, cloudNotificationSettings.sendVideoPayload) &&
        Objects.equals(this.events, cloudNotificationSettings.events);
  }

  @Override
  public int hashCode() {
    return Objects.hash(url, delay, sendVideoPayload, events);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CloudNotificationSettings {\n");
    
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
    sb.append("    sendVideoPayload: ").append(toIndentedString(sendVideoPayload)).append("\n");
    sb.append("    events: ").append(toIndentedString(events)).append("\n");
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

