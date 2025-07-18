FROM gradle:8.14.3-jdk24 AS build
WORKDIR /app
COPY . .
RUN gradle installDist --no-daemon

FROM eclipse-temurin:24-jre
WORKDIR /app
COPY --from=build /app/app/build/install/app/ .
ENTRYPOINT ["bin/app"]