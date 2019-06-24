Folder Structure
============================

### The current project is structured as follows

    .
    ├── java-client	      		    # API Java Client
    ├── jaxrs-server                    # API JAX-RS Server
    └── spiga-parking-api-spec          # API Documentation


### spiga-parking-api-spec

Swagger UI allows anyone — be it your development team or your end consumers — to visualize and interact 
with the API’s resources without having any of the implementation logic in place. 
It’s automatically generated from Swagger Specification, with the visual documentation making it easy for back end 
implementation and client side consumption.


### jaxrs-server

Contains the server publishing the API:
the server stubs have been automatically generated thanks to Swagger Codegen and 
then enhanced in order to simulate a pre-filled database and implementing the functionalities to interact with that.


### java-client
Contains an example of Java client of the API:
the client stubs have been automatically generated thanks to Swagger Codegen and then enhanced to create a simple client class as example and 
JUnit class to test the main functionalities.