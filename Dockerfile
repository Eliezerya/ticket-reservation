FROM azul/zulu-openjdk:8
EXPOSE 8081
ADD target/api-reservasi-tiket.jar api-reservasi-tiket.jar
ENTRYPOINT ["java", "-jar", "/api-reservasi-tiket.jar"]
# ketika menjalankan akan menjadi image atau kontainer
