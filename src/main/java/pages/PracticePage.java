package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class PracticePage {

    private final WebDriver driver;

    //Locating Elements
    private final By chooseRadioButton = By.cssSelector("label [value ='radio3']");
    private final By checkBoxOption1= By.id("checkBoxOption1");
    private final By checkBoxOption2= By.id("checkBoxOption2");
    private final By dynamicDropDown = By.id("autocomplete");
    private final By dynamicDropDownElement = By.id("ui-id-117");
    private final By dynamicDropDownList = By.id("ui-id-1");
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
    //Select RadioButton
    public WebElement chooseRadio(){
        var selectOption3 = driver.findElement(chooseRadioButton);
        selectOption3.click();
        return selectOption3;
    }
//    //Dynamic DropDown list
//    public WebElement setDynamicDropDown() {
//        return driver.findElement(dynamicDropDown);
//    }

    //Dynamic DropDown list
    public void setDropDown(String currentValue) {
        WebElement setValue = driver.findElement(dynamicDropDownList);
        setValue.sendKeys(currentValue);
        List<WebElement> option = optionListOfDynamicDropDown();
        for (WebElement e : option) {
            String currentOption = e.getText();
            if (currentOption.contains(currentValue)) {
                e.click();
                break;

            }

        }
    }

    public List<WebElement> optionListOfDynamicDropDown() {
        List<WebElement> optionList = (List<WebElement>) driver.findElement(dynamicDropDownElement);
        return optionList;
    }



    //Static DropDown list
    public void staticDropDown() {
        driver.findElement(staticDropDown).click();
    }
    public WebElement selectOptionDropDown() {
        return driver.findElement(selectOptionDropDown);
    }

    //Selecting CheckBox
    public WebElement selectCheckBox1(){
        return driver.findElement(checkBoxOption1);
    }
    public WebElement selectCheckBox2(){
        return driver.findElement(checkBoxOption2);
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
    //Alert Popup
    public WebElement inputTextForAlert(){
        return driver.findElement(inputTextForAlert);
    }
    public void triggerAlert(){
        driver.findElement(alertBtn).click();
    }
    public String getAlertText(){
        triggerAlert();
        Alert text = driver.switchTo().alert();
        return text.getText();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    //Confirm Popup
    public WebElement inputTextForConfirm(){
        return driver.findElement(inputTextForAlert);
    }
    public void triggerConfirm(){
        driver.findElement(confirmBtn).click();
    }
    public String getConfirmText(){
        triggerConfirm();
        Alert text = driver.switchTo().alert();
        return text.getText();
    }
    public void acceptConfirm(){
        driver.switchTo().alert().accept();
    }
    public void cancelConfirm(){
        driver.switchTo().alert().dismiss();
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

    //IFrame
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
