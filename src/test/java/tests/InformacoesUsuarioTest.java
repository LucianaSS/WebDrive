package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuarioTest.csv")
public class InformacoesUsuarioTest {
    private WebDriver driver;
    @Rule
    public TestName test = new TestName();
    @Before
    public void setUp(){
        driver = Web.createChrome();


        //Clicar no link que possui o texto "Sign in"
        driver.findElement(By.linkText("Sign in")).click();

        //Identificando o formulario de login
        WebElement formularioSignInBox = driver.findElement(By.id("signinbox"));

        //Digitar no campo com name "login" que está dentro do campo Id "signinbox" "julio0001"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name "password" que está dentro do campo Id "signinbox" "123456"
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");
        //Clicar com no texto "SIGN IN"
        driver.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento "class me" tem o texto "Hi,Julio"
        WebElement me = driver.findElement(By.className("me"));
        String textoNoElementoMe = me.getText();
        assertEquals("Hi, Julio", textoNoElementoMe);

        //Clicar em um link que possui a class "me"
        driver.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto "More data about you"
        driver.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void testAdicionarUmainformacaoAdicionalDoUsuario(@Param(name="tipo")String tipo, @Param(name = "contato") String contato, @Param(name = "mensagem") String mensagemEsperada) {


        //Clicar no botão através do seu xpath //button[@data-target='addmoredata']
        driver.findElement(By.xpath("//button[@data-target='addmoredata']")).click();

        //Identificar a popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = driver.findElement(By.id("addmoredata"));

        //Na combo de name type escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);

        //No campo "contact" digitar "+5511999999999"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);

        //Clicar no link de text "SAVE" que está na popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de id "toast-container" validar que o texto é "Your contact has been added!"
        WebElement mensagemPop = driver.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText() ;
        assertEquals(mensagemEsperada, mensagem);

    }
     @Test
     public void removerUmContatoDeUmUsuario(){
         //clicar no elemento pelo seu xpath span
        ///driver.findElement(By.xpath("//*[@id=\"moredata\"]/div[1]/ul/li[440]/span")).click();
        driver.findElement(By.xpath("//span[text()=\"+5561997975522\"]/following-sibling::a")).click();

         //*[@id="moredata"]/div[1]/ul/li[431]/a/i
         //confirmar a janela java script
         driver.switchTo().alert().accept();
         //validar que a mensagem apresentada foi "Rest in peace, dear phone!"
         WebElement mensagemPop = driver.findElement(By.id("toast-container"));
         String mensagem = mensagemPop.getText() ;
         assertEquals("Rest in peace, dear phone!", mensagem);
         String screenshotArquivo = "C:\\Users\\daniel-diogo\\testes" + Generator.dataHoraParaArquivo() + test.getMethodName()+".png";
         Screenshot.tirar(driver, screenshotArquivo);

         //aguardar 10 segundos até que a janela desapareça
         WebDriverWait Aguardar = new WebDriverWait(driver,10);
         Aguardar.until(ExpectedConditions.stalenessOf(mensagemPop));
         //Clicar no link com texto "Logout"
         driver.findElement(By.linkText("Logout")).click();
     }
       @After
        public void tearDown(){
       // driver.quit();
   }
}
