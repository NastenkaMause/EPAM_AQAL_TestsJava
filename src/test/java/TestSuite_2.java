import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestSuite_2 extends BaseClass{

    @Test
    public void TestCase2_01()
    {
        driver.findElement(By.xpath("//span[@class='link inlblk']/strong")).click();
        Assert.assertEquals("",driver.findElement(By.name("login[email_phone]")).getText());
        Assert.assertEquals("",driver.findElement(By.name("login[password]")).getText());
        Assert.assertTrue(driver.findElement(By.id("checkbox_user-remember")).isSelected());
    }

    @Test
    public void TestCase2_02()
    {
        driver.findElement(By.xpath("//span[@class='link inlblk']/strong")).click();
        driver.findElement(By.name("login[email_phone]")).sendKeys("емайл");
        driver.findElement(By.name("login[password]")).sendKeys("пароль");
        Assert.assertTrue(driver.findElement(By.xpath("//label[@class='error']")).isDisplayed());
    }
}
