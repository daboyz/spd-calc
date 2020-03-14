package com.calculatoria.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasicCalcPage extends BasePage {

    private final String cookieScript = "return document.cookie.match('zf_obspaska1').input.split('zf_obspaska1=')[1]";

    public BasicCalcPage(WebDriver driver) {
        super(driver);
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='C']")
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

    /**
     * Had to implement decoder because calculatoria did not encode math symbols in UTF-8 when storing notes in cookie file
     */
    public String[] getAllNotesVal(){
        String notesPool = executor.executeScript(cookieScript).toString();
        notesPool = notesPool.replace("%3D", "=").replace("%28", "(").replace("%29", ")");
        return notesPool.split("%0A");
    }

    public String getLastNotesVal() {
        String[] pool = getAllNotesVal();
        return pool[pool.length-1];
    }

    public String getScreenVal(){
        return  displayScreen.getAttribute("value");
    }

    public void buttonPresser(String val){

        char[] register = val.toCharArray();

        for (char ch : register) {
            switch (ch) {
                case '1':
                    executor.executeScript("arguments[0].click()", digitOne);
                    break;
                case '2':
                    executor.executeScript("arguments[0].click()", digitTwo);
                    break;
                case '3':
                    executor.executeScript("arguments[0].click()", digitThree);
                    break;
                case '4':
                    executor.executeScript("arguments[0].click()", digitFour);
                    break;
                case '5':
                    executor.executeScript("arguments[0].click()", digitFive);
                    break;
                case '6':
                    executor.executeScript("arguments[0].click()", digitSix);
                    break;
                case '7':
                    executor.executeScript("arguments[0].click()", digitSeven);
                    break;
                case '8':
                    executor.executeScript("arguments[0].click()", digitEight);
                case '9':
                    executor.executeScript("arguments[0].click()", digitNine);
                    break;
                case '0':
                    executor.executeScript("arguments[0].click()", digitZero);
                    break;
                case '.':
                    executor.executeScript("arguments[0].click()", pointCtrl);
                    break;
                case '+':
                    executor.executeScript("arguments[0].click()", addCtrl);
                    break;
                case '-':
                    executor.executeScript("arguments[0].click()", subCtrl);
                    break;
                case '*':
                    executor.executeScript("arguments[0].click()", multCtrl);
                    break;
                case '/':
                    executor.executeScript("arguments[0].click()", divCtrl);
                    break;
                case '=':
                    executor.executeScript("arguments[0].click()", equalsCtrl);
                    break;
                case '(':
                    executor.executeScript("arguments[0].click()", colLeftCtrl);
                    break;
                case ')':
                    executor.executeScript("arguments[0].click()", colRightCtrl);
                    break;
                default:
                    System.out.println("Unknown parameter in test data");
            }
        }
    }

    public void clearInput() {
        executor.executeScript("arguments[0].click()", clearCtrl);
    }

}