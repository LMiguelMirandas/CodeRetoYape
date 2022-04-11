#language: es
@TicketEscenario
Característica: Ticket de tren

  @Ticket
  Esquema del escenario: CP01 GeneraTicketTren
    Dado Cargue la página de PeruRail
    Y selecciona destino: <varDestino>
    Y selecciona ruta: <varRuta>
  Y selecciona Tren: <varTren>
  Y selecciona solo ida: <varSoloIda>
  Y selecciona fecha de salida <varFecSalida>
  Y selecciona fecha de retorno <varFecRegreso>
  Y selecciona boton 'Buscar'
Y seleccioanar Boletos
  Y selecciona boton 'Continuar'
  Y ingresa información de Pasajeros
  Y selecciona boton 'ContinuarPago'
  Entonces validar monto de pago


    Ejemplos:
      |varSoloIda|varDestino|varRuta|varTren|varFecSalida|varFecRegreso|
  # |  "Ignore"   |"Cusco"|"Puno > Cusco"|"PeruRail Titicaca Train"|"12/05/2022"|"Ignore"|
  ## |  "Ignore"   |"Cusco"|"Puno > Cusco"|"Andean Explorer, A Belmond Train"|"15/05/2022"|"Ignore"|
   ## |   "Ignore"    |"Cusco"|"Arequipa > Puno > Cusco"|"Ignore"|"27/04/2022"|"Ignore"|
      |  "Ignore"     |"Machu Picchu"|"Cusco > Machu Picchu"|"Ignore"|"19/04/2022"|"19/04/2022"|
##    |"NO"|"Machu Picchu"|"Cusco > Machu Picchu"|"Ignore"|"27/05/2022"|"Ignore"|
