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


package io.swagger.client;

import com.squareup.okhttp.*;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

import java.io.IOException;

/**
 * Encodes request bodies using gzip.
 *
 * Taken from https://github.com/square/okhttp/issues/350
 */
class GzipRequestInterceptor implements Interceptor {
    @Override public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        if (originalRequest.body() == null || originalRequest.header("Content-Encoding") != null) {
            return chain.proceed(originalRequest);
        }

        Request compressedRequest = originalRequest.newBuilder()
                                                   .header("Content-Encoding", "gzip")
                                                   .method(originalRequest.method(), forceContentLength(gzip(originalRequest.body())))
                                                   .build();
        return chain.proceed(compressedRequest);
    }

    private RequestBody forceContentLength(final RequestBody requestBody) throws IOException {
        final Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        return new RequestBody() {
            @Override
            public MediaType contentType() {
                return requestBody.contentType();
            }

            @Override
            public long contentLength() {
                return buffer.size();
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.write(buffer.snapshot());
            }
        };
    }

    private RequestBody gzip(final RequestBody body) {
        return new RequestBody() {
            @Override public MediaType contentType() {
                return body.contentType();
            }

            @Override public long contentLength() {
                return -1; // We don't know the compressed length in advance!
            }

            @Override public void writeTo(BufferedSink sink) throws IOException {
                BufferedSink gzipSink = Okio.buffer(new GzipSink(sink));
                body.writeTo(gzipSink);
                gzipSink.close();
            }
        };
    }
}