USE tabletoptreasures_database;

-- table catégories
INSERT INTO categories (nom)
VALUE 
	('Stratégie'),
	('Familial'),
	('Aventure');
    
SELECT *
FROM categories;

-- table jeux
INSERT INTO jeux (nom, description, prix, id_categorie)
VALUE
	('Catan', 'Jeu de stratégie et de développement de colonies', 30, 1),
	('Dixit', 'Jeu d''association d''images', 25, 2),
	('Les Aventuriers', 'Jeu de plateau d''aventure', 40, 3),
	('Carcassonne', 'Jeu de placement de tuiles', 28, 1),
	('Codenames', 'Jeu de mots et d''indices', 20, 2),
	('Pandemic', 'Jeu de coopération pour sauver le monde', 35, 3),
	('7 Wonders', 'Jeu de cartes et de civilisations', 29, 1),
	('Splendor', 'Jeu de développement économique', 27, 2),
	('Horreur à Arkham', 'Jeu d''enquête et d''horreur', 45, 3),
	('Risk', 'Jeu de conquête mondiale', 22, 1),
	('Citadelles', 'Jeu de rôles et de bluff', 23, 2),
	('Terraforming Mars', 'Jeu de stratégie de colonisation de Mars', 55, 3),
	('Small World', 'Jeu de civilisations fantastiques', 32, 1),
	('7 Wonders Duel', 'Jeu de cartes pour 2 joueurs', 26, 2),
	('Horreur à l''Outreterre', 'Jeu d''aventure horrifique', 38, 3);
    
SELECT *
FROM jeux;

-- table clients
INSERT INTO clients (nom, prenom, adresse_mail, adresse_de_livraison, telephone)
VALUE
	('Dubois', 'Marie', 'marie.dubois@example.com', '123 Rue de la Libération, Ville', '+1234567890'),
	('Lefebvre', 'Thomas', 'thomas.lefebvre@example.com', '456 Avenue des Roses, Ville', '+9876543210'),
	('Martinez', 'Léa', 'lea.martinez@example.com', '789 Boulevard de la Paix, Ville', '+2345678901'),
	('Dupuis', 'Antoine', 'antoine.dupuis@example.com', '567 Avenue de la Liberté, Ville', '+3456789012'),
	('Morin', 'Camille', 'camille.morin@example.com', '890 Rue de l''Avenir, Ville', '+4567890123'),
	('Girard', 'Lucas', 'lucas.girard@example.com', '234 Avenue des Champs, Ville', '+5678901234'),
	('Petit', 'Emma', 'emma.petit@example.com', '123 Rue des Étoiles, Ville', '+6789012345'),
	('Sanchez', 'Gabriel', 'gabriel.sanchez@example.com', '345 Boulevard du Bonheur, Ville', '+7890123456'),
	('Rossi', 'Clara', 'clara.rossi@example.com', '678 Avenue de la Joie, Ville', '+8901234567'),
	('Lemoine', 'Hugo', 'hugo.lemoine@example.com', '456 Rue de la Nature, Ville', '+9012345678'),
	('Moreau', 'Eva', 'eva.moreau@example.com', '789 Avenue de la Créativité, Ville', '+1234567890'),
	('Fournier', 'Noah', 'noah.fournier@example.com', '234 Rue de la Découverte, Ville', '+2345678901'),
	('Leroy', 'Léa', 'lea.leroy@example.com', '567 Avenue de l''Imagination, Ville', '+3456789012'),
	('Robin', 'Lucas', 'lucas.robin@example.com', '890 Rue de la Création, Ville', '+4567890123'),
	('Marchand', 'Anna', 'anna.marchand@example.com', '123 Boulevard de l''Innovation, Ville', '+5678901234');
    
    SELECT *
    FROM clients;
    
-- Effectuez trois commandes en insérant une nouvelle entrée dans la table 
-- "Commandes". Assurez-vous d'inclure l'ID du client (créé précédemment), la 
-- date de commande, l'adresse de livraison et le statut de la commande.

INSERT INTO commandes (id_client, adresse_de_livraison)
VALUE
	(8, '345 Boulevard du Bonheur, Ville'),
    (12, '234 Rue de la Découverte, Ville'),
    (4, '567 Avenue de la Liberté, Ville');
    
SELECT *
FROM commandes;

    
INSERT INTO commandes_jeux (id_commande, id_jeu)
VALUE 
	(1, 10),
    (1, 11),
    (2, 1),
    (2, 13),
    (2, 15),
    (3, 1);

SELECT * 
FROM commandes_jeux;
    

-- On enlève la sécurité enfant
SET SQL_SAFE_UPDATES = 0;

-- Mettez à jour le prix du jeu avec l'ID 3 (Les Aventuriers) pour le fixer à 35 €.
UPDATE jeux 
SET prix = 35
WHERE id = 3;

-- Supprimez le jeu avec l'ID 2 (Dixit) de la table "Jeux"
DELETE FROM jeux
WHERE id = 2 ;

