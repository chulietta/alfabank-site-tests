package ru.alfabank.lifecycle;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.alfabank.driver.LocalDriverFactory;
import ru.alfabank.driver.RemoteDriverFactory;
import ru.alfabank.driver.DriverFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static ru.alfabank.helpers.AttachmentsHelper.*;

public class WebTestLifeCycleExtension implements BeforeAllCallback, AfterEachCallback, BeforeEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        getFactory().createDriver().init();
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open("everyday/debit-cards/");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        attachScreenshot("Page screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());
        attachVideo();
        closeWebDriver();
    }

    private DriverFactory getFactory() {
        if (System.getProperty("env").equals("remote")) {
            return new RemoteDriverFactory();
        } else {
            return new LocalDriverFactory();
        }
    }
}
