import core.Compiler;
import dao.FileDao;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        FileDao fileDao = new FileDao("config.txt");
        Compiler compiler = new Compiler(new FirefoxDriver());
        compiler.webExecute(fileDao.getDataTransfer());
    }
}
