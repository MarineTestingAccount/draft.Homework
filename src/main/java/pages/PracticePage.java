package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PracticePage {

    private final WebDriver driver;

    //Locating Elements
    private final By chooseRadioButton = By.cssSelector("label [value ='radio3']");
    private final By checkBoxOption= By.id("checkBoxOption2");
    private final By dynamicDropDown = By.id("autocomplete");
    private final By staticDropDown = By.id("dropdown-class-example");
    private final By selectOptionDropDown = By.cssSelector("#dropdown-class-example [value = \"option3\"]");

    private final By openWindowBtn = By.id("openwindow");
    private final By openTabBtn = By.id("opentab");
    private final By inputTextForAlert = By.id("name");
    private final By alertBtn = By.id("alertbtn");
    private final By confirmBtn = By.id("confirmbtn");

    private final By hideTextBox = By.id("hide-textbox");
    private final By showTextBox = By.id("show-textbox");
    private final By tableFixedHeader = By.id("product");

    private final By mouseHover = By.id("mousehover");
    private final By mouseHoverTop = By.id("div.mouse-hover-content a[href = \"#top\"]");
    private final By mouseHoverReload = By.id("div.mouse-hover-content a[href = \"\"]");

    private final By iFrameRegisterBtn = By.cssSelector("body div.top-right.clearfix > div:nth-child(2) > a");


    //Making the Constructor
    public PracticePage(WebDriver driver) {
        this.driver = driver;
    }
    //Choosing RadioButton
    public WebElement chooseRadio(){
        return driver.findElement(chooseRadioButton);
    }
    //Dynamic DropDown list
//    public WebElement dynamicDropDown(){
//        return driver.findElement(dynamicDropDown);
//    }

    public WebElement setdynamicDropDown() {
        return driver.findElement(dynamicDropDown);
    }
    public WebElement selectOptionDropDown() {
        return driver.findElement(selectOptionDropDown);
    }

    //Static DropDown list
    public void staticDropDown() {
        driver.findElement(staticDropDown).click();
    }

    //Selecting CheckBox
    public WebElement selectCheckBox(){
        return driver.findElement(checkBoxOption);
    }

    //Open in new window
    public WebElement openWindow(){
        return driver.findElement(openWindowBtn);
    }

    //Open in new Tab
    public WebElement openTab(){
        return driver.findElement(openTabBtn);
    }

    public void switchTab() {
        openTab().click();
        var windows = driver.getWindowHandle();
        driver.switchTo().window(windows);
    }
    //Open and Accept Alert Popup
    public WebElement inputTextForAlert(){
        return driver.findElement(inputTextForAlert);
    }
    public WebElement triggerAlert(){
       return driver.findElement(alertBtn);
    }

    public Alert acceptAlert(){
        driver.switchTo().alert();
        return null;
    }

    //Open confirm
    public WebElement confirmInput(){
        return driver.findElement(confirmBtn);
    }

    //Hide TextBox
    public WebElement hideTextBox(){
        return driver.findElement(hideTextBox);
    }

    //Show TextBox
    public WebElement showTextBox(){
        return driver.findElement(showTextBox);
    }

    //Table Fixed Header
    public WebElement scrollTableFixedHeader(){
        return driver.findElement(tableFixedHeader);
    }

    //Mouse Hover
    public void mouseHover(){
        WebElement mouseHoverElement = driver.findElement(mouseHover);
        Actions actions = new Actions(driver);
        actions.moveToElement(mouseHoverElement).perform();

    }

    //Mouse Hover Top
    public WebElement mouseHoverTop(){
        return driver.findElement(mouseHoverTop);
    }

    //Mouse Hover Reload
    public WebElement mouseHoverReload(){
        return driver.findElement(mouseHoverReload);
    }

    //Get iFrame
    private void getIFrame(){
        String iFrame = "courses-iframe";
        driver.switchTo().frame(iFrame);
    }

    //Click on iFrame Register Button
    public void clickOnFrameRegisterButton(){
        getIFrame();
        WebElement getRegisterBtn =  driver.findElement(iFrameRegisterBtn);
        getRegisterBtn.click();
    }
    //Switch to iFrame
    public WebDriver switchToMainFrame(){
        clickOnFrameRegisterButton();
        return driver.switchTo().parentFrame();
    }

}
