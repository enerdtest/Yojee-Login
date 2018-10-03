package pages;

import dataProvider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import static org.testng.Assert.assertEquals;

public class AdminPage {
    public AdminPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Get User name after login successfully
    @FindBy(how = How.XPATH, using = ".//*/div[@class=' pull-right']//span[@class='semi-bold']") WebElement userProfile;
    // Open Workers page
    @FindBy(how = How.XPATH, using = ".//*/a[contains(@href,'workers')]/following-sibling::div[contains(@class, 'clickable')]") WebElement selectLi;
    // Add new Worker "+" button
    @FindBy(how = How.XPATH, using = ".//*/header-button/button[@title='Add']") WebElement btnAddWorker;
    // Name textbox
    @FindBy(how = How.XPATH, using = ".//*/label[.='Name']/following-sibling::input") WebElement txtWorkerName;
    // Phone Number textboxs
    @FindBy(how = How.XPATH, using = ".//*/label[.='Phone Number']/following-sibling::input") WebElement txtPhoneNumber;
    // Email textbox
    @FindBy(how = How.XPATH, using = ".//*/label[.='Email']/following-sibling::input") WebElement txtEmail;
    // Email SMS Token
    @FindBy(how = How.XPATH, using = ".//*/label[.='SMS Token']/following-sibling::input") WebElement txtSMSToken;
    // Use SMS Token checkbox
    @FindBy(how = How.XPATH, using = ".//*/div[@class='checkbox check-success']") WebElement chkbxSMSToken;
    // Save button
    @FindBy(how = How.XPATH, using = ".//*/div[contains(@class, 'panel-controls')]/mini-action-button[@icon='save']") WebElement btnSaveNewWorker;
    //Get added Worker Name
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'fa-pencil')]/preceding::div[@class='panel-title']") WebElement workerName;
    //Get added Phone Number
    @FindBy(how = How.XPATH, using = ".//*/span[contains(@class,'fa-phone')]/following-sibling::a") WebElement workerPhoneNumber;
    //Get registered email
    @FindBy(how = How.XPATH, using = ".//*/span[contains(@class,'fa-envelope')]/following-sibling::a") WebElement workerEmail;

    WebDriver driver;
    ConfigFileReader configFileReader = new ConfigFileReader();

    //This method to verify login successfully  with correct user name
    public void verifyUserName(){
        String actualUserName = userProfile.getText().trim();
        String userProfileName = configFileReader.getUserProfileName();
        assertEquals(userProfileName,actualUserName);
    }
    //Open Worker Page to add new worker
    public void openWorkerPage(){
        selectLi.click();
    }
    // Click add new Worker button
    public void clickAddWorkerButton(){
        btnAddWorker.click();
    }
    //This method to set Worker Name
    public void setWorkerName(String strName){
        txtWorkerName.clear();
        txtWorkerName.sendKeys( strName);
    }
    //This method to set Phone Number
    public void setWorkerPhoneNumber(String strPhoneNumber){
        txtPhoneNumber.clear();
        txtPhoneNumber.sendKeys(strPhoneNumber);
    }
    //This method to set Email
    public void setWorkerEmail(String strEmail){
        txtEmail.clear();
        txtEmail.sendKeys(strEmail);
    }
    //This method to check to the use SMS token checkbox
    public void checkUseSMSToken(){
        chkbxSMSToken.click();
    }
    //This method to set the SMS Token
    public void setSMSToken(String strSMSToken){
        txtSMSToken.clear();
        txtSMSToken.sendKeys(strSMSToken);
    }
    //Click Save new Worker
    public void clickSaveNewWorker(){
        btnSaveNewWorker.click();
    }
    //Verify create new Worker successfully with correct provided detail
    public void verifyNewWorker(){
        String actualWorkerName = workerName.getText().trim().toLowerCase();
        String actualPhoneNumber = workerPhoneNumber.getText().trim().toLowerCase();
        String actualEmail = workerEmail.getText().trim().toLowerCase();
        String workerName = configFileReader.getWorkerName().trim().toLowerCase();
        String phoneNumber = configFileReader.getWorkerPhoneNumber().toLowerCase();
        String workEmail = configFileReader.getWorkerEmail();

        assertEquals(workerName,actualWorkerName);
        assertEquals(phoneNumber,actualPhoneNumber);
        assertEquals(workEmail, actualEmail);
    }
}
