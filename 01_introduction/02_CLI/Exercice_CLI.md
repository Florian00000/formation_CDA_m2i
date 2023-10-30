**Exercice : Gestion de fichiers et de dossiers en utilisant le CLI**

1. Ouvrez votre terminal.

2. Naviguez jusqu'à votre dossier personnel.
    - cd .\CLI\

3. Créez un nouveau dossier appelé "Exercice_CLI".
    - mkdir Exercice_CLI

4. Accédez au dossier que vous venez de créer.
    -  cd .\Exercice_CLI\

5. Créez trois fichiers à l'intérieur du dossier "Exercice_CLI" : "fichier1.txt", "fichier2.txt" et "fichier3.txt".
    - echo . > fichier1.txt; echo . > fichier2.txt; echo . > fichier3.txt

6. Listez les fichiers du dossier.
    - dir

7. Copiez "fichier1.txt" dans un sous-dossier appelé "SousDossier" à l'intérieur de "Exercice_CLI".
    - cp fichier1.txt SousDossier

8. Renommez "fichier2.txt" en "nouveau_fichier.txt".
    - mv .\fichier2.txt nouveau_fichier.txt

9. Déplacez "nouveau_fichier.txt" dans le dossier "SousDossier".
    - mv .\nouveau_fichier.txt .\SousDossier\

10. Supprimez le dossier "SousDossier" et son contenu.
    - del -r .\SousDossier\ 
    - mettre l'option `-r` avant l'argument `.\SousDossier\` par convention

11. Revenez au dossier parent.
    - cd ../

12. Supprimez le dossier "Exercice_CLI" et son contenu.
    - del -r .\Exercice_CLI\     