package com.ass.two;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngTwo {
	private  WebDriver     driver;
    private  WebDriverWait wait;
    final private String  URL1 = "https://www.fb.com";
    @BeforeClass
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        }
    @AfterClass
    public void quitDriver() {
        driver.quit();
    }
  @Test
    public void fbSignup() throws InterruptedException {
	  driver.navigate().to(URL1);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated (By.id("email")));
        Thread.sleep(1000);
        driver.findElement(By.linkText("Create new account")).click();	
        Thread.sleep(10000);
        driver.findElement(By.name("firstname")).sendKeys("xyz");
        driver.findElement(By.name("lastname")).sendKeys("abc");
        driver.findElement(By.name("reg_email__")).sendKeys("7869084527");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Password@123");
        Select date = new Select(driver.findElement(By.id("day")));
        date.selectByVisibleText("24");
        Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Dec");
        Thread.sleep(1000);
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("2001");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.partialLinkText("Sign")).click();
        Thread.sleep(1000);
        if(driver.findElement(By.partialLinkText("We couldn't create your account")).isDisplayed())
        {
        	System.out.println("Account creation unsccessful");
        }
        else
        	System.out.println("Accpnt is sccessfully created");
        }
        
}