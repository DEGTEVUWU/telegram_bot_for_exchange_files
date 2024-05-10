.DEFAULT_GOAL := build-run

start:
	make -C dispatcher start
#запускает приложение из главного класса

start-node:
	make -C node start-node
#запускает приложение из node модуля

restart:
	make -C dispatcher restart
#пересборка проекта + упаковка в jar-файлы

depend:
	make -C dispatcher depend
#показать все зависимости

spring:
	make -C dispatcher spring
#запустить спринг-бут приложение

.PHONY: build
