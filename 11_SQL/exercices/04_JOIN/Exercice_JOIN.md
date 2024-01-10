*Ceci est l'exercice présent sur le support mis sous une forme Markdown*

# Exercice jointures:

Considérez deux tables, "Clients" et "Achats".

1. **Création des tables :**
   - La table "Clients" a les colonnes suivantes : `id` (clé primaire), `nom`, `prenom`, `ville`.
   - La table "Achats" a les colonnes suivantes : `client_id` (clé étrangère vers "Clients"), `produit`, `montant`.

2. **Insertion des données :**
   - Insérez au moins cinq clients dans la table "Clients".
   - Insérez au moins dix achats dans la table "Achats", en veillant à ce que certains clients aient effectué des achats et d'autres non.

3. **Exercices de jointure :**

   a. **INNER JOIN :**
   - Sélectionnez les noms et prénoms des clients ainsi que les détails de leurs achats (si disponibles).

   b. **LEFT JOIN :**
   - Sélectionnez tous les clients et les détails de leurs achats s'ils ont effectué des achats, sinon affichez les colonnes des achats avec des valeurs NULL.

   c. **RIGHT JOIN :**
   - Sélectionnez tous les achats et les détails des clients correspondants, même s'il n'y a pas de correspondance pour certains achats.

   d. **FULL JOIN :**
   - Sélectionnez tous les clients et tous les achats, en affichant les détails des clients même s'ils n'ont pas effectué d'achats, et vice versa.