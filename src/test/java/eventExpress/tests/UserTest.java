package eventExpress.tests;

import eventExpress.data.NavData;
import eventExpress.data.UserData;
import eventExpress.models.User;
import eventExpress.pages.HomePage;
import eventExpress.pages.LoginForm;
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
                Arguments.of(new User(UserData.EMAIL,UserData.PASSWORD,UserData.NAME), NavData.getUserNavItems())
        );


    }

    @ParameterizedTest
    @MethodSource("loginTextData")

    public void GoToUserProfile(User user,List<String> navItems){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        String email=user.getEmail();
        String password=user.getPassword();
        String userName=user.getName();
        UserPage userPage=loginForm.login(email,password);
        assertThat(userPage.isHeaderProfileExist(),is(true));
        assertThat(userPage.isCurrentUserName(userName),is(true));
        assertThat(userPage.isCurrentNav(navItems),is(true));
        //PersonalInfo personalInfo=userPage.goToPersonalInfo();
    }
}
