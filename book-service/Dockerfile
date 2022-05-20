FROM openjdk:11
LABEL maintainer="biroy@gmail.com"
WORKDIR /app
ADD target/book-service-1.0.jar book-service-1.0.jar
ENV ACTIVE_PROFILE dev
ENTRYPOINT ["java", "-jar","book-service-1.0.jar","--spring.profiles.active=${ACTIVE_PROFILE}"]
EXPOSE 8010