# Lorus

Для использования данного кода необходимо:

1) поднять базу PostgreSQL, назвать ее "test"
2) запустить приложение (запустится метод, забирающий по API информацию о погоде, метод отрабатывает раз в пять минут)
3) перейти по адресу http://localhost:23033/swagger-ui.html
4) для отправки запроса на получение данных о погоде в Краснодаре и Сочи реализован специальный метод,
  в параметр которому необходимо передать дату, за которую необходимо получить данные
5) дата передается в следующем формате: "гггг-мм-дд"
