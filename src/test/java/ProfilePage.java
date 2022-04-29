import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage extends BasePage {

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        final By logOutButtonBy = By.xpath("//button[text()=\"Log out\"]");
        WebElement logOutButton = waitVisibilityAndFindElement(logOutButtonBy);
        logOutButton.click();
    }

    public void edit(String displayName, String description) {
        final By displayNameBy = By.id("display_name");
        WebElement displayNameElement = waitClickableAndFindElement(displayNameBy);
        displayNameElement.clear();
        displayNameElement.sendKeys(displayName);

        final By descriptionTextAreaBy = By.id("description");
        WebElement descriptionTextAreaElement = waitClickableAndFindElement(descriptionTextAreaBy);
        descriptionTextAreaElement.clear();
        descriptionTextAreaElement.sendKeys(description);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("scroll(0, 250)");

        final By submitButtonBy = By.xpath("//p[@class='profile__submit-button-wrapper']/button");
        WebElement submitButton = waitClickableAndFindElement(submitButtonBy);
        submitButton.click();


        final By profileSavedAlert = By.xpath("//div[@class='notice is-success is-dismissable']");
        waitVisibilityAndFindElement(profileSavedAlert);

    }

}
