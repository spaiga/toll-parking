package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.Bill;
import io.swagger.model.ErrorModel;
import io.swagger.model.Parking;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public abstract class ParkingsApiService {
    public abstract Response addParking(Parking body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteParking( @Min(1L)Long parkingId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getParkingBill(Long parkingId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getParkingByID(Long parkingId,SecurityContext securityContext) throws NotFoundException;
}
