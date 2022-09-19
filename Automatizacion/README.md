# Automation

Descripcion de la Prueba tecnica Realizada:

Se realizaron 2 procesos de automatizacion por UI en un proyecto tipo gradle, el primero se utilizó Cucumber + Selenium + Java y en el segundo se utilizo JUnit + Selenium + Java, en ambas formas de automatizacion extendemos de una clase base la cual se encarga de todo el proceso de inicializar el browser y realizar el teardown del mismo.

Proceso 1.

1. Creación de un proyecto tipo Gradle
2. Framework de automatización de pruebas UI “Selenium” (Utilizado Principalmente para realizar escenarios de regresion o criticos para el core del negocio)
3. Framework de ejecución de pruebas Cucumber
4. Arquitectura del proyecto de pruebas POM “Page Object Model”

Para este proceso se crearon 2 escenarios de automatizacion (Un registro exitoso de un usuario y otro un registro en donde falta completar informacion y se valida que retorne correctamente el mensaje de error), en donde se creó un Runner para la ejecucion de la prueba, se crearon los step definitions necesarios y el feature de registro donde se tienen los dos escenarios probados, adicionalmente se tienen las clases page en donde se interactua con la pagina que se está probando.

Parte 2.


1. Creación de un proyecto tipo Gradle
2. Framework de automatización de pruebas UI “Selenium” (Utilizado Principalmente para realizar escenarios de regresion o criticos para el core del negocio)
3. Framework de ejecución de pruebas Junit
4. Arquitectura del proyecto de pruebas POM “Page Object Model”
5. Patron de Automatizacion AAA "Arrange - Act - Assert"

Para este proceso se crearon tambien 2 escenarios de automatizacion, se crea una clase Test con los mismos dos escenarios de automatizacion y se crean las clases Page con las cuales se interactua con la ventana a validar. Adicionalmente se tiene una clase base en la cual se hace el proceso de inicializar el browser y hacer tambien el cierre del mismo, de esta clase extendemos en la clase de test para facilitar el proceso de pruebas y reutilizar codigo con las etiquetas @Before
