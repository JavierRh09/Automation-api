Feature: Realizar un pedido para una mascota y Buscar orden de compra por ID

  @Examen
  Scenario Outline: Realizar un pedido para una mascota

    When realizo el pedido con el id "<id>", petId: "<petId>", quantity: "<quantity>"

    Examples:
      | id | petId | quantity |
      | 19 | 2206  | 30       |