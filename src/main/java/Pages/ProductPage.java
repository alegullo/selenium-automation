package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private WebDriver driver;


    @FindBy(xpath = "//h2[@class='title text-center']")
    private WebElement productsTitle;

    @FindBy(xpath = "//div[@class='features_items']/div")
    private List<WebElement> productList;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement viewFirstProductButton;

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    private WebElement getProductTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isProductsPageVisible() {
        return getProductTitle.isDisplayed();
    }

    public boolean isProductListVisible() {
        return productList != null && !productList.isEmpty() && productList.get(0).isDisplayed();
    }

    public void clickViewFirstProduct() {
        viewFirstProductButton.click();
    }

    public void clickViewProductByIndex(int index) {
        // index começa em 1 (1 = primeiro, 2 = segundo, etc)
        String xpath = "(//a[contains(text(),'View Product')])[" + index + "]";
        WebElement viewProductButton = driver.findElement(By.xpath(xpath));
        viewProductButton.click();
    }

    public void isProductDetailPageVisible() {
        productDetailTitle.isDisplayed();
    }
} 