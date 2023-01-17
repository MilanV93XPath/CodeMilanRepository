package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
       
    public LoginPage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com/";
    By usernameBy = By.id("user-name");
    By passwordBy = By.id("password");
    By loginbuttonBy = By.id("login-button");
    By errorContainerBy = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");

    public LoginPage basePage(){
       driver.get(baseUrl);
       return this;
    }

    public LoginPage login(String username, String password){
       writeText(usernameBy, username);
       writeText(passwordBy, password);
       click(loginbuttonBy);
       return this;
    }
    
    public LoginPage verifyUnsuccesfullLogin(String expectedText){
       String actualText = readText(errorContainerBy);
       assertTextEquals(expectedText, actualText);
       return this;
    }

    public LoginPage verifyLogout(){
       waitVisability(usernameBy);
       return this;
    }
}
