import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class Google extends PageObject {

    public Google(WebDriver driver) {
        super(driver);
    }


    @FindBy(name = "q")
   private WebElement searchField;

    @FindBy(xpath = "//*[text()='https://www.rw.by']")
    private WebElement result;

    @FindBy(xpath = "//div[@class='top-lang__item']//a[@href='/en/']")
    private WebElement en_change_language_button;

    public void enterSearchRequest(){
    this.searchField.sendKeys(Utils.requestForGoogle, Keys.ENTER);
}
    public void clickOnResult(){
    this.result.click();
}
    public void checkEnLanguageButton(){
        ExpectedConditions.elementToBeClickable(en_change_language_button);
        Assert.assertTrue(en_change_language_button.isDisplayed());
    }


}
