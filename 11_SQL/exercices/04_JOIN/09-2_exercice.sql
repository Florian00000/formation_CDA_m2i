USE test_join;

-- On enlève la sécurité enfant
SET SQL_SAFE_UPDATES = 0;

-- Insertion des données :

-- Insérez au moins cinq clients dans la table "Clients".

INSERT INTO clients (nom, prenom, ville)
VALUES 
	( 'Dupont', 'Jean', 'Avigon'),
    ( 'Frombridge', 'John', 'Londres'),
    ( 'Delpuente', 'Juan', 'Seville'),
	( 'Mostu', 'Jan', 'Prague'),
    ( 'Debrug', 'Johan', 'Gand');
    
SELECT * 
FROM clients;

-- Insérez au moins dix achats dans la table "Achats", en veillant à ce que certains clients aient effectué des achats et d'autres non.

INSERT INTO achats (id_client, produit, montant)
VALUES
	(1 , 'une moitié de pont', 500000),
    (1, 'tenture', 500),
    (1, 'pastis', 20),
    (2, 'une vraie biere pour une fois', 4),
    (2, 'parapluie', 10),
    (5, 'bouteille d eau', 0.5),
    (5, 'peniche', 250000),
    (1, 'baguette', 1),
    (5, 'carbonnade', 15),
    (5, 'biere', 4),
    (2, 'pays de galle', 500);
    
INSERT INTO achats (produit, montant)
VALUES
	('undefined', 0);
    
SELECT * 
FROM achats;

-- Exercices de jointure :

-- a. INNER JOIN :

-- Sélectionnez les noms et prénoms des clients ainsi que les détails de leurs achats (si disponibles).

SELECT clients.nom, clients.prenom, achats.produit
FROM clients
INNER JOIN achats ON clients.id_client = achats.id_client;

-- LEFT JOIN :

-- Sélectionnez tous les clients et les détails de leurs achats s'ils ont effectué des achats, sinon affichez les colonnes des achats avec des valeurs NULL.

SELECT *
FROM clients
LEFT JOIN achats ON clients.id_client = achats.id_client;

-- RIGHT JOIN :

-- Sélectionnez tous les achats et les détails des clients correspondants, même s'il n'y a pas de correspondance pour certains achats.

SELECT *
FROM clients AS c
RIGHT JOIN achats AS a ON c.id_client = a.id_client;

-- FULL JOIN :

-- Sélectionnez tous les clients et tous les achats, en affichant les détails des clients même s'ils n'ont pas effectué d'achats, et vice versa.

SELECT *
FROM clients AS c 
LEFT JOIN achats AS a ON c.id_client = a.id_client

UNION

SELECT *
FROM clients AS c
RIGHT JOIN achats AS a ON c.id_client = a.id_client;