package co.zonafit.runner;

import co.zonafit.configuracion.WebUI;
import co.zonafit.model.ZonaFitModel;
import co.zonafit.pagina.ZonaFitPaginaEscenarioUno;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.log4j.Logger;


import static co.zonafit.pagina.ZonaFitPaginaEscenarioUno.validacionPedido;

public class ZonaFitTest extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ZonaFitTest.class);


    private ZonaFitModel cliente;

    @BeforeEach
    public void configurar(){
        try {
            generalSetUp();
            LOGGER.info("Configuracion Lista");
            clienteGeneral();

        }catch (Exception exception){
            Assertions.fail(exception.getMessage(),exception);
            quiteDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }

    }

    @Test
    public void zonaFitCamposObligatorios(){

        try {
            ZonaFitPaginaEscenarioUno zonaFitPagina = new ZonaFitPaginaEscenarioUno(cliente, driver);
            zonaFitPagina.llenarInformacion();

            Assertions.assertEquals("CONVENIO RECAUDO ZONA FIT – BALOTO",
                    "CONVENIO RECAUDO ZONA FIT – BALOTO","El texto es diferente");
            validacionPedido();


        } catch (Exception exception) {
            Assertions.fail(exception.getMessage(), exception);
            quiteDriver();
            LOGGER.warn(exception.getMessage(), exception);
        }
    }

    @AfterEach
    public void cerar(){quiteDriver();

    }

    private void clienteGeneral () {
        cliente = new ZonaFitModel();
        cliente.setNumeroDeDocumento("1075256778");
        cliente.seteMail("pruebastest@gmail.com");
        cliente.setNombre(" Luis");
        cliente.setApellido(" Rojas");
        cliente.setDepartamento("huila");
        cliente.setCiudad("rivera");
        cliente.setDireccion(" Calle 2 # 16-78");
        cliente.setApartamento(" 201");
        cliente.setNumeroCelular("3202596244");

    }


}
