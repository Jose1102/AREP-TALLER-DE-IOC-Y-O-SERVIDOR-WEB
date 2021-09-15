# AREP-TALLER-DE-IOC-Y-O-SERVIDOR-WEB


Para este taller los estudiantes deberán construir un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor debe atender múltiples solicitudes no concurrentes.

Para este taller desarrolle un prototipo mínimo que demuestre capcidades reflexivas de JAVA y permita por lo menos cargar un bean (POJO) y derivar una aplicación Web a partir de él. Debe entregar su trabajo al final del laboratorio.

## Despliegue Heroku


[![Heroku](https://www.herokucdn.com/deploy/button.png)](https://taller-ioc.herokuapp.com/index.html)



## Autor ✒️


* **Jose María Castro Ortega** - *Autor*  - *Estudiante de ingeniería de sistemas*
* **15/09/2021** - *Fecha* 


## Tabla de contenido

- [Circleci](#circleci).
- [Requisitos](#requisitos-).
- [Enunciado](#enunciado).
- [Comenzando](#comenzando-).
- [Productividad](#productividad).
- [Javadoc](#javaDoc-).
- [Licencia](#licencia-)

## Circleci

[![CircleCI](https://circleci.com/gh/circleci/circleci-docs.svg?style=svg)](https://app.circleci.com/pipelines/github/Jose1102/AREP-TALLER-DE-IOC-Y-O-SERVIDOR-WEB)

## Requisitos 📋
* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Git](https://git-scm.com/) - Software de control de versiones
* [Java](https://www.oracle.com/java/) - Lenguaje de programación

## Enunciado


Para este taller los estudiantes deberán construir un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor debe atender múltiples solicitudes no concurrentes.

Para este taller desarrolle un prototipo mínimo que demuestre capcidades reflexivas de JAVA y permita por lo menos cargar un bean (POJO) y derivar una aplicación Web a partir de él. Debe entregar su trabajo al final del laboratorio.

## Comenzando 🚀
1. Clonar el repositorio
```
git clone https://github.com/Jose1102/AREP-TALLER-DE-IOC-Y-O-SERVIDOR-WEB
```

2. Compilar el proyecto

```
mvn package
```

3. Ejecutar el proyecto de manera local

```
java -cp target/classes;target/dependency/* edu.escuelaing.arep.app.App
```




## Ejecutando las pruebas

1. Compilar pruebas

```
mvn test
```







## Productividad
La productividad de este proyecto fue:
* 356 loc / 29 hours

## JavaDoc 📖

Para consultar la carpeta de [JAVADOC](https://github.com/Jose1102/AREP-TALLER-DE-IOC-Y-O-SERVIDOR-WEB/tree/main/doc) .

## Licencia 📌

Este proyecto está bajo la Licencia Pública General GNU - consulte el archivo de [LICENCIA](https://github.com/Jose1102/AREP-TALLER-DE-IOC-Y-O-SERVIDOR-WEB/blob/main/LICENSE.txt) para obtener más detalles.
