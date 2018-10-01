package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    //Using FindBy for locating elements
    @FindBy(how = How.XPATH, using=".//*/input[contains(@name, 'email')]") WebElement txtEmail;
    @FindBy(how = How.XPATH, using=".//*/input[contains(@name, 'password')]") WebElement txtPassword;
    @FindBy(how = How.XPATH, using = ".//*/button[contains(@type, 'submit')]") WebElement btnLogin;
    // Defining all the user actions (Methods) that can be performed in the Facebook home page

    // This method is to set Email in the email text box
    public void setEmail(String strEmail){
        txtEmail.sendKeys(strEmail);
    }
    // This method is to set Password in the password text box
    public void setPassword(String strPassword){
        txtPassword.sendKeys(strPassword);
    }
    // This method is to click on Login Button
    public void clickOnLoginButton(){
        btnLogin.click();
    }

}