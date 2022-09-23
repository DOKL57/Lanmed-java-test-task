# Test task at java gamedev deloper Lanmed
## Task
1. Сделать приложение к которому клиенты могут подключиться по TCP. Есть файл с фразами, сервер читает фразы из файла и отправляет случайную подключенному клиенту раз в 5 секунд (время может меняться, например быть рандомным, клиентов может быть несколько, отсчет времени для каждого клиента индивидуальный)
2. Сделать мод для майнкрафта, который после запуска подключается к серверу из п.1, получает фразу и выводит в интерфейсе игры.


# start server
```sh
cd server
mvn clean install
cd ../target && java -jar server-1.0-SNAPSHOT.jar
```

# start client with mod
Minecraft version 1.19.2
```sh
cd client
gradle runClient
```
# configuration
You can change frequency of message sending and server port at
```sh
/server/src/main/resources/config.properties
```
You can change phrases at
```sh
/server/strings.txt
```
