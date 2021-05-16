package eventExpress.pages;

import eventExpress.configure.URL;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends BasePage {

    private LeftNav leftNav;
    private final String PAGE_URL= URL.HOME_PAGE;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver.get(PAGE_URL);
        leftNav=new LeftNav(driver);
    }
    public boolean isLeftSideVisible(){
        return leftNav.getNavigationVisible()&&leftNav.getSignInButtonVisible();
    }
    public String getLeftNavBtnText(){
        return leftNav.getSignInButtonText();
    }
    public List<String> getNavItems(){
       return leftNav.getNavItems();
    }
    public LoginForm signInClick(){
       return leftNav.signInClick();
    }

    public boolean isSignInButton(){
        return leftNav.isSignInButton();
    }
    public String getSignInText(){
        return leftNav.getSignInButtonText();
    }
}
