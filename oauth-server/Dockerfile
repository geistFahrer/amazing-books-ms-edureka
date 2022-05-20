FROM openjdk:11
LABEL maintainer="biroy@gmail.com"
WORKDIR /app
ADD target/oauth-server-1.0.jar oauth-server-1.0.jar
ENV ACTIVE_PROFILE dev
ENTRYPOINT ["java", "-jar","oauth-server-1.0.jar","--spring.profiles.active=${ACTIVE_PROFILE}"]
EXPOSE 8030