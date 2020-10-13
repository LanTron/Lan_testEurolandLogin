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

    public LoginStepDefinitions() {
        this.driver = Hook.driver;
        this.loginPage = new LoginPage(this.driver);
    }


    @Given("^The login page has been shown$")
    public void the_login_page_has_been_shown()  {
        this.loginPage.open();

    }

    @When("^The user login with email is (.+) and password is (.+)$")
    public void the_user_login_with_email_is_and_password_is(String email, String password){
        this.loginPage.username.sendKeys(email);
        this.loginPage.password.sendKeys(password);
        this.loginPage.loginBtn.click();

    }

    @When("^The user login with valid credentials: email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void the_user_login_with_valid_credentials_email_something_and_password_something(String email, String password){
        this.loginPage.username.sendKeys(email);
        this.loginPage.password.sendKeys(password);
        this.loginPage.loginBtn.click();
    }

    @Then("^The placeholder of username field is \"([^\"]*)\" and password field is \"([^\"]*)\"$")
    public void the_placeholder_of_username_field_is_something_and_password_field_is_something(String usernameLabel, String passwordLabel){
        Assert.assertEquals(usernameLabel, this.loginPage.username.getAttribute("placeholder"));
        Assert.assertEquals(passwordLabel, this.loginPage.password.getAttribute("placeholder"));
    }

    @Then("^The error (.+) is shown in red color$")
    public void the_is_shown_in_red_color(String message){
        Assert.assertEquals(message, this.loginPage.getErrorLabel().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getErrorLabel().getCssValue("color"));

    }

    @Then("^The popup message \"([^\"]*)\" is shown in red color$")
    public void the_popup_message_something_is_shown_in_red_color(String message){
        Assert.assertEquals(message, this.loginPage.getValidationErrorMessage().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getValidationErrorMessage().getCssValue("color"));

    }

    @Then("^The list of Tools dashboard is shown$")
    public void the_list_of_tools_dashboard_is_shown(){
        Assert.assertTrue(this.loginPage.getCustomerInterface()!=null);

    }

}
