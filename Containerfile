FROM docker.io/library/tomcat:8.5.100-jre8-temurin

LABEL build=java-migration-example
ADD target/java-migration-example.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]
