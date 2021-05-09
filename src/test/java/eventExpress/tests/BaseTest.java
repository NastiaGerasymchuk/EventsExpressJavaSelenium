package eventExpress.tests;
import eventExpress.configure.BrawserConfigure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseTest {
    protected  static WebDriver driver;

    @BeforeAll
    public static void setup(){
        System.setProperty(BrawserConfigure.BRAWLER_NAME, BrawserConfigure.DESKTOP_PATH);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterAll
    public static void TearDown(){

         //driver.close();
    }




}

