package eventExpress.pages;

import eventExpress.models.PersonalInfoTextTitle;
import eventExpress.models.User;
import org.openqa.selenium.WebDriver;

public class PersonalInfo extends BasePage{
    public PersonalInfo(WebDriver driver){
        super(driver);
        info=new Info(driver);
    }
    public PersonalInfo(WebDriver driver,Info info){
        super(driver);
        this.info=info;
    }
    private Info info;
    public boolean isVisibleInfo(){
      return info.isVisibleInfo();
    }
    public boolean isEnabledButtonsInfo(){
        return info.isEnabledButtons();
    }

    public boolean isCurrentTitles(PersonalInfoTextTitle personalInfoTextTitle){
        return info.isCurrentTitles(personalInfoTextTitle);
    }
    public boolean isCurrentUser(User user){
        return info.isCurrentUser(user);
    }
    public boolean isCurrentName(String name){
       return info.isCurrentName(name);
    }
    public boolean isEnabledUserNameSubmit(){
        return info.isEnabledSubmit();
    }
    public PersonalInfo changeUserName(String name){
       info.changeUserName(name);
       return this;
    }
    public PersonalInfo goToUserName(){
        info.clickUserNameButton();
        return this;
    }
}
