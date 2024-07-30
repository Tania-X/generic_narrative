FROM openjdk:17

LABEL maintainer="13126565350@163.com"

ADD gen-alpha.jar /gen-alpha/gen-alpha.jar

WORKDIR /gen-alpha

RUN ln -sf /usr/local/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone

HEALTHCHECK --interval=1m --timeout=10s \
CMD curl -f http://localhost:10087/emergency/checkHealth \
| grep -q '^0$' || exit 1

ENTRYPOINT ["java", "-jar", "gen-alpha.jar"]

CMD ["0"]