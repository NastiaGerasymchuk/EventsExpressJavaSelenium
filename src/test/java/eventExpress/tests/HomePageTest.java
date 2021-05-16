package eventExpress.tests;

import eventExpress.data.NavData;
import eventExpress.pages.HomePage;
import eventExpress.testData.NavTitle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static utils.EqualsSanitilize.equalsSanitilize;

public class HomePageTest extends BaseTest {
    public HomePageTest(){
        super();
    }

    private static Stream<Arguments> homeNavData() {

        return Stream.of(
                Arguments.of(NavData.getHomeNavItems())

        );
    }
    @ParameterizedTest
    @MethodSource("homeNavData")
    public void ExistLeftNav(ArrayList<String> homeMenu){
        HomePage homePage=new HomePage(driver);
        assertThat(homePage.isLeftSideVisible(),is(true));
        assertThat(homePage.getSignInText(),is(equalToIgnoringCase(NavTitle.SIGN_IN_BUTTON_TEXT)));
        List<String> currentNav=homePage.getNavItems();
        assertThat("navigation panel for user is correct(full)",homeMenu, equalsSanitilize(currentNav));
    }
}
