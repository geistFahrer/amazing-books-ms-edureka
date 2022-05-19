FROM openjdk:11
LABEL maintainer="biroy@gmail.com"
WORKDIR /app
ADD target/api-gateway-1.0.jar api-gateway-1.0.jar
ENV ACTIVE_PROFILE dev
ENTRYPOINT ["java", "-jar","api-gateway-1.0.jar","--spring.profiles.active=${ACTIVE_PROFILE}"]
EXPOSE 8181