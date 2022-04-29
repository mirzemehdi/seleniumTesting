import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private final By profileButtonBy = By.xpath("//a[@href='/me']");
    private final By mainHeaderBy = By.xpath("//h1[@class='formatted-header__title wp-brand-font']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ProfilePage goToProfilePage() {
        waitVisibilityAndFindElement(mainHeaderBy);
        WebElement profileButton = waitVisibilityAndFindElement(profileButtonBy);
        profileButton.click();
        return new ProfilePage(driver);
    }

    public String getMainHeaderText() {
        WebElement titleElement = waitVisibilityAndFindElement(mainHeaderBy);
        return titleElement.getText();
    }


}
