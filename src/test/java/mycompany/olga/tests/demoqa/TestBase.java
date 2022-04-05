package mycompany.olga.tests.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import mycompany.olga.helpers.Attach; //  путь!
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        //удаленно:
        String remoteBrowserUser = System.getProperty("remote_browser_user", "user1");
        String remoteBrowserPassword = System.getProperty("remote_browser_password", "1234");
        String remoteBrowserURL = System.getProperty("remote_browser_URL", "selenoid.autotests.cloud/wd/hub");
        //локально:
        String browser = System.getProperty("browser","CHROME");
        String size = System.getProperty("size","1920x1080");
        String browserVersion = System.getProperty("version", "100"); // !!! следить за актуальн. верс.

        //конфиг:
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = browser;
        //Configuration.browserSize = "1920x1080";
        Configuration.browserSize = size;
        Configuration.browserVersion = browserVersion; // !!! следить за актуальн. верс.
        Configuration.pageLoadTimeout = 5000;

        //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.remote = "https://" + remoteBrowserUser + ":" + remoteBrowserPassword + "@" + remoteBrowserURL;

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
}