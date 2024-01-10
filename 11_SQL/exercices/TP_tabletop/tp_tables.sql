CREATE DATABASE IF NOT EXISTS tabletoptreasures_database;

USE tabletoptreasures_database;

-- crations des tables

DROP TABLE IF EXISTS commandes_jeux;
DROP TABLE IF EXISTS commandes;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS jeux;
DROP TABLE IF EXISTS categories;

CREATE TABLE clients(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    adresse_mail VARCHAR(255) NOT NULL,
    adresse_de_livraison VARCHAR(255),
    telephone VARCHAR(12)
);

CREATE TABLE categories(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL
);

CREATE TABLE jeux(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    description VARCHAR (255),
    prix DECIMAL(5,2) NOT NULL,
    id_categorie INT NOT NULL,
    
    FOREIGN KEY(id_categorie) REFERENCES categories(id)
);

CREATE TABLE commandes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_client INT NOT NULL, 
    date_de_commande DATETIME DEFAULT CURRENT_TIMESTAMP,
    adresse_de_livraison VARCHAR(255) NOT NULL,
    statut BOOLEAN DEFAULT FALSE,
    
    FOREIGN KEY (id_client) REFERENCES clients(id)
);


-- table de liaison entre les commandes et les clients
CREATE TABLE commandes_jeux(
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_commande INT,
    id_jeu INT,
    
    FOREIGN KEY (id_commande) REFERENCES commandes(id),
    FOREIGN KEY (id_jeu) REFERENCES jeux(id)
);

SHOW TABLES;