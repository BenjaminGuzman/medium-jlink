# we need maven to build sources and generate the JRE
FROM maven:3.9-eclipse-temurin-17-alpine as builder

RUN apk add binutils # jlink uses objcopy which is provided by binutils

WORKDIR /usr/src

COPY src ./src
COPY pom.xml modularize.sh ./ 

# modularize.sh contains all the jdeps, javac, jar commands to modularize a dependency
RUN ./modularize.shi

FROM alpine

# copy the generated JRE
COPY --from=builder /usr/src/target/maven-jlink/default /jre
ENV PATH="/jre/bin:${PATH}"

# copy resources
COPY src/main/resources /resources

# execute the Main class by default
WORKDIR /
ENTRYPOINT ["java", "-m", "dev.benjaminguzman.medium/dev.benjaminguzman.Main"]

