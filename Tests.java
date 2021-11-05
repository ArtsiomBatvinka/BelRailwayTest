import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;

public class Tests {
private static  WebDriver driver;
@BeforeMethod

    public static void setup()

{
    if(Utils.Browser == "Chrome"){
        driver = new ChromeDriver();
       System.setProperty("webdriver.chrome.driver", Utils.ChromeDriverLocation);


   }
     else if(Utils.Browser == "Firefox"){
        WebDriver driver = new FirefoxDriver();
       System.setProperty("webdriver.firefox.driver", Utils.FirefoxDriverLocation);


   }
     else {
      System.out.println("Please, check the Browser name");
     }

    driver.manage().window().maximize();
}


    @Test(priority = 1)
    public void Search_In_Google(){
    driver.get(Utils.GoogleUrl);
    Google google = new Google(driver);
    google.enterSearchRequest();
    google.clickOnResult();
    google.checkEnLanguageButton();
    }


    @Test(priority = 2)
        public void Changing_Language_And_Check_News()
    {
            driver.get(Utils.BelRailUrl);
            MainPage mainPage = new MainPage(driver);
            mainPage.changeLanguageToEN();
            mainPage.checkNumberOfNews();
            mainPage.checkCopyright();
            mainPage.checkButtons();


        }

        @Test(priority = 3)
        public void Work_With_Search()
        {
            driver.get(Utils.BelRailUrl);
            SearchPage searchPage = new SearchPage(driver);
            searchPage.enterRandomString();
            searchPage.checkUrl();
            searchPage.checkNotFoundText();
            searchPage.clearInput();
            searchPage.enterValidLocation();
            searchPage.clickInputButton();
            searchPage.checkNumberOfLinks();
            searchPage.writeTextFromLinks();

        }

        @Test(priority = 4)
        public void Work_With_Calendar()
        {
            driver.get(Utils.BelRailUrl);
            MainPage mainPage = new MainPage(driver);
            Google google = new Google(driver);
            TrainsList trainsList = new TrainsList(driver);
            google.checkEnLanguageButton();
            mainPage.enterTripLocations();
            mainPage.enterDate();
            mainPage.clickSearchButton();
            trainsList.writeResults();
            trainsList.openLink();
            trainsList.checkNameOfTrain();
            trainsList.checkDaysOfTrips();
            trainsList.clickOnLogo();

        }
        @AfterMethod
        public static void TearDown(){
       driver.manage().deleteAllCookies();
       driver.quit();
   }
}
