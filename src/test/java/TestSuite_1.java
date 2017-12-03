import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestSuite_1 extends BaseClass{

    @Test
    public void TestCase1_01()
    {
        Assert.assertTrue("Check 'Мой профиль' is present",driver.findElements(By.xpath("//span[@class='link inlblk']/strong")).size()>0);
        Assert.assertTrue("Two elements 'Популярные запросы' found",driver.findElements(By.xpath("//*[contains(text(),'Популярные запросы')]")).size()==2);
    }

    @Test
    public void TestCase1_02()
    {
        WebElement language = driver.findElement(By.xpath("//*[@id='changeLang']"));
        language.click();
        language = driver.findElement(By.cssSelector(".lang-selector span"));
        Assert.assertEquals("мова",language.getText());
    }

    @Test
    public void TestCase1_03()
    {
        driver.findElement(By.id("headerSearch")).sendKeys("автомобили");
        driver.findElement(By.id("submit-searchmain")).click();
    }

    @Test
    public void TestCase1_04()
    {
        driver.findElement(By.id("headerSearch")).sendKeys("автомобили");
        driver.findElement(By.id("submit-searchmain")).click();
        Assert.assertTrue(driver.findElements(By.xpath("//table[contains(@class,'offers--top')]")).size()>0);
        Assert.assertTrue(driver.findElements(By.xpath("//div[contains(@class,'pager')]//span[text()='1']")).size()>0);
    }

    @Test
    public void TestCase1_05()
    {
        driver.findElement(By.id("headerSearch")).sendKeys("автомобили");
        driver.findElement(By.id("submit-searchmain")).click();
        List<WebElement> firstElementsColl = driver.findElements(By.cssSelector(".offer a>strong"));
        String[] firstSearchTexts = new String[2];
        firstSearchTexts[0] = firstElementsColl.get(0).getText();
        firstSearchTexts[1] = firstElementsColl.get(1).getText();
        List<WebElement> ad = driver.findElements(By.xpath("//*[@id=\"paramsListOpt\"]/div/div[3]/div[2]/div[2]/span"));
        if (ad.size()>0)
            ad.get(0).click();
        driver.findElement(By.xpath("//*[@id=\"topLink\"]/div[1]/ul[1]/li[1]/a")).click();
        List<WebElement> secondElementsColl = driver.findElements(By.cssSelector(".offer a>strong"));
        Assert.assertNotEquals(firstSearchTexts[0], secondElementsColl.get(0).getText());
        Assert.assertNotEquals(firstSearchTexts[1], secondElementsColl.get(1).getText());
    }
}
