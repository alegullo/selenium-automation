import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import config.WebDriverConfig;

public abstract class BaseTest {
    
    protected WebDriver driver;
    
    @BeforeEach
    void setUp() {
        driver = WebDriverConfig.createDriver();
    }
    
    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 