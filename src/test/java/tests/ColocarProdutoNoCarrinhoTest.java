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
import suporte.Generator;
import suporte.Screenshot;
import suporte.Web;

import static org.junit.Assert.assertEquals;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "src/test/resources/produtosParaAdicionarNoCarrinho.csv")
public class ColocarProdutoNoCarrinhoTest {
    public WebDriver navegador;
    @Rule
    public TestName test = new TestName();
    @Before
    public void setup(){
        navegador = Web.abrirBrowserStack();
    }
    @Test
    public void testColocarProdutoNocarrinho(@Param(name="produtoPesquisa")String produtoPesquisa){
        navegador.findElement(By.id("h_search-input")).sendKeys(produtoPesquisa);
        navegador.findElement(By.id("h_search-btn")).click();
        navegador.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[3]/div[3]/div[1]/div/a/span[1]")).click();
        navegador.findElement(By.linkText("comprar")).click();
        navegador.findElement(By.linkText("continuar")).click();
        WebElement tituloCarrinho = navegador.findElement(By.xpath("//section/section/header/h2[@class=\"page-title\"]"));
        String textoTitulo = tituloCarrinho.getText();
        assertEquals("minha cesta",textoTitulo);

        String screenshotArquivo = "C:\\Users\\andre\\IdeaProjects\\MercadoLivreTests\\screenshot\\"+ Generator.dataHoraParaArquivo() + test.getMethodName()+ ".png";
        Screenshot.tirarPrint(navegador, screenshotArquivo);

    }
    @After
    public void tearDown(){
        navegador.quit();
    }

}
