package mycompany.olga.tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mycompany.olga.helpers.Attach;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("It's 3 Simple Yes-Not-Skipped Tests")
public class SimpleYesNotSkippedTests //no TestBase!
{

    /*
    //------------example----------------------------
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        //удаленно:
        //String remoteBrowserUser = System.getProperty("remote_browser_user", "user1");
        //String remoteBrowserPassword = System.getProperty("remote_browser_password", "1234");
        String remoteBrowserUser = System.getProperty("remote_browser_user");
        String remoteBrowserPassword = System.getProperty("remote_browser_password");
        String remoteBrowserURL = System.getProperty("remote_browser_URL", "selenoid.autotests.cloud/wd/hub");

        //локально:
        //String browser = System.getProperty("browser","CHROME");
        //String size = System.getProperty("size","1920x1080");
        //String browserVersion = System.getProperty("version", "100.0"); // !!! следить за актуальн. верс.

        //конфиг:
        //Configuration.baseUrl = "не нужен";
        //Configuration.browser = browser;
        //Configuration.browserSize = "1920x1080";
        //Configuration.browserSize = size;
        //Configuration.browserVersion = browserVersion; // !!! следить за актуальн. верс.
        Configuration.pageLoadTimeout = 5000;

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        //Configuration.remote = "https://" + remoteBrowserUser + ":" + remoteBrowserPassword + "@" + remoteBrowserURL;

        //конфигурация удаленного запуска:
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true); //пишем видео
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    @DisplayName("Прикрепляем атачи результата теста")
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver(); // браузера НЕТ
    }
    //------------example----------------------------
*/

    @Test
    @Tag("PositiveTestOneTag")
    @DisplayName("Positive Test One")
    void test00() {
        assertTrue(true);
    }

    @Test
    @Disabled("Skipped Test: With some reason")
    @DisplayName("False Test: With some reason")
    void test01() {
        assertTrue(false);
    }

    @Test
    @Disabled("Skipped Test: With some reason")
    void test02() {
        assertTrue(false);
    }
}
