package com.auto.base.stepDefinitions;

import com.auto.base.steps.TicketPeruRailStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.thucydides.core.annotations.Steps;

import java.text.ParseException;

public class TicketPeruRailSD {

    @Steps
    public TicketPeruRailStep ticketPeruRailStep;

    @Given("^Cargue la página de PeruRail$")
    public void carguelaPaginadePeruRail() {
        ticketPeruRailStep.openPage();
    }

    @Y("^selecciona destino: (.*)$")
    public void seleccionaDestino(String destino) {
        ticketPeruRailStep.selectDestino(destino);
    }

    @Y("^selecciona ruta: (.*)$")
    public void seleccionaRuta(String ruta) { ticketPeruRailStep.selectRuta(ruta);
    }

    @Y("^selecciona Tren: (.*)$")
    public void seleccionaTren(String tren) {
        ticketPeruRailStep.selectTren(tren);
    }

    @Y("^selecciona solo ida: (.*)$")
    public void seleccionaSoloIda(String SINO) {
        ticketPeruRailStep.selectSoloIda(SINO);
    }
    @Y("^selecciona fecha de salida (.*)$")

    public void seleccionaFecSalida(String fecSalida) throws ParseException { ticketPeruRailStep.selectFecSalida(fecSalida);
    }
    @Y("^selecciona fecha de retorno (.*)$")
    public void seleccionaFecRetorno(String fecRetorno) throws ParseException { ticketPeruRailStep.selectFecRetorno(fecRetorno);
    }

    @Y("^selecciona boton 'Buscar'")
    public void seleccionaBtnBuscar() {
        ticketPeruRailStep.selectBtnBuscar();
    }

    @Y("^seleccioanar Boletos")
    public void seleccionaBoletos() { ticketPeruRailStep.selectBoletos();
    }

    @Y("^selecciona boton 'Continuar'")
    public void seleccionaBtnContinuar() {
        ticketPeruRailStep.selectBtnContinuar();
    }

       @Y("^ingresa información de Pasajeros")
    public void sendInformacionPasajeros() {
        ticketPeruRailStep.sendInfPasajeros();
    }

    @Y("^selecciona boton 'ContinuarPago'")
    public void seleccionaBtnContinuarPago() {
        ticketPeruRailStep.selectBtnContinuarPago();
    }

    @Entonces("^validar monto de pago")
    public void validaMontoPago() { ticketPeruRailStep.validaMontoPago();
    }

}
