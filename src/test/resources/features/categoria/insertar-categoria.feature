Feature: Gestion Categoria

  Scenario Outline: Registrar Categoria
    Given cargo la pagina visor web
    And inicio sesion con usuario <usuario> y la contraseña <clave>
    When cargo la pagina registrar categoria
    And registro la categoria <categoria>
    Then el sistema debe mostrar el mensaje <mensajeEsperado>

    Examples:
      | usuario | clave   | categoria     | mensajeEsperado                                     |
      | "admin" | "clave" | "Teclado RGB" | "Se guardó de manera correcta la Categoría"         |
      | "admin" | "clave" | ""            | "Nombre: Error de validación: se necesita un valor." |
      | "admin" | "clave" | "MONITOR LCD" | "Se guardó de manera correcta la Categoría"         |
