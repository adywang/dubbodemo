FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY ./ruoyi-admin.jar /opt/app/ruoyi-admin.jar
EXPOSE 8081
WORKDIR /opt/app
CMD java -jar ruoyi-admin.jar


