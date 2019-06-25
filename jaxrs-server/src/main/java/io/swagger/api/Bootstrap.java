package io.swagger.api;

import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.models.*;

import io.swagger.models.auth.*;

import javax.servlet.http.HttpServlet;

import com.spiga.persistence.MockTollParkingInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

public class Bootstrap extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    Info info = new Info()
      .title("Swagger Server")
      .description("# API information The document aims at describing the Toll Parking API create by `Fabio SPIGA`.  Through Toll Parking API, an end user is able to search for the most convenient parking lot for its own vehicle, drive to it and park. At the moment of leaving, the API allows to compute the amount to pay and bill the end user.  ## CRUD operations All our URLs are [RESTful](http://en.wikipedia.org/wiki/Representational_state_transfer). Every endpoint (URL) may support one of four different http verbs. GET requests fetch information about an object, POST requests create objects, PUT requests update objects and DELETE requests will delete objects.  ## Main Resources ### Parking The central resource is the `Parking`: this resource represents an ongoing occupancy of a `Lot` from a `Car`. It is in charge of keeping the information regarding the time spent so allowing the computation of the `Bill`.  ### Lot `Lot` refers to a parking lot of any type. It is  It display of the air seat map, allowing the end user to identify the seat to be booked for free or at a charge.  ### PricingPolicy A `Pricing Policy` is the formule to compute a bill.  ### Car The `Car` resource represent any potential user of the toll parking, that is cars, motorbikes, vans and so on.     ## Limitations - The    ## Examples ``` GET /lots ``` will return all the parking lots with their details ``` GET /lots/findAvailable?facility=powerSupply20kw ``` will filter all the parking lots with status 'available' and providing for a 20kW power supply ")
      .termsOfService("")
      .contact(new Contact()
        .email("spiga.fabio@gmail.com"))
      .license(new License()
        .name("")
        .url("http://unlicense.org"));

    ServletContext context = config.getServletContext();
    Swagger swagger = new Swagger().info(info);

    new SwaggerContextService().withServletConfig(config).updateSwagger(swagger);
    
    // Initializing the in-memory database with a prefilled set of Lots and Pricing Policies
    MockTollParkingInitializer.getInstance().initParkingConfiguration();
  }
}
