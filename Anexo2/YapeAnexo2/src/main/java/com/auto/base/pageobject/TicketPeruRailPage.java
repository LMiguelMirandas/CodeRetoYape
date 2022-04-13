package com.auto.base.pageobject;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@DefaultUrl("https://www.perurail.com")

public class TicketPeruRailPage extends PageObject {

     String strVarTren = "";
    Date dateSalida;
    int difA;
    int difM;

    static class GlobalVals{
        static Double Dolares1;
        static Double Soles1;
        static Double Dolares2 ;
        static Double Soles2;
    }

    @FindBy(id = "destinoSelect")
    public WebElement cbxDestino;
    @FindBy(id = "rutaSelect")
    public WebElement cbxRuta;
    @FindBy(id = "cbTrenSelect")
    public WebElement cbxTren;
    @FindBy(xpath = "//*[@id='radioset']/div[1]")
    public WebElement rbRetorno;

    @FindBy(id = "salida")
    public WebElement btnFecSalida;
    @FindBy(id = "regreso")
    public WebElement btnFecRetorno;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div/a[2]")
    public WebElement btnSiguienteFec;

    @FindBy(id = "btn_search")
    public WebElement btnBuscar;

    @FindBy(id = "imagenIda")
    public WebElement imgCargaIda;


    @FindBy(id = "div_2021010535_10")
    public WebElement btnBuscarBoleto;
    @FindBy(xpath = "//*[@id='div_2021010535_10']/div[6]/div")
    public WebElement lblCostoBoleto;
    @FindBy(id = "div_2021021605_11")
    public WebElement btnBuscarBoleto2;
    @FindBy(xpath = "//*[@id='div_2021021605_11']/div[6]")
    public WebElement lblCostoBoleto2;
    @FindBy(xpath = "//*[@id='formTrenSeleccionar']/div/div/input")
    public WebElement btnContinuar;
    @FindBy(id = "formPasajero1-nomPasajero")
    public WebElement lblSiguientePasajero;
    @FindBy(id = "formPasajero1-apePasajero")
    public WebElement txtApePasajero;
    @FindBy(id = "formPasajero1-fecNacimiento")
    public WebElement formFecNacimiento;
    @FindBy(id = "formPasajero1-numDocumentoIdentidad")
    public WebElement txtNumDocIdentidad;

    @FindBy(id = "formPasajero1-numTelefono")
    public WebElement txtNumTelefono;
    @FindBy(id = "formPasajero1-desEmail")
    public WebElement txtdesEmail;
    @FindBy(id = "formPasajero1-desEmailConfirmacion")
    public WebElement txtConfirEmail;

    @FindBy(xpath = "//*[@id='formPasajeroRegistrar']/div[2]/div[1]")
    public WebElement btnRegistrar;
    @FindBy(id = "formPasajero2-nomPasajero")
    public WebElement lblSiguientePasajero2;
    @FindBy(id = "formPasajero2-apePasajero")
    public WebElement txtApePasajero2;
    @FindBy(id = "formPasajero2-fecNacimiento")
    public WebElement formFecNacimiento2;
    @FindBy(id = "formPasajero2-numDocumentoIdentidad")
    public WebElement txtNumDocIdentidad2;

    @FindBy(id = "formPasajero2-numTelefono")
    public WebElement txtNumTelefono2;
    @FindBy(id = "formPasajero2-desEmail")
    public WebElement txtdesEmail2;
    @FindBy(id = "formPasajero2-desEmailConfirmacion")
    public WebElement txtConfirEmail2;


    @FindBy(id = "enviarPago")
    public WebElement btnEnviarPago;
    @FindBy(id = "compra") //*[@id="compra"]
    public WebElement txtPayment;

    @FindBy(xpath = "//*[@id='compra']/div/div[2]/div[5]/span")
    public WebElement txtSubTotal1;
    @FindBy(xpath = "//*[@id='compra']/div/div[3]/div[5]/span")
    public WebElement txtSubTotal2;
    @FindBy(xpath = "//*[@id='compra']/div/div[4]/div[1]/div[2]/span")
    public WebElement txtTotalSol;
    @FindBy(xpath = "//*[@id='compra']/div/div[4]/div[1]/div[1]/span[2]")
    public WebElement txtTotalDol;

    public void SelectDestino(String strDestino) {
        cbxDestino.click();
        find(By.xpath("//*[@id='destinoSelect']/option[text()="+strDestino+"]")).click();
    }
    public void SelectRuta(String strRuta) {
        cbxRuta.click();
        find(By.xpath("//*[@id='rutaSelect']/option[text()="+strRuta+"]")).click();
    }

    public void selectTren(String strTren) {
        if ( !strTren.trim().equals("Ignore")) {
            strVarTren=strTren;
            cbxTren.click();
            find(By.xpath("//*[@id='cbTrenSelect']"+"/option[text()="+strTren+"]")).click();
        }

    }
    public void selectSoloIda(String strSINO) {
        if (strSINO.equals("NO")){
            rbRetorno.click();
        }

    }

    public void selectFecSalida(String strFecSalida) throws ParseException {

        String[] date_dd_MM_yyyy = strFecSalida.split("/");

        btnFecSalida.click();

        DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
      //  Date date = new Date();
        dateSalida = formato.parse(strFecSalida);
/*
        difA = dateSalida.getYear()- date.getYear();
        difM = difA * 12 + dateSalida.getMonth() - date.getMonth();

        if (strVarTren.equals("Andean Explorer, A Belmond Train")){
            difM=difM-1;

        }

        for (int i = 0; i < difM; i++){
            btnSiguienteFec.click();
        }
*/
        int intMes = Integer.parseInt(date_dd_MM_yyyy[1]);
        intMes=intMes-1;

        find(By.xpath("//td[contains(@data-month,"+intMes+")]/*[contains(text(),"+date_dd_MM_yyyy[0]+")]")).click();

    }

    public boolean selectFecRetorno(String strFecRetorno) throws ParseException {


        if (!strFecRetorno.trim().equals("Ignore")) {

            btnFecRetorno.click();

            String[] date_dd_MM_yyyyR = strFecRetorno.split("/");
            //DateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            //Date dateRetorno = formato.parse(strFecRetorno);

         /*   int difA1 = dateRetorno.getYear() - dateSalida.getYear();
            int difM1 = difA * 12 + dateRetorno.getMonth() - dateSalida.getMonth();

            for (int i = 0; i < difM; i++) {
                btnSiguienteFec.click();
            }
*/
            int intMes1 = Integer.parseInt(date_dd_MM_yyyyR[1]);
            intMes1 = intMes1 - 1;

            find(By.xpath("//td[contains(@data-month," + intMes1 + ")]/*[contains(text()," + date_dd_MM_yyyyR[0] + ")]")).click();

        }
        return false;
    }
        public void selectBtnBuscar() {
            btnBuscar.click();
        }
    public boolean verificarCarga() {
        waitFor(imgCargaIda);

        boolean status = imgCargaIda.isDisplayed();
        return status;
    }



    public void selectBoletos() {
        btnBuscarBoleto.click();
        String strCosto1=lblCostoBoleto.getText();

        String[] precio = strCosto1.split("\n");
        GlobalVals.Dolares1= Double.parseDouble(precio[0].substring(3).trim());
        GlobalVals.Soles1=Double.parseDouble(precio[1].substring(2).trim());

        btnBuscarBoleto2.click();
        String strCosto2=lblCostoBoleto2.getText();

        String[] precio2 = strCosto2.split("\n");
        GlobalVals.Dolares2=Double.parseDouble(precio2[0].substring(3).trim());
        GlobalVals.Soles2=Double.parseDouble(precio2[1].substring(2).trim());

    }



    public void selectBtnContinuar() {
        btnContinuar.click();
    }
    public boolean verificarCargaPasajero() throws InterruptedException {

        waitFor(lblSiguientePasajero);

        boolean status = lblSiguientePasajero.isDisplayed();
        return status;
    }



    public void sendNombrePasajero1(){
        lblSiguientePasajero.sendKeys("Luis");
    }
    public void sendApedellidoPasajero1(){
        txtApePasajero.sendKeys("Miranda");
    }
    public void selectFecNacimiento1 (){
        formFecNacimiento.click();
    }

    public void sendNumDocIdentidad1 (String strNumDNI){
        txtNumDocIdentidad.sendKeys(strNumDNI);
    }
    public void sendNumTelefono1 (String strNumTelefono){
        txtNumTelefono.sendKeys(strNumTelefono);
    }
    public void sendEmal1 (String strEmail){
        txtdesEmail.sendKeys(strEmail);
    }
    public void sendEmalConfir1 (String strEmail){
        txtConfirEmail.sendKeys(strEmail);
    }


    public void sendInfPasajeros() {
        String anioNacimiento="1986";
        String mesNacimiento="MARCH";
        String diaNcimiento="17";
        String Pais="Peru";
        String numDNI="4373859";
        String sexo="Male";
        String telefono= "979702185";
        String mail="miguel054@gmail.com";

        sendNombrePasajero1();
        sendApedellidoPasajero1();
        selectFecNacimiento1();

        find(By.xpath("//*[@id='calendario_anio']"+"/option[text()='"+anioNacimiento+"']")).click();
        find(By.xpath("//*[@id='calendario_mes']"+"/option[text()='"+mesNacimiento+"']")).click();
        find(By.xpath("//*[@id='tlb_calendario']//a[text()="+diaNcimiento+"]")).click();
        find(By.xpath("//*[@id='formPasajero1-idPais']"+"/option[text()='"+Pais+"']")).click();
        find(By.xpath("//*[@id='formPasajero1-idDocumentoIdentidad']"+"/option[text()='Identification Card']")).click();

        sendNumDocIdentidad1(numDNI);

       find(By.xpath("//*[@id='formPasajero1-idSexo']"+"/option[text()='"+sexo+"']")).click();
        sendNumTelefono1(telefono);
        sendEmal1(mail);
        sendEmalConfir1(mail);

        waitFor(lblSiguientePasajero);

        btnRegistrar.click();

        //----------Pasajero2

        lblSiguientePasajero2.sendKeys("Miguel");
        txtApePasajero2.sendKeys("Miranda");
        formFecNacimiento2.click();
        find(By.xpath("//*[@id='calendario_anio']"+"/option[text()='1995']")).click();
        find(By.xpath("//*[@id='calendario_mes']"+"/option[text()='MARCH']")).click();
        find(By.xpath("//*[@id='tlb_calendario']//a[text()='2']")).click();
        find(By.xpath("//*[@id='formPasajero2-idPais']"+"/option[text()='Peru']")).click();
        find(By.xpath("//*[@id='formPasajero2-idDocumentoIdentidad']"+"/option[text()='Identification Card']")).click();
        txtNumDocIdentidad2.sendKeys("45869578");

        find(By.xpath("//*[@id='formPasajero2-idSexo']"+"/option[text()='Male']")).click();
        txtNumTelefono2.sendKeys("979702185");
        txtdesEmail2.sendKeys("miguel054@gmail.com");
        txtConfirEmail2.sendKeys("miguel054@gmail.com");

    }


    public void selectBtnContinuarPago(){
        btnEnviarPago.click();

    }

    public boolean validaPayment (){
        waitFor(txtPayment);
        return txtPayment.isDisplayed();
    }


    public String getSubtTotal1(){
        waitFor(txtSubTotal1);
        return txtSubTotal1.getText();
    }
    public String getSubtTotal2(){
        return txtSubTotal2.getText();
    }
    public String getTotalSol(){
        return txtTotalSol.getText();
    }

    public String getTotalDol(){
        return txtTotalDol.getText();
    }


    public boolean validaSubTotal1 (){
        String totalIdaDol= GlobalVals.Dolares1*2+"0";
        String Actual1 = getSubtTotal1();
        return totalIdaDol.equals(Actual1);

    }
    public boolean validaSubTotal2(){

        String totalRetDol= GlobalVals.Dolares2*2+"0";
        return  totalRetDol.equals(getSubtTotal2());
    }

    public boolean validaTotalSol(){

        String totalSol=GlobalVals.Soles1*2+GlobalVals.Soles2*2+"";

        String totalSol2=getTotalSol().substring(3);
        return totalSol.equals(totalSol2.replace(",",""));

    }
    public boolean validaTotalDol(){

        String totalDol=GlobalVals.Dolares1*2+GlobalVals.Dolares2*2+"0";
        String totalDol2=getTotalDol().substring(4);

        return totalDol.equals(totalDol2);

    }


}
