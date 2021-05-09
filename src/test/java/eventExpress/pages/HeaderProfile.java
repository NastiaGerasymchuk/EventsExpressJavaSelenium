package eventExpress.pages;

import eventExpress.selectorData.HeaderProfileSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderProfile extends BasePage {
    public HeaderProfile(WebDriver driver){
        super(driver);
    }
    @FindBy(css = HeaderProfileSelector.PHOTO)
    WebElement photo;
    @FindBy(css = HeaderProfileSelector.USER_NAME)
    WebElement userName;
    @FindBy(css = HeaderProfileSelector.PERSONAL_INFO_BUTTON)
    WebElement personalInfoButton;
    @FindBy(css = HeaderProfileSelector.NOTIFICATION_BUTTON)
    WebElement notificationButton;
    @FindBy(css = HeaderProfileSelector.LOG_OUT_BUTTON)
    WebElement logOutButton;
    @FindBy(css = HeaderProfileSelector.ADD_EVENT_BUTTON)
    WebElement addEventButton;
    public String getUserName(){
        return getText(userName);
    }
    public PersonalInfo personalInfoButtonClick(){
        click(personalInfoButton);
        return new PersonalInfo(driver);
    }
    private boolean isPhotoVisible(){
        By item=By.cssSelector(HeaderProfileSelector.PHOTO);
        return  isVisible(item);
    }
    private boolean isNameVisible(){
        By item=By.cssSelector(HeaderProfileSelector.USER_NAME);
        return  isVisible(item);
    }
    private boolean isPersonalInfoVisible(){
        By item=By.cssSelector(HeaderProfileSelector.PERSONAL_INFO_BUTTON);
        return  isVisible(item);
    }
    private boolean isNotificationVisible(){
        By item=By.cssSelector(HeaderProfileSelector.NOTIFICATION_BUTTON);
        return  isVisible(item);
    }
    private boolean isLogOutVisible(){
        By item=By.cssSelector(HeaderProfileSelector.LOG_OUT_BUTTON);
        return  isVisible(item);
    }
    private boolean isAddEventVisible(){
        By item=By.cssSelector(HeaderProfileSelector.ADD_EVENT_BUTTON);
        return  isVisible(item);
    }
    private boolean isEnabledPersonalInfoButton(){
        By item=By.cssSelector(HeaderProfileSelector.PERSONAL_INFO_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledNotificationButton(){
        By item=By.cssSelector(HeaderProfileSelector.NOTIFICATION_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledLogOutButton(){
        By item=By.cssSelector(HeaderProfileSelector.LOG_OUT_BUTTON);
        return isEnabled(item);
    }
    private boolean isEnabledAddEventButton(){
        By item=By.cssSelector(HeaderProfileSelector.ADD_EVENT_BUTTON);
        return isEnabled(item);
    }
    public boolean isBeginVisible(){
        return isPhotoVisible()&&
                isNameVisible()&&
                isPersonalInfoVisible()&&
                isNotificationVisible()&&
                isLogOutVisible()&&
                isAddEventVisible();
    }
    public boolean isBeginEnabled(){
        return isEnabledPersonalInfoButton()&&
                isEnabledNotificationButton()&&
                isEnabledLogOutButton()&&
                isEnabledAddEventButton();
    }

}
