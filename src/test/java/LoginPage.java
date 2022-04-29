import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By usernameBy = By.id("usernameOrEmail");
    private final By passwordBy = By.id("password");
    private final By continueButtonBy = By.xpath("//button[text()=\"Continue\"]");
    private final By submitButtonBy = By.xpath("//button[text()=\"Log In\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MainPage login(String email, String password) {
        WebElement usernameElement = waitVisibilityAndFindElement(usernameBy);
        usernameElement.sendKeys(email);

        WebElement continueButton = waitVisibilityAndFindElement(continueButtonBy);
        continueButton.click();

        WebElement passwordElement = waitVisibilityAndFindElement(passwordBy);
        passwordElement.sendKeys(password);
        WebElement submitButton = waitVisibilityAndFindElement(submitButtonBy);
        submitButton.click();

        return new MainPage(driver);

    }

}
