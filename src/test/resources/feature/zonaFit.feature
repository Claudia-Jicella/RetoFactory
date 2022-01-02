Feature: Compra de suplementos
  como cliente de la tienda virtual zonafit
  necesito comprar suplementos en oferta
  con el fin de venderlos en el gimnasio

  Background:
  Given que el cliente se encuentra en la pagína principal de la tienda virtual

  @Scenario1
  Scenario: Pago en Baloto
    When el cliente selecciona el producto y digita la informacion requerida tomando como opcion de pago Baloto
    Then el sistema debera mostrar el número del pedido

  @Scenario2
  Scenario: Pago con Efecty
    When el comprador selecciona el producto y llena los campos solicitados donde el metodo de pago efecty
    Then el sistema debebra mostrar el numero del convenio
