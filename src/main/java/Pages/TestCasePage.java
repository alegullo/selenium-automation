package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCasePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//h2[@class='title text-center']/b")
    private WebElement getTestCaseTitle;

    // ------------------------------------------------------------

    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    public boolean isTestCasesPageVisible() {
        return getTestCaseTitle.isDisplayed();
    }

} 