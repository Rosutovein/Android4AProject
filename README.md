# Application Pokemon: PokeAPI-V2

## Créateur
Alexandre Piga, étudiant en 4ème année à l'école d'ingénieur ESIEA

## Présentation
Projet consistant en la création d'une application android codé en Kotlin sur l'univers de Pokemon.
Cette application affiche le pokedex de la première génération de Pokemon en utilisant une API Github.
(JSON stocké sur ce compte github). Utilisation d'une base de données pour stocker des utilisateurs.


## Prérequis
* Installation du logiciel Android Studio (disponible sur Mac, Linux et Windows)
* Récupérer le programme grâce au lien Github suivant:
```
https://github.com/Rosutovein/Android4AProject.git
```

## Consignes respectées:
* Utilisation du langage Kotlin
* Architecture MVVM (Tentative mais il y a très probablement des erreurs)
* Clean Architecture
* Utilisation d'une réelle base de données pour les utilisateurs
* Appel WebService à une API Rest (```https://raw.githubusercontent.com/Rosutovein/Android4AProject/master/pokedex.json```)
* Affichage d'une liste d'éléments 
* Fonctions supplémentaires:
  * Écran avec le détail d'un élément (types, évolution, etc.)
  * SplashScreen au démarrage de l'application
  * Notification Push (Firebase)

## Fonctionalités:

### Première écran
* Splash Screen au démarage de l'application
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/SplashActivity.jpg" width="360" height="640" />

### Écran Home
* Création d'un compte utilisateur
Il suffit d'écrire dans les champs un nom d'utilisateur et un mot de passe puis appuyer sur "CREATE ACCOUNT"
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/SplashActivity.jpg" width="360" height="640" />
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/Success.jpg" width="360" height="640" />
* Connexion à un compte utilisateur
Comme précédément, il suffit d'écrire dans les champs un nom d'utilisateur et un mot de passe puis appuyer sur "LOG IN"
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/Error.jpg" width="360" height="640" />

### Écran du pokedex
* Afficher la liste des pokemon
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/Pokedex.jpg" width="360" height="640" />

### Écran du pokemon
* Affiche les détails du pokemon sélectionné dans le pokedex
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/Pokemon.jpg" width="360" height="640" />

### Notification push
* Exemple de notification (Firebase)
<img src="https://github.com/Rosutovein/Android4AProject/blob/master/img_readme/Notification.jpg" width="360" height="640" />
