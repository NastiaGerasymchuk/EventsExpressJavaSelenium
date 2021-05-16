package eventExpress.tests;
import eventExpress.pages.HomePage;
import eventExpress.pages.LoginForm;
import eventExpress.selectorData.LoginSelector;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static utils.EqualsSanitilize.equalsSanitilize;

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
        var loginForm=homePage.signInClick();
        assertThat(loginForm, instanceOf(LoginForm.class));
        assertAll("enabled buttons",
                ()->assertThat("login",loginForm.isEnabledLoginBtn(),is(true)),
                ()->assertThat("register",loginForm.isEnabledRegisterBtn(),is(true)),
                ()->assertThat("clear",loginForm.isEnabledClearButton(),is(false)),
                ()->assertThat("sign in",loginForm.isEnabledSingInButton(),is(true)),
                ()->assertThat("facebook",loginForm.isEnabledFacebookButton(),is(true)),
                ()->assertThat("google",loginForm.isEnabledGoogleButton(),is(true)),
                ()->assertThat("password",loginForm.isEnabledForgotPasswordButton(),is(true)),
                ()->assertThat("cancel",loginForm.isEnabledCancelButton(),is(true))
                );
        assertAll("enabled fields",
                ()->assertThat("email",loginForm.isEnabledEmailInput(),is(true)),
                ()->assertThat("password",loginForm.isEnabledPasswordInput(),is(true))
        );
        assertAll("visible",
                ()->assertThat("email",loginForm.isVisibleLoginButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleRegisterButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleEmailInput(),is(true)),
                ()->assertThat("password",loginForm.isVisiblePasswordInput(),is(true)),
                ()->assertThat("password",loginForm.isVisibleClearButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleSignInButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleFacebookButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleGoogleButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleForgotPasswordButton(),is(true)),
                ()->assertThat("password",loginForm.isVisibleCancelButton(),is(true))
        );
        List<String> loginElements=loginForm.getElementsText();
        assertThat("text is correct on login elements",items, equalsSanitilize(loginElements));
    }
}
