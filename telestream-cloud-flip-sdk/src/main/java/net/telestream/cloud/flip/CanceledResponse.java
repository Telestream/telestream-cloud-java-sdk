/*
 * Flip API
 * Description
 *
 * OpenAPI spec version: 2.0.1
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

/**
 * CanceledResponse
 */

public class CanceledResponse {
  @SerializedName("canceled")
  private Boolean canceled = null;

  public CanceledResponse canceled(Boolean canceled) {
    this.canceled = canceled;
    return this;
  }

   /**
   * Informs whether an action has been canceled successfully.
   * @return canceled
  **/
  @ApiModelProperty(value = "Informs whether an action has been canceled successfully.")
  public Boolean isCanceled() {
    return canceled;
  }

  public void setCanceled(Boolean canceled) {
    this.canceled = canceled;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CanceledResponse canceledResponse = (CanceledResponse) o;
    return Objects.equals(this.canceled, canceledResponse.canceled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(canceled);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CanceledResponse {\n");
    
    sb.append("    canceled: ").append(toIndentedString(canceled)).append("\n");
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

