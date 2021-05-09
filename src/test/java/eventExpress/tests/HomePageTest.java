package eventExpress.tests;

import eventExpress.data.NavData;
import eventExpress.pages.HomePage;
import eventExpress.selectorData.LeftNavSelector;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

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
        assertThat(homePage.isSignInButton(),is(true));
        assertThat(homePage.isCurrentNav(homeMenu),is(true));
    }
}
