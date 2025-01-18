# НИИ ЧАВО (Научно-исследовательский институт Чародейства и Волшебства)

## О проекте

Данный репозиторий содержит материалы и код проекта, созданного в рамках хакатона **FCADHACK**. Хакатон был организован студенческим советом факультета компьютерного проектирования (ФКП, БГУИР) при поддержке компании **T-Bank**. Наша команда, **НИИ ЧАВО**, заняла **3-е место** среди участников!

![Логотип хакатона](images/logo.png)

---

## Кейс хакатона

**Задача:**
Разработка Proxy-сервиса для сквозной фильтрации и маскирования чувствительных данных (ЧД/ПД).

### Вводная информация

- Файл: `data.log`.
- Количество объектов: **194 790**.
- Основной функционал: фильтрация данных и управление доступом через конфигурацию сервера.

![Визуализация кейса](images/case-visualization.png)

---

## Используемый стек технологий

- **Базы данных**: PostgreSQL, Redis.
- **Брокер сообщений**: Kafka.
- **Фреймворк потоковой обработки**: Apache Flink.
- **Развёртывание**: Docker, Kubernetes.
- **Визуализация данных**: Grafana.

![Стек технологий](images/technology-stack.png)

---

## Архитектура решения

Проект был реализован как микросервисная архитектура:

- **Фронтенд**: интерфейс для управления и отображения данных.
- **Бэкенд**: микросервисы для фильтрации и обработки данных.
  - Микросервис админ-панели.
  - Микросервисы фильтрации (n инстансов).
  - Микросервис получения информации.
- **Базы данных**:
  - **PD DataBase**: PostgreSQL.
  - **Config DataBase**: Redis.
- **Технологии**:
  - Apache Flink (обработка потоков).

![Архитектура решения](images/architecture.png)

---

## Скриншоты интерфейса

### Экран с таблицей фильтрации информации
![Скриншот 1](images/screenshot1.png)

### Экран с управлением конфигурацией сервера
![Скриншот 2](images/screenshot2.png)

### Экран с таблицей блокировки источников
![Скриншот 3](images/screenshot3.png)

---

## Состав команды

| Роль             | Имя                       | Факультет/Курс |
|-------------------|---------------------------|----------------|
| **Team Lead**     | Тиунчик Даниил Романович | ФКП, 4 курс    |
| **Backend**       | Ставров Владислав Владимирович | ФКП, 4 курс    |
| **Frontend**      | Грибач Назар Эдуардович | ФКП, 1 курс    |
| **DevOps**        | Венский Никита Александрович | ФКП, 4 курс    |
| **Designer**      | Крогаль Анастасия Андреевна | ФиТУ, 4 курс   |

![Команда НИИ ЧАВО](images/team-photo.png)

---

## Благодарности

Мы выражаем благодарность организаторам хакатона FCADHACK, студенческому совету ФКП (БГУИР) и компании T-Bank за возможность принять участие и развивать свои навыки!
