Feature: Consultar Producto
Como administrador del sistema 
Quiero Consultar los productos
Para obtener su información detallada

  Background:
    Given que el administrador inició sesion con usuario "admin" y la contraseña "clave"

  Scenario Outline: Buscar un producto en el catálogo
    Given que el sistema muestra el catálogo de mantenimiento de productos
    When busca el producto <producto>
    Then el sistema debe mostrar <producto> en la lista de resultados

    Examples:
      | producto     |
      | "AUDIFONOS"  |
      | "BATERIAS"   |
      | "CHOCOCHIPS" |

  Scenario Outline: Mostrar mensaje cuando no se encuentra resultados en la búsqueda
    Given que el sistema muestra el catálogo de mantenimiento de productos
    When busca el producto <productoNoExistente>
    Then el sistema debe mostrar un mensaje "No existe registros para la consulta"

    Examples:
      | productoNoExistente |
      | "Carritos"          |
      | "wewree3"           |
      | "999999999"         |
