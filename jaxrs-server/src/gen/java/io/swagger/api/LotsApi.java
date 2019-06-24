package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.LotsApiService;
import io.swagger.api.factories.LotsApiServiceFactory;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import io.swagger.model.ErrorModel;
import io.swagger.model.Lot;

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

@Path("/lots")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the lots API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public class LotsApi  {
   private final LotsApiService delegate;

   public LotsApi(@Context ServletConfig servletContext) {
      LotsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("LotsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (LotsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = LotsApiServiceFactory.getLotsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Add a new Lot to the Tool Parking", notes = "Add a new Lot to the Tool Parking", response = Lot.class, tags={ "lot", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Lot.class) })
    public Response addLot(@ApiParam(value = "Lot that needs to be added to the toll parking" ,required=true) Lot body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.addLot(body,securityContext);
    }
    @DELETE
    @Path("/{lotId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Deletes a Lot by ID", notes = "Deletes a single lot based on the ID supplied", response = Void.class, tags={ "lot", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 204, message = "lot deleted", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    public Response deleteLot(@ApiParam(value = "ID of lot to delete",required=true) @PathParam("lotId") Long lotId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteLot(lotId,securityContext);
    }
    @GET
    @Path("/{lotId}")
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Returns a Lot by ID", notes = "Returns a Lot by ID", response = Lot.class, tags={ "lot", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Lot.class),
        
        @io.swagger.annotations.ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    public Response getLotByID(@ApiParam(value = "ID of the lot to fetch",required=true) @PathParam("lotId") Long lotId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getLotByID(lotId,securityContext);
    }
    @GET
    
    @Consumes({ "application/json" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Returns a list of Lots, optionally filtered by Status and CarType", notes = "Returns a list of Lots, optionally filtered by Status and CarType", response = Lot.class, responseContainer = "List", tags={ "parking", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Lot.class, responseContainer = "List"),
        
        @io.swagger.annotations.ApiResponse(code = 204, message = "No Lots found!", response = Void.class) })
    public Response getLots(@ApiParam(value = "Availability of the Lot", allowableValues="available, busy", defaultValue="available") @DefaultValue("available") @QueryParam("status") String status
,@ApiParam(value = "Power Supply of the Car", allowableValues="gasoline, electric20kw, electric50kw") @QueryParam("carType") String carType
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.getLots(status,carType,securityContext);
    }
    @PUT
    
    @Consumes({ "application/json", "application/xml" })
    @Produces({ "application/json", "application/xml" })
    @io.swagger.annotations.ApiOperation(value = "Update the Status of a Lot", notes = "Update the Status of a Lot", response = Lot.class, tags={ "lot", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "successful response", response = Lot.class),
        
        @io.swagger.annotations.ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Lot not found", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 405, message = "Validation exception", response = Void.class) })
    public Response updateLotStatus(@ApiParam(value = "Lot that needs to be updated" ,required=true) Lot body
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.updateLotStatus(body,securityContext);
    }
}
