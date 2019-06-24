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


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.Bill;
import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Lot;
import io.swagger.client.model.Parking;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingApi {
    private ApiClient apiClient;

    public ParkingApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ParkingApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addParking
     * @param body New Parking of a Vehicle (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addParkingCall(Parking body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/parkings";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addParkingValidateBeforeCall(Parking body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addParking(Async)");
        }
        

        com.squareup.okhttp.Call call = addParkingCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Start the Parking of a Vehicle
     * Start the Parking of a Vehicle
     * @param body New Parking of a Vehicle (required)
     * @return Parking
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Parking addParking(Parking body) throws ApiException {
        ApiResponse<Parking> resp = addParkingWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Start the Parking of a Vehicle
     * Start the Parking of a Vehicle
     * @param body New Parking of a Vehicle (required)
     * @return ApiResponse&lt;Parking&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Parking> addParkingWithHttpInfo(Parking body) throws ApiException {
        com.squareup.okhttp.Call call = addParkingValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<Parking>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Start the Parking of a Vehicle (asynchronously)
     * Start the Parking of a Vehicle
     * @param body New Parking of a Vehicle (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addParkingAsync(Parking body, final ApiCallback<Parking> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addParkingValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Parking>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteParking
     * @param parkingId ID of the parking to be deleted (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteParkingCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/parkings/{parkingId}"
            .replaceAll("\\{" + "parkingId" + "\\}", apiClient.escapeString(parkingId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteParkingValidateBeforeCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'parkingId' is set
        if (parkingId == null) {
            throw new ApiException("Missing the required parameter 'parkingId' when calling deleteParking(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteParkingCall(parkingId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * End the Parking of a Vehicle
     * Delete a parking by ID
     * @param parkingId ID of the parking to be deleted (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteParking(Long parkingId) throws ApiException {
        deleteParkingWithHttpInfo(parkingId);
    }

    /**
     * End the Parking of a Vehicle
     * Delete a parking by ID
     * @param parkingId ID of the parking to be deleted (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteParkingWithHttpInfo(Long parkingId) throws ApiException {
        com.squareup.okhttp.Call call = deleteParkingValidateBeforeCall(parkingId, null, null);
        return apiClient.execute(call);
    }

    /**
     * End the Parking of a Vehicle (asynchronously)
     * Delete a parking by ID
     * @param parkingId ID of the parking to be deleted (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteParkingAsync(Long parkingId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteParkingValidateBeforeCall(parkingId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getLots
     * @param status Availability of the Lot (optional, default to available)
     * @param carType Power Supply of the Car (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLotsCall(String status, String carType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/lots";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (status != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("status", status));
        if (carType != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("carType", carType));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getLotsValidateBeforeCall(String status, String carType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        

        com.squareup.okhttp.Call call = getLotsCall(status, carType, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a list of Lots, optionally filtered by Status and CarType
     * Returns a list of Lots, optionally filtered by Status and CarType
     * @param status Availability of the Lot (optional, default to available)
     * @param carType Power Supply of the Car (optional)
     * @return List&lt;Lot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Lot> getLots(String status, String carType) throws ApiException {
        ApiResponse<List<Lot>> resp = getLotsWithHttpInfo(status, carType);
        return resp.getData();
    }

    /**
     * Returns a list of Lots, optionally filtered by Status and CarType
     * Returns a list of Lots, optionally filtered by Status and CarType
     * @param status Availability of the Lot (optional, default to available)
     * @param carType Power Supply of the Car (optional)
     * @return ApiResponse&lt;List&lt;Lot&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Lot>> getLotsWithHttpInfo(String status, String carType) throws ApiException {
        com.squareup.okhttp.Call call = getLotsValidateBeforeCall(status, carType, null, null);
        Type localVarReturnType = new TypeToken<List<Lot>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a list of Lots, optionally filtered by Status and CarType (asynchronously)
     * Returns a list of Lots, optionally filtered by Status and CarType
     * @param status Availability of the Lot (optional, default to available)
     * @param carType Power Supply of the Car (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLotsAsync(String status, String carType, final ApiCallback<List<Lot>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getLotsValidateBeforeCall(status, carType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Lot>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getParkingBill
     * @param parkingId ID of the Parking (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getParkingBillCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/parkings/{parkingId}/bill"
            .replaceAll("\\{" + "parkingId" + "\\}", apiClient.escapeString(parkingId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getParkingBillValidateBeforeCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'parkingId' is set
        if (parkingId == null) {
            throw new ApiException("Missing the required parameter 'parkingId' when calling getParkingBill(Async)");
        }
        

        com.squareup.okhttp.Call call = getParkingBillCall(parkingId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Computes and returns the Bill for a Parking
     * Computes and returns the Bill for a Parking
     * @param parkingId ID of the Parking (required)
     * @return Bill
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Bill getParkingBill(Long parkingId) throws ApiException {
        ApiResponse<Bill> resp = getParkingBillWithHttpInfo(parkingId);
        return resp.getData();
    }

    /**
     * Computes and returns the Bill for a Parking
     * Computes and returns the Bill for a Parking
     * @param parkingId ID of the Parking (required)
     * @return ApiResponse&lt;Bill&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Bill> getParkingBillWithHttpInfo(Long parkingId) throws ApiException {
        com.squareup.okhttp.Call call = getParkingBillValidateBeforeCall(parkingId, null, null);
        Type localVarReturnType = new TypeToken<Bill>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Computes and returns the Bill for a Parking (asynchronously)
     * Computes and returns the Bill for a Parking
     * @param parkingId ID of the Parking (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getParkingBillAsync(Long parkingId, final ApiCallback<Bill> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getParkingBillValidateBeforeCall(parkingId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Bill>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getParkingByID
     * @param parkingId ID of the Parking to fetch (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getParkingByIDCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/parkings/{parkingId}"
            .replaceAll("\\{" + "parkingId" + "\\}", apiClient.escapeString(parkingId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json", "application/xml"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getParkingByIDValidateBeforeCall(Long parkingId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'parkingId' is set
        if (parkingId == null) {
            throw new ApiException("Missing the required parameter 'parkingId' when calling getParkingByID(Async)");
        }
        

        com.squareup.okhttp.Call call = getParkingByIDCall(parkingId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a Parking by ID
     * Returns a Parking by ID
     * @param parkingId ID of the Parking to fetch (required)
     * @return Parking
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Parking getParkingByID(Long parkingId) throws ApiException {
        ApiResponse<Parking> resp = getParkingByIDWithHttpInfo(parkingId);
        return resp.getData();
    }

    /**
     * Returns a Parking by ID
     * Returns a Parking by ID
     * @param parkingId ID of the Parking to fetch (required)
     * @return ApiResponse&lt;Parking&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Parking> getParkingByIDWithHttpInfo(Long parkingId) throws ApiException {
        com.squareup.okhttp.Call call = getParkingByIDValidateBeforeCall(parkingId, null, null);
        Type localVarReturnType = new TypeToken<Parking>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a Parking by ID (asynchronously)
     * Returns a Parking by ID
     * @param parkingId ID of the Parking to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getParkingByIDAsync(Long parkingId, final ApiCallback<Parking> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getParkingByIDValidateBeforeCall(parkingId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Parking>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}