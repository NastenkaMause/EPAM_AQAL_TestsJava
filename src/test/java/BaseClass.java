import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

    WebDriver driver;
    String base_URL = "https://www.olx.ua/";

    @BeforeClass
    public void SetUpFeature()
    {
        driver = new ChromeDriver();
        driver.navigate().to(base_URL);
    }

    @AfterClass
    public  void TearDownFeature()
    {
        driver.close();
    }
}
