# Toll Parking API

The document aims at describing the Toll Parking API create by `Fabio SPIGA`.

Through Toll Parking API, an end user is able to search for the most convenient parking lot for its own vehicle, drive to it and park. 
At the moment of leaving, the API allows to compute the amount to pay and bill the end user.

Toll Parking RESTful API is based on `OpenAPI Specification` (OAS) and uses `Swagger UI` tool to generate and visualize API documentation 
so it can be easily understood and used.

You can learn more about Swagger specifications from here: [http://swagger.io/specification/](http://swagger.io/specification/)


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.




## Prerequisites
Make sure you have installed all of the following prerequisites on your development machine:
* Git - [Download & Install Git](https://git-scm.com/downloads)
* Java JDK 8 - [Download & Install JDK](https://www.oracle.com/technetwork/java/javaee/downloads/index.html)
* Maven - [Download & Install Maven](https://maven.apache.org/download.cgi)




## Downloading Toll Parking API

There are several ways you can get the Toll Parking API installed:

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




## Running Toll Parking API

Toll Parking API is based on Swagger/OpenAPI.
The documentation was generated thanks to the `Swagger UI` tool and can be used for both reading and interacting with the API.

In order to access to it, you can easily start the server:
```bash
$ mvn clean package jetty:run
```

and then go to the url:
[http://localhost:8080/toll-parking-api-spec/](http://localhost:8080/toll-parking-api-spec/)

The server comes with a prefilled configuration of:
* 12 parking lots;
* 2 pricing policies.


As an example, you can get all the available lots using the following CURL:
```
curl -X GET "http://localhost:8080/api/lots?status=available" -H  "accept: application/json"
```


### Reading the documentation


### Interacting with the API

Several modes exists.

#### Interacting via the Documentation
http://localhost:8080/toll-parking-api-spec/



#### Interacting via CURL



#### Interacting via the Java Client
- Unit test
- Example


## Generating Clients
We can automatically generate server stubs and client SDKs using [Swagger Codegen](https://github.com/swagger-api/swagger-codegen).
Simply import the file 
```
jaxrs-server\src\main\webapp\toll-parking-api-spec\toll_parking_api.yml
```
into [Swagger Editor](http://editor.swagger.io/)
and click on `Generate Client`.