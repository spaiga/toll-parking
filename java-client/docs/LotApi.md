# LotApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLot**](LotApi.md#addLot) | **POST** /lots | Add a new Lot to the Tool Parking
[**deleteLot**](LotApi.md#deleteLot) | **DELETE** /lots/{lotId} | Deletes a Lot by ID
[**getLotByID**](LotApi.md#getLotByID) | **GET** /lots/{lotId} | Returns a Lot by ID
[**updateLotStatus**](LotApi.md#updateLotStatus) | **PUT** /lots | Update the Status of a Lot


<a name="addLot"></a>
# **addLot**
> Lot addLot(body)

Add a new Lot to the Tool Parking

Add a new Lot to the Tool Parking

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LotApi;


LotApi apiInstance = new LotApi();
Lot body = new Lot(); // Lot | Lot that needs to be added to the toll parking
try {
    Lot result = apiInstance.addLot(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LotApi#addLot");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Lot**](Lot.md)| Lot that needs to be added to the toll parking |

### Return type

[**Lot**](Lot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

<a name="deleteLot"></a>
# **deleteLot**
> deleteLot(lotId)

Deletes a Lot by ID

Deletes a single lot based on the ID supplied

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LotApi;


LotApi apiInstance = new LotApi();
Long lotId = 789L; // Long | ID of lot to delete
try {
    apiInstance.deleteLot(lotId);
} catch (ApiException e) {
    System.err.println("Exception when calling LotApi#deleteLot");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lotId** | **Long**| ID of lot to delete |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="getLotByID"></a>
# **getLotByID**
> Lot getLotByID(lotId)

Returns a Lot by ID

Returns a Lot by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LotApi;


LotApi apiInstance = new LotApi();
Long lotId = 789L; // Long | ID of the lot to fetch
try {
    Lot result = apiInstance.getLotByID(lotId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LotApi#getLotByID");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **lotId** | **Long**| ID of the lot to fetch |

### Return type

[**Lot**](Lot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="updateLotStatus"></a>
# **updateLotStatus**
> Lot updateLotStatus(body)

Update the Status of a Lot

Update the Status of a Lot

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LotApi;


LotApi apiInstance = new LotApi();
Lot body = new Lot(); // Lot | Lot that needs to be updated
try {
    Lot result = apiInstance.updateLotStatus(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LotApi#updateLotStatus");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**Lot**](Lot.md)| Lot that needs to be updated |

### Return type

[**Lot**](Lot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json, application/xml
 - **Accept**: application/json, application/xml

