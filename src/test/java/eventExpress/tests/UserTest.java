package eventExpress.tests;

import eventExpress.data.NavData;
import eventExpress.data.UserData;
import eventExpress.models.PersonalInfoTextTitle;
import eventExpress.models.User;
import eventExpress.pages.HomePage;
import eventExpress.pages.LoginForm;
import eventExpress.pages.PersonalInfo;
import eventExpress.pages.UserPage;
import eventExpress.testData.PersonalInfoTitle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static utils.EqualsSanitilize.equalsSanitilize;

public class UserTest extends BaseTest{
    private static Stream<Arguments> personalUserData() {

        return Stream.of(
                Arguments.of(new User(UserData.EMAIL,UserData.PASSWORD,UserData.NAME,UserData.GENDER,UserData.BIRTHDAY,UserData.CATEGORIES,UserData.MANAGE_NOTIFICATIONS),
                        new PersonalInfoTextTitle(
                                PersonalInfoTitle.AVATAR,
                                PersonalInfoTitle.USERNAME,
                                PersonalInfoTitle.GENDER,
                                PersonalInfoTitle.DATE_OF_BIRTH,
                                PersonalInfoTitle.FAVORITE_CATEGORIES,
                                PersonalInfoTitle.MANAGE_NOTIFICATIONS,
                                PersonalInfoTitle.LINKED_ACCOUNTS
                                ))
        );


    }
    private static Stream<Arguments> changeUserNameData() {

        return Stream.of(
                Arguments.of(new User(UserData.EMAIL,UserData.PASSWORD,UserData.NAME,UserData.GENDER,UserData.BIRTHDAY,UserData.CATEGORIES,UserData.MANAGE_NOTIFICATIONS),
                        "New user name")
        );


    }
    private static Stream<Arguments> navUserData() {

        return Stream.of(
                Arguments.of(new User(UserData.EMAIL,UserData.PASSWORD,UserData.NAME,UserData.GENDER,UserData.BIRTHDAY,UserData.CATEGORIES,UserData.MANAGE_NOTIFICATIONS),
                        NavData.getUserNavItems()
        ));


    }

    @ParameterizedTest
    @MethodSource("navUserData")
    public void goToUserProfile(User user,List<String> navItems)
    {
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        assertAll(
                "header visible",
                ()->assertThat("is photo visible",userPage.isPhotoVisible(),is(true)),
                ()->assertThat("is name visible",userPage.isNameVisible(),is(true)),
                ()->assertThat("is personal info visible",userPage.isPersonalInfoVisible(),is(true)),
                ()->assertThat("is notification visible",userPage.isNotificationVisible(),is(true)),
                ()->assertThat("is log out visible",userPage.isLogOutVisible(),is(true)),
                ()->assertThat("is add event visible",userPage.isAddEventVisible(),is(true))
        );
        assertAll(
                "button header enabled",
                ()->assertThat("is photo visible",userPage.isEnabledPersonalInfoButton(),is(true)),
                ()->assertThat("is name visible",userPage.isEnabledNotificationButton(),is(true)),
                ()->assertThat("is personal info visible",userPage.isEnabledLogOutButton(),is(true)),
                ()->assertThat("is notification visible",userPage.isEnabledAddEventButton(),is(true))
        );
        List<String> currentNav=userPage.getNavItems();
        assertThat("navigation panel for user is correct(full)",navItems, equalsSanitilize(currentNav));
    }
    @ParameterizedTest
    @MethodSource("personalUserData")
    public void getUserInfo(User user,PersonalInfoTextTitle personalInfoTextTitle){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        var personalInfo=userPage.goToPersonalInfo();
        assertThat(personalInfo, instanceOf(PersonalInfo.class));
        assertAll("visible",
                ()-> assertThat("change avatar text",personalInfo.isVisibleChangeAvatarText(),is(true)),
                ()->assertThat("change avatar button",personalInfo.isVisibleChangeAvatarButton(),is(true)),
                ()->assertThat("user name text",personalInfo.isVisibleUserNameText(),is(true)),
                ()->assertThat("user name ",personalInfo.isVisibleUserName(),is(true)),
                ()->assertThat("user name button ",personalInfo.isVisibleUserNameButton(),is(true)),
                ()->assertThat("gender text",personalInfo.isVisibleGenderText(),is(true)),
                ()->assertThat("gender name",personalInfo.isVisibleGenderName(),is(true)),
                ()->assertThat("gender button",personalInfo.isVisibleGenderButton(),is(true)),
                ()->assertThat("date of birth text",personalInfo.isVisibleDateOfBirthText(),is(true)),
                ()->assertThat("date of birth name",personalInfo.isVisibleDateOfBirthName(),is(true)),
                ()->assertThat("date of birth button",personalInfo.isVisibleDateOfBirthButton(),is(true)),
                ()->assertThat("favourite categories button",personalInfo.isVisibleFavouriteCategoriesButton(),is(true)),
                ()->assertThat("manage notification text",personalInfo.isVisibleManageNotificationText(),is(true)),
                ()->assertThat("manage notification button",personalInfo.isVisibleManageNotificationButton(),is(true)),
                ()->assertThat("linked account text",personalInfo.isVisibleLinkedAccountsText(),is(true)),
                ()->assertThat("linked account button",personalInfo.isVisibleLinkedAccountsButton(),is(true))
                );

        assertAll("enabled buttons",
                ()->assertThat("change avatar",personalInfo.isEnabledChangeAvatarButton()),
                ()->assertThat("user name",personalInfo.isEnabledUserNameSubmit(),is(true)),
                ()->assertThat("manage notification",personalInfo.isEnabledManageNotificationButton(),is(true)),
                ()->assertThat("gender",personalInfo.isEnabledGenderButton(),is(true)),
                ()->assertThat("date of birth",personalInfo.isEnabledDateOfBirthButton(),is(true)),
                ()->assertThat("favourite categories",personalInfo.isEnabledFavouriteCategoriesButton(),is(true))
                );
        assertThat("titles are equals",personalInfo.getCurrentTitles(),is(equalTo(personalInfoTextTitle)));
        assertAll("current user",
                ()->assertThat("name",personalInfo.getUserName(),is(user.getName())),
                ()->assertThat("date of birth",personalInfo.getUserBirth(),is(user.getBirthday()))

        );
    }


    @ParameterizedTest
    @MethodSource("changeUserNameData")
    public void changeUserName(User user,String newUserName){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        PersonalInfo personalInfo=userPage.goToPersonalInfo();
        personalInfo.goToUserName();
        personalInfo.changeUserName(newUserName);
        assertThat("name has been changed",personalInfo.getUserName(),is(equalTo(newUserName)));
        personalInfo.goToUserName();
    }
}
