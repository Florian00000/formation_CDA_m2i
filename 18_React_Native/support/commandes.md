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
Nom de la variable (variable utilisateur): ANDROID_HOME


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

### bottom tabs

```bash
npm install @react-navigation/bottom-tabs
```

## Rajouter de icônes

1. bibliothèque react native vector icons 

```bash
npm install react-native-vector-icons
```


2. chemin du fichier à modifier:  /android/app/build.gradle  
rajout à faire: `apply from: "../../node_modules/react-native-vector-icons/fonts.gradle"`

3. Dans le fichier jsx: 
```jsx
import Icon from 'react-native-vector-icons/[nomDeLaBibliothèque]  

<Icon name='phone' color="red" size={50}/>
```

## Async Storage 

```bash
npm install @react-native-async-storage/async-storage
```

## GPS

1. commande npm
```bash
npm install @react-native-community/geolocation
```

2. aller dans le repertoire `android/app/src/main/AndroidManifest.xml`  

3. Ajout d'une ligne en dessous de la permission internet (déjà accordé): 
```xml
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

## redux

```bash
npm install @reduxjs/toolkit react-redux
```