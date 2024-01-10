-- Exercice jointures:
-- Considérez deux tables, "Clients" et "Achats".

-- Création des tables :

-- La table "Clients" a les colonnes suivantes : id (clé primaire), nom, prenom, ville.
-- La table "Achats" a les colonnes suivantes : client_id (clé étrangère vers "Clients"), produit, montant.

CREATE DATABASE IF NOT EXISTS test_join;

USE test_join;

DROP TABLE IF EXISTS achats;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients(
	id_client INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    ville VARCHAR(100)
);

CREATE TABLE achats(
	id_achat INT AUTO_INCREMENT PRIMARY KEY,
    id_client INT,
    produit VARCHAR(255),
    montant DECIMAL(9,2),
    FOREIGN KEY(id_client) REFERENCES clients(id_client)
);

SHOW TABLES;

