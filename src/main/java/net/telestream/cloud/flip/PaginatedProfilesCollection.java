/*
 * Flip API
 * Description
 *
 * OpenAPI spec version: 3.1.0
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
import net.telestream.cloud.flip.Profile;

/**
 * PaginatedProfilesCollection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-11-15T18:18:06.971+01:00")
public class PaginatedProfilesCollection {
  @SerializedName("profiles")
  private List<Profile> profiles = null;

  @SerializedName("page")
  private Integer page = null;

  @SerializedName("per_page")
  private Integer perPage = null;

  @SerializedName("total")
  private Integer total = null;

  public PaginatedProfilesCollection profiles(List<Profile> profiles) {
    this.profiles = profiles;
    return this;
  }

  public PaginatedProfilesCollection addProfilesItem(Profile profilesItem) {
    if (this.profiles == null) {
      this.profiles = new ArrayList<Profile>();
    }
    this.profiles.add(profilesItem);
    return this;
  }

   /**
   * Get profiles
   * @return profiles
  **/
  @ApiModelProperty(value = "")
  public List<Profile> getProfiles() {
    return profiles;
  }

  public void setProfiles(List<Profile> profiles) {
    this.profiles = profiles;
  }

  public PaginatedProfilesCollection page(Integer page) {
    this.page = page;
    return this;
  }

   /**
   * A number of the fetched page.
   * @return page
  **/
  @ApiModelProperty(value = "A number of the fetched page.")
  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public PaginatedProfilesCollection perPage(Integer perPage) {
    this.perPage = perPage;
    return this;
  }

   /**
   * A number of profiles per page.
   * @return perPage
  **/
  @ApiModelProperty(value = "A number of profiles per page.")
  public Integer getPerPage() {
    return perPage;
  }

  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public PaginatedProfilesCollection total(Integer total) {
    this.total = total;
    return this;
  }

   /**
   * A number of all profiles stored in the db.
   * @return total
  **/
  @ApiModelProperty(value = "A number of all profiles stored in the db.")
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
    PaginatedProfilesCollection paginatedProfilesCollection = (PaginatedProfilesCollection) o;
    return Objects.equals(this.profiles, paginatedProfilesCollection.profiles) &&
        Objects.equals(this.page, paginatedProfilesCollection.page) &&
        Objects.equals(this.perPage, paginatedProfilesCollection.perPage) &&
        Objects.equals(this.total, paginatedProfilesCollection.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(profiles, page, perPage, total);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaginatedProfilesCollection {\n");
    
    sb.append("    profiles: ").append(toIndentedString(profiles)).append("\n");
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
