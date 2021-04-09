package ru.alfabank.driver;

public class RemoteDriverFactory extends DriverFactory{
    @Override
    public DriverProvider createDriver() {
        return new RemoteDriver();
    }
}
