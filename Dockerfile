FROM openjdk:11
ADD target/CurrencyConverterService-0.0.1-SNAPSHOT.jar CurrencyConverterService-0.0.1-SNAPSHOT.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "CurrencyConverterService-0.0.1-SNAPSHOT.jar"]