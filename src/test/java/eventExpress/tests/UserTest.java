package eventExpress.tests;

import eventExpress.data.NavData;
import eventExpress.data.UserData;
import eventExpress.models.User;
import eventExpress.pages.HomePage;
import eventExpress.pages.LoginForm;
import eventExpress.pages.PersonalInfo;
import eventExpress.pages.UserPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserTest extends BaseTest{
    private static Stream<Arguments> loginTextData() {

        return Stream.of(
                Arguments.of(new User(UserData.EMAIL,UserData.PASSWORD,UserData.NAME,UserData.GENDER,UserData.BIRTHDAY,UserData.CATEGORIES,UserData.MANAGE_NOTIFICATIONS), NavData.getUserNavItems())
        );


    }

    @ParameterizedTest
    @MethodSource("loginTextData")
    public void goToUserProfile(User user,List<String> navItems){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        String userName=user.getName();
        UserPage userPage=loginForm.login(user);
        assertThat(userPage.isHeaderProfileExist(),is(true));
        assertThat(userPage.isCurrentUserName(userName),is(true));
        assertThat(userPage.isCurrentNav(navItems),is(true));
    }
    @ParameterizedTest
    @MethodSource("loginTextData")
    public void getUserInfo(User user){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        UserPage userPage=loginForm.login(user);
        PersonalInfo personalInfo=userPage.goToPersonalInfo();
        assertThat(personalInfo.isVisibleInfo(),is(true));
        assertThat(personalInfo.isEnabledButtonsInfo(),is(true));
        assertThat(personalInfo.isCurrentUser(user),is(true));
    }
}
