package eventExpress.pages;

import eventExpress.selectorData.LeftNavSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LeftNav extends BasePage{
    @FindBy(css = LeftNavSelector.LIST_ITEMS)
    WebElement listItems;
    @FindBy(css = LeftNavSelector.NAVIGATION)
    WebElement navigation;
    @FindBy(css = LeftNavSelector.SIGN_IN_BUTTON)
    WebElement signInButton;
    public LeftNav(WebDriver driver){
        super(driver);
    }
    public boolean getNavigationVisible(){
        By element=By.cssSelector(LeftNavSelector.NAVIGATION);
        return isVisible(element);
    }
    public boolean getSignInButtonVisible(){
        By element=By.cssSelector(LeftNavSelector.SIGN_IN_BUTTON);
        return isVisible(element);
    }
    public String getSignInButtonText(){
        return getText(signInButton);
    }
    public List<String> getNavItems(){
        By items= By.cssSelector(LeftNavSelector.LIST_ITEMS);
        return getValuesGroupText(items);
    }
    public LoginForm signInClick(){
        click(signInButton);
        return new LoginForm(driver);
    }
    public boolean isCurrentMenu(List<String> items ){
            List<String> assertList=getNavItems();
        return  equalsIgnoreCase(assertList,items);
        //return ((assertList.size() == expectedList.size()) && assertList.containsAll((expectedList)) && expectedList.containsAll(assertList));

    }
    public boolean isCurrentButton(String button,String current){
        return isEqualElements(button,current);
    }
    public boolean isSignInButton() {
        String button = LeftNavSelector.SIGN_IN_BUTTON_TEXT;
        String current = getSignInButtonText();
        return isCurrentButton(button, current);
    }
}
