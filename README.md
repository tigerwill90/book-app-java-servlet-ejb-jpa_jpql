# Application bibliothèque basique - JAVA EE - Servlet avec EJB et JPA_JPQL sous TOMEE

C'est une simple application de demonstration, dans le cadre du cours 635-1 de la HEG (HES-SO)
de l'implémentation d'une application web avec

* JAVA EE
* Api Servlet
* Entreprise JavaBeans EJB
* OpenJPA - JPA_JPQL
* JSTL core, fmt et functions

#### Installation de l'environnement de développement

````
    Télécharger ou cloner le répertoire sur votre machine local :
    
    https://github.com/tigerwill90/book-app-java-servlet-ejb-jpa_jpql.git
````

##### Sous eclipse
* Java
* Dynamic Web Module 3.0
* JPA 2.0 (jar disponnible dans le répertoire lib de tomee)

Copiez les fichiers source contenu dans `src` et `web` à destination de votre nouveau projet

##### Sous IntelliJ IDEA
* Java EE 7
* Web Application 
* JavaEE Persistence, OpenJPA 2.0 (jar disponnible dans le répertoire lib de tomee)

Copiez les fichiers source contenu dans `src` et `web` à destination de votre nouveau projet

##### TomEE

La version de tomee utilisé est la 7.0.x.

Modifiez le fichier `tomecat-users.xml` dans le répertoire `conf` de votre serveur tomee et ajouter
un nouveau utilisateur :

````xml
    <role rolename="tomee-admin" />
    <user username="tomee" password="tomee" roles="tomee-admin" />
````

#### Déploiement du war sur TomEE

##### Configurer catalina

Modifiez le fichier `catalina.bat` dans le répertoire `bin` de votre serveur tomee et ajouter la ligne suivante
à la fin de la section commentaire `rem` :

````bat
set JAVA_HOME=\Path\to\jdk

Exemple sous windows :
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_152
````

##### Déploiment du war

* Copier le fichier `library.war` du dossier `out`, dans le répertoire `webapps` de votre serveur tomee
* Sous windows, exécuter le script `startup.bat` localisé dans `bin`
* Sous linux et mac, exécuter le script `startup.sh` localisé dans `bin` à l'aide de la commande
`./startup.sh`

Si tout c'est bien passé, un nouveau répertoire `library` a été créer dans le répertoire `webapps`.
L'application s'exécute à l'adresse `http://localhost:8080/library/`

##### Version

RC-1.0.2