package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;


public class ProductPage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement productsTitle;

    @FindBy(xpath = "//div[@class='features_items']")
    private List<WebElement> productList;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement viewFirstProductButton;

    @FindBy(xpath = "//*[text()='All Products']")
    private WebElement getProductTitle;

    @FindBy(css = ".product-information h2")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='product-information']/p[1]")
    private WebElement category;

    @FindBy(css = ".product-information span > span")
    private WebElement price;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Availability:']]")
    private WebElement availability;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Condition:']]")
    private WebElement condition;

    @FindBy(xpath = "//div[@class='product-information']/p[b[text()='Brand:']]")
    private WebElement brand;
    

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductListVisible() {
        return productList != null && !productList.isEmpty() && productList.get(0).isDisplayed();
    }

    public void clickViewFirstProduct() {
        viewFirstProductButton.click();
    }

    public void clickViewProductByIndex(int index) {
        // Encontra todos os produtos na página
        List<WebElement> produtos = driver.findElements(By.cssSelector(".features_items .col-sm-4"));
        // O índice começa em 1 para o usuário, mas em 0 para a lista
        WebElement produto = produtos.get(index - 1);
        // Dentro do produto, encontra o link "View Product"
        WebElement viewProductBtn = produto.findElement(By.xpath(".//a[contains(text(),'View Product')]"));
        viewProductBtn.click();
    }

    public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isCategoryVisible() {
        return category.isDisplayed();
    }

    public boolean isPriceVisible() {
        return price.isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return availability.isDisplayed();
    }

    public boolean isConditionVisible() {
        return condition.isDisplayed();
    }

    public boolean isBrandVisible() {
        return brand.isDisplayed();
    }

} 