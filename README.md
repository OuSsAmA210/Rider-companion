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
