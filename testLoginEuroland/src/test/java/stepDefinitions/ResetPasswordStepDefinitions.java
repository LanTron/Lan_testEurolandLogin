package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageOject.LoginPage;

public class ResetPasswordStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;
    public ResetPasswordStepDefinitions(){
        this.driver = Hook.driver;
        this.loginPage = new LoginPage(this.driver);
    }


    @Given("^The reset password page has been shown$")
    public void the_reset_password_page_has_been_shown() {
        this.loginPage.open();
        this.loginPage.resetPasswordBtn.click();
        this.loginPage.getResetPasswordLabel();

    }

    @When("^The user reset password with email is (.+)$")
    public void the_user_reset_password_with_email_is(String email){
        this.loginPage.getEmailEl().sendKeys(email);
        this.loginPage.getResetBtn().click();

    }

    @When("^The user close reset password page$")
    public void the_user_close_reset_password_page() {
        this.loginPage.getCancelBtn().click();

    }

    @Then("^The field have placeholder with content \"([^\"]*)\"$")
    public void the_field_have_placeholder_with_content_something(String emailLabel)  {
        Assert.assertEquals(emailLabel, this.loginPage.getEmailEl().getAttribute("placeholder"));

    }

    @Then("^The error message (.+) is shown in red color below Email field$")
    public void the_error_message_something_is_shown_in_red_color_below_email_field(String message)  {
        Assert.assertEquals(message, this.loginPage.getResetErrorLabel().getText());
        Assert.assertEquals("rgba(255, 0, 0, 1)", this.loginPage.getResetErrorLabel().getCssValue("color"));

    }

    @Then("^The message (.+) is shown$")
    public void the_message_is_shown(String message) {
        Assert.assertEquals(message, this.loginPage.validationResetMessage().getText());

    }

    @Then("^It will redirect to login page$")
    public void it_will_redirect_to_login_page() throws InterruptedException{
        Assert.assertEquals("UserName", this.loginPage.getActiveEl().getAttribute("id"));

    }


}
