import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class TrainsList extends PageObject{
    public TrainsList(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='pic-wrap']")
    private WebElement siteLogo;

    @FindBy(xpath = "//span[@class='train-route']")
    private WebElement resLink;

    @FindBy(xpath = "//div[@class='sch-title__title h2']")
    private WebElement nameOfTrain;

    @FindBy(xpath = "//div[@class='sch-title__descr']")
    private WebElement daysOfTrips;

    public void writeResults()
    {
        List<WebElement> train = driver.findElements(By.xpath("//span[@class='train-route']"));
        List<WebElement> time = driver.findElements(By.xpath("//div[@class='sch-table__time train-from-time']"));
        for ( WebElement trainName: train) {

            for ( WebElement trainTime: time) {

                System.out.println(trainName.getText() + "-" + trainTime.getText());
            }
        }
    }

    public void openLink()
    {
        resLink.click();
    }

    public void checkNameOfTrain()
    {
        ExpectedConditions.visibilityOf(en_change_language_button);
        Assert.assertTrue(nameOfTrain.isDisplayed());
    }

    public void checkDaysOfTrips()
    {
        Assert.assertTrue(daysOfTrips.isDisplayed());
    }

    public void clickOnLogo()
    {
        siteLogo.click();
    }

}
