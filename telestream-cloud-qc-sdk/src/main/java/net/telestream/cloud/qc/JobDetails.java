/*
 * Qc API
 * QC API
 *
 * OpenAPI spec version: 2.0.1
 * Contact: cloudsupport@telestream.net
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package net.telestream.cloud.qc;

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
import net.telestream.cloud.qc.JobDetailsResult;
import net.telestream.cloud.qc.Media;

/**
 * JobDetails
 */

public class JobDetails {
  @SerializedName("media")
  private List<Media> media = null;

  @SerializedName("result")
  private JobDetailsResult result = null;

  public JobDetails media(List<Media> media) {
    this.media = media;
    return this;
  }

  public JobDetails addMediaItem(Media mediaItem) {
    if (this.media == null) {
      this.media = new ArrayList<Media>();
    }
    this.media.add(mediaItem);
    return this;
  }

   /**
   * Get media
   * @return media
  **/
  @ApiModelProperty(value = "")
  public List<Media> getMedia() {
    return media;
  }

  public void setMedia(List<Media> media) {
    this.media = media;
  }

  public JobDetails result(JobDetailsResult result) {
    this.result = result;
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @ApiModelProperty(value = "")
  public JobDetailsResult getResult() {
    return result;
  }

  public void setResult(JobDetailsResult result) {
    this.result = result;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JobDetails jobDetails = (JobDetails) o;
    return Objects.equals(this.media, jobDetails.media) &&
        Objects.equals(this.result, jobDetails.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(media, result);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JobDetails {\n");
    
    sb.append("    media: ").append(toIndentedString(media)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
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

