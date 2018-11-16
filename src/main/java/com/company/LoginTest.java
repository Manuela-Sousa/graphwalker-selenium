package com.company;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


@GraphWalker
public class LoginTest extends ExecutionContext implements LoginSearch {
    WebDriver driver = null;

    @Override
    public void e_SearchSapoEmailPage() {
        driver.get("http://www.sapo.pt/");
    }

    @Override
    public void e_CleanCache() {
        driver.manage().deleteAllCookies();
    }

    @Override
    public void v_SapoSearchResult() {
        System.out.println("Obtido o resultado da pesquisa!");
    }

    @Override
    public void v_BrowserNotStarted() {
        System.out.println("O browser ainda não foi iniciado!");
    }

    @Override
    public void v_SearchResult() {
        System.out.println("Efetuar pesquisa!");
    }

    @Override
    public void e_Logout() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='applogout']"))).click();
        driver.manage().deleteAllCookies();
    }

    @Override
    public void v_LoginPrompted() {
        System.out.println("Efetuar login!");
    }

    @Override
    public void e_ClickOpenSapo() {
        WebElement username_txt = driver.findElement(By.xpath("//*[@id='bsu-todo-o-sapo']/ul/li[1]/a"));
        username_txt.click();

    }

    @Override
    public void e_ValidCredentials() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        Boolean isPresent = driver.findElements(By.xpath("//*[@id='sapo_widget_login_form']/fieldset/div[1]/a")).size() > 0;
        if (isPresent == true) {
            WebElement box = driver.findElement(By.xpath("//*[@id='sapo_widget_login_form']/fieldset/div[1]/a"));
            box.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-email']"))).sendKeys("testesgraphwalker@sapo.pt");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-password']"))).sendKeys("Testesgraphwalker!199");
            WebElement button_login = driver.findElement(By.xpath("//*[@class='ink-button green large-100']"));
            button_login.click();
        } else {
            WebElement username_txt = driver.findElement(By.xpath("//*[@id='text-email']"));
            username_txt.clear();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-email']"))).sendKeys("testesgraphwalker@sapo.pt");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-password']"))).sendKeys("Testesgraphwalker!199");
            WebElement button_login = driver.findElement(By.xpath("//*[@class='ink-button green large-100']"));
            button_login.click();
        }


    }

    @Override
    public void v_BrowserOpened() {
        System.out.println("O browser está agora aberto!");
    }

    @Override
    public void e_Exit() {
        driver.close();
    }

    @Override
    public void e_OpenBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/manue/testAutomation_GraphWalker_MasterThesis/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Override
    public void v_EmailOpened() {
        System.out.println("O email foi aberto!");

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='horde-subnavi-point']/a[contains(text(), 'Caixa de Entrada')]")));


    }

    @Override
    public void e_searchEmail() {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        WebElement box = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='horde-subnavi-point']/a[contains(text(), 'Caixa de Entrada')]")));
        box.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='horde-search-input']"))).sendKeys("sapo");
        WebElement enter_search = driver.findElement(By.xpath("//*[@id='horde-search-input']"));
        enter_search.sendKeys(Keys.ENTER);

    }

    @Override
    public void e_CloseBrowser() {
        driver.quit();
    }

    @Override
    public void v_LoginMade() {
        System.out.println("O login foi efetuado!");
    }

    @Override
    public void v_CacheCleaned() {
        System.out.println("A cache foi limpa");
    }

    @Override
    public void e_Init() {
        System.out.println("Início da execução");
    }

    @Override
    public void v_SapoPageOpened() {
        System.out.println("Página sapo aberta!");
    }

    @Override
    public void e_ClickToOpen() {


        List<WebElement> email = driver.findElements(By.xpath("//*[@id='VProw_3']/div[3]"));

        for (WebElement emailsub : email) {
            if (emailsub.getText().equals("Bem-vindo ao SAPO Mail") == true) {
                emailsub.click();
                break;
            }
        }
    }

    @Override
    public void e_ClickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='loginModalTrigger']"))).click();

    }

    @Override
    public void e_InvalidCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        Boolean isPresent = driver.findElements(By.xpath("//*[@id='sapo_widget_login_form']/fieldset/div[1]/a")).size() > 0;

        if (isPresent == true) {
            WebElement box = driver.findElement(By.xpath("//*[@id='sapo_widget_login_form']/fieldset/div[1]/a"));
            box.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-email']"))).sendKeys("sdfsdfsdf@sapo.pt");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-password']"))).sendKeys("sdfsdf!dsfs");

            WebElement button_login = driver.findElement(By.xpath("//*[@class='ink-button green large-100']"));
            button_login.click();
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-email']"))).sendKeys("sdfsdfsdf@sapo.pt");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='text-password']"))).sendKeys("sdfsdf!dsfs");

            WebElement button_login = driver.findElement(By.xpath("//*[@class='ink-button green large-100']"));
            button_login.click();
        }

        WebElement errorMessage = driver.findElement(By.xpath("//*[@class='login_failed'][contains(text(), 'O login falhou.')]"));
        Assert.assertEquals(errorMessage.getText(), "O login falhou.");

    }

}
