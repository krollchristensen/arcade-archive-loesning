# Arcade archive

Et skeletprojekt til undervisning i:

- Spring Boot
- MySQL
- ren JDBC med JdbcTemplate
- clean architecture
- CRUD
- Thymeleaf

Projektet handler om klassiske arkadespil fra 80'erne og 90'erne.

## Formål

De studerende skal lære at koble en MySQL-database til en Spring Boot-applikation uden brug af ORM.

I dette projekt arbejder vi med tabellen `arcade_games`, som indeholder data om arkadespil.

Projektet er bevidst lavet som et skelet:

- read er implementeret
- create, update og delete mangler og skal laves af de studerende

## Arkitektur

Projektet er opdelt i lag:

### domain
Indeholder domænemodellen og repository-interfacet.

- `ArcadeGame`
- `ArcadeGameRepository`

### application
Indeholder service-laget.

- `ArcadeGameService`

### infrastructure
Indeholder databasekoden.

- `JdbcArcadeGameRepository`

### web
Indeholder controlleren og koblingen til Thymeleaf.

- `ArcadeGameController`

## Teknologier

- Java 17
- Spring Boot
- Thymeleaf
- MySQL
- JdbcTemplate
- Maven

## Sådan kommer du i gang

### 1. Opret databasen i MySQL

Kør dette i MySQL:

```sql
CREATE DATABASE arcade_archive;