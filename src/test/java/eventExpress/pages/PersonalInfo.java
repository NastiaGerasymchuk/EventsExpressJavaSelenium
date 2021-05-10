package eventExpress.pages;

import eventExpress.models.User;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class PersonalInfo extends BasePage{
    public PersonalInfo(WebDriver driver){
        super(driver);
        info=new Info(driver);
    }
    private Info info;
    public boolean isVisibleInfo(){
      return info.isVisibleInfo();
    }
    public boolean isEnabledButtonsInfo(){
        return info.isEnabledButtons();
    }
    public String getUserName(){
        return info.getUserName();
    }
    public List<String> getCategories(){
       return info.getCategories();
    }
    public boolean isCurrentUser(User user){
        return info.isCurrentUser(user);
    }
}
