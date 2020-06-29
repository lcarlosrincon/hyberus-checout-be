FROM amazoncorretto:8u252-al2
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} checkout.jar
ENTRYPOINT ["java","-jar","/checkout.jar"]