# Second Degree Equation Solver

Bienvenue sur le projet "Second Degree Equation Solver" ! Ce projet est une application Java qui permet de résoudre des équations du second degré. Voici quelques instructions simples pour vous aider à démarrer.

## Prérequis

Avant de commencer, assurez-vous que les éléments suivants sont installés sur votre ordinateur :

- Java JDK 11 ou supérieur
- Maven (un outil de gestion et d'automatisation de projet)

## Comment démarrer ?

Pour exécuter l'application, suivez ces étapes :

1. **Téléchargement du Projet :**

   - Si vous avez le projet sous forme de fichier zip, décompressez-le dans un dossier de votre choix.
   - Si vous avez accès au dépôt de code, clonez-le sur votre machine locale.

2. **Ouvrir une Fenêtre de Commande :**

   - Ouvrez une fenêtre de commande (aussi appelée terminal ou invite de commande) sur votre ordinateur.

3. **Naviguer vers le Dossier du Projet :**

   - Utilisez la commande `cd` pour naviguer dans le dossier où vous avez placé le projet. Par exemple :
     ```
     cd chemin/vers/le/dossier/du/projet
     ```

4. **Exécuter l'Application :**
   - Dans le dossier du projet, exécutez la commande suivante pour lancer l'application :
     ```
     mvn clean install
     ```

## Tests

Le projet contient deux types de tests : des tests unitaires et des tests End-to-End (E2E).

- Pour exécuter uniquement les tests unitaires, utilisez :

  ```
  mvn test
  ```

- Pour exécuter les tests E2E, utilisez :
  ```
  mvn verify
  ```

## Remarques Additionnelles

- Le projet utilise plusieurs outils de qualité de code tels que PMD et Checkstyle pour assurer un code propre et bien structuré.
- Vous trouverez des rapports détaillés sur la qualité du code et les tests dans le dossier `target` après avoir exécuté les tests.

## Déploiement

Pour déployer l'application, suivez ces étapes :

1. **Empaqueter l'Application :**

   - Utilisez la commande Maven pour créer un fichier WAR (Web Application Archive) qui peut être déployé sur un serveur :
     ```
     mvn package
     ```
   - Cette commande va générer un fichier `.war` dans le dossier `target`.

2. **Déploiement sur un Serveur Local :**
   - Assurez-vous d'avoir un serveur Apache Tomcat (version 10.1.4 ou supérieure) installé sur votre machine.
   - Copiez le fichier `.war` généré depuis le dossier `target` vers le dossier `webapps` de votre installation Apache Tomcat.
   - Démarrez ou redémarrez le serveur Tomcat pour déployer l'application.

Après le déploiement, vous devriez pouvoir accéder à l'application via un navigateur web en utilisant l'URL appropriée, généralement quelque chose comme `http://localhost:8080/nom_du_fichier_war`.
