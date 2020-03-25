FROM java:8
VOLUME /tmp
ADD demo-0.0.1-snapshot.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
# http://hongjiang.info/jvm-random-and-entropy-source/ 关于该命令的解释
# 采用非阻塞的熵源(entropy source) 提高效率的问题
#SecureRandom在java各种组件中使用广泛，可以可靠的产生随机数。
# 但在大量产生随机数的场景下，性能会较低。这时可以使用"-Djava.security.egd=file:/dev/./urandom"加快随机数产生过程。
# hotspot 需要该设置才能从urandom读取数据
EXPOSE 8762