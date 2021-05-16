package eventExpress.pages;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class UserPage extends BasePage{
    public UserPage(WebDriver driver){
        super(driver);
        headerProfile=new HeaderProfile(driver);
        leftNav=new LeftNav(driver);
    }

    private HeaderProfile headerProfile;
    private LeftNav leftNav;
    public String getUserName(){
        return headerProfile.getUserName();
    }
    public boolean isCurrentUserName(String userName){
        String currentName=getUserName();
        return isEqualElements(userName,currentName);
    }
    public PersonalInfo goToPersonalInfo(){
        return headerProfile.personalInfoButtonClick();
    }

    public boolean isPhotoVisible(){
        return headerProfile.isPhotoVisible();
    }
    public boolean isNameVisible(){
        return  headerProfile.isNameVisible();
    }
    public boolean isPersonalInfoVisible(){
        return  headerProfile.isPersonalInfoVisible();
    }
    public boolean isNotificationVisible(){
        return  headerProfile.isNotificationVisible();
    }
    public boolean isLogOutVisible(){
        return  headerProfile.isLogOutVisible();
    }
    public boolean isAddEventVisible(){
        return  headerProfile.isAddEventVisible();
    }
    public boolean isEnabledPersonalInfoButton(){
        return  headerProfile.isEnabledPersonalInfoButton();
    }
    public boolean isEnabledNotificationButton(){
        return  headerProfile.isEnabledNotificationButton();
    }
    public boolean isEnabledLogOutButton(){
       return headerProfile.isEnabledLogOutButton();
    }
    public boolean isEnabledAddEventButton(){
       return headerProfile.isEnabledAddEventButton();
    }
    public List<String> getNavItems(){
        return leftNav.getNavItems();
    }
}
