package ru.alfabank.driver;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static ru.alfabank.config.WebConfig.WEB_CONFIG;

public class RemoteDriver implements DriverProvider {
    @Override
    public void init() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.startMaximized = true;
        Configuration.timeout = 15000;
        Configuration.browser = WEB_CONFIG.getBrowserName();
        Configuration.browserVersion = WEB_CONFIG.getBrowserVersion();
        Configuration.baseUrl = WEB_CONFIG.getBaseUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = WEB_CONFIG.getRemoteUrl();
        //Configuration.remote = System.getProperty("remote_driver_url");
    }
}