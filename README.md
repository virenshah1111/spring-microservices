# Spring Microservices

This Project covers how to use microservices with Spring cloud

## Ports

|     Application       |     Port          |
| ------------- | ------------- |
| Limits Service | 8080, 8081, ... |
| Spring Cloud Config Server | 8888 |
| Currency Exchange Service | 8000, 8001, 8002, ..  |
| Currency Conversion Service | 8100, 8101, 8102, ... |
| Netflix Eureka Naming Server | 8761 |
| API Gateway Server | 8765 |


## List of URLs
- config server : `localhost:8888/<application-name>/<profile>`
- config client (limits-service) : `http://localhost:8080/limits`
- currency-exchange: `http://localhost:8000/currency-exchange/from/USD/to/INR`
- currency-conversion without feign: `http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/1000`
- currency-conversion with feign: `http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/1000`
- Eureka server: `http://localhost:8761/`

**API gateway before filter**
- currency-exchange: `http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR`
- currency-conversion: `http://localhost:8765/currency-conversion-service/currency-conversion-feign/from/USD/to/INR/quantity/10`

**API gateway after filter**
- currency-exchange: `http://localhost:8765/currency-exchange/from/USD/to/INR`
- currency-conversion: `http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10`
