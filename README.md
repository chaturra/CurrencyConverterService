# Spring Boot - Currency Converter Service #

## Project Description ##

The purpose of this coding exercise is to implement a JAVA web application to fetch the
current localized price of a cryptocurrency.

Currency Converter Service uses scheduler task to invoke backend Crypto Api url and insert data
in the in memory database.

## Example table structure ##
CRYPTO_CURRENCY_NAME  	   PRICE  
Bitcoin	                  2759.9587600493583
Tether	                  384.0708288589653
USD Coin	              88.16112496301952
XRP	                      79.97415602232513
Cardano	                  1.0002108588942273
Binance USD	              0.13172247977631946
Avalanche	              14.940104050119858
Shiba Inu	              37912.353322802344

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

## H2 database url ##

http://localhost:8084/h2-console

### How to use the service? ###

Run Application and hit below urls via postman

1. Example request:

GET v1/zoo/cryptoRates/{cryptoCurrencyCode}/{ip}

1:Test Url: http://localhost:8084/v1/zoo/cryptoRates/Bitcoin

Example response:
{
"price" : 37943.198217129684,
"sign" : "$"
}

2: http://localhost:8084/v1/zoo/cryptoRates/XRP

Example response:
{
"price": 79.97415602232513,
"sign": "$"
}

3. http://localhost:8084/v1/zoo/cryptoRates/Tether

Example response:
{
"price": 384.0708288589653,
"sign": "$"
}





