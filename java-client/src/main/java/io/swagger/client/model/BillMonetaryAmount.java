/*
 * Toll Parking API
 * # API information The document aims at describing the Toll Parking API create by `Fabio SPIGA`.  Through Toll Parking API, an end user is able to search for the most convenient parking lot for its own vehicle, drive to it and park. At the moment of leaving, the API allows to compute the amount to pay and bill the end user.  ## CRUD operations All our URLs are [RESTful](http://en.wikipedia.org/wiki/Representational_state_transfer). Every endpoint (URL) may support one of four different http verbs. GET requests fetch information about an object, POST requests create objects, PUT requests update objects and DELETE requests will delete objects.  ## Main Resources ### Parking The central resource is the `Parking`: this resource represents an ongoing occupancy of a `Lot` from a `Car`. It is in charge of keeping the information regarding the time spent so allowing the computation of the `Bill`.  ### Lot `Lot` refers to a parking lot of any type. It is  It display of the air seat map, allowing the end user to identify the seat to be booked for free or at a charge.  ### PricingPolicy A `Pricing Policy` is the formule to compute a bill.  ### Car The `Car` resource represent any potential user of the toll parking, that is cars, motorbikes, vans and so on.     ## Limitations - The    ## Examples ``` GET /lots ``` will return all the parking lots with their details ``` GET /lots/findAvailable?facility=powerSupply20kw ``` will filter all the parking lots with status 'available' and providing for a 20kW power supply 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: spiga.fabio@gmail.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * BillMonetaryAmount
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2019-06-24T08:37:54.969Z")
public class BillMonetaryAmount {
  @SerializedName("currency")
  private String currency = null;

  @SerializedName("amount")
  private BigDecimal amount = null;

  public BillMonetaryAmount currency(String currency) {
    this.currency = currency;
    return this;
  }

   /**
   * Get currency
   * @return currency
  **/
  @ApiModelProperty(value = "")
  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BillMonetaryAmount amount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BillMonetaryAmount billMonetaryAmount = (BillMonetaryAmount) o;
    return Objects.equals(this.currency, billMonetaryAmount.currency) &&
        Objects.equals(this.amount, billMonetaryAmount.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(currency, amount);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BillMonetaryAmount {\n");
    
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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
