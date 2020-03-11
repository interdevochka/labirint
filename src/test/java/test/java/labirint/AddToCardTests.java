package test.java.labirint;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;


public class AddToCardTests {
  private WebDriver wd;


  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new InternetExplorerDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    login();
  }

  private void login() throws InterruptedException {
    wd.get("https://www.labirint.ru/");
    wd.findElement(By.cssSelector("span.js-b-autofade-text > span")).click();
    wd.findElement(By.id("g-recap-1-btn")).click();
    wd.findElement(By.xpath("(//input[@name='code'])")).sendKeys("F940-4DA5-870F");
    wd.findElement(By.xpath("(//input[@type='submit'])")).click();
    Thread.sleep(6000);
  }

  @Test
  public void testAddToCard() throws Exception {

    searchBook("Java");
    addToBasket();
    goToBasket();
    //todo проверить наличие слова Java на странице корзины
    logout();
  }

  private void goToBasket() {
    wd.findElement(By.cssSelector("span.b-header-b-personal-e-wrapper-m-closed > span.b-header-b-personal-e-icon-count-m-cart.basket-in-cart-a")).click();
  }

  private void addToBasket() {
    wd.findElement(By.xpath("(//a[@class='btn buy-link btn-primary'])")).click();
  }

  private void searchBook(String bookName) {
    wd.findElement(By.id("search-field")).click();
    wd.findElement(By.id("search-field")).clear();
    wd.findElement(By.id("search-field")).sendKeys(bookName);
    wd.findElement(By.id("searchform")).submit();
  }

  private void logout() {
    wd.findElement(By.xpath("(//a[@href='/authorization/logout/'])")).click();
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
