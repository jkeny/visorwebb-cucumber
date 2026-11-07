Feature: Registrar Producto
Como usuario administrador
Quiero registrar nuevos productos
Para visualizarlos en el catálogo general

  Scenario Outline: Registrar Nuevo producto
    Given que el administrador inició sesion con usuario <usuario> y la contraseña <password>
    When registra un nuevo producto <producto> <categoria> <precio>
    Then el sistema muestra un mensaje <mensajeEsperado>

    Examples:
      | usuario | password | producto            | categoria    | precio | mensajeEsperado                                      |
      | "admin" | "clave"  | "Útiles de Oficina" | "ACCESORIOS" | "3.50" | "Se guardó de manera correcta el Producto"           |
      | "admin" | "clave"  | ""                 | "CELULAR"    | "250.50" | "Nombre: Error de validación: se necesita un valor." |
