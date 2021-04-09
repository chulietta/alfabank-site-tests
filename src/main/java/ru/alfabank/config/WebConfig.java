package ru.alfabank.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"
})

public interface WebConfig extends Config{
    WebConfig WEB_CONFIG = ConfigFactory.create(WebConfig.class);

    @Key("base.url")
    String getBaseUrl();

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.version")
    String getBrowserVersion();

    @Key("remote.url")
    String getRemoteUrl();

    @Key("video.storage")
    String getVideoStorage();
}
