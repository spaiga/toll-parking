# PricingPolicyApi

All URIs are relative to *http://localhost:8080/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addFixedThenLinearPricingPolicy**](PricingPolicyApi.md#addFixedThenLinearPricingPolicy) | **POST** /pricingPolicies/fixedThenlinearPricingPolicy | Creates a PricingPolicy of type &#x60;FixedThenLinear&#x60;
[**addLinearPricingPolicy**](PricingPolicyApi.md#addLinearPricingPolicy) | **POST** /pricingPolicies/linearPricingPolicy | Creates a PricingPolicy of type &#x60;Linear&#x60;
[**getPricingPolicyById**](PricingPolicyApi.md#getPricingPolicyById) | **GET** /pricingPolicies/{pricingPolicyId} | Returns a Pricing Policy by ID


<a name="addFixedThenLinearPricingPolicy"></a>
# **addFixedThenLinearPricingPolicy**
> FixedThenLinearPricingPolicy addFixedThenLinearPricingPolicy(body)

Creates a PricingPolicy of type &#x60;FixedThenLinear&#x60;

Creates a PricingPolicy of type &#x60;FixedThenLinear&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PricingPolicyApi;


PricingPolicyApi apiInstance = new PricingPolicyApi();
FixedThenLinearPricingPolicy body = new FixedThenLinearPricingPolicy(); // FixedThenLinearPricingPolicy | New pricing policy
try {
    FixedThenLinearPricingPolicy result = apiInstance.addFixedThenLinearPricingPolicy(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PricingPolicyApi#addFixedThenLinearPricingPolicy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**FixedThenLinearPricingPolicy**](FixedThenLinearPricingPolicy.md)| New pricing policy |

### Return type

[**FixedThenLinearPricingPolicy**](FixedThenLinearPricingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="addLinearPricingPolicy"></a>
# **addLinearPricingPolicy**
> LinearPricingPolicy addLinearPricingPolicy(body)

Creates a PricingPolicy of type &#x60;Linear&#x60;

Creates a PricingPolicy of type &#x60;Linear&#x60;

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PricingPolicyApi;


PricingPolicyApi apiInstance = new PricingPolicyApi();
LinearPricingPolicy body = new LinearPricingPolicy(); // LinearPricingPolicy | New pricing policy
try {
    LinearPricingPolicy result = apiInstance.addLinearPricingPolicy(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PricingPolicyApi#addLinearPricingPolicy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**LinearPricingPolicy**](LinearPricingPolicy.md)| New pricing policy |

### Return type

[**LinearPricingPolicy**](LinearPricingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

<a name="getPricingPolicyById"></a>
# **getPricingPolicyById**
> PricingPolicy getPricingPolicyById(pricingPolicyId)

Returns a Pricing Policy by ID

Returns a Pricing Policy by ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.PricingPolicyApi;


PricingPolicyApi apiInstance = new PricingPolicyApi();
Long pricingPolicyId = 789L; // Long | ID of the Pricing Policy to fetch
try {
    PricingPolicy result = apiInstance.getPricingPolicyById(pricingPolicyId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling PricingPolicyApi#getPricingPolicyById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **pricingPolicyId** | **Long**| ID of the Pricing Policy to fetch |

### Return type

[**PricingPolicy**](PricingPolicy.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, application/xml

