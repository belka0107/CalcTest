# CalcTest

Run:
---
mvn clean test site jetty:run -Dmaven.test.failure.ignore=true

Допущения:
----------
1. Считаем что в программе не заложены специальные значения для значений infinity и NaN
2. Результат деления округляется до тысячных
3. Данные читаются из файла test/resources/data

Просмотр отчета по адресу http://localhost:8080