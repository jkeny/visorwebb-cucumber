Feature: Actualizar Producto
Yo como administrador del sistema
Quiero editar los productos del catalogo
Para mantener actualizado los productos

  Background:
    Given que el administrador inició sesion con usuario "admin" y la contraseña "clave"

  Scenario Outline: Actualizar producto y validar respuesta del sistema
    Given que estando en el detalle del producto seleccionado <productoSeleccionado>
    When actualiza el nombre del producto seleccionado con los valores <nuevoNombreProducto> <nuevaCategoria> <nuevoPrecio>
    Then el sistema debe mostrar el mensaje <mensajeEsperado>

    Examples: Actualización Exitosa
      | usuario | password | productoSeleccionado | nuevoNombreProducto | nuevaCategoria | nuevoPrecio | mensajeEsperado                               |
      | "admin" | "clave"  | "BATERIAS"           | "CHOCOCHIPS"        | "CHOCOLATES"   | "6.00"      | "Se actualizó de manera correcta el Producto" |
      | "admin" | "clave"  | "CHOCOCHIPS"         | "BATERIAS"          | "ACCESORIOS"   | "6.00"      | "Se actualizó de manera correcta el Producto" |

    Examples: Flujos Alternos / Errores de Validación
      | usuario | password | productoSeleccionado | nuevoNombreProducto | nuevaCategoria | nuevoPrecio | mensajeEsperado                                      |
      | "admin" | "clave"  | "BATERIAS"           | ""                  | "CHOCOLATES"   | "6.00"      | "Nombre: Error de validación: se necesita un valor." |

  Scenario: Validar restricción al intentar editar sin seleccionar un producto
    Given que el sistema muestra el catálogo de mantenimiento de productos
    When se intenta editar un producto "BATERIAS" sin haberlo seleccionado de la lista
    Then el sistema debe mostrar el mensaje de advertencia "No ha seleccionado un Producto"
