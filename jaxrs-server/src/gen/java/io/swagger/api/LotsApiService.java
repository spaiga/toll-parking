package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import io.swagger.model.ErrorModel;
import io.swagger.model.Lot;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-06-24T08:37:30.304Z")
public abstract class LotsApiService {
    public abstract Response addLot(Lot body,SecurityContext securityContext) throws NotFoundException;
    public abstract Response deleteLot(Long lotId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getLotByID(Long lotId,SecurityContext securityContext) throws NotFoundException;
    public abstract Response getLots( String status, String carType,SecurityContext securityContext) throws NotFoundException;
    public abstract Response updateLotStatus(Lot body,SecurityContext securityContext) throws NotFoundException;
}
