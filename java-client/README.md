# swagger-java-client

Toll Parking API
- API version: 1.0.0
  - Build date: 2019-06-24T08:37:54.969Z

# API information 
The document aims at describing the Toll Parking API create by `Fabio SPIGA`.  Through Toll Parking API, an end user is able to search for the most convenient parking lot for its own vehicle, drive to it and park. At the moment of leaving, the API allows to compute the amount to pay and bill the end user.  ## CRUD operations All our URLs are [RESTful](http://en.wikipedia.org/wiki/Representational_state_transfer). Every endpoint (URL) may support one of four different http verbs. GET requests fetch information about an object, POST requests create objects, PUT requests update objects and DELETE requests will delete objects.  ## Main Resources ### Parking The central resource is the `Parking`: this resource represents an ongoing occupancy of a `Lot` from a `Car`. It is in charge of keeping the information regarding the time spent so allowing the computation of the `Bill`.  ### Lot `Lot` refers to a parking lot of any type. It is  It display of the air seat map, allowing the end user to identify the seat to be booked for free or at a charge.  ### PricingPolicy A `Pricing Policy` is the formule to compute a bill.  ### Car The `Car` resource represent any potential user of the toll parking, that is cars, motorbikes, vans and so on.     ## Limitations - The    ## Examples ``` GET /lots ``` will return all the parking lots with their details ``` GET /lots/findAvailable?facility=powerSupply20kw ``` will filter all the parking lots with status 'available' and providing for a 20kW power supply 


*Automatically generated by the [Swagger Codegen](https://github.com/swagger-api/swagger-codegen)*


## Requirements

Building the API client library requires:
1. Java 1.7+
2. Maven/Gradle

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn clean install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn clean deploy
```

Refer to the [OSSRH Guide](http://central.sonatype.org/pages/ossrh-guide.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-java-client</artifactId>
  <version>1.0.0</version>
  <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

```shell
mvn clean package
```

Then manually install the following JARs:

* `target/swagger-java-client-1.0.0.jar`
* `target/lib/*.jar`

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.LotApi;

import java.io.File;
import java.util.*;

public class LotApiExample {

    public static void main(String[] args) {
        
        LotApi apiInstance = new LotApi();
        Lot body = new Lot(); // Lot | Lot that needs to be added to the toll parking
        try {
            Lot result = apiInstance.addLot(body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling LotApi#addLot");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *http://localhost:8080/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*LotApi* | [**addLot**](docs/LotApi.md#addLot) | **POST** /lots | Add a new Lot to the Tool Parking
*LotApi* | [**deleteLot**](docs/LotApi.md#deleteLot) | **DELETE** /lots/{lotId} | Deletes a Lot by ID
*LotApi* | [**getLotByID**](docs/LotApi.md#getLotByID) | **GET** /lots/{lotId} | Returns a Lot by ID
*LotApi* | [**updateLotStatus**](docs/LotApi.md#updateLotStatus) | **PUT** /lots | Update the Status of a Lot
*ParkingApi* | [**addParking**](docs/ParkingApi.md#addParking) | **POST** /parkings | Start the Parking of a Vehicle
*ParkingApi* | [**deleteParking**](docs/ParkingApi.md#deleteParking) | **DELETE** /parkings/{parkingId} | End the Parking of a Vehicle
*ParkingApi* | [**getLots**](docs/ParkingApi.md#getLots) | **GET** /lots | Returns a list of Lots, optionally filtered by Status and CarType
*ParkingApi* | [**getParkingBill**](docs/ParkingApi.md#getParkingBill) | **GET** /parkings/{parkingId}/bill | Computes and returns the Bill for a Parking
*ParkingApi* | [**getParkingByID**](docs/ParkingApi.md#getParkingByID) | **GET** /parkings/{parkingId} | Returns a Parking by ID
*PricingPolicyApi* | [**addFixedThenLinearPricingPolicy**](docs/PricingPolicyApi.md#addFixedThenLinearPricingPolicy) | **POST** /pricingPolicies/fixedThenlinearPricingPolicy | Creates a PricingPolicy of type &#x60;FixedThenLinear&#x60;
*PricingPolicyApi* | [**addLinearPricingPolicy**](docs/PricingPolicyApi.md#addLinearPricingPolicy) | **POST** /pricingPolicies/linearPricingPolicy | Creates a PricingPolicy of type &#x60;Linear&#x60;
*PricingPolicyApi* | [**getPricingPolicyById**](docs/PricingPolicyApi.md#getPricingPolicyById) | **GET** /pricingPolicies/{pricingPolicyId} | Returns a Pricing Policy by ID


## Documentation for Models

 - [Bill](docs/Bill.md)
 - [BillMonetaryAmount](docs/BillMonetaryAmount.md)
 - [Car](docs/Car.md)
 - [ErrorModel](docs/ErrorModel.md)
 - [FixedThenLinearPricingPolicy](docs/FixedThenLinearPricingPolicy.md)
 - [LinearPricingPolicy](docs/LinearPricingPolicy.md)
 - [Lot](docs/Lot.md)
 - [LotCoordinates](docs/LotCoordinates.md)
 - [Parking](docs/Parking.md)
 - [PricingPolicy](docs/PricingPolicy.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

spiga.fabio@gmail.com
