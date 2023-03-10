# Spring Boot Capitole Test Project

This is a test  Java / Gradle / Spring Boot (version 3) application.

The project is a simple price query REST Service. It uses an in-memory database (H2) to store the data.

Notes: All basic security is disabled.

The test requirements are in the file `requerimiento_java_test.txt`


## How to Run

### Clone the project

    git clone https://github.com/LuisOgando/capitole-test.git
    cd capitole-test

There are 3 different ways to run this project:

1- Using a docker container. You must have `docker` installed locally,
just run the  `startup` command form the Makefile:

	make statup

2- Using gradle command:

	gradle clean build
	gradle bootRun

3- You can also use the native java command after packaging the project with `gradle assemble`:

```
java -jar build/libs/logandotest.jar
```

## Run Tests

    make test
    or
    gradle test

##  REST API

# Get price
### Request

    curl -i -H 'Accept: application/json' 'http://localhost:8080/price?
						    product_id=35455&
						    brand_id=1&
						    date=2020-06-15T10%3A00%3A00.000'

### Request

    HTTP/1.1 200
    Content-Type: application/json
    Transfer-Encoding: chunked
    Date: Sat, 11 Mar 2023 18:56:32 GMT
    
    {
       "product_id":35455,
       "brand_id":1,
       "price_list":3,
       "start_date":"2020-06-15T00:00:00",
       "end_date":"2020-06-15T11:00:00",
       "price":30.5
    }
    
 
After the service is running you can visit the link to see the documentation:

`http://localhost:8080/swagger-ui/index.html#/`

![alt text](/api-doc.png)


    

