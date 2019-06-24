package com.spiga.api.impl;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.spiga.persistence.MockEntityManagerPricingPolicies;

import io.swagger.api.NotFoundException;
import io.swagger.api.PricingPoliciesApiService;
import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.LinearPricingPolicy;
import io.swagger.model.PricingPolicy;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-22T10:19:47.246Z")
public class MockPricingPoliciesApiServiceImpl extends PricingPoliciesApiService {
    @Override
    public Response addFixedThenLinearPricingPolicy(FixedThenLinearPricingPolicy body, SecurityContext securityContext) throws NotFoundException {
        PricingPolicy pp = MockEntityManagerPricingPolicies.getInstance().addPricingPolicy(body);
        System.out.println("Added PricingPolicy with ID #" + pp.getPricingPolicyId());
        return Response.ok().entity(pp).build();
    }
    @Override
    public Response addLinearPricingPolicy(LinearPricingPolicy body, SecurityContext securityContext) throws NotFoundException {
        PricingPolicy pp = MockEntityManagerPricingPolicies.getInstance().addPricingPolicy(body);
        System.out.println("Added PricingPolicy with ID #" + pp.getPricingPolicyId());
        return Response.ok().entity(pp).build();
    }
    @Override
    public Response getPricingPolicyById(Long pricingPolicyId, SecurityContext securityContext) throws NotFoundException {
    	PricingPolicy pp = MockEntityManagerPricingPolicies.getInstance().getPricingPolicyByID(pricingPolicyId);
        System.out.println("Returning PricingPolicy #" + pp.getPricingPolicyId()); 
        return Response.ok().entity(pp).build();
    }
}
