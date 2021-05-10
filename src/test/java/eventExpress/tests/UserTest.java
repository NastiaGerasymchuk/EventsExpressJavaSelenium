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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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
    public void goToUserProfile(User user,List<String> navItems){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        assertThat(userPage.isHeaderProfileExist(),is(true));
        assertThat(userPage.isCurrentNav(navItems),is(true));
    }
    @ParameterizedTest
    @MethodSource("personalUserData")
    public void getUserInfo(User user,PersonalInfoTextTitle personalInfoTextTitle){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        PersonalInfo personalInfo=userPage.goToPersonalInfo();
        assertThat(personalInfo.isVisibleInfo(),is(true));
        assertThat(personalInfo.isEnabledButtonsInfo(),is(true));
        assertThat(personalInfo.isCurrentTitles(personalInfoTextTitle),is(true));
        assertThat(personalInfo.isCurrentUser(user),is(true));
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
        personalInfo.isCurrentName(newUserName);
        personalInfo.goToUserName();
    }
}
