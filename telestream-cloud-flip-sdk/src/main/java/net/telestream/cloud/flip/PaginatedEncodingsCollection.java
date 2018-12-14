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
import java.util.ArrayList;
import java.util.List;
import net.telestream.cloud.flip.Encoding;

/**
 * PaginatedEncodingsCollection
 */

public class PaginatedEncodingsCollection {
  @SerializedName("encodings")
  private List<Encoding> encodings = new ArrayList<Encoding>();

  @SerializedName("page")
  private Integer page = null;

  @SerializedName("per_page")
  private Integer perPage = null;

  @SerializedName("total")
  private Integer total = null;

  public PaginatedEncodingsCollection encodings(List<Encoding> encodings) {
    this.encodings = encodings;
    return this;
  }

  public PaginatedEncodingsCollection addEncodingsItem(Encoding encodingsItem) {
    this.encodings.add(encodingsItem);
    return this;
  }

   /**
   * Get encodings
   * @return encodings
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Encoding> getEncodings() {
    return encodings;
  }

  public void setEncodings(List<Encoding> encodings) {
    this.encodings = encodings;
  }

  public PaginatedEncodingsCollection page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * A number of the fetched page.
   * @return page
  **/
  @ApiModelProperty(required = true, value = "A number of the fetched page.")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PaginatedEncodingsCollection perPage(Integer perPage) {
    this.perPage = perPage;
    return this;
  }

   /**
   * A number of encodings per page.
   * @return perPage
  **/
  @ApiModelProperty(required = true, value = "A number of encodings per page.")
  public Integer getPerPage() {
    return perPage;
  }

  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public PaginatedEncodingsCollection total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * A number of all encodings stored in the db.
   * @return total
  **/
  @ApiModelProperty(required = true, value = "A number of all encodings stored in the db.")
  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaginatedEncodingsCollection paginatedEncodingsCollection = (PaginatedEncodingsCollection) o;
    return Objects.equals(this.encodings, paginatedEncodingsCollection.encodings) &&
        Objects.equals(this.page, paginatedEncodingsCollection.page) &&
        Objects.equals(this.perPage, paginatedEncodingsCollection.perPage) &&
        Objects.equals(this.total, paginatedEncodingsCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(encodings, page, perPage, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedEncodingsCollection {\n");
    
    sb.append("    encodings: ").append(toIndentedString(encodings)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
    sb.append("    perPage: ").append(toIndentedString(perPage)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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
