FROM ghcr.io/graalvm/graalvm-ce:java11-21 AS build
RUN gu install native-image

## resources and reflection
COPY ./src/main/resources/reflect-config.json /tmp/dist/reflect-config.json
COPY ./src/main/resources/resource-config.json /tmp/dist/resource-config.json

COPY ./target/mySQLGraalVM-1.0.jar /build/app.jar
RUN cd build && native-image --static -jar app.jar -H:Name=output

FROM scratch
COPY --from=build /build/output /opt/output
CMD ["/opt/output"]