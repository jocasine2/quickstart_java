// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class SIASTECConsultarlistadeprogramasTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }
  @Test
  public void sIASTECConsultarlistadeprogramas() {
    driver.get("https://idp.transferegov.sistema.gov.br/idp/");
    driver.findElement(By.linkText("Acesso livre")).click();
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.linkText("Consultar Programas")).click();
    vars.put("win8957", waitForWindow(2000));
    driver.switchTo().window(vars.get("win8957").toString());
    driver.findElement(By.id("consultarProgramaAtende")).click();
    driver.findElement(By.xpath("(//input[@id=\'consultarProgramaAtende\'])[2]")).click();
    driver.findElement(By.cssSelector("tr:nth-child(3) > .estados:nth-child(9) > #consultarEstadosHabilitado")).click();
    driver.findElement(By.xpath("(//input[@id=\'form_submit\'])[3]")).click();
    driver.findElement(By.linkText("2")).click();
    driver.findElement(By.linkText("3")).click();
    driver.findElement(By.linkText("4")).click();
    driver.findElement(By.linkText("5600020095503")).click();
  }
}
