FROM openjdk:8-jdk

COPY target/musicrest-0.0.1-SNAPSHOT.jar /music-app.jar
COPY docker-entrypoint.sh /

RUN chmod a+rx /docker-entrypoint.sh

EXPOSE 8080

CMD ["/docker-entrypoint.sh"]

