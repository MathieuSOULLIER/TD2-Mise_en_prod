# TD2 - Mise en production

Ce **projet** sert de support au TD2 du cours de mise en production (5A/SIR - Polytech NANCY). L'objectif de ce TD est de **builder un projet Java**.

Ce TD se sépare en 2 parties :

#### 1. Builder un projet Gradle en local à l'aide de Docker

#### 2. Builder un projet Gradle avec Jenkins et Docker

## Builder un projet Gradle en local avec Docker

### 1. Prérequis :
- Télécharger [Docker Desktop](https://hub.docker.com/)
- Télécharger [PostgreSQL](https://www.postgresql.org/download/)
- Télécharger un IDE (Exemple : [Visual Studio Code](https://code.visualstudio.com/))

### 2. Code source de l'application

- Cloner ce dépôt sur votre local.
- Lancer votre IDE.
- Ouvrir le dossier cloné.

Vous pouvez trouver un **dossier **à la racine nommé **App**, ce fichier contient le code source de notre application Java.

### 3. Lancer un build en local

- LUne fois téléchargé et un compte créé, vous pouvez lancer l'application Docker Desktop et vérifier que celle-ci est bien active.
- Ouvrir le projet depuis un terminal. Vérifiez que vous êtes bien à la racine du dossier intitulé **TD2-MISE_EN_PROD**.
- Lancer le build en utilisant la commande `docker build -t td2_mise_en_prod .`

>[!TIP]
> Vous pouvez vérifier que votre build s'est bien déroulé en allant dans la section "Images" de Docker Desktop où vous devriez retrouver l'image que vous venez de créer.

### 4. Démarrer l'application en local

Entrer la commande `docker compose up`.

>[!TIP]
> Vous pouvez vérifier que votre application a bien démarré en allant dans la section "Containers" de Docker Desktop où vous devriez retrouver le container de notre application.

### 5. Tester l'application

[Cliquez ici](http://localhost:8080/public/test) pour tester l'application.

### 6. Fermer l'application

Entrer la commande `docker compose down`.

>[!TIP]
> Vous pouvez vérifier que votre application s'est bien arrêtée en allant dans la section "Containers" de Docker Desktop et en regardant l'état du container de notre application.

## Builder un projet Gradle avec Jenkins et Docker

### 1. Prérequis :
#### -> Télécharger [Docker Desktop](https://hub.docker.com/)
#### -> Télécharger [PostgreSQL](https://www.postgresql.org/download/)
#### -> Télécharger un IDE (Exemple : [Visual Studio Code](https://code.visualstudio.com/))
#### -> Cloner ce dépôt sur votre local

### 2. Lancer Jenkins

Ouvrir un terminal à l'emplacement du projet (vérifier que vous êtes bien à la racine du dossier intitulé **TD2-MISE_EN_PROD**).

Lancer les commandes suivantes :
 ```cd jenkins-compose```
 ```docker compose up```

### 3. Ouvrir Jenkins

Ouvrir Docker Desktop et aller dans la section "Containers". Sélectionner le container Jenkins puis cliquer sur son port pour l'ouvrir dans votre navigateur.

Suivez les procédures d'inscription.

Puis ajoutez le module Docker à Jenkins.

### 4. Créer votre pipeline

-> Créer un nouvel item de type pipeline.

-> Dans la configuration du projet, recherchez la section "Pipeline" ou "Pipeline script from SCM" (selon la version
   de Jenkins que vous utilisez).

-> Configurez les paramètres SCM (Source Code Management) :

-> Sélectionnez Git comme système de gestion de code source.

-> Entrez l'URL de votre référentiel GitHub dans le champ "https://github.com/MathieuSOULLIER/TD2-Mise_en_prod".

-> Sélectionnez la branche "main".

-> Dans la section Pipeline, recherchez le champ "Script Path" ou "Script Definition".
   Spécifiez le chemin du Jenkinsfile dans votre référentiel (ici: jenkinsfile).

-> Enregistrez la configuration.

### 5. Build avec Jenkins

Il ne vous reste plus qu'à lancer le build depuis votre pipeline Jenkins.

>[!CAUTION]
>### Erreurs rencontrées :
>-> Pensez à avoir un accès internet pour que Jenkins puisse accéder à GitHub.
>-> Testez que Docker est bien installé sur Jenkins avec la commande ```docker --version```.
>-> Si vous avez l'erreur "Docker is not found", installez Docker manuellement à l'aide des commandes suivantes :
>```apt-get update```
>```apt-get install -y docker.io```
