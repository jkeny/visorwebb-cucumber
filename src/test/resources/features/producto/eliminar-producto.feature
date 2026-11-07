Feature: Eliminar Producto
Como usuario administrador
Quiero eliminar produtos del catálogo
Para mantener actualizado el maestro de productos

  Background:
    Given que el administrador inició sesion con usuario "admin" y la contraseña "clave"

  Scenario Outline: Eliminar producto seleccionado y validar respuesta del sistema
    Given que el sistema muestra el catálogo de mantenimiento de productos
    When busca el producto <producto> a eliminar
    And selecciona el producto <producto> de la tabla
    And hace clic en el botón Eliminar
    And acepta el mensaje de confirmación de eliminación
    Then el sistema mostrará un mensaje <mensajeEsperado> de eliminación exitosa

    Examples:
      | producto   | mensajeEsperado                             |
      | "BATERIAS" | "Se eliminó de manera correcta el Producto" |

  Scenario Outline: Eliminar sin seleccionar producto y validar respuesta del sistema
    Given que el sistema muestra el catálogo de mantenimiento de productos
    When busca el producto <producto> a eliminar
    And hace clic en el botón Eliminar
    And acepta el mensaje de confirmación de eliminación
    Then el sistema mostrará un mensaje <mensajeEsperado> de producto no seleccionado

    Examples:
      | producto   | mensajeEsperado                  |
      | "BATERIAS" | "No ha seleccionado un Producto" |
