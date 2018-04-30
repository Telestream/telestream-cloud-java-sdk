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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project
 */

public class Project {
  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  /**
   * Project status.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    ACTIVE("active"),
    
    PENDING("pending"),
    
    ARCHIVED("archived"),
    
    SUSPENDED("suspended");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return StatusEnum.fromValue(String.valueOf(value));
      }
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("template")
  private String template = null;

  @SerializedName("options")
  private Map<String, Object> options = null;

  public Project id(String id) {
    this.id = id;
    return this;
  }

   /**
   * A unique identifier of a Project.
   * @return id
  **/
  @ApiModelProperty(value = "A unique identifier of a Project.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Project name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Human-readable identifier of a Project.
   * @return name
  **/
  @ApiModelProperty(value = "Human-readable identifier of a Project.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Project status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Project status.
   * @return status
  **/
  @ApiModelProperty(value = "Project status.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Project template(String template) {
    this.template = template;
    return this;
  }

   /**
   * Name of QC template.
   * @return template
  **/
  @ApiModelProperty(value = "Name of QC template.")
  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public Project options(Map<String, Object> options) {
    this.options = options;
    return this;
  }

  public Project putOptionsItem(String key, Object optionsItem) {
    if (this.options == null) {
      this.options = new HashMap<String, Object>();
    }
    this.options.put(key, optionsItem);
    return this;
  }

   /**
   * JSON with specific options
   * @return options
  **/
  @ApiModelProperty(example = "{\"file_tests\":{\"container_test\":{\"checked\":true,\"container\":\"Mov\",\"reject_on_error\":true},\"video_codec_test\":{\"checked\":true,\"video_codec\":\"ProRes\",\"video_profile\":\"VideoProfileNone\",\"video_level\":\"VideoLevelNone\",\"reject_on_error\":true},\"container_essence_consistency_test\":{\"checked\":true},\"enhanced_syntax_test\":{\"checked\":true},\"framesize_test\":{\"checked\":true,\"horizontal_size\":1920,\"vertical_size\":1080},\"pixel_aspect_ratio_test\":{\"checked\":true,\"pixel_aspect_ratio_numerator\":1,\"pixel_aspect_ratio_denominator\":1},\"i_tunes_compatibility_test\":{\"checked\":true,\"reject_on_error\":true},\"framerate_test\":{\"checked\":true,\"framerate_numerator\":25,\"framerate_denominator\":1},\"video_bit_rate_mode_test\":{\"checked\":true,\"mode\":\"VBR\"},\"video_bitrate_test\":{\"checked\":true,\"video_bitrate_lower\":88,\"video_bitrate_upper\":220}}}", value = "JSON with specific options")
  public Map<String, Object> getOptions() {
    return options;
  }

  public void setOptions(Map<String, Object> options) {
    this.options = options;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Project project = (Project) o;
    return Objects.equals(this.id, project.id) &&
        Objects.equals(this.name, project.name) &&
        Objects.equals(this.status, project.status) &&
        Objects.equals(this.template, project.template) &&
        Objects.equals(this.options, project.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, template, options);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Project {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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

