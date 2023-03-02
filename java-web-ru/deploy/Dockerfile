FROM gradle:7.4.0-jdk17

WORKDIR WORKDIR /java-web-ru/deploy/

COPY COPY /java-web-ru/deploy/ .

RUN gradle installDist

CMD ./build/install/deploy/bin/deploy