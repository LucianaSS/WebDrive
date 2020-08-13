package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //private WebDriver driver; // atributo do tipo webdriver
    //public LoginPage(WebDriver driver){   //um construtor que recebe uma instância a esta propriedade interna
      //  this.driver = driver;
 //estrutura default de uma page do page object: todas as pages do page object terão um atributo do tipo webdriver, e
//um construtor que recebe uma instância a esta propriedade interna

    public LoginFormPage clicarSignIn(){
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginFormPage(driver);
    }
}

