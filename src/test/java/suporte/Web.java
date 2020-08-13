package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class Web {
    public static final String USERNAME = "lucianasouza1";
    public static final String AUTOMATE_KEY = "9rCKykAyKT6h9mvwbx4D";
    public static final String URLBrowserStack = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

//    public static final String USERNAME = "lucianasouza1";
//    public static final String AUTOMATE_KEY = "9rCKykAyKT6h9mvwbx4D";
//    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//    public static final String URLBrowserStack = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome(){
        //abrindo o navegador
        System.setProperty("webdriver.chrome.driver","src/test/java/suporte/driver/chromedriver.exe");
        WebDriver driver  = new ChromeDriver();
        //navegando na pagina do Taskit
        driver.get("http://www.juliodelima.com.br/taskit");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }
    public static WebDriver createBrowserStack() throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability("os", "Windows");
//        caps.setCapability("os_version", "10");
//        caps.setCapability("browser", "Chrome");
//        caps.setCapability("browser_version", "80");
//        caps.setCapability("name", "lucianasouza1's First Test");
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "80");
        caps.setCapability("name", "lucianasouza1's First Test");

        WebDriver driver = new RemoteWebDriver(new URL(URLBrowserStack), caps);
        driver.manage().window().maximize();
        driver.get("http://www.juliodelima.com.br/taskit");



//        System.out.println(URLBrowserStack);
//
//        WebDriver driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL(URLBrowserStack),caps);
//            driver.manage().window().maximize();
//            driver.get("http://www.juliodelima.com.br/taskit");
//
//        }catch (MalformedURLException e){
//            System.out.println("Houveram problemas com a URL:"+e.getMessage());
//        }


        return driver;
    }
}

