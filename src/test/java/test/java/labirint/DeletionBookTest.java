package test.java.labirint;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;



public class DeletionBookTest {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void deletionBookTest() throws Exception {
    wd.get("https://www.labirint.ru/");
    wd.findElement(By.cssSelector("span.js-b-autofade-text > span")).click();
    wd.findElement(By.id("g-recap-1-btn")).click();
    wd.findElement(By.cssSelector("span.b-header-b-personal-e-icon-count-m-cart.basket-in-cart-a")).click();
    wd.findElement(By.cssSelector("span.btn.btn-lessen.btn-lessen-cart")).click();
   // assertTrue(closeAlertAndGetItsText().matches("^Удалить товары из корзины[\\s\\S]$"));
    wd.findElement(By.cssSelector("span.js-b-autofade-text > span")).click();
    wd.findElement(By.linkText("Выход")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }


}
