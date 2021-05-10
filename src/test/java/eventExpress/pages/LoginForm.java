package eventExpress.pages;

import eventExpress.models.User;
import eventExpress.selectorData.LoginSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class LoginForm extends BasePage{
    @FindBy(css = LoginSelector.LOGIN_BUTTON)
    WebElement loginButton;
    @FindBy(css = LoginSelector.REGISTER_BUTTON)
    WebElement registerButton;
    @FindBy(css = LoginSelector.EMAIL_INPUT)
    WebElement emailInput;
    @FindBy(css = LoginSelector.PASSWORD_INPUT)
    WebElement passwordInput;
    @FindBy(css = LoginSelector.CLEAR_BUTTON)
    WebElement clearButton;
    @FindBy(css = LoginSelector.SIGN_IN_BUTTON)
    WebElement signInButton;
    @FindBy(css = LoginSelector.FACEBOOK_BUTTON)
    WebElement facebookButton;
    @FindBy(css = LoginSelector.GOOGLE_BUTTON)
    WebElement googleButton;
    @FindBy(css = LoginSelector.FORGOT_PASSWORD_BUTTON)
    WebElement forgotPasswordButton;
    @FindBy(css = LoginSelector.CANCEL_BUTTON)
    WebElement cancelButton;

    public LoginForm(WebDriver driver){
        super(driver);
    }
    public boolean isPresentElements(){
        return isVisible(By.cssSelector((LoginSelector.LOGIN_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.REGISTER_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.EMAIL_INPUT)))&&
                isVisible(By.cssSelector((LoginSelector.PASSWORD_INPUT)))&&
                isVisible(By.cssSelector((LoginSelector.CLEAR_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.SIGN_IN_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.FACEBOOK_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.GOOGLE_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.FORGOT_PASSWORD_BUTTON)))&&
                isVisible(By.cssSelector((LoginSelector.CANCEL_BUTTON)));
    }
    protected String getLoginBtnText(){
        return getText(loginButton);
    }
    protected String getRegisterText(){
        return getText(registerButton);
    }

    protected String getEmailInputPlaceholder(){
        return getPlaceholder(emailInput);
    }
    protected String getPasswordInputPlaceholder(){
        return getPlaceholder(passwordInput);
    }
    protected String getClearButtonText(){
        return getText(clearButton);
    }
    protected String getSingInButtonText(){
        return getText(signInButton);
    }
    protected String getFacebookButtonText(){
        return getText(facebookButton);
    }
    protected String getGoogleButtonText(){
        return getText(googleButton);
    }
    protected String getForgotPasswordButtonText(){
        return getText(forgotPasswordButton);
    }
    protected String getCancelButtonText(){
        return getText(cancelButton);
    }
    public List<String> getElementsText(){
       return new ArrayList<String>() {
           {
               add(getLoginBtnText());
               add(getRegisterText());
               add(getEmailInputPlaceholder());
               add(getPasswordInputPlaceholder());
               add(getClearButtonText());
               add(getSingInButtonText());
               add(getFacebookButtonText());
               add(getGoogleButtonText());
               add(getForgotPasswordButtonText());
               add(getCancelButtonText());

           }
       };
    }

    public boolean isCurrentText(List<String> listTextElements){
        List<String> currentList=getElementsText();
        return equalsIgnoreCase(currentList,listTextElements);
    }
    private boolean isEnabledLoginBtn(){
        By item=By.cssSelector(LoginSelector.LOGIN_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledRegisterBtn(){
        By item=By.cssSelector(LoginSelector.REGISTER_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledEmailInput(){
        By item=By.cssSelector(LoginSelector.EMAIL_INPUT);
        return isEnabled(item);
    }
    private boolean isEnabledPasswordInput(){
        By item=By.cssSelector(LoginSelector.PASSWORD_INPUT);
        return isEnabled(item);
    }
    private boolean isEnabledClearButton(){
        By item=By.cssSelector(LoginSelector.CLEAR_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledSingInButton(){
        By item=By.cssSelector(LoginSelector.SIGN_IN_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledFacebookButton(){
        By item=By.cssSelector(LoginSelector.FACEBOOK_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledGoogleButton(){
        By item=By.cssSelector(LoginSelector.GOOGLE_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledForgotPasswordButton(){
        By item=By.cssSelector(LoginSelector.FORGOT_PASSWORD_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledCancelButton(){
        By item=By.cssSelector(LoginSelector.CANCEL_BUTTON);
        return isEnabled(item);
    }
    public boolean isBeginEnabled(){
        return isEnabledLoginBtn()&&
                isEnabledRegisterBtn()&&
                isEnabledEmailInput()&&
                isEnabledPasswordInput()&&
                !isEnabledClearButton()&&
                isEnabledSingInButton()&&
                isEnabledLoginBtn()&&
                isEnabledFacebookButton()&&
                isEnabledGoogleButton()&&
                isEnabledForgotPasswordButton()&&
                isEnabledCancelButton();

    }
    public UserPage login(User user){
        String email=user.getEmail();
        String password=user.getPassword();
        sendKeys(emailInput,email);
        sendKeys(passwordInput,password);
        click(signInButton);
        return new UserPage(driver);
    }

}
