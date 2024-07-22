- Utilisez la commande Docker pour créer un container basé sur l'image Alpine.
- Connectez-vous au shell du container nouvellement créé.

``` bash
docker pull apline
docker run -it alpine

```

- À l'intérieur du container, utilisez la commande `git` pour cloner un dépôt public depuis GitHub (par exemple, https://github.com/votre-utilisateur/exemple-repo.git).
- Allez dans le répertoire du dépôt cloné.

``` bash
apk add git
cd root/
git clone https://github.com/Florian00000/TodoList_SpringApi_FrontReact.git
cd TodoList_SpringApi_FrontReact/
```

- À l'intérieur du container, ouvrez un fichier texte (par exemple, README.md) à l'aide d'un éditeur de texte disponible dans l'image Alpine.
- Ajoutez une ligne de texte à votre choix et enregistrez le fichier

``` bash
apk add nano
nano README.md
docker cp nifty_taussig:/root/TodoList_SpringApi_FrontReact/README.md .\Desktop\
```