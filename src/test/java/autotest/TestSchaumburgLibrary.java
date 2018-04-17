/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autotest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author thao.nguyen
 */
public class TestSchaumburgLibrary {
    WebDriver driver;
    
    public TestSchaumburgLibrary() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        driver = new FirefoxDriver();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSearch() {
        driver.get("https://www.schaumburglibrary.org");
        
        driver.findElement(By.id("edit-search-query")).sendKeys("netbeans");
        driver.findElement(By.id("edit-submit")).submit();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    }
/* 
    @Test
    public void testSearchArticles() {
        driver.get("https://www.schaumburglibrary.org");
        
        driver.findElement(By.id("edit-search-query")).sendKeys("netbeans");
        
        WebElement elem0 = driver.findElement(By.xpath("//*[@id=\"select2-edit-options-container\"]"));
        elem0.click();
        WebElement elem1 = elem0.findElement(By.xpath("//*[@id=\"select2-edit-options-results\"]"));
        elem1.click();
        WebElement elem2 = elem1.findElement(By.xpath("//*[@id=\"select2-edit-options-result-0d6e-articles\"]"));
        elem2.click();
               
        //driver.findElement(By.id("edit-submit")).submit();   
    }    
*/ 
    @Test
    public void testSort() {
        driver.get("https://catalog.schaumburglibrary.org/Search/Results?lookfor=netbeans");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Select elem = new Select(driver.findElement(By.id("sort_options_1")));
        elem.selectByVisibleText("Oldest First");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Select elem2 = new Select(driver.findElement(By.id("sort_options_1")));
        elem2.selectByVisibleText("Newest First");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Select elem3 = new Select(driver.findElement(By.id("sort_options_1")));
        elem3.selectByVisibleText("Author");
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        Select elem4 = new Select(driver.findElement(By.id("sort_options_1")));
        elem4.selectByVisibleText("Title");
     }    
}

