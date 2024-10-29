FROM amd64/amazoncorretto:17
WORKDIR /app
COPY ./build/libs/youngNam-0.0.1-SNAPSHOT.jar /app/youngnam.jar
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "-Dspring.profiles.active=dev", "youngnam.jar"]
