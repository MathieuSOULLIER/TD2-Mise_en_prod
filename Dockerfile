FROM eclipse-temurin:17-jdk-jammy

WORKDIR /workdir

COPY . /workdir

WORKDIR /workdir/App

# Donner les permissions d'exécution au script gradlew
RUN chmod +x ./gradlew

RUN ./gradlew build

CMD [ "java" ,"-jar", "/workdir/App/build/libs/demo-0.0.1-SNAPSHOT.jar" ]

# Exposez le port sur lequel votre application Spring Boot écoute
EXPOSE 8080
