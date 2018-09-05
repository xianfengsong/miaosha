FROM tomcat:8.5.33-jre8-alpine
VOLUME /tmp
ARG WAR_FILE
COPY ${WAR_FILE} /usr/local/tomcat/webapps/