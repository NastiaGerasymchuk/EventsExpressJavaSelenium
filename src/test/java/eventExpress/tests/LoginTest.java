package eventExpress.tests;
import eventExpress.pages.HomePage;
import eventExpress.pages.LoginForm;
import eventExpress.selectorData.LoginSelector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {
    public LoginTest(){
        super();
    }
    private static Stream<Arguments> loginTextData() {

        return Stream.of(
                Arguments.of(new ArrayList<String>() {
                    {
                        add(LoginSelector.LOGIN_BUTTON_TEXT);
                                add(LoginSelector.REGISTER_BUTTON_TEXT);
                                add(LoginSelector.EMAIL_PLACEHOLDER);
                                add(LoginSelector.PASSWORD_PLACEHOLDER);
                                add(LoginSelector.CLEAR_BUTTON_TEXT);
                                add(LoginSelector.SIGN_IN_BUTTON_TEXT);
                                add(LoginSelector.FACEBOOK_BUTTON_TEXT);
                                add(LoginSelector.GOOGLE_BUTTON_TEXT);
                                add(LoginSelector.FORGOT_PASSWORD_BUTTON_TEXT);
                                add(LoginSelector.CANCEL_BUTTON_TEXT);

                    }
                })
                );


    }
    @ParameterizedTest
    @MethodSource("loginTextData")
    public void isPresentLoginForm(List<String> items){
        HomePage homePage=new HomePage(driver);
        LoginForm loginForm=homePage.signInClick();
        assertThat(loginForm.isPresentElements(),is(true));
        assertThat(loginForm.isCurrentText(items),is(true));
        assertThat(loginForm.isBeginEnabled(),is(true));
    }

}
