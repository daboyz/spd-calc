package com.calculatoria.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.calculatoria.pages.Util.clickScript;


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

    public void jsClicker(WebElement el){
        executor.executeScript(clickScript, el);
    }

}