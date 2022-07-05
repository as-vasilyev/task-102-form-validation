import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FormValidation {

    WebDriver driver;
    @Before
    public void BeforeClass(){
        driver = new ChromeDriver();
        driver.get("file:///C:/html/form.html");
    }




    @Test
    public void insertValues(){
        driver.findElement(By.id("tbLName")).sendKeys("Ivanov");
        driver.findElement(By.id("tbFName")).sendKeys("Peter");
        driver.findElement(By.id("radioM")).click();
    }

    void validateLabel(String elementId, String actualValue){
        elementId = driver.findElement(By.id(elementId)).getText();
        Assert.assertEquals(elementId, actualValue);
    }

    void validateValue(String elementId, String actualValue){
        elementId = driver.findElement(By.id(elementId)).getAttribute("value");
        Assert.assertEquals(elementId, actualValue);
    }

    @Test
    public void validateLabels(){
        validateLabel("lblFName", "Имя");
        validateLabel("lblLName", "Фамилия");
        validateLabel("lblFName", "Имя");
        validateLabel("lblGender", "Пол");
        validateLabel("btnOrder", "Заказать");
    }

    @Test
    public void validateInputs(){
        insertValues();
        validateValue("tbFName", "Peter");
        validateValue("tbLName", "Ivanov");
        WebElement radioButton = driver.findElement(By.id("radioM"));
        Assert.assertTrue(radioButton.isSelected());
    }

    @After
    public void afterClass(){
        driver.quit();
    }
}
