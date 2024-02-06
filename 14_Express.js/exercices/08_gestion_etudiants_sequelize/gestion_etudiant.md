# Exercice : Gestion Sécurisée des Étudiants dans une École avec JWT et Bcrypt

Dans cet exercice, vous allez créer une API sécurisée pour gérer les étudiants d'une école en utilisant Sequelize dans une application Node.js avec Express. Vous allez également implémenter l'authentification des utilisateurs à l'aide de JWT (JSON Web Tokens) et Bcrypt pour sécuriser les routes.

## Objectifs de l'exercice :

- Créer une base de données avec Sequelize pour stocker les informations sur les étudiants et les utilisateurs.
- Implémenter l'authentification des utilisateurs avec JWT et Bcrypt.
- Créer des routes sécurisées pour effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les étudiants.
- Utiliser l'architecture MVC pour organiser le code de l'application.

## Tâches à accomplir :

1) Définir un modèle Sequelize pour représenter les utilisateurs avec les champs suivants :
    - Nom d'utilisateur
    - Mot de passe (haché avec Bcrypt)
    - Role (par exemple, admin, utilisateur)

2) Créer un contrôleurs pour gérer l'authentification des utilisateurs :
    - Créer un utilisateur avec un mot de passe haché
    - Authentifier un utilisateur et générer un JWT

3) Créer un contrôleurs pour gérer les opérations sur les étudiants :
    - Lire tous les étudiants
    - Lire un étudiant par son identifiant
    - Mettre à jour les informations d'un étudiant
    - Supprimer un étudiant

4) Implémenter un middleware pour vérifier l'authentification des utilisateurs à l'aide de JWT et Bcrypt.

5) Définir des routes pour les différentes opérations sur les utilisateurs et les étudiants en utilisant Express :
    - Une route POST pour créer un nouvel utilisateur
    - Une route POST pour authentifier un utilisateur et générer un JWT
    - Des routes sécurisées avec JWT pour effectuer des opérations CRUD sur les étudiants

6) Tester l'API en utilisant un outil comme Postman ou curl :
    - Envoyer des requêtes POST pour créer un nouvel utilisateur et authentifier un utilisateur
    - Récupérer le token JWT généré après l'authentification
    - Utiliser le token JWT pour envoyer des requêtes sécurisées pour effectuer des opérations CRUD sur les étudiants

Vous pouvez vous aider de la doc sequelize : https://sequelize.org/docs/v6/getting-started/
