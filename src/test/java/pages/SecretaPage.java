package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretaPage extends BasePage{

    public SecretaPage(WebDriver driver) {
        super(driver);
    }
    public MePage ClicarMe(){
        driver.findElement(By.className("me")).click();
        return new MePage(driver);
    }
}

