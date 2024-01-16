## Урок 2. Основы Spring. Spring Boot

1\. Создать spring-boot приложение с помощью https://start.spring.io/

2\. Создать Класс Student c полями: идентификатор, имя, имя группы

3\. Создать контроллер, обрабатывающий входящие запросы:

3.1. `GET /student/{id}` &mdash; получить студента по ID

3.2. `GET /student` &mdash; получить всех студентов

3.3. `GET /student/search?name=studentName` &mdash; получить список студентов, чье имя содержит подстроку studentName

3.4. `GET /group/{groupName}/student` &mdash; получить всех студентов группы

3.5. `POST /student` &mdash; создать студента (принимает JSON) (отладиться можно с помощью Postman)

3.6. `DELETE /student/{id}` &mdash; удалить студента

4. При старте приложения, в программе должно быть создано 5-10 студентов.


### Пример выполнения:

**Получение всех, получение по ключу**

![Получение всех, получение по ключу](https://raw.githubusercontent.com/alexeycoder/illustrations/main/java-spring-hw2/ex_get_all_byid_byname.png)

**Добавление, удаление, поиск по шаблону имени**

![Добавление, удаление](https://raw.githubusercontent.com/alexeycoder/illustrations/main/java-spring-hw2/ex_post_delete.png)

**Получение по группе**

![Получение по группе](https://raw.githubusercontent.com/alexeycoder/illustrations/main/java-spring-hw2/ex_bygroup.png)
