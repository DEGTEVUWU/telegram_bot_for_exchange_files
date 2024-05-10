.DEFAULT_GOAL := build-run

start:
	mvn compile  exec:java -Dexec.mainClass="spring_project.DispatcherApplication"
#запускает приложение из главного класса

restart:
	mvn clean install
#пересборка проекта + упаковка в jar-файлы

depend:
	   mvn dependency:tree
#показать все зависимости

spring:
	   mvn spring-boot:run
#запустить спринг-бут приложение

.PHONY: build
