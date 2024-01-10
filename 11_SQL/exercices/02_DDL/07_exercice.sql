CREATE DATABASE IF NOT EXISTS  bdd_streaming;

USE bdd_streaming;

DROP TABLE IF EXISTS chansons_playlists;
DROP TABLE IF EXISTS playlists;
DROP TABLE IF EXISTS utilisateurs;
DROP TABLE IF EXISTS chansons;

CREATE TABLE utilisateurs (
	id_utilisateur INT AUTO_INCREMENT PRIMARY KEY,
    nom_utilisateur VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    date_inscription DATETIME DEFAULT CURRENT_TIMESTAMP,
    pays VARCHAR(100)
);

CREATE TABLE chansons (
	id_chanson INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    artitste VARCHAR(100),
    album VARCHAR(255),
    duree TIME NOT NULL,
    genre VARCHAR (100),
    annee_sortie YEAR
);

CREATE TABLE playlists (
	id_playlist INT AUTO_INCREMENT PRIMARY KEY,
    nom_playlist VARCHAR(255) NOT NULL,
    id_utilisateur INT NOT NULL,
    date_creation DATE,
    FOREIGN KEY (id_utilisateur) REFERENCES utilisateurs(id_utilisateur)
);

CREATE TABLE chansons_playlists (
	id_chansons_playlists INT AUTO_INCREMENT PRIMARY KEY,
    id_chanson INT NOT NULL,
    id_playlist INT NOT NULL,
    FOREIGN KEY (id_chanson) REFERENCES chansons(id_chanson),
    FOREIGN KEY (id_playlist) REFERENCES playlists(id_playlist)
);

SHOW TABLES;