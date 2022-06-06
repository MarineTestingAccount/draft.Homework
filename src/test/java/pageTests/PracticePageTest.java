package pageTests;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

public class PracticePageTest extends BaseTest {

    @Test
    @DisplayName("RadioButton")
    public void chooseRadioButton(){
        var option = practicePage.chooseRadio();
        assertTrue(option.isSelected());
    }

    @Test
    @DisplayName("Dynamic Dropdown")
    public void chooseFromDynamicDropDown() {
        WebElement dynamicDropDown = practicePage.setDynamicDropDown();
        dynamicDropDown.sendKeys("Col");
        dynamicDropDown.sendKeys(Keys.ARROW_DOWN);
        dynamicDropDown.sendKeys(Keys.ENTER);
        //gets wrong value
        String value = dynamicDropDown.getAttribute("value");
        System.out.println(value);
        assertTrue(value.contains("Col"));
    }

    @Test
    @DisplayName("Static Dropdown")
    public void chooseFromStaticDropDown() {
        WebElement selectDropDown = practicePage.selectOptionDropDown();
        selectDropDown.click();
        assertTrue(selectDropDown.isSelected());
    }

    @Test
    @DisplayName("CheckBox")
    public void chooseCheckBox(){
        WebElement checkbox3 = practicePage.selectCheckBox();
        checkbox3.click();
        assertTrue(checkbox3.isSelected());
    }

//    @Test
//    @DisplayName("Open Window Button")
//    public void openWindow() {
//        WebElement openWindow = practicePage.openWindow();
//        openWindow.click();
//
//    }
//
    @Test
    @DisplayName("Open Tab Button")
    public void openTab() {
        practicePage.switchTab();
        assertFalse(driver.getWindowHandle().isEmpty());
    }

    @Test
    @DisplayName("Alert Button")
    public void alert() {
        var inputText= practicePage.inputTextForAlert();
        inputText.sendKeys("Tesvan");

        var messageText = practicePage.getAlertText();
        practicePage.acceptAlert();
        assertEquals(messageText,"Hello Tesvan, share this practice page and share your knowledge");
    }

    @Test
    @DisplayName("Confirm Accept")
    public void confirmAccept() {
        var inputConfirmText= practicePage.inputTextForConfirm();
        inputConfirmText.sendKeys("Tesvan");

        var messageText = practicePage.getConfirmText();
        practicePage.acceptConfirm();
        assertEquals(messageText,"Hello Tesvan, Are you sure you want to confirm?");
    }

    @Test
    @DisplayName("Confirm Cancel")
    public void confirmCancel() {
        var inputConfirmText= practicePage.inputTextForConfirm();
        inputConfirmText.sendKeys("Tesvan");

        var messageText = practicePage.getConfirmText();
        practicePage.cancelConfirm();
        assertEquals(messageText,"Hello Tesvan, Are you sure you want to confirm?");
    }

    @Test
    @DisplayName("iFrame Register")
    public void iFrame(){
        practicePage.switchToMainFrame();

    }
}
