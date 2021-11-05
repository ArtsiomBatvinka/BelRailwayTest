import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//div[@class='top-lang__item']//a[@href='/en/']")
    public WebElement en_change_language_button;
}
