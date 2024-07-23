# Exercice 5

- Création d'un volume nommé 

```bash
docker volume create volumeEx5
```

- Création d'un conteneur serveur web avec nginx et utilisation du volume cree pour stocker votre site web.

```bash
docker run --name cexo5 -p 8081:80 -v volumeEx5:/usr/share/nginx/html nginx
docker cp C:\Users\Administrateur\Desktop\exo1cactus\. cexo5:/usr/share/nginx/html
```

- confirmation via votre navigateur 

- suppression de votre conteneur nginx

```bash
docker rm cexo5
```

- Création d'un conteneur serveur web avec apache qui utilisera le site web présent dans votre volume.

```bash
docker run --name cexo5 -p 8080:80 -d -v volumeEx5:/usr/local/apache2/htdocs/ httpd
```