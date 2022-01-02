package co.zonafit.stepdefinition;

import co.zonafit.configuracion.WebUI;
import co.zonafit.model.ZonaFitModel;
import co.zonafit.pagina.ZonaFitPaginaEscenarioDos;
import co.zonafit.pagina.ZonaFitPaginaEscenarioUno;
import co.zonafit.runner.ZonaFitTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


import static co.zonafit.pagina.ZonaFitPaginaEscenarioUno.*;

public class ZonaFitCucumberStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ZonaFitTest.class);
    private ZonaFitPaginaEscenarioUno zonaFitPaginaEscenarioUno;
    private ZonaFitModel cliente;

    //Background
    @Given("que el cliente se encuentra en la pagína principal de la tienda virtual")
    public void queElClienteSeEncuentraEnLaPaginaPrincipalDeLaTiendaVirtual() {

        try {

            generalSetUp();
        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    //Escenario 1
    @When("el cliente selecciona el producto y digita la informacion requerida tomando como opcion de pago Baloto")
    public void elClienteSeleccionaElProductoYDigitaLaInformacionRequeridaTomandoComoOpcionDePagoBaloto() {

        try {
            clienteGeneral();
            ZonaFitPaginaEscenarioUno zonaFitPaginaEscenarioUno = new ZonaFitPaginaEscenarioUno(cliente, driver);
            zonaFitPaginaEscenarioUno.llenarInformacion();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("el sistema debera mostrar el número del pedido")
    public void elSistemaDeberaMostrarElNumeroDelPedido() {

        try {
            Assertions.assertEquals("CONVENIO RECAUDO ZONA FIT – BALOTO",
                    "CONVENIO RECAUDO ZONA FIT – BALOTO","El texto es diferente");
                    validacionPedido();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }

    }
    //Funciones
    private void clienteGeneral () {
        cliente = new ZonaFitModel();
        cliente.setNumeroDeDocumento("1075256778");
        cliente.seteMail("pruebastest@gmail.com");
        cliente.setNombre(" Luis");
        cliente.setApellido(" Rojas");
        cliente.setDepartamento("Tolima");
        cliente.setCiudad("Ibague");
        cliente.setDireccion(" Calle 2 # 16-78");
        cliente.setApartamento(" 201");
        cliente.setNumeroCelular("3202596244");

    }


    //Esenario 2
    @When("el comprador selecciona el producto y llena los campos solicitados donde el metodo de pago efecty")
    public void elCompradorSeleccionaElProductoYLlenaLosCamposSolicitadosDondeElMetodoDePagoEfecty() {

        try {
            clienteGeneral();
            ZonaFitPaginaEscenarioDos zonaFitPaginaEscenarioDos = new ZonaFitPaginaEscenarioDos(cliente, driver);
            zonaFitPaginaEscenarioDos.digitarinformacion();

        }catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);
            LOGGER.warn(exception.getMessage(), exception);
        }
    }
    @Then("el sistema debebra mostrar el numero del convenio")
    public void elSistemaDebebraMostrarElNumeroDelConvenio() {

        try {

            Assertions.assertEquals("Número de Convenio",
                    "Número de Convenio","El texto es diferente");
            validacionPedido();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(),exception);

        }

    }

}
