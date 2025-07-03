package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {
    
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    /**
     * Aguarda até que o elemento esteja visível e clicável
     */
    protected void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    /**
     * Aguarda até que o elemento esteja visível
     */
    protected void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    /**
     * Clica em um elemento após aguardar que esteja clicável
     */
    protected void safeClick(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
        logger.info("Clicou no elemento: {}", element);
    }
    
    /**
     * Preenche um campo após aguardar que esteja visível
     */
    protected void safeSendKeys(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
        logger.info("Preencheu o campo com: {}", text);
    }
    
    /**
     * Verifica se um elemento está visível
     */
    protected boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            logger.warn("Elemento não está visível: {}", e.getMessage());
            return false;
        }
    }
    
    /**
     * Obtém o texto de um elemento após aguardar que esteja visível
     */
    protected String getElementText(WebElement element) {
        waitForElementToBeVisible(element);
        return element.getText();
    }
} 