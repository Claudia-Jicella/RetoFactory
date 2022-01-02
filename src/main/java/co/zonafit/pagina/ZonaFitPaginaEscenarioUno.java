package co.zonafit.pagina;


import co.zonafit.model.ZonaFitModel;
import co.zonafit.pagina.comun.AccionComunDeLaPagina;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ZonaFitPaginaEscenarioUno extends AccionComunDeLaPagina {


    public final ZonaFitModel zonaFitModel;
    private WebDriver webDriver;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"mega-menu-item-198556\"]/a")
    private WebElement ofertas;

    private final By seleccionProducto = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[18]");

    private final By elegirOpcion = By.id("pa_sabor_574");
    private final By sabor = By.xpath("//*[@id=\"pa_sabor_574\"]/option[3]");


    private final By anadirAlCarrrito = By.xpath("//*[@id=\"product-196396\"]/div/div[1]/div/div[2]/form/div[3]/div/div[4]/button");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div[4]/ul/li[5]/div/a")
    private WebElement carrito;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[2]/div[2]/div/div[1]/div/a")
    private WebElement finalizarCompra;

    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement numeroDeDocumento;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement e_Mail;

    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement nombre;

    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement apellido;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"billing_state_field\"]/span/span/span[1]/span")
    private WebElement seleccionBotondepartamento;

    private final By departamento = By.xpath("/html/body/span/span/span[1]/input");

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_state-results\"]")
    private WebElement seleccionDepartamento;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"select2-billing_city-container\"]")
    private WebElement seleccionBotonCiudad;

    private final By ciudad = By.xpath("/html/body/span/span/span[1]/input");

    @CacheLookup
    @FindBy(xpath = "/html/body/span/span/span[2]")
    private WebElement seleccionCiudad;

    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement direccion;

    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement apartamento;

    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement numeroCelular;

    @CacheLookup
    @FindBy(id = "payment_method_bank_transfer_1")
    private WebElement baloto;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"terms\"]")
    private WebElement terminosCondiciones;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"place_order\"]")
    private WebElement realizarPedido;

    //Validacion
    private static final By confirmacionPedido = By.xpath("//*[@id=\"main\"]/div[2]/div/div");


    public ZonaFitPaginaEscenarioUno(ZonaFitModel zonaFitModel, WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        this.zonaFitModel = zonaFitModel;
        PageFactory.initElements(webDriver, this);
    }

    //Funciones
    public void llenarInformacion() throws InterruptedException {


        click(ofertas);
        explicitWaitTime(ofertas);
        click(ofertas);
        explicitWaitTime(ofertas);

        explicitWaitTime(seleccionProducto);
        scrollDown(seleccionProducto);
        click(seleccionProducto);

        explicitWaitTime(elegirOpcion);
        click(elegirOpcion);

        explicitWaitTime(sabor);
        click(sabor);

        scrollDown(anadirAlCarrrito);
        click(anadirAlCarrrito);
        explicitWaitTime(anadirAlCarrrito);

        click(carrito);
        explicitWaitTime(carrito);

        explicitWaitTime(finalizarCompra);
        click(finalizarCompra);

        explicitWaitTime(numeroDeDocumento);
        escribir(numeroDeDocumento, zonaFitModel.getNumeroDeDocumento());

        explicitWaitTime(e_Mail);
        borrarTexto(e_Mail);
        escribir(e_Mail, zonaFitModel.geteMail());

        explicitWaitTime(nombre);
        borrarTexto(nombre);
        escribir(nombre, zonaFitModel.getNombre());

        explicitWaitTime(apellido);
        borrarTexto(apellido);
        escribir(apellido, zonaFitModel.getApellido());

        scrollDown(seleccionBotondepartamento);
        click(seleccionBotondepartamento);
        escribir(departamento, zonaFitModel.getDepartamento());
        explicitWaitTime(departamento);
        click(seleccionDepartamento);


        click(seleccionBotonCiudad);
        escribir(ciudad, zonaFitModel.getCiudad());
        explicitWaitTime(ciudad);
        click(seleccionCiudad);

        explicitWaitTime(direccion);
        borrarTexto(direccion);
        escribir(direccion, zonaFitModel.getDireccion());

        explicitWaitTime(apartamento);
        borrarTexto(apartamento);
        escribir(apartamento, zonaFitModel.getApartamento());

        explicitWaitTime(numeroCelular);
        borrarTexto(numeroCelular);
        escribir(numeroCelular, zonaFitModel.getNumeroCelular());


        scrollDown(baloto);
        Thread.sleep(5000);
        click(baloto);

        Thread.sleep(2000);
        click(terminosCondiciones);

        explicitWaitTime(realizarPedido);
        click(realizarPedido);

    }
    

    public static String validacionPedido(){return getText(confirmacionPedido).trim();}


}
