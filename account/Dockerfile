FROM mariadb

FROM gradle

COPY . .

RUN gradle compileJava

CMD ["gradle", "bootRun"]
