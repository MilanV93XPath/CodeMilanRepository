package tests;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTests{
    
   public LoginPage loginPage;
   public HomePage homePage;
   String standardUsername = "standard_user";
   String password = "secret_sauce";
   String expectedText = "PRODUCTS";
   int numberOfAllItems = 6;
   //CHECKOUT: YOUR INFORMATIONS
   String FirstName = "Milan";
   String LastName = "Vojinovic";
   double ZipKode = 11400;
   String ZipCode = ZipKode +"";  // str is '11400'


 @Test
 public void verifyNumberOfItemsOnHomePage(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfullLogin(expectedText);
    homePage.numberOfProducts(6);

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
   }
 }

 @Test
public void verifySuccesfullAddtoCartOff2Products(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfullLogin(expectedText);
    homePage.verifyProductsAddedToCart();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
   }
 }


 @Test
 public void verifyLogout(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfullLogin(expectedText);
    homePage.clickOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
   }
 }

 @Test
 public void verifyTotalPrice(){
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfullLogin(expectedText);
    homePage.clickOnAddToCart();
    homePage.clickOnCheckoutButton();
    homePage.writeCheckoutInfo(FirstName, LastName, ZipKode);
    homePage.clickOnContinueButton();
    homePage.VerifyTotalPriceOfProducts();
    homePage.clickOnFinishButton();
    homePage.verifyTyForYourOrderText();
    
    try{
        Thread.sleep(5000);
    }catch(InterruptedException e){
        e.printStackTrace();
   }
 }
}