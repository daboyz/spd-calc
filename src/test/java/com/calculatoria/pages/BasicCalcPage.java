package com.calculatoria.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.UnsupportedEncodingException;

import static com.calculatoria.pages.Util.*;


public class BasicCalcPage extends BasePage {

    public BasicCalcPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='delete display']")
    protected WebElement clearCtrl;

    @FindBy(xpath = "//a[text()='(']")
    protected WebElement colLeftCtrl;

    @FindBy(xpath = "//a[text()=')']")
    protected WebElement colRightCtrl;

    @FindBy(xpath = "//a[text()='+']")
    protected WebElement addCtrl;

    @FindBy(xpath = "//a[text()='-']")
    protected WebElement subCtrl;

    @FindBy(xpath = "//a[text()='×']")
    protected WebElement multCtrl;

    @FindBy(xpath = "//a[text()='÷']")
    protected WebElement divCtrl;

    @FindBy(xpath = "//a[text()='=']")
    protected WebElement equalsCtrl;

    @FindBy(xpath = "//a[text()='1']")
    protected WebElement digitOne;

    @FindBy(xpath = "//a[text()='2']")
    protected WebElement digitTwo;

    @FindBy(xpath = "//a[text()='3']")
    protected WebElement digitThree;

    @FindBy(xpath = "//a[text()='4']")
    protected WebElement digitFour;

    @FindBy(xpath = "//a[text()='5']")
    protected WebElement digitFive;

    @FindBy(xpath = "//a[text()='6']")
    protected WebElement digitSix;

    @FindBy(xpath = "//a[text()='7']")
    protected WebElement digitSeven;

    @FindBy(xpath = "//a[text()='8']")
    protected WebElement digitEight;

    @FindBy(xpath = "//a[text()='9']")
    protected WebElement digitNine;

    @FindBy(xpath = "//a[text()='0']")
    protected WebElement digitZero;

    @FindBy(xpath = "//a[text()='·']")
    protected WebElement pointCtrl;

    @FindBy(xpath = "//form[@name='calculator']//input[@name='expr']")
    protected WebElement displayScreen;


    public String getLastNotesVal() throws UnsupportedEncodingException {
        String[] notesPool = decoder(executor.executeScript(cookieScript).toString()).split("\n");;
        return notesPool[notesPool.length-1];
    }

    public String getScreenVal(){
        return  displayScreen.getAttribute("value");
    }

    public void digitPresser(String val){

        char[] register = val.toCharArray();

        for (char ch : register) {
            switch (ch) {
                case '1':
                    jsClicker(digitOne);
                    break;
                case '2':
                    jsClicker(digitTwo);
                    break;
                case '3':
                    jsClicker(digitThree);
                    break;
                case '4':
                    jsClicker(digitFour);
                    break;
                case '5':
                    jsClicker(digitFive);
                    break;
                case '6':
                    jsClicker(digitSix);
                    break;
                case '7':
                    jsClicker(digitSeven);
                    break;
                case '8':
                    jsClicker(digitEight);
                case '9':
                    jsClicker(digitNine);
                    break;
                case '0':
                    jsClicker(digitZero);
                    break;
                case '.':
                    jsClicker(pointCtrl);
                    break;
                case '(':
                    jsClicker(colLeftCtrl);
                    break;
                case ')':
                    jsClicker(colRightCtrl);
                    break;
                case '-':
                    jsClicker(subCtrl);
                    break;
                default:
                    System.out.println("Unknown parameter in test data");
            }
        }
    }

    public void pressEquals() {
        jsClicker(equalsCtrl);
    }

    public void pressSum() {
        jsClicker(addCtrl);
    }

    public void pressSub() {
        jsClicker(subCtrl);
    }

    public void pressMult() {
        jsClicker(multCtrl);
    }

    public void pressDiv() {
        jsClicker(divCtrl);
    }

    public void clearInput() {
        jsClicker(clearCtrl);
    }

}