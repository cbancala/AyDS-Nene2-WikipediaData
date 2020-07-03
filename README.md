# AyDS-Nene2-WikipediaData
## Librería para obtener datos sobre una película desde la API de Wikipedia.

### Utilizar librería como sub-módulo
Para esto necesitamos:
* Clonar el repositorio dentro de un directorio en el proyecto general.
* Dentro del proyecto general: Incluir a la librería en el archivo settings.gradle y también como dependencia en el archivo build.gradle.
* Para el compilador IntelliJ: De ser necesario, agregar la dependencia a través de Module Settings.

### Obtener información de una pelicula 
**Clase WikipediaService**

*fun getInfo(movieTitle: String, movieYear: Integer):WikipediaInfoResponse*

Retorna información sobre una película recibida por parámetro a través de un objeto WikipediaInfoResponse. 

*Parámetros:*
* movieTitle: String, título de la película.
* movieYear : Integer, año de la película.

*Retorna:*
* Un objeto WikipediaInfoResponse 

**Ne-ne 2: Christian Bancalá. Dylan Barbona, Facundo Gonzalo, Yasmín Pie López.**