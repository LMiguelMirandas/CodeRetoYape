package com.auto.base.steps;

import com.auto.base.pageobject.TicketPeruRailPage;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

public class TicketPeruRailStep {

    private TicketPeruRailPage ticketPeruRailPage;

    private static final Logger LOGGER = LoggerFactory.getLogger(TicketPeruRailStep.class);

    public void openPage(){
        LOGGER.info("abre pagina de inicio");
        ticketPeruRailPage.open();
    }

    public void selectDestino(String strdestino){ ticketPeruRailPage.SelectDestino(strdestino);
    }
        public void selectRuta(String strRuta){ ticketPeruRailPage.SelectRuta(strRuta);
    }
    public void selectTren(String strTren){ ticketPeruRailPage.selectTren(strTren);
    }
    public void selectSoloIda(String strSINO){ ticketPeruRailPage.selectSoloIda(strSINO);
    }
    public void selectFecSalida(String strFecSalida) throws ParseException { ticketPeruRailPage.selectFecSalida(strFecSalida);
    }
    public void selectFecRetorno(String strFecRetorno) throws ParseException { ticketPeruRailPage.selectFecRetorno(strFecRetorno);
    }
    public void selectBtnBuscar(){ ticketPeruRailPage.selectBtnBuscar();
       // Assert.assertEquals(true ,ticketPeruRailPage.verificarCarga());
    }
    public void selectBoletos(){ ticketPeruRailPage.selectBoletos();
    }
    public void selectBtnContinuar() throws InterruptedException { ticketPeruRailPage.selectBtnContinuar();
        Assert.assertEquals(true ,ticketPeruRailPage.verificarCargaPasajero());
    }
    public void sendInfPasajeros(){ ticketPeruRailPage.sendInfPasajeros();
    }
    public void selectBtnContinuarPago(){ ticketPeruRailPage.selectBtnContinuarPago();
      //
    }
    public void validaMontoPago(){
        Assert.assertEquals(true ,ticketPeruRailPage.validaPayment());
        Assert.assertEquals(true ,ticketPeruRailPage.validaSubTotal1());
        Assert.assertEquals(true ,ticketPeruRailPage.validaSubTotal2());
        Assert.assertEquals(true ,ticketPeruRailPage.validaTotalDol());
        Assert.assertEquals(true ,ticketPeruRailPage.validaTotalSol());

    }



}
