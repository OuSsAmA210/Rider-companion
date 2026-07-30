# Rider Companion 🏍️

Rider Companion est une application destinée aux motards permettant de gérer leurs motos, suivre les opérations d’entretien et préparer leurs sorties.

## 📌 Fonctionnalités MVP

- Authentification utilisateur
- Gestion du profil pilote
- Tableau de bord (Dashboard)
- Gestion des motos (Virtual Garage)
- Suivi des entretiens (Maintenance Logbook)
- Planification des sorties (Ride Planner)

## 🏗️ Architecture du projet

```text
rider-companion/
├── backend/
├── web-app/
├── android-app/
└── docs/

## Démarrer le backend en local

Le profil Spring `local` utilise une base H2 en mémoire, sans PostgreSQL installé :

```bash
cd backend/rider-companion
bash ./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

H2 Console: [http://localhost:8081/h2-console](http://localhost:8081/h2-console)

Use the following JDBC URL in the console: `jdbc:h2:mem:rider_companion` (user: `sa`, password: empty).

## API documentation

When the backend is running, OpenAPI documentation is available at:

- Swagger UI: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
- OpenAPI JSON: [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)
