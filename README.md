# TD2 - Mise en production

Ce projet sert de support au TD2 du cours de mise en production (5A/SIR - Polytech NANCY). L'objectif de ce TD est de build un projet Java.

Ce TD ce separ en 2 parties:

#### 1. Builder un projet Gradle en local à l'aide de Docker

#### 2. Builder un projet Gradle avec Jenkins et Docker

## Builder un projet Gradle en local avec Docker

### 1. Prérequis :
#### -> Télecharger [Docker desktop](https://hub.docker.com/)
#### -> Télecharger un IDE (Exemple : [Visual studio code](https://code.visualstudio.com/))

### 2.  code source de l'application

#### - Cloner ce depot sur votre local
#### - Lancer votre IDE
#### - Ouvrir le Dossier cloné

Vous pouvez trouver un dossier à la racine nomé "App", ce fichier contient le code source de notre application Java.

### 3. Lancer un build en local

#### - Lancer Docker Desktop
Une fois telecharger et un compte crée, vous pouvez lancer l'application Docker desktop et verifié que celle ci est bien active.

#### - Ouvrez le projet depuis un terminal
verifier que vous etes bien à la racine du dossier intitulé "TD2-MISE_EN_PROD"

#### - Lancé le build
Entrer la commande ```docker build -t td2_mise_en_prod .```