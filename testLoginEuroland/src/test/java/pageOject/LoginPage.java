package pageOject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    @FindBy(css = "input#UserName")
    public WebElement username;
    @FindBy(css = "input#Password")
    public WebElement password;
    @FindBy(css = "div.login-panel button.btn")
    public WebElement loginBtn;
    @FindBy(linkText = "Forgot password?")
    public WebElement resetPasswordBtn;

    By errorLabelLocator = By.cssSelector("span.field-validation-error");
    By validationErrorLocator = By.cssSelector("div.validation-summary-errors li");
    By resetPasswordLabelLocator = By.cssSelector("div.forgot-pass-panel");
    By emailLocator = By.cssSelector("input#UserEmail");
    By resetBtnLocator = By.cssSelector("div.forgot-pass-panel button");
    By cancelBtnLocator = By.linkText("Cancel");
    By resetErrorLabel = By.cssSelector("div.field-validation-error");
    By validationResetMessage = By.cssSelector("p.after-message");
    By customerInterface = By.cssSelector("div.wrapper");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open(){
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.get("https://dev.vn.euroland.com/tools/customerinterface2/Account/Login?ReturnUrl=%2ftools%2fcustomerinterface2%2f");
    }

    public WebElement getErrorLabel(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement errorLabel = waiter.until(ExpectedConditions.visibilityOfElementLocated(errorLabelLocator));
        return errorLabel;
    }
    public WebElement getValidationErrorMessage (){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement validateMessage = waiter.until(ExpectedConditions.visibilityOfElementLocated(validationErrorLocator));
        return validateMessage;

    }
    public WebElement getCustomerInterface(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement customerInterfaceEl = waiter.until(ExpectedConditions.visibilityOfElementLocated(customerInterface));
        return customerInterfaceEl;
    }

    public WebElement getResetPasswordLabel(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement resetPasswordLabel = waiter.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordLabelLocator));
        return resetPasswordLabel;

    }
    public WebElement getEmailEl(){
        return this.getResetPasswordLabel().findElement(emailLocator);

    }
    public WebElement getResetBtn(){

        return this.getResetPasswordLabel().findElement(resetBtnLocator);
    }
    public WebElement getResetErrorLabel(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement resetErrorLabelEl = waiter.until(ExpectedConditions.presenceOfElementLocated(resetErrorLabel));
        return resetErrorLabelEl;
    }

    public WebElement validationResetMessage(){
        WebDriverWait waiter = new WebDriverWait(this.driver, 20);
        WebElement validationEmailResetMessage = waiter.until(ExpectedConditions.visibilityOfElementLocated(validationResetMessage));
        return validationEmailResetMessage;
    }

    public WebElement getCancelBtn(){

        return this.getResetPasswordLabel().findElement(cancelBtnLocator);
    }
    public WebElement getActiveEl() throws InterruptedException{
        Thread.sleep(1000);
        return this.driver.switchTo().activeElement();
    }





}
