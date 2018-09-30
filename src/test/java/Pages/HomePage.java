package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //Using FindBy for locating elements


    @FindBy(how = How.XPATH, using = ".//*/div/span[contains(@class, 'semi-bold')]") WebElement userName;


    //Get userName
    public void verifyUserName(){
        userName.getText();
        String text = userName.getText();
        System.out.println(text);
    }

}
