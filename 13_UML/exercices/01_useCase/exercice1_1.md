# Exercice 1: useCase

On considère une borne de chargement de titre de transport Navigo. Les utilisateurs peuvent charger leur Navigo et les techniciens peuvent intervenir en cas de panne.

1. **Question 1:** Pour charger son titre, le client dépose son titre et suit les instructions indiquées. Quel est l'acteur et l'action dans ce cas d'utilisation.

    acteur: client  
    action: cherger titre

2. **Question 2 :** Jojo, dont le métier est technicien au sein de la RATP, veut charger le navigo de son fils. Pour modéliser cette activité de Jojo, doit-on définir un nouvel acteur ?  
Comment modélise-t-on ça ?

    Il n'est pas utile de définir un nouvel acteur.

3. **Question 3 :** Lorsque Jojo vient avec ses outils pour réparer la borne en cas de panne, est-il considéré comme un nouvel acteur ? Comment modélise-t-on cela ?

    Jojo est alors considéré comme un nouvel acteur (technicien). Il effecture une action de maintenance.

4. **Question 4 :** Certains agent de la RATP qui ne sont pas des techniciens sont aussi qualifiés pour opérer des opérations de maintenance en plus des opérations habituelles des techniciens telles que le remplacement de certains pièces et produits. Ils sont donc techniciens en plus d'être agents. Comment modéliser cela ?

    Agent est un acteur qui hérite de Technicien, cet acteur effectue comme action: remplacement pièce (remplacement pièce découle de maintenance).

