# Проект по автоматизации тестирования сайта компании [X5Group](https://www.x5.ru/ru/)
![This is an image](images/screenshots/x5group.png)
## **Содержание:**
____

* <a href="#tools">Технологии и инструменты</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#console">Запуск из терминала</a>
* <a href="#allure">Allure отчет</a>
* <a href="#telegram">Уведомление в Telegram </a>
* <a href="#video">Видео примера запуска тестов в Selenoid</a>
____

<a id="tools"></a>
## **Технологии и инструменты**

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg"></a> 
<a href="https://www.java.com/ru/"><img width="6%" title="Java" src="images/logo/Java.svg"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="images/logo/Selenide.svg"></a>
<a href="https://aerokube.com/selenoid/"><img width="6%" title="Selenoid" src="images/logo/Selenoid.svg"></a>
<a href="https://github.com/allure-framework"><img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="images/logo/AllureTestOps.svg"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="images/logo/Gradle.svg"></a>
<a href="https://junit.org/junit5/"><img width="6%" title="JUnit5" src="images/logo/JUnit5.svg"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="images/logo/GitHub.svg"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="images/logo/Jenkins.svg"></a>
<a href="https://web.telegram.org/"><img width="6%" title="Telegram" src="images/logo/Telegram.svg"></a>
<a href="https://www.atlassian.com/software/jira/"><img width="5%" title="Jira" src="images/logo/Jira.svg"></a>
</p>


- Язык программирования для написания автотестов:
    - [Java](https://www.java.com/ru/)
- Фреймворки для тестирования:
    - [Selenide](https://selenide.org/) (для автоматизации браузерных тестов)
    - [JUnit 5](https://junit.org/) (для структурирования и запуска тестов)
- Сборка и управление зависимостями: [Gradle](https://gradle.org/)
- Запуск браузеров в [Selenoid](https://aerokube.com/selenoid/) при прогоне тестов
- CI/CD: [Jenkins](https://www.jenkins.io/) (реализована джоба для удаленного запуска тестов с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота)

Содержание Allure-отчета:
* Шаги теста;
* Скриншот страницы на последнем шаге;
* Page Source;
* Логи браузерной консоли;
* Видео выполнения автотеста.

____
<a id="jenkins"></a>
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/rrtugushev_jenkins_x5_group/)

Для запуска сборки необходимо перейти в раздел <code>Собрать с параметрами</code> и нажать кнопку <code>Собрать</code>.
<p align="center">
<img title="Jenkins Build" src="images/screenshots/jenkins.png">
</p>

____
<a id="console"></a>
## Запуск из терминала
```
./gradle clean test
```
При выполнении команды, тесты запустятся удаленно в [Selenoid](https://aerokube.com/selenoid/).

<code>clean</code> — удаляет каталог build/ в проекте (все скомпилированные классы, отчёты, кэш тестов, временные файлы);

<code>test</code> — запускает задачу тестирования Gradle, которая:

- компилирует тесты и основной код;
- запускает тесты (JUnit, TestNG и т.д.);
- формирует отчёты (например, `build/reports/tests/test/index.html`).

***Удаленный запуск через Jenkins***
```
clean test
-Dbrowser=${BROWSER}
-DbrowserVersion=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-DremoteUrl=https://user1:1234@${REMOTE_URL}/wd/hub
```
***Параметры сборки в Jenkins***

- *browser (браузер, в котором выполнятся тесты - по умолчанию chrome)*
- *browserVersion (версия браузера - по умолчанию 128)*
- *browserSize (размер окна браузера, в котором будут выполняться тесты)*
- *remoteUrl (адрес удаленного сервера, на котором будут запускаться тесты)
____
<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/rrtugushev_jenkins_x5_group/3/allure/)

<p align="center">
<img title="Allure Overview" src="images/screenshots/AllureReport.png">
</p>

В отчете Allure представлены результаты тестирования с общей статистикой.
____
<a id="telegram"></a>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в Telegram, автоматически обрабатывает и отправляет сообщение с результатом.
<p align="center">
<img width="70%" title="Telegram Notifications" src="images/screenshots/Bot.png">
</p>

____
<a id="video"></a>

## <img width="4%" style="vertical-align:middle" src="images/logo/Selenoid.svg"> Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="images/screenshots/video.gif">
</p>
