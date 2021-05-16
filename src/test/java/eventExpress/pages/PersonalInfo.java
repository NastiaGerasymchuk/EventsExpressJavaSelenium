package eventExpress.pages;

import eventExpress.models.PersonalInfoTextTitle;
import eventExpress.selectorData.InfoSelector;
import org.openqa.selenium.By;
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
    public boolean isVisibleChangeAvatarText(){
        return info.isVisibleChangeAvatarText();
    }
    public boolean isVisibleChangeAvatarButton(){
        return info.isVisibleChangeAvatarButton();
    }
    public boolean isVisibleUserNameText(){
        return info.isVisibleUserNameText();
    }
    public boolean isVisibleUserName(){
        return info.isVisibleUserName();
    }
    public boolean isVisibleUserNameButton(){
        return info.isVisibleUserNameButton();
    }
    public boolean isVisibleGenderText(){
        return info.isVisibleGenderText();
    }
    public boolean isVisibleGenderName(){
        return info.isVisibleGenderName();
    }
    public boolean isVisibleGenderButton(){
        return info.isVisibleGenderButton();
    }
    public boolean isVisibleDateOfBirthText(){
        return info.isVisibleDateOfBirthText();
    }
    public boolean isVisibleDateOfBirthName(){
        return info.isVisibleDateOfBirthName();
    }
    public boolean isVisibleDateOfBirthButton(){
        return info.isVisibleDateOfBirthButton();
    }
    public boolean isVisibleFavouriteCategoriesButton(){
        By item=By.xpath(InfoSelector.FAVOURITE_CATEGORIES_BUTTON);
        return isVisible(item);
    }

    public boolean isVisibleManageNotificationText(){
        return info.isVisibleManageNotificationText();
    }
    public boolean isVisibleManageNotificationButton(){
        return info.isVisibleManageNotificationButton();
    }

    public boolean isVisibleLinkedAccountsText(){
        return info.isVisibleLinkedAccountsText();
    }
    public boolean isVisibleLinkedAccountsButton(){
        return info.isVisibleLinkedAccountsButton();
    }
    public PersonalInfoTextTitle getCurrentTitles(){
        return info.getCurrentTitles();
    }
    public String getUserBirth(){
        return info.getDateOfBirthText();
    }
    public boolean isEnabledUserNameSubmit(){
        return info.isEnabledSubmit();
    }
    public boolean isEnabledUserNameButton(){
        return isEnabledUserNameButton();
    }
    public boolean isEnabledManageNotificationButton(){
        return info.isEnabledManageNotificationButton();
    }
    public boolean isEnabledChangeAvatarButton(){
        return info.isEnabledChangeAvatarButton();
    }
    public boolean isEnabledGenderButton(){
       return info.isEnabledGenderButton();
    }
    public boolean isEnabledDateOfBirthButton(){
        return info.isEnabledDateOfBirthButton();
    }
    public boolean isEnabledFavouriteCategoriesButton(){
        By item=By.xpath(InfoSelector.FAVOURITE_CATEGORIES_BUTTON);
        return isEnabled(item);
    }

    public boolean isEnabledLinkedAccountsButton(){
       return isEnabledLinkedAccountsButton();
    }

    public PersonalInfo changeUserName(String name){
       info.changeUserName(name);
       return this;
    }
    public PersonalInfo goToUserName(){
        info.clickUserNameButton();
        return this;
    }
    public String getUserName(){
        return info.getUserName();
    }
}
