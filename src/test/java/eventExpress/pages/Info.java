package eventExpress.pages;

import eventExpress.enums.Gender;
import eventExpress.models.PersonalInfoTextTitle;
import eventExpress.models.User;
import eventExpress.selectorData.InfoSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Info extends BasePage{
    public Info(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = InfoSelector.CHANGE_AVATAR_TEXT)
    WebElement changeAvatar;
    @FindBy(xpath = InfoSelector.CHANGE_AVATAR_BUTTON)
    WebElement changeAvatarButton;
    @FindBy(xpath = InfoSelector.USER_NAME_TEXT)
    WebElement userNameText;
    @FindBy(xpath = InfoSelector.USER_NAME)
    WebElement userName;
    @FindBy(xpath = InfoSelector.USER_NAME_BUTTON)
    WebElement userNameButton;
    @FindBy(xpath = InfoSelector.INPUT_USER_NAME)
    WebElement userNameInput;
    @FindBy(xpath = InfoSelector.SUBMIT_USER_NAME)
    WebElement userNameSubmit;
    @FindBy(xpath = InfoSelector.CLEAR_USER_NAME)
    WebElement userNameClear;
    @FindBy(xpath = InfoSelector.GENDER_TEXT)
    WebElement genderText;
    @FindBy(xpath = InfoSelector.GENDER_NAME)
    WebElement genderName;
    @FindBy(xpath = InfoSelector.GENDER_BUTTON)
    WebElement genderButton;
    @FindBy(xpath = InfoSelector.DATE_OF_BIRTH_TEXT)
    WebElement dateOfBirthText;
    @FindBy(xpath = InfoSelector.DATE_OF_BIRTH)
    WebElement dateOfBirthName;
    @FindBy(xpath = InfoSelector.DATE_OF_BIRTH_BUTTON)
    WebElement dateOfBirthButton;
    @FindBy(xpath = InfoSelector.FAVOURITE_CATEGORIES_TEXT)
    WebElement favouriteCategoriesText;
    @FindBy(css = InfoSelector.FAVOURITE_CATEGORIES_ITEMS)
    WebElement favouriteCategoriesItems;
    @FindBy(xpath = InfoSelector.FAVOURITE_CATEGORIES_BUTTON)
    WebElement favouriteCategoriesButton;
    @FindBy(xpath = InfoSelector.MANAGE_NOTIFICATIONS_TEXT)
    WebElement manageNotificationText;
    @FindBy(xpath = InfoSelector.MANAGE_NOTIFICATIONS_ITEMS)
    WebElement manageNotificationItems;
    @FindBy(xpath = InfoSelector.MANAGE_NOTIFICATIONS_BUTTON)
    WebElement manageNotificationButton;
    @FindBy(xpath = InfoSelector.LINKED_ACCOUNTS_TEXT)
    WebElement linkedAccountsText;
    @FindBy(xpath = InfoSelector.LINKED_ACCOUNTS_BUTTON)
    WebElement linkedAccountsButton;
    public String getChangeAvatarText(){
        return getText(changeAvatar);
    }
    public boolean isVisibleChangeAvatarText(){
        By item=By.xpath(InfoSelector.CHANGE_AVATAR_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleChangeAvatarButton(){
        By item=By.xpath(InfoSelector.CHANGE_AVATAR_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledChangeAvatarButton(){
        By item=By.xpath(InfoSelector.CHANGE_AVATAR_BUTTON);
        return isEnabled(item);
    }
    public String getUserNameText(){
        return getText(userNameText);
    }
    public String getUserName(){
        return getText(userName);
    }
    public boolean isVisibleUserNameText(){
        By item=By.xpath(InfoSelector.USER_NAME_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleUserName(){
        By item=By.xpath(InfoSelector.USER_NAME);
        return isVisible(item);
    }
    public boolean isVisibleUserNameButton(){
        By item=By.xpath(InfoSelector.USER_NAME_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledUserNameButton(){
        By item=By.xpath(InfoSelector.USER_NAME_BUTTON);
        return isEnabled(item);
    }
    public Info clickUserNameButton(){
        click(userNameButton);
        return this;
    }
    public boolean isCurrentName(String name){
        return getUserName().equals(name);
    }
    public String getGenderText(){
        return getText(genderText);
    }
    public String getGenderName(){
        return getText(genderName);
    }
    public boolean isVisibleGenderText(){
        By item=By.xpath(InfoSelector.GENDER_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleGenderName(){
        By item=By.xpath(InfoSelector.GENDER_NAME);
        return isVisible(item);
    }
    public boolean isVisibleGenderButton(){
        By item=By.xpath(InfoSelector.GENDER_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledGenderButton(){
        By item=By.xpath(InfoSelector.GENDER_BUTTON);
        return isEnabled(item);
    }

    public String getDateOfBirthText(){
        return getText(dateOfBirthText);
    }
    public String getDateOfBirthName(){
        return getText(dateOfBirthName);
    }
    public boolean isVisibleDateOfBirthText(){
        By item=By.xpath(InfoSelector.DATE_OF_BIRTH_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleDateOfBirthName(){
        By item=By.xpath(InfoSelector.DATE_OF_BIRTH);
        return isVisible(item);
    }
    public boolean isVisibleDateOfBirthButton(){
        By item=By.xpath(InfoSelector.DATE_OF_BIRTH_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledDateOfBirthButton(){
        By item=By.xpath(InfoSelector.DATE_OF_BIRTH_BUTTON);
        return isEnabled(item);
    }

    public String getFavouriteCategoriesText(){
        return getText(favouriteCategoriesText);
    }
    public boolean isVisibleFavouriteCategoriesText(){
        By item=By.xpath(InfoSelector.FAVOURITE_CATEGORIES_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleFavouriteCategoriesButton(){
        By item=By.xpath(InfoSelector.FAVOURITE_CATEGORIES_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledFavouriteCategoriesButton(){
        By item=By.xpath(InfoSelector.FAVOURITE_CATEGORIES_BUTTON);
        return isEnabled(item);
    }
    public String getManageNotificationText(){
        return getText(manageNotificationText);
    }
    public boolean isVisibleManageNotificationText(){
        By item=By.xpath(InfoSelector.MANAGE_NOTIFICATIONS_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleManageNotificationButton(){
        By item=By.xpath(InfoSelector.MANAGE_NOTIFICATIONS_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledManageNotificationButton(){
        By item=By.xpath(InfoSelector.MANAGE_NOTIFICATIONS_BUTTON);
        return isEnabled(item);
    }
    public String getLinkedAccountsText(){
        return getText(linkedAccountsText);
    }
    public boolean isVisibleLinkedAccountsText(){
        By item=By.xpath(InfoSelector.LINKED_ACCOUNTS_TEXT);
        return isVisible(item);
    }
    public boolean isVisibleLinkedAccountsButton(){
        By item=By.xpath(InfoSelector.LINKED_ACCOUNTS_BUTTON);
        return isVisible(item);
    }
    public boolean isEnabledLinkedAccountsButton(){
        By item=By.xpath(InfoSelector.LINKED_ACCOUNTS_BUTTON);
        return isEnabled(item);
    }

    public boolean isVisibleInfo(){
        return isVisibleChangeAvatarButton()&&
                isVisibleChangeAvatarText()&&
                isVisibleUserNameText()&&
                isVisibleUserName()&&
                isVisibleUserNameButton()&&
                isVisibleGenderText()&&
                isVisibleGenderName()&&
                isVisibleGenderButton()&&
                isVisibleDateOfBirthText()&&
                isVisibleDateOfBirthName()&&
                isVisibleDateOfBirthButton()&&
                isVisibleFavouriteCategoriesText()&&
                isVisibleFavouriteCategoriesButton()&&
                isVisibleManageNotificationText()&&
                isVisibleManageNotificationButton()&&
                isVisibleLinkedAccountsText()&&
                isVisibleLinkedAccountsButton();

    }
    public boolean isEnabledButtons(){
        return isEnabledChangeAvatarButton()&&
                isEnabledUserNameButton()&&
                isEnabledGenderButton()&&
                isEnabledDateOfBirthButton()&&
                isEnabledFavouriteCategoriesButton()&&
                isEnabledManageNotificationButton()&&
                isEnabledLinkedAccountsButton();
    }
    public List<String> getCategories(){
        By items=By.cssSelector(InfoSelector.FAVOURITE_CATEGORIES_ITEMS);
        return getValuesGroupText(items);
    }
    public List<String> getManageNotifications(){
        By items=By.cssSelector(InfoSelector.MANAGE_NOTIFICATIONS_ITEMS);
        return getValuesGroupText(items);
    }
    public boolean isGender(Gender gender){
       return isEnumElements(getGenderName())&&gender==getEnumElements(getGenderName());
    }
    public boolean isCurrentUser(User user){
        return isEqualElements(user.getName(),getUserName())&&
                isGender(user.getGender())&&
                isEqualElements(user.getBirthday(),getDateOfBirthName())&&
               equalsIgnoreCase(user.getCategories(),getCategories())&&
               equalsIgnoreCase(user.getManageNotifications(),getManageNotifications());
    }
    public boolean isCurrentTitles(PersonalInfoTextTitle personalInfoTextTitle){
            String avatar=getChangeAvatarText();
            String userName=getUserNameText();
            String gender=getGenderText();
            String dateOfBirth=getDateOfBirthText();
            String favouriteCategories=getFavouriteCategoriesText();
            String manageNotification=getManageNotificationText();
            String linkedAccounts=getLinkedAccountsText();
            PersonalInfoTextTitle existedTitles=new PersonalInfoTextTitle(
                    avatar,userName,gender,dateOfBirth,favouriteCategories,manageNotification,linkedAccounts
            );
            return personalInfoTextTitle.equals(existedTitles);
    }

    private void inputUserName(String name){
        sendKeys(userNameInput,name);
    }
    private void submitUserName(){
        click(userNameSubmit);
    }
    public Info changeUserName(String name){
        inputUserName(name);
        submitUserName();
        return this;
    }
    public boolean isEnabledSubmit(){
        By item=By.xpath(InfoSelector.SUBMIT_USER_NAME);
        return isEnabled(item);
    }
}
