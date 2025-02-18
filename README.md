# Un "MonoRepo" avec Spring Boot, vue.js et Bootstrap

## Structure du projet

```
monorepo
├─┬ backend     → backend module with Spring Boot code
│ ├── src
│ └── pom.xml
├─┬ frontend    → frontend module with Vue.js code
│ ├── src
│ └── pom.xml
└── pom.xml     → Maven parent pom managing both modules
```

## Pour exécuter le projet

A la racine du projet:

```bash
mvn clean install
```

Cette commande va :
- Installer node et npm.
- construire le frontend en utilisant les outils vue.js.
- recopier ensuite les fichiers dans le backend.
- construire le backend.

Pour exécuter l'application "fullstack" :

```bash
mvn --projects backend spring-boot:run
```

L'application fullstack est accessible sur : <http://localhost:8989/>.

Vous avez également accès à [la console d'administration H2](http://localhost:8989/h2-console) 
et à l'[API swagger](http://localhost:8989/swagger-ui/index.html)

## Utilisation des outils de développement "front-end"

Pour faciliter le développement du frontend, on peut lancer le serveur de développement, qui "rafraîchit" automatiquement le front-end à chaque changement dans le code ! Pour cela (dans un nouveau terminal), se positionner dans le répertoire `frontend` et lancer :

```bash
cd frontend
npm run dev
```

## Déployer sur un cloud

[![Deploy to Koyeb](https://www.koyeb.com/static/images/deploy/button.svg)](https://app.koyeb.com/deploy?name=monorepo&repository=bastide%2Fmonorepo&branch=master&instance_type=free)