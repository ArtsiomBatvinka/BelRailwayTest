import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class MainPage extends PageObject {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='pic-wrap']")
    private WebElement SiteLogo;

    @FindBy(xpath = "//div[@class='top-lang__item']//a[@href='/en/']")
    private WebElement en_change_language_button;

    @FindBy(xpath = "//div[@class='top-lang__item']//a[@href='/ru/']")
    private WebElement ru_change_language_button;

    @FindBy(xpath = "//div[@class='copyright']")
    private WebElement copyright;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Press center']")
    private WebElement pressCenter;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Passenger Services']")
    private WebElement passengerServices;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Freight']")
    private WebElement freight;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Corporate']")
    private WebElement corporate;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Contacts']")
    private WebElement contacts;

    @FindBy(xpath = "//div[@class='menu-items-wrap']//em//u//b[text()='Tickets']")
    private WebElement tickets;

    @FindBy(xpath = "//input[@id='acFrom']")
    private WebElement fromField;

    @FindBy(xpath = "//input[@id='acTo']")
    private WebElement toField;

    @FindBy(xpath = "//input[@class='type-text datepicker-popup hasDatepicker']")
    private WebElement dateField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;



     int newsNum = driver.findElements(By.xpath("//div[@class='index-news-list-wrap']//dd")).size();

    public void changeLanguageToEN(){
        this.en_change_language_button.click();
        ExpectedConditions.elementToBeClickable(en_change_language_button);
    }
    public void changeLanguageToRu(){
        this.en_change_language_button.click();
        ExpectedConditions.elementToBeClickable(ru_change_language_button);
    }

    public void checkNumberOfNews(){
        Assert.assertTrue(newsNum >= 4);

    }
    public void checkCopyright(){
        Assert.assertTrue(copyright.isDisplayed());
    }
    public void checkButtons(){
    Assert.assertTrue(pressCenter.isDisplayed());
    Assert.assertTrue(passengerServices.isDisplayed());
    Assert.assertTrue(tickets.isDisplayed());
    Assert.assertTrue(freight.isDisplayed());
    Assert.assertTrue(corporate.isDisplayed());
    Assert.assertTrue(contacts.isDisplayed());
    }

    public void enterTripLocations(){
        fromField.click();
        fromField.sendKeys(Utils.trainRequestFrom);
        toField.click();
        toField.sendKeys(Utils.trainRequestTo);
    }

    public void enterDate()
    {
        dateField.click();

        Calendar date = new GregorianCalendar();
        date.add(Calendar.DAY_OF_MONTH, 5);
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        dateField.sendKeys(dateFormat.format(date.getTime()), Keys.ENTER);

    }
    public void clickSearchButton()
    {
    searchButton.click();
    }






}
