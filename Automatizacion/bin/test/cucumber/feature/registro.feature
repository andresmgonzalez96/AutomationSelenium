Feature: Realizar el Registro de un usuario

  Scenario: Registro exitoso de un usuario
    Given Un Usuario quiere registrarse
    When se envia la informacion requerida
    Then Deberia permitir realizar el registro exitoso
    
  Scenario: Registro fallido de un usuario faltan datos
    Given Un Usuario quiere registrarse
    When se envia la informacion incompleta
    Then Deberia retornar un menaje de error en el registro
