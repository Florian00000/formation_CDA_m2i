# Exercice 6

On souhaite cree une imge docker pour distribue notre site web statique via un serveur web

- Choisir une image de serveur web

- Cree un dockerfile a partir de cette image qui a la place de sa page par défaut montrera votre projet

- Vous notere la commande pour teste votre image 

```bash
docker build -t exercice6 .
docker run -p 8080:80 -d exercice6
```

Bonus :

- Vous publierez cette image sur docker hub 