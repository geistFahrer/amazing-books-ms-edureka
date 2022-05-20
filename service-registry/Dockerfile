FROM openjdk:11
LABEL maintainer="biroy@gmail.com"
WORKDIR /app
ADD target/service-registry-1.0.jar service-registry-1.0.jar
ENV ACTIVE_PROFILE dev
ENTRYPOINT ["java", "-jar","service-registry-1.0.jar","--spring.profiles.active=${ACTIVE_PROFILE}"]
EXPOSE 8761