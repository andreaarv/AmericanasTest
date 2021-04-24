package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = System.getenv("andrarodrigues_5FinvO");
    public static final String AUTOMATE_KEY = System.getenv("VQ72axiQ2ByQEyXfzYzp");
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver abrirChrome(){
        System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        navegador.get("https://www.americanas.com.br/");
        return navegador;
    }

    public static WebDriver abrirBrowserStack(){
        DesiredCapabilities caps = new DesiredCapabilities();
       // caps.setCapability("browserstack.local", "true");
        caps.setCapability("browser", "chrome");
        caps.setCapability("browser_version", "60.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        WebDriver navegador = null;
        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
            navegador.get("https://www.americanas.com.br/");
        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL: " + e.getMessage());
        }

        return navegador;
    }

}
