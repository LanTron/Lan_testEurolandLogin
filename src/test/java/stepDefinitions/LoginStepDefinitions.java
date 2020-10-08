package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageOject.LoginPage;

public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void initTest(){
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\WebDriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(this.driver);
        this.driver.manage().window().maximize();
    }

    @Given("^The login page has been shown$")
    public void the_login_page_has_been_shown() {
        this.loginPage.open();

    }


    @When("^The user login with blank User Name$")
    public void the_user_login_with_blank_user_name() {
        this.loginPage.loginBtn.click();

    }

    @When("^The user login with an invalid email (.+)$")
    public void the_user_login_with_an_invalid_email(String email)  {
        this.loginPage.username.sendKeys(email);
        this.loginPage.loginBtn.click();

    }

    @When("^The user login with blank Password and a valid email \"([^\"]*)\"$")
    public void the_user_login_with_blank_password_and_a_valid_email_something(String email) {
        this.loginPage.username.sendKeys(email);
        this.loginPage.loginBtn.click();
    }

    /*@When("^The user login with invalid credentials: email \"([^\"]*)\" and password \"([^\"]*)\" $")
    public void the_user_login_with_invalid_credentials_email_something_and_password_something(String email, String password){
        this.loginPage.username.sendKeys(email);
        this.loginPage.password.sendKeys(password);
        this.loginPage.loginBtn.click();

    }*/
    @When("^The user login with invalid credentials: email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_login_with_invalid_credentials_email_something_and_password_something(String strArg1, String strArg2){
        this.loginPage.username.sendKeys(strArg1);
        this.loginPage.password.sendKeys(strArg2);
        this.loginPage.loginBtn.click();
    }


    @When("^The user login with valid credentials: email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_login_with_valid_credentials_email_something_and_password_something(String email, String password){
        this.loginPage.username.sendKeys(email);
        this.loginPage.password.sendKeys(password);
        this.loginPage.loginBtn.click();

    }


    @Then("^The fields have placeholders with content \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_fields_have_placeholders_with_content_something_and_something(String userName, String password){
        Assert.assertEquals(userName, this.loginPage.username.getAttribute("placeholder"));
        Assert.assertEquals(password, this.loginPage.password.getAttribute("placeholder"));

    }

    @Then("^The error message \"([^\"]*)\" is shown in red color below User Name field$")
    public void the_error_message_something_is_shown_in_red_color_below_user_name_field(String message) {
        Assert.assertEquals(message, this.loginPage.getErrorLabel().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getErrorLabel().getCssValue("color"));

    }

    @Then("^The error message \"([^\"]*)\" is shown in red color below Password field$")
    public void the_error_message_something_is_shown_in_red_color_below_password_field(String message) {
        Assert.assertEquals(message, this.loginPage.getErrorLabel().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getErrorLabel().getCssValue("color"));

    }
    @Then("^The error message \"([^\"]*)\" is shown in red color$")
    public void the_error_message_something_is_shown_in_red_color(String message) {
        Assert.assertEquals(message, this.loginPage.getValidationErrorMessage().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getValidationErrorMessage().getCssValue("color"));
    }


    @Then("^The Customer Interface 2 will show$")
    public void the_customer_interface_2_will_show() {

    }


    @After
    public void finishTest(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenshot");
        }
        this.driver.quit();
    }

}
