# Basic books webapp - JAVA EE - Servlet with EJB and JPA_JPQL under TOMEE

This is a simple demo app for java EE using 

* JAVA EE
* Api Servlet
* Entreprise JavaBeans EJB
* OpenJPA - JPA_JPQL
* JSTL core, fmt et functions

#### Getting Started

````
Clone or download repository
````

Maven is don't used yet, so you need to manually create a new project with the following dependancies :

* Java EE - Web application, web.xml ^3.0
* OpenJPA 2.0 (JPA library is included in TomEE WebProfil)

##### TomEE

You can use Apache TomEE WebProfil 1.7.x or 7.0.x

Add the following line in your `tomecat-users.xml`, localised `conf` directory of your TomEE installation

````xml
    <role rolename="tomee-admin" />
    <user username="tomee" password="tomee" roles="tomee-admin" />
````

#### Quickly deploying war for demo

##### Catalina

Modify `catalina.bat` file in `bin` directory of your TomEE installation. Add the following line after comment section

````bat
set JAVA_HOME=\Path\to\jdk

Example under windows :
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_152
````

##### Deploying

* Copy `library.war` file from `out`directory to `webapps` directory of your TomEE installation
* Under windows, execute `startup.bat`localized on `bin` directory
* Under linux or mac, execute `startup.sh` localized in `bin` directory with `./startup.sh` command


The application is accessible on `http://localhost:8080/library/`

##### Version

RC-1.0.3