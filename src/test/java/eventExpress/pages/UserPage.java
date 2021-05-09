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
    public boolean isCurrentNav(List<String> items){
        return leftNav.isCurrentMenu(items);
    }
    public boolean isHeaderProfileExist(){
        return headerProfile.isBeginEnabled()&&
                headerProfile.isBeginVisible();
    }

}
