import org.junit.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import io.github.bonigarcia.wdm.WebDriverManager;


import static org.junit.Assert.*;

public class SeleniumTest {

    private WebDriver driver;
    private WelcomePage welcomePage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        welcomePage = new WelcomePage(driver);
    }


    @Test
    public void testWelcomePageAndTitle() {
        assertTrue(welcomePage.getBodyText().contains("popular website builder"));
        assertTrue(welcomePage.getTitleText().contains("WordPress.com: Fast, Secure Managed WordPress Hosting"));
    }

    @Test
    public void testDeletingConsentCookie() {
        String consentCookieKey = "sensitive_pixel_option";
        Cookie newConsentCookie = new Cookie.Builder(consentCookieKey, "yes").build();
        driver.manage().addCookie(newConsentCookie);
        welcomePage.reload();
        Cookie cookie = driver.manage().getCookieNamed(consentCookieKey);
        boolean isCookieConsentShown = cookie != null;
        assertTrue(isCookieConsentShown);
    }

    @Test
    public void testSuccessLoginPage() {
        MainPage mainPage = loginUser();
        assertTrue(mainPage.getMainHeaderText().contains("My Home"));
    }


    @Test
    public void testLogOutPage() {
        ProfilePage profilePage = loginAndGetCurrentProfile();
        profilePage.logout();
        assertTrue(welcomePage.isInUnAuthorizedState());
    }

    @Test
    public void testEditProfile() {
        ProfilePage profilePage = loginAndGetCurrentProfile();
        int nbElements = 3;
        String[] randomStrings = Helper.generateRandomStringArray(nbElements);
        for (String randomString : randomStrings) {
            profilePage.edit(randomString, randomString);
            assertTrue(profilePage.getBodyText().contains("Settings saved successfully!"));
        }
    }

    private ProfilePage loginAndGetCurrentProfile() {
        MainPage mainPage = loginUser();
        return mainPage.goToProfilePage();
    }

    private MainPage loginUser() {
        LoginPage loginPage = welcomePage.goToLoginPage();
        String correctUsername = "somok66006";
        String correctPassword = "somok66006M*";
        return loginPage.login(correctUsername, correctPassword);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
