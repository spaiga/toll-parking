package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PricingPoliciesApiService;
import io.swagger.api.factories.PricingPoliciesApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ErrorModel;
import io.swagger.model.FixedThenLinearPricingPolicy;
import io.swagger.model.LinearPricingPolicy;
import io.swagger.model.PricingPolicy;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/pricingPolicies")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the pricingPolicies API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class PricingPoliciesApi  {
   private final PricingPoliciesApiService delegate;

   public PricingPoliciesApi(@Context ServletConfig servletContext) {
      PricingPoliciesApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("PricingPoliciesApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (PricingPoliciesApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = PricingPoliciesApiServiceFactory.getPricingPoliciesApi();
      }

      this.delegate = delegate;
   }

    @POST
    @Path("/fixedThenlinearPricingPolicy")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Creates a PricingPolicy of type `FixedThenLinear`", notes = "Creates a PricingPolicy of type `FixedThenLinear`", response = FixedThenLinearPricingPolicy.class, tags={ "pricingPolicy", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = FixedThenLinearPricingPolicy.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Pricing Policy", response = Void.class) })
    public Response addFixedThenLinearPricingPolicy(@ApiParam(value = "New pricing policy" ,required=true) FixedThenLinearPricingPolicy body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addFixedThenLinearPricingPolicy(body,securityContext);
    }
    @POST
    @Path("/linearPricingPolicy")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Creates a PricingPolicy of type `Linear`", notes = "Creates a PricingPolicy of type `Linear`", response = LinearPricingPolicy.class, tags={ "pricingPolicy", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = LinearPricingPolicy.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid Pricing Policy", response = Void.class) })
    public Response addLinearPricingPolicy(@ApiParam(value = "New pricing policy" ,required=true) LinearPricingPolicy body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addLinearPricingPolicy(body,securityContext);
    }
    @GET
    @Path("/{pricingPolicyId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Returns a Pricing Policy by ID", notes = "Returns a Pricing Policy by ID", response = PricingPolicy.class, tags={ "pricingPolicy", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = PricingPolicy.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    public Response getPricingPolicyById(@ApiParam(value = "ID of the Pricing Policy to fetch",required=true) @PathParam("pricingPolicyId") Long pricingPolicyId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getPricingPolicyById(pricingPolicyId,securityContext);
    }
}
