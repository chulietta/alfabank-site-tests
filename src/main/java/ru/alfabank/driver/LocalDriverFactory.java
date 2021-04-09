package ru.alfabank.driver;

public class LocalDriverFactory extends DriverFactory{
    @Override
    public DriverProvider createDriver() {
        return new LocalDriver();
    }
}
