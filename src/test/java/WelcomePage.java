import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage extends BasePage {
    private static final String BASE_URL = "https://wordpress.com";

    private final By loginBy = By.xpath("//ul[@class='x-nav-list x-nav-list--right']/li/a");

    public WelcomePage(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public LoginPage goToLoginPage() {
        WebElement loginButton = waitVisibilityAndFindElement(loginBy);
        loginButton.click();
        return new LoginPage(driver);
    }


    public String getTitleText() {
        return driver.getTitle();
    }

    public boolean isInUnAuthorizedState() {
        try {
            waitVisibilityAndFindElement(By.xpath("//a[text()=\"Log In\"]"));
            return true;

        } catch (NoSuchElementException e) {
            System.out.println("Login Button is not found");
            return false;
        }
    }

}
