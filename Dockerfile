FROM openjdk:8-jdk

COPY target/webshop-0.0.1-SNAPSHOT.jar /webshop-app.jar
COPY docker-entrypoint.sh /

RUN chmod a+rx /docker-entrypoint.sh

EXPOSE 8080

CMD ["/docker-entrypoint.sh"]

