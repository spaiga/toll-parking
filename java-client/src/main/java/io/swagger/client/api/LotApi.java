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


import io.swagger.client.model.ErrorModel;
import io.swagger.client.model.Lot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotApi {
    private ApiClient apiClient;

    public LotApi() {
        this(Configuration.getDefaultApiClient());
    }

    public LotApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addLot
     * @param body Lot that needs to be added to the toll parking (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addLotCall(Lot body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/lots";

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
            "application/json", "application/xml"
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
    private com.squareup.okhttp.Call addLotValidateBeforeCall(Lot body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addLot(Async)");
        }
        

        com.squareup.okhttp.Call call = addLotCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add a new Lot to the Tool Parking
     * Add a new Lot to the Tool Parking
     * @param body Lot that needs to be added to the toll parking (required)
     * @return Lot
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Lot addLot(Lot body) throws ApiException {
        ApiResponse<Lot> resp = addLotWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Add a new Lot to the Tool Parking
     * Add a new Lot to the Tool Parking
     * @param body Lot that needs to be added to the toll parking (required)
     * @return ApiResponse&lt;Lot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Lot> addLotWithHttpInfo(Lot body) throws ApiException {
        com.squareup.okhttp.Call call = addLotValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add a new Lot to the Tool Parking (asynchronously)
     * Add a new Lot to the Tool Parking
     * @param body Lot that needs to be added to the toll parking (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addLotAsync(Lot body, final ApiCallback<Lot> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = addLotValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteLot
     * @param lotId ID of lot to delete (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteLotCall(Long lotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/lots/{lotId}"
            .replaceAll("\\{" + "lotId" + "\\}", apiClient.escapeString(lotId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
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
    private com.squareup.okhttp.Call deleteLotValidateBeforeCall(Long lotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'lotId' is set
        if (lotId == null) {
            throw new ApiException("Missing the required parameter 'lotId' when calling deleteLot(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteLotCall(lotId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Deletes a Lot by ID
     * Deletes a single lot based on the ID supplied
     * @param lotId ID of lot to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteLot(Long lotId) throws ApiException {
        deleteLotWithHttpInfo(lotId);
    }

    /**
     * Deletes a Lot by ID
     * Deletes a single lot based on the ID supplied
     * @param lotId ID of lot to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteLotWithHttpInfo(Long lotId) throws ApiException {
        com.squareup.okhttp.Call call = deleteLotValidateBeforeCall(lotId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Deletes a Lot by ID (asynchronously)
     * Deletes a single lot based on the ID supplied
     * @param lotId ID of lot to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteLotAsync(Long lotId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteLotValidateBeforeCall(lotId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getLotByID
     * @param lotId ID of the lot to fetch (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getLotByIDCall(Long lotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/lots/{lotId}"
            .replaceAll("\\{" + "lotId" + "\\}", apiClient.escapeString(lotId.toString()));

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
    private com.squareup.okhttp.Call getLotByIDValidateBeforeCall(Long lotId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'lotId' is set
        if (lotId == null) {
            throw new ApiException("Missing the required parameter 'lotId' when calling getLotByID(Async)");
        }
        

        com.squareup.okhttp.Call call = getLotByIDCall(lotId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Returns a Lot by ID
     * Returns a Lot by ID
     * @param lotId ID of the lot to fetch (required)
     * @return Lot
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Lot getLotByID(Long lotId) throws ApiException {
        ApiResponse<Lot> resp = getLotByIDWithHttpInfo(lotId);
        return resp.getData();
    }

    /**
     * Returns a Lot by ID
     * Returns a Lot by ID
     * @param lotId ID of the lot to fetch (required)
     * @return ApiResponse&lt;Lot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Lot> getLotByIDWithHttpInfo(Long lotId) throws ApiException {
        com.squareup.okhttp.Call call = getLotByIDValidateBeforeCall(lotId, null, null);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Returns a Lot by ID (asynchronously)
     * Returns a Lot by ID
     * @param lotId ID of the lot to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getLotByIDAsync(Long lotId, final ApiCallback<Lot> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getLotByIDValidateBeforeCall(lotId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updateLotStatus
     * @param body Lot that needs to be updated (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updateLotStatusCall(Lot body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/lots";

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
            "application/json", "application/xml"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updateLotStatusValidateBeforeCall(Lot body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling updateLotStatus(Async)");
        }
        

        com.squareup.okhttp.Call call = updateLotStatusCall(body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Update the Status of a Lot
     * Update the Status of a Lot
     * @param body Lot that needs to be updated (required)
     * @return Lot
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Lot updateLotStatus(Lot body) throws ApiException {
        ApiResponse<Lot> resp = updateLotStatusWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Update the Status of a Lot
     * Update the Status of a Lot
     * @param body Lot that needs to be updated (required)
     * @return ApiResponse&lt;Lot&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Lot> updateLotStatusWithHttpInfo(Lot body) throws ApiException {
        com.squareup.okhttp.Call call = updateLotStatusValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update the Status of a Lot (asynchronously)
     * Update the Status of a Lot
     * @param body Lot that needs to be updated (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updateLotStatusAsync(Lot body, final ApiCallback<Lot> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = updateLotStatusValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Lot>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
