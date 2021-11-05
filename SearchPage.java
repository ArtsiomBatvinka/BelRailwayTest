import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SearchPage extends PageObject{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='example gray']")
    private WebElement searchField;

    @FindBy(xpath = "//*[text()='К сожалению, на ваш поисковый запрос ничего не найдено.']")
    private WebElement notFoundText;

    String ran = new Random().ints(20, 65, 90)
            .mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining());

    @FindBy(xpath = "//input[@id='searchinpm']")
    private WebElement input;

    @FindBy(xpath = "//div[@class='search-button' ]/input")
    private WebElement inoutButton;

    public void enterRandomString()
    {

        searchField.sendKeys(ran, Keys.ENTER);
        System.out.println("Search request is: " + ran);
    }
    public void checkUrl()
    {
     Assert.assertEquals(driver.getCurrentUrl(),"https://www.rw.by/search/?s=Y&q=" + ran);
        System.out.println(driver.getCurrentUrl());
    }

    public void checkNotFoundText()
    {
        ExpectedConditions.elementToBeClickable(en_change_language_button);
    Assert.assertTrue(notFoundText.isDisplayed());
    }

    public void clearInput()
    {
    input.clear();}

    public void enterValidLocation() {
        input.sendKeys("Санкт-Петербург");
    }
    public void clickInputButton()
    {
        inoutButton.click();
    }

    public void checkNumberOfLinks()
    {

        ExpectedConditions.elementToBeClickable(en_change_language_button);
        int resultNum = driver.findElements(By.xpath("//ol[@class='search-result']//li")).size();
        System.out.println(resultNum);
        Assert.assertTrue(15 == resultNum);


    }
    public void writeTextFromLinks()
    {
        List<WebElement> res = driver.findElements(By.xpath("//ol[@class='search-result']//li//h3"));
        for ( WebElement we: res) {
            System.out.println(we.getText());
        }
    }

}
