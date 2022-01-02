package co.zonafit.pagina.comun;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccionComunDeLaPagina {

    protected static WebDriver driver;
    private WebDriverWait wait;

    public AccionComunDeLaPagina(WebDriver driver) {
        this.driver = driver;
    }

    protected void escribir(By locator, String value) {driver.findElement(locator).sendKeys(value);}

    public void borrarTexto(By locator) {   //ok
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void scrollTo(By locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView();", driver.findElement(locator));

    }

    public void scrollDown(By buscarBoton) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20000)");
    }

    protected static String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    protected void explicitWaitTime(By locator) {
        wait = new WebDriverWait(driver, 2000);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    protected void escribir(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }

    public void borrarTexto(WebElement webElement) {webElement.clear();}

    public void click(WebElement webElement) {webElement.click();}


    public void scrollTo(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("argument[0].scrollIntoView();", webElement);
    }

    public void scrollDown(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,20000)");
    }

    protected static String getText(WebElement webElement) {
        return webElement.getText();
    }

    protected void explicitWaitTime(WebElement webElement) {
        wait = new WebDriverWait(driver, 3000);
    }
}

