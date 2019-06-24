package io.swagger.api.factories;

import com.spiga.api.impl.MockParkingsApiServiceImpl;

import io.swagger.api.ParkingsApiService;
import io.swagger.api.impl.ParkingsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class ParkingsApiServiceFactory {
    private final static ParkingsApiService service = new MockParkingsApiServiceImpl();

    public static ParkingsApiService getParkingsApi() {
        return service;
    }
}
