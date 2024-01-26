CREATE DATABASE IF NOT EXISTS bibliotheque;

USE bibliotheque;

DROP TABLE IF EXISTS Livres;

CREATE TABLE Livres(
id INT AUTO_INCREMENT PRIMARY KEY,
titre VARCHAR(100),
auteur VARCHAR(50),
annee_publication INT,
disponible BOOLEAN
);

INSERT INTO livres (titre, auteur, annee_publication, disponible) VALUES ('Le seigneur des anneaux', 'Tolkien', '1954', true);

SELECT * FROM livres;