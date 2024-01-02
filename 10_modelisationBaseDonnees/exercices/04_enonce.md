### Sujet : Modélisation de la base de données d'un hôpital

#### Informations fournies :

- L'hôpital a des employés qui sont des docteurs et des infirmières, avec chacun un numéro d'employé, un nom, un prénom, une adresse, et un numéro de téléphone.
- Plusieurs services composent l'hôpital, chacun ayant un code, un nom, un bâtiment, et un directeur (docteur).
- Chaque service contient plusieurs salles, identifiées par un numéro, un surveillant (infirmier), et un nombre de lits.
- Les infirmiers sont affectés à un seul service.
- Les docteurs ont une spécialité mais ne sont pas affectés à un service spécifique.
- Les infirmiers ont une rotation et un salaire.
- Les patients sont représentés par un numéro, un nom, un prénom, une adresse, un numéro de téléphone, et hospitalisés avec un numéro de lit et un diagnostic. Ils sont soignés par un docteur et peuvent être transférés en cas de complications.

#### Questions :

1. **Définir l'ensemble des propriétés de ce système.**
   
   Les propriétés décrivent les caractéristiques des employés, services, salles, infirmiers, docteurs, et patients, ainsi que leurs relations et contraintes.

2. **Définir les entités de ce système.**
   
   Les entités principales sont : Employé, Docteur, Infirmier, Service, Salle, Patient.

3. **Définir le MCD (Modèle Conceptuel de Données) de ce système.**
   
   Le MCD illustre les relations entre les différentes entités, définissant comment elles interagissent les unes avec les autres, comme la relation entre un docteur et le service qu'il dirige.
