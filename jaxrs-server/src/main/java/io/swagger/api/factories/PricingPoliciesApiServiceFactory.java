package io.swagger.api.factories;

import com.spiga.api.impl.MockPricingPoliciesApiServiceImpl;

import io.swagger.api.PricingPoliciesApiService;
import io.swagger.api.impl.PricingPoliciesApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class PricingPoliciesApiServiceFactory {
    private final static PricingPoliciesApiService service = new MockPricingPoliciesApiServiceImpl();

    public static PricingPoliciesApiService getPricingPoliciesApi() {
        return service;
    }
}
