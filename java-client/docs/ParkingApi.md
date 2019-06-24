# ParkingApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addParking**](ParkingApi.md#addParking) | **POST** /parkings | Start the Parking of a Vehicle
[**deleteParking**](ParkingApi.md#deleteParking) | **DELETE** /parkings/{parkingId} | End the Parking of a Vehicle
[**getLots**](ParkingApi.md#getLots) | **GET** /lots | Returns a list of Lots, optionally filtered by Status and CarType
[**getParkingBill**](ParkingApi.md#getParkingBill) | **GET** /parkings/{parkingId}/bill | Computes and returns the Bill for a Parking
[**getParkingByID**](ParkingApi.md#getParkingByID) | **GET** /parkings/{parkingId} | Returns a Parking by ID


<a name="addParking"></a>
# **addParking**
> Parking addParking(body)

Start the Parking of a Vehicle

Start the Parking of a Vehicle

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ParkingApi;


ParkingApi apiInstance = new ParkingApi();
Parking body = new Parking(); // Parking | New Parking of a Vehicle
try {
    Parking result = apiInstance.addParking(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ParkingApi#addParking");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Parking**](Parking.md)| New Parking of a Vehicle |

### Return type

[**Parking**](Parking.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="deleteParking"></a>
# **deleteParking**
> deleteParking(parkingId)

End the Parking of a Vehicle

Delete a parking by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ParkingApi;


ParkingApi apiInstance = new ParkingApi();
Long parkingId = 789L; // Long | ID of the parking to be deleted
try {
    apiInstance.deleteParking(parkingId);
} catch (ApiException e) {
    System.err.println("Exception when calling ParkingApi#deleteParking");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parkingId** | **Long**| ID of the parking to be deleted |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="getLots"></a>
# **getLots**
> List&lt;Lot&gt; getLots(status, carType)

Returns a list of Lots, optionally filtered by Status and CarType

Returns a list of Lots, optionally filtered by Status and CarType

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ParkingApi;


ParkingApi apiInstance = new ParkingApi();
String status = "available"; // String | Availability of the Lot
String carType = "carType_example"; // String | Power Supply of the Car
try {
    List<Lot> result = apiInstance.getLots(status, carType);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ParkingApi#getLots");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **status** | **String**| Availability of the Lot | [optional] [default to available] [enum: available, busy]
 **carType** | **String**| Power Supply of the Car | [optional] [enum: gasoline, electric20kw, electric50kw]

### Return type

[**List&lt;Lot&gt;**](Lot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="getParkingBill"></a>
# **getParkingBill**
> Bill getParkingBill(parkingId)

Computes and returns the Bill for a Parking

Computes and returns the Bill for a Parking

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ParkingApi;


ParkingApi apiInstance = new ParkingApi();
Long parkingId = 789L; // Long | ID of the Parking
try {
    Bill result = apiInstance.getParkingBill(parkingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ParkingApi#getParkingBill");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parkingId** | **Long**| ID of the Parking |

### Return type

[**Bill**](Bill.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="getParkingByID"></a>
# **getParkingByID**
> Parking getParkingByID(parkingId)

Returns a Parking by ID

Returns a Parking by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ParkingApi;


ParkingApi apiInstance = new ParkingApi();
Long parkingId = 789L; // Long | ID of the Parking to fetch
try {
    Parking result = apiInstance.getParkingByID(parkingId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ParkingApi#getParkingByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **parkingId** | **Long**| ID of the Parking to fetch |

### Return type

[**Parking**](Parking.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

