package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.ParkingsApiService;
import io.swagger.api.factories.ParkingsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.Bill;
import io.swagger.model.ErrorModel;
import io.swagger.model.Parking;

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

@Path("/parkings")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the parkings API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class ParkingsApi  {
   private final ParkingsApiService delegate;

   public ParkingsApi(@Context ServletConfig servletContext) {
      ParkingsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("ParkingsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (ParkingsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = ParkingsApiServiceFactory.getParkingsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Start the Parking of a Vehicle", notes = "Start the Parking of a Vehicle", response = Parking.class, tags={ "parking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful operation", response = Parking.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid parking", response = Void.class) })
    public Response addParking(@ApiParam(value = "New Parking of a Vehicle" ,required=true) Parking body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addParking(body,securityContext);
    }
    @DELETE
    @Path("/{parkingId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "End the Parking of a Vehicle", notes = "Delete a parking by ID", response = Void.class, tags={ "parking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Parking not found", response = Void.class) })
    public Response deleteParking(@ApiParam(value = "ID of the parking to be deleted",required=true) @PathParam("parkingId") Long parkingId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteParking(parkingId,securityContext);
    }
    @GET
    @Path("/{parkingId}/bill")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Computes and returns the Bill for a Parking", notes = "Computes and returns the Bill for a Parking", response = Bill.class, tags={ "parking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Bill.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    public Response getParkingBill(@ApiParam(value = "ID of the Parking",required=true) @PathParam("parkingId") Long parkingId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getParkingBill(parkingId,securityContext);
    }
    @GET
    @Path("/{parkingId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Returns a Parking by ID", notes = "Returns a Parking by ID", response = Parking.class, tags={ "parking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Parking.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    public Response getParkingByID(@ApiParam(value = "ID of the Parking to fetch",required=true) @PathParam("parkingId") Long parkingId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getParkingByID(parkingId,securityContext);
    }
}
