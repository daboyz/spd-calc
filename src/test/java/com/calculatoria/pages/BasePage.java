package com.calculatoria.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public abstract class BasePage {

    protected WebDriver driver;

    protected Actions actions;

    protected JavascriptExecutor executor;

    protected static String baseUrl = "http://www.calculatoria.com/";


    public BasePage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        executor = (JavascriptExecutor)driver;
    }

}