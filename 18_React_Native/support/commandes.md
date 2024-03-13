# commandes pour React native

## Installation

### Installer le JDK (Java)
```bash
choco install -y nodejs-lts microsoft-openjdk17
```
- enlever node si déjà installé


### Android studio
exécutable:  
- ne pas oublier android virtal device à chocher
- créer un émulateur et prendre le pixel 8 Pro. Ne pas oublier UpsideDownCake.

### Rajouter une variable d'environnement
Nom de la variable: ANDROID_HOME


`C:\Users\Administrateur\AppData\Local\Android\Sdk`
- chemin de base si on a pas modifier l'emplacement de l'émulateur. Attention le AppData est caché

## Lancement

### Création du projet

```bash
npx react-native@latest init NomDuProjet
```

### Liasion à l'émulateur

```bash
npm run android
```
ou
```bash
npx react-native run-android
```

## packages Navigation

```bash
npm install @react-navigation/native
npm install react-native-screens react-native-safe-area-context
```

### stack 

```bash
npm install @react-navigation/native-stack
```

### 

```bash

```