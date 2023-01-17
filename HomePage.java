package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    
     public HomePage (WebDriver driver){
          super (driver); 
    }

    By HomePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By addToCartButton2By = By.id("add-to-cart-sauce-labs-bike-light");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By numberOfItemsBy = By.className("inventory_item");
    By hamburgerMenuBy = By.id("react-burger-menu-btn");
    By logoutButtonBy = By.id("logout_sidebar_link");
    String expectedLink = "https://saucelabs.com/";
    By cartContainerBy = By.id("shopping_cart_container");
    By checkoutButtonBy = By.id("checkout");
    By continueButtonBy = By.id("continue");
    //CHECKOUT: YOUR INFORMATIONS
    By firstNameBy = By.id("first-name");
    By lastNameBy = By.id("last-name");
    By zipCodeBy = By.id("postal-code");
    String FirstName = "Milan";
    String LastName = "Vojinovic";
    double ZipKode = 11400d;
    String ZipCode = ZipKode +""; // str is '11400'
    double itemTax;
    String thankYouText = "THANK YOU FOR YOUR ORDER";
    String read = "";

    By itemTotalPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[5]");
    By taxPriceBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
    By totalPricePlusTaxBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");
    By finishBy = By.id("finish");
    By tyForYourOrderBy = By.xpath("//*[@id='checkout_complete_container']/h2");
    


    public HomePage verifySuccesfullLogin (String expectedText){
        String actualText = readText(HomePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }


    public HomePage numberOfProducts (int expectedNumberOfProducts){
        int actuaclNumberOfProducts = countItems(numberOfItemsBy);
        assertIntegerEquals(expectedNumberOfProducts, actuaclNumberOfProducts);
        return this;
    }

    public HomePage verifyProductsAddedToCart(){
        click(addToCartButton1By);
        click(addToCartButton2By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }
    
    public HomePage clickOnHamburgerMenu(){
        click(hamburgerMenuBy);
        return this;
    }


    public HomePage clickOnLogoutButton(){
        click(hamburgerMenuBy);
        click(logoutButtonBy);
        return this;
    }
    
    public HomePage clickOnAddToCart(){
        click(addToCartButton1By);
        click(addToCartButton2By);
        click(cartContainerBy);
        waitVisability(cartContainerBy);
        return this;
    }

    public HomePage clickOnCheckoutButton(){
        click(checkoutButtonBy);
        return this; 
    }
    
    public HomePage writeCheckoutInfo(String FirstName, String LastName, double ZipKode){
        writeText(firstNameBy, FirstName);
        writeText(lastNameBy, LastName);
        writeText(zipCodeBy, ZipCode);
        return this;
    }

    public HomePage clickOnContinueButton(){
        click(continueButtonBy);
        return this;
    }

    public HomePage VerifyTotalPriceOfProducts(){ //
        double total = Double.parseDouble(readText(itemTotalPriceBy).substring(13));
        double tax = Double.parseDouble(readText(taxPriceBy).substring(6));
        double totalTax = Double.parseDouble(readText(totalPricePlusTaxBy).substring(8));
        itemTax = total + tax;
        assertDoubleEquals(itemTax, totalTax);
        return this;
    }

    public HomePage clickOnFinishButton(){
       click(finishBy);
       return this;
    }

    public HomePage verifyTyForYourOrderText(){
       read = readText(tyForYourOrderBy);
       assertTextEquals(read, thankYouText);
       waitVisability(tyForYourOrderBy);
       return this;
    }
}