FROM alpine:3.7

ENV JAVA_HOME /usr/lib/jvm/default-jvm
RUN apk add --no-cache openjdk8 && \
    ln -sf "${JAVA_HOME}/bin/"* "/usr/bin/"

RUN apk add --no-cache git
RUN apk add --no-cache bash

RUN MAVEN_VERSION=3.3.9 \
 && cd /usr/share \
 && wget -q http://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz -O - | tar xzf - \
 && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven

RUN git clone https://guillemhs@bitbucket.org/itnove/simple-maven-spring-boot-example.git /root/simple-maven-spring-boot-example

RUN cd /root/simple-maven-spring-boot-example

WORKDIR /root/simple-maven-spring-boot-example
EXPOSE 9999
CMD ["mvn","jetty:run"]
