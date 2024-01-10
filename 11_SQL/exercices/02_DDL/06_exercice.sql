USE test_bdd;

DROP TABLE IF EXISTS adresse;
DROP TABLE IF EXISTS personne;

CREATE TABLE personne (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    telephone VARCHAR(12),
    email VARCHAR(150)
);

CREATE TABLE adresse (
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_personne INT NOT NULL,
    rue VARCHAR(100),
    ville VARCHAR(50),
    code_postal VARCHAR(6),
    FOREIGN KEY (id_personne) REFERENCES personne(id)
);

DROP TABLE IF EXISTS compte;

CREATE TABLE compte (
	compte_id INT AUTO_INCREMENT PRIMARY KEY,
    pseudo VARCHAR(50) NOT NULL,
    mot_de_passe VARCHAR(50),
    email VARCHAR(255),
    date_creation DATE DEFAULT CURRENT_TIMESTAMP(),
	derniere_connexion VARCHAR(50)
);


SHOW TABLES;
