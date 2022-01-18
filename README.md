# Тестовое задание Playtox Junior Java Developer

Данный документ содержит описание стандартного тестового задания для соискателей на должность Junior Java разработчика.

## Общее описание
Необходимо разработать приложение в соответствии с изложенными ниже требованиями.

## Требования

### Общие требования
 - Архитектура - Java SE 8.0 (или выше), использование библиотек и фреймворков на усмотрение исполнителя.
 - Должна быть система логирования (на основе готового решения, например Log4j). Приложение должно логировать в файл любые действия, приводящие к изменению данных. Приложение должно корректно обрабатывать и логировать ошибки.
###Структура данных

В приложении должна быть сущность Account (счет) содержащая поля:

 - ID (строковое) - идентификатор счета
 - Money (целочисленное) - сумма средств на счете.
### Функциональные требования
 - При запуске приложение должно создать четыре (или более) экземпляров объекта Account со случайными значениями ID и значениями money равным 10000.
 - В приложении запускается несколько (не менее двух) независимых потоков. Потоки должны просыпаться каждые 1000-2000 мс. Время на которое засыпает поток выбирается случайно при каждом исполнении.
 - Потоки должны выполнять перевод средств с одного счета на другой. Сумма списания или зачисления определяется случайным образом. Поле money не должно становиться отрицательным, сумма money на всех счетах не должна меняться.
 - Решение должно быть масштабируемым по количеству счетов и потоков и обеспечивать возможность одновременного (параллельного) перевода средств со счета a1 на счет a2 и со счета a3 на счет а4 в разных потоках.
 - Результаты всех транзакций должны записываться в лог.
 - После 30 выполненных транзакций приложение должно завершиться.
