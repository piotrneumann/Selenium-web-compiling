package core;

import dto.DataTransfer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.logging.Logger;

public class Compiler {

    protected final Logger logger = Logger.getLogger(getClass().getName());
    private WebDriver webDriver;
    private final String JBZD = "JBZD";
    private final String DEMOTYWATORY = "DEMOTYWATORY";
    private final String WIOCHA = "WIOCHA";


    public Compiler(WebDriver webDriver) {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        this.webDriver = webDriver;
    }

    public void webExecute(List<DataTransfer> dataTransferList) {
        dataTransferList.stream().forEach(dataTransfer -> {
            switch (dataTransfer.getKey()) {
                case JBZD: {
                    jbzdExecute(dataTransfer);
                    break;
                }
                case WIOCHA: {
                    wiochaExecute(dataTransfer);
                    break;
                }
            }
        });
    }

    private void jbzdExecute(DataTransfer dataTransfer) {
        try {
            webDriver.get(dataTransfer.getSite());
            webDriver.findElement(By.name("l_email")).sendKeys(dataTransfer.getLogin());
            webDriver.findElement(By.name("l_password")).sendKeys(dataTransfer.getPassword());
            webDriver.findElement(By.name("l_password")).sendKeys(Keys.ENTER);
            webDriver.findElement(By.className("button_button--SPx18r")).click();
            webDriver.findElement(By.xpath("//*[@data-container='upload-name']")).click();
            webDriver.findElement(By.xpath("//*[@data-container='upload-name']")).sendKeys(dataTransfer.getTitle());
            webDriver.findElement(By.xpath("//*[@data-container='upload-youtube-url']")).sendKeys(dataTransfer.getLink());
            webDriver.findElement(By.xpath("//textarea[@name='description']")).sendKeys(dataTransfer.getSubTitle());
            webDriver.findElement(By.xpath("//*[@class='ui-widget-content ui-autocomplete-input']")).sendKeys(dataTransfer.getTags());
            JavascriptExecutor jse = (JavascriptExecutor) webDriver;
            jse.executeScript("window.scrollBy(0,500)", "");
            webDriver.findElement(By.xpath("//button[@type='submit']")).click();
            webDriver.findElement(By.xpath("//button[@type='submit']")).click();
        } catch (Exception e) {
            logger.info("ERROR: " + JBZD);
            logger.info(e.getMessage());
        }

    }

    private void wiochaExecute(DataTransfer dataTransfer) {
        try {

        } catch (Exception e) {
            logger.info("ERROR: " + WIOCHA);
        }
    }
}
