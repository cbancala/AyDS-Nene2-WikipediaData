# AyDS-Nene2-WikipediaData
## Librería para obtener datos sobre una película desde la API de Wikipedia.

### Utilizar librería como sub-módulo
Para esto necesitamos:
* Clonar el repositorio dentro de un directorio en el proyecto general.
* Dentro del proyecto general: Incluir a la librería en el archivo settings.gradle y también como dependencia en el archivo build.gradle.
* Para el compilador IntelliJ: De ser necesario, agregar la dependencia a través de Module Settings.

### Obtener información de una película 
Para obtener información de una película hay que utilizar el método getInfo, el cual pertenece a la clase WikipediaService. 
Se debe hacer uso de dicho método a través del objeto WikipediaDataModule, dónde ya se encuentra instanciada la clase WikipediaService a través de la constante WIKIPEDIA_SERVICE. 

*fun getInfo(movieTitle: String, movieYear: Integer):WikipediaInfo*

Retorna información sobre una película recibida por parámetro a través de un objeto WikipediaInfo. 

*Parámetros:*
* movieTitle: String, título de la película.
* movieYear : String, año de la película.

*Retorna:*
* Un objeto WikipediaInfo

*Casos especiales:*
* En caso perder conexión de red se lanza una excepción. 

**Ne-ne 2: Christian Bancalá, Dylan Barbona, Facundo Gonzalo, Yasmín Pie López.**