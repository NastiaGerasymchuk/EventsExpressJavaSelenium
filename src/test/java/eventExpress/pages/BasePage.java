package eventExpress.pages;

import eventExpress.configure.BrawserConfigure;
import eventExpress.enums.Gender;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(BrawserConfigure.SECONDS_WANTINGS));
        PageFactory.initElements(this.driver, this);
    }
    private void waitForElementToBeDisplayed(WebElement element) {
        ExpectedCondition<Boolean> elementIsDisplayed = arg0 -> element.isDisplayed();
        wait.until(elementIsDisplayed);
    }
    protected void click(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }
    private String getAttribute(WebElement webElement, String attribute){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attribute);

    }
    protected String getText(WebElement webElement){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }
    protected   void sendKeys(WebElement webElement ,String number){
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(number);

    }

    protected boolean isVisible(By locator){
        try {
            WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return webElement.isDisplayed();
        }
        catch (TimeoutException exception){
            return false;
        }

    }
    protected boolean isEnabled(By locator){
        try {
            WebElement webElement= wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return webElement.isEnabled();
        }
        catch (TimeoutException exception){
            return false;
        }

    }

    protected String getPlaceholder(WebElement webElement){
        String attribute="placeholder";
        return getAttribute(webElement,attribute);
    }

    protected List<String> getValuesGroupText(By element) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        List<String> values = new ArrayList<>();
        for (WebElement elem : elements) {
            values.add(elem.getText().trim());
        }
        return values;
    }
    protected boolean isEqualElements(String elem1,String elem2){
        return elem1.equalsIgnoreCase(elem2);
    }
    protected boolean isEnumElements(String gender){
      Gender res=  Arrays.stream(Gender.values())
                .filter(e -> e.name().equalsIgnoreCase(gender)).findAny().orElse(null);
      return res != null;
    }
    protected Gender getEnumElements(String gender){
        Gender res=  Arrays.stream(Gender.values())
                .filter(e -> e.name().equalsIgnoreCase(gender)).findAny().orElse(null);
        return res;
    }
    private static String
    removeNonAlphanumeric(String str)
    {
        str = str.replace(
                "0", "")
                .replace(
                "\\\\n", "");
        return str;
    }

    protected boolean equalsIgnoreCase(List<String> l1, List<String> l2) {
        if (l1.size() != l2.size()) {
            return false;
        }
        Iterator<String> i1=l1.iterator();
        Iterator<String> i2=l2.iterator();
        while(i1.hasNext()) {
            if (!removeNonAlphanumeric(i1.next()).trim().equalsIgnoreCase(removeNonAlphanumeric(i2.next()).trim())) {
                return false;
            }
        }
        return true;
    }



}
