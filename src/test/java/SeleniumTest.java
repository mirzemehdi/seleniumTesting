import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.*;


public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    private final By bodyLocator = By.tagName("body");
    private final By requestPassword = By.id("requestPassword");
    private final By input = By.id("account");
    private final By requestButton = By.name("submit");




    private WebElement waitVisibiiltyAndFindElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    @Test
    public void testWeb() {
        this.driver.get("http://selenium.thinkcode.se");

        WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator );
        System.out.println(resultElement.getText());
        Assert.assertTrue(resultElement.getText().contains("Request password - fill out and submit a form"));


        WebElement requestPasswordElement = waitVisibiiltyAndFindElement(requestPassword);
        requestPasswordElement.click();

        WebElement inputElement = waitVisibiiltyAndFindElement(input);
        inputElement.sendKeys("test");

        WebElement submitButton = waitVisibiiltyAndFindElement(requestButton);
        submitButton.click();

        WebElement bodyElement = waitVisibiiltyAndFindElement(bodyLocator);
        System.out.println(bodyElement.getText());
        Assert.assertTrue(bodyElement.getText().contains("A new password has been sent to test"));

    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
