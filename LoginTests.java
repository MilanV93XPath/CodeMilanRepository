package tests;
import org.junit.Test;
import pages.LoginPage;
import pages.HomePage;

public class LoginTests extends BaseTests{
   
    public LoginPage loginPage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPassword = "";
    String emptyPasswordError = "Epic sadface: Password is required";
    String badUsername = "test";
    String badUsernamePasswordError = "Epic sadface: Username and password do not match any user in this service";

    
    @Test
    public void verifySuccesfullLogin(){
       LoginPage loginPage = new LoginPage(driver);
       HomePage homePage = new HomePage(driver);

       loginPage.basePage();
       loginPage.login(standardUsername, password);
       homePage.verifySuccesfullLogin(expectedText);
       

       try{
        Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void verifyUnscuccesfullLoginWithEmptyUsername(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccesfullLogin(emptyUsernameError);
 
        try{
        Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void verifyUnscuccesfullLoginWithEmptyPassword(){
        LoginPage loginPage = new LoginPage(driver);
    
        loginPage.basePage();
        loginPage.login(standardUsername, emptyPassword);
        loginPage.verifyUnsuccesfullLogin(emptyPasswordError);
    
        try{
        Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

    @Test
    public void verifyUnscuccesfullLoginWithBadUsername(){
        LoginPage loginPage = new LoginPage(driver);
    
        loginPage.basePage();
        loginPage.login(badUsername, password);
        loginPage.verifyUnsuccesfullLogin(badUsernamePasswordError);
    
        try{
        Thread.sleep(5000);
        }catch(InterruptedException e){
        e.printStackTrace();
        }
    }

}

