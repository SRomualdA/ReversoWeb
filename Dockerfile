# image a utiliser
FROM alpine:latest
# mise a jour de l'index
RUN apk update
# ajout des outils JDK et wget
RUN apk add openjdk17-jre-headless wget
# ajout de curl
RUN apk add curl
# creation d'un repertoire
RUN mkdir /usr/local/tomcat
# recuperation de Tomcat via wget dans le repertoire tmp
RUN wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.23/bin/apache-tomcat-10.1.23.tar.gz -O /tmp/tomcat.tar.gz
# décompression et copie du repertoire
RUN cd /tmp ; tar xvfz tomcat.tar.gz
RUN cp -Rv /tmp/apache-tomcat-10.1.23/* /usr/local/tomcat/
# exposition du port 8080 du conteneur
EXPOSE 8080
# creation d'une variable d'environnement JAVA_HOME
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk
# creation d'un label indiquant le responsable de ce dockerfile
LABEL email = surveillantromualdpro@gmail.com
# désignation du repertoire de travail de tomcat
WORKDIR /usr/local/tomcat/webapps
# démarrage de Tomcat
RUN curl -O -L https://tomcat.apache.org/tomcat-7.0-doc/appdev/sample/sample.war
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]