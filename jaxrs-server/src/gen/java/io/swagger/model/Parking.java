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


package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Car;
import javax.validation.constraints.*;

/**
 * Parking
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class Parking   {
  @JsonProperty("parkingId")
  private Long parkingId = null;

  @JsonProperty("lotId")
  private Long lotId = null;

  @JsonProperty("car")
  private Car car = null;

  @JsonProperty("startDate")
  private Long startDate = null;

  @JsonProperty("endDate")
  private Long endDate = null;

  public Parking parkingId(Long parkingId) {
    this.parkingId = parkingId;
    return this;
  }

  /**
   * Get parkingId
   * @return parkingId
   **/
  @JsonProperty("parkingId")
  @ApiModelProperty(value = "")
  public Long getParkingId() {
    return parkingId;
  }

  public void setParkingId(Long parkingId) {
    this.parkingId = parkingId;
  }

  public Parking lotId(Long lotId) {
    this.lotId = lotId;
    return this;
  }

  /**
   * Get lotId
   * @return lotId
   **/
  @JsonProperty("lotId")
  @ApiModelProperty(value = "")
  public Long getLotId() {
    return lotId;
  }

  public void setLotId(Long lotId) {
    this.lotId = lotId;
  }

  public Parking car(Car car) {
    this.car = car;
    return this;
  }

  /**
   * Get car
   * @return car
   **/
  @JsonProperty("car")
  @ApiModelProperty(value = "")
  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public Parking startDate(Long startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Start time of the parking in milliseconds
   * @return startDate
   **/
  @JsonProperty("startDate")
  @ApiModelProperty(value = "Start time of the parking in milliseconds")
  public Long getStartDate() {
    return startDate;
  }

  public void setStartDate(Long startDate) {
    this.startDate = startDate;
  }

  public Parking endDate(Long endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * End time of the parking in milliseconds
   * @return endDate
   **/
  @JsonProperty("endDate")
  @ApiModelProperty(value = "End time of the parking in milliseconds")
  public Long getEndDate() {
    return endDate;
  }

  public void setEndDate(Long endDate) {
    this.endDate = endDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Parking parking = (Parking) o;
    return Objects.equals(this.parkingId, parking.parkingId) &&
        Objects.equals(this.lotId, parking.lotId) &&
        Objects.equals(this.car, parking.car) &&
        Objects.equals(this.startDate, parking.startDate) &&
        Objects.equals(this.endDate, parking.endDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(parkingId, lotId, car, startDate, endDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Parking {\n");
    
    sb.append("    parkingId: ").append(toIndentedString(parkingId)).append("\n");
    sb.append("    lotId: ").append(toIndentedString(lotId)).append("\n");
    sb.append("    car: ").append(toIndentedString(car)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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
