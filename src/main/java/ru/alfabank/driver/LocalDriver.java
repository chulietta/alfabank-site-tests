package ru.alfabank.driver;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import ru.alfabank.config.WebConfig;

import static com.codeborne.selenide.logevents.SelenideLogger.addListener;

public class LocalDriver implements DriverProvider {
    @Override
    public void init() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 5000;
        Configuration.startMaximized = true;
        Configuration.browser = WebConfig.WEB_CONFIG.getBrowserName();
        Configuration.baseUrl = WebConfig.WEB_CONFIG.getBaseUrl();
    }
}
