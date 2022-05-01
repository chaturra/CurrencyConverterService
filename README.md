# Spring Boot - Currency Converter Service #

## Project Description ##

The purpose of this coding exercise is to implement a JAVA web application to fetch the
current localized price of a cryptocurrency.

### steps for build and run the project ###

There are two approaches:
1. A. Run command mvn clean install for creating the build
   B. Run command mvn spring-boot:run for running the application

2. Run using jar file created in target folder
   java -jar CurrencyConverterService-0.0.1-SNAPSHOT.jar
   

### Build and Run project using Docker ###
1: build the image

docker build -f Dockerfile -t crypto-rate-service .

2: run the image

docker run -p 8084:8084 crypto-rate-service


## Service Documentation ##

Service documentation url http://localhost:8084/swagger-ui/index.html

### How to use the service? ###

Run Application and hit below urls via postman

1. Example request:

GET v1/zoo/cryptoRates/{cryptoCurrencyCode}/{ip}

Test Url: http://localhost:8084/v1/zoo/cryptoRates/Bitcoin/10.12.34.56
          http://localhost:8084/v1/zoo/cryptoRates/Bitcoin

Example response:
{
"price" : 37943.198217129684,
"sign" : "$"
}

Thymeleaf:

