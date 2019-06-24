package io.swagger.api.factories;

import com.spiga.api.impl.MockLotsApiServiceImpl;

import io.swagger.api.LotsApiService;
import io.swagger.api.impl.LotsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class LotsApiServiceFactory {
    private final static LotsApiService service = new MockLotsApiServiceImpl();

    public static LotsApiService getLotsApi() {
        return service;
    }
}
