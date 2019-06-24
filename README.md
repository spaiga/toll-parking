# Toll Parking API

The document aims at describing the Toll Parking API create by `Fabio SPIGA`.

Through Toll Parking API, an end user is able to search for the most convenient parking lot for its own vehicle, drive to it and park. 
At the moment of leaving, the API allows to compute the amount to pay and bill the end user.


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Prerequisites
Make sure you have installed all of the following prerequisites on your development machine:
* Git - [Download & Install Git](https://git-scm.com/downloads)
* Java JDK 8 - [Download & Install JDK](https://www.oracle.com/technetwork/java/javaee/downloads/index.html)

## Installing Toll Parking API
There are several ways you can get the Toll Parking project:

### Cloning The GitHub Repository
The recommended way to get the Toll Parking project is to use git to directly clone the repository:

```bash
$ git clone https://github.com/spaiga/toll-parking.git toll-parking
```

This will clone the latest version of the toll-parking repository to a **toll-parking** folder.

### Downloading The Repository Zip File
Another way to use the Toll Parking boilerplate is to download a zip copy from the [master branch on GitHub](https://github.com/spaiga/toll-parking/archive/master.zip). You can also do this using the `wget` command:

```bash
$ wget https://github.com/spaiga/toll-parking/archive/master.zip -O toll-parking.zip; unzip toll-parking.zip; rm toll-parking.zip
```

## Installing Toll Parking API

The Toll Parking project is based on Swagger/OpenAPI.

### Running the server
TODO

### Reading the documentation
http://localhost:8080/toll-parking-api-spec/

### Interacting with the API

Several modes exists.

#### Interacting via the Documentation
http://localhost:8080/toll-parking-api-spec/



#### Interacting via CURL
Examples

#### Interacting via the Java Client
- Unit test
- Example



The folder `spiga-parking-api-spec` contains the Toll Parking API documentation, 
automatically generated from Swagger Specification, with the visual documentation making it easy for back end 
implementation and client side consumption.


### spiga-parking-api-spec

Swagger UI allows anyone — be it your development team or your end consumers — to visualize and interact 
with the API’s resources without having any of the implementation logic in place. 
It’s 


### jaxrs-server

Contains the server publishing the API:
the server stubs have been automatically generated thanks to Swagger Codegen and 
then enhanced in order to simulate a pre-filled database and implementing the functionalities to interact with that.


### java-client
Contains an example of Java client of the API:
the client stubs have been automatically generated thanks to Swagger Codegen and then enhanced to create a simple client class as example and 
JUnit class to test the main functionalities.