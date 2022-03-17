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
public class SimpleYesNotSkippedTests {

    //------------example----------------------------
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String remoteBrowserUser = System.getProperty("remote_browser_user");
        String remoteBrowserPassword = System.getProperty("remote_browser_password");

        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

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
        closeWebDriver();
    }

    //------------example----------------------------


    @Test
    @Tag("Positive Test One Tag")
    @DisplayName("Positive Test One")
    void test00() {
        assertTrue(true);
    }

    @Test
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
