import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainTest {
    private WebDriver driver;

    @Test
    public void main() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
        String filmName = "The Circus";
        driver = new ChromeDriver();

        driver.get("https://www.imdb.com");

        driver.manage().window().maximize();

        driver.findElement(By.id("imdbHeader-navDrawerOpen--desktop")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/oscars/?ref_=nv_ev_acd']")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("1929")).click();
        Thread.sleep(3000);

        Thread.sleep(3000);

        driver.findElement(By.linkText(filmName)).click();
        Thread.sleep(3000);

        String director,writer,star1,star2,star3;

        director = driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[1]/section[1]/section[1]/div[3]/section[1]/section[1]/div[3]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/ul[1]/li[1]/a[1]")).getText();
        writer = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        star1 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        star2 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).getText();
        star3 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")).getText();


        searchFilm(filmName);
        Thread.sleep(3000);
        checkFilmDetails(director, star1, star2, star3, writer);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ipc-title ipc-title--section-title ipc-title--base ipc-title--on-textPrimary PhotosHeader__PhotoSectionTitle-pzwaan-0 fwspOK ipc-title-link-wrapper']//h3[@class='ipc-title__text']")).click();
        Thread.sleep(3000);
        checkImages();
        Thread.sleep(3000);
        driver.findElement(By.className("prevnext")).click();
        Thread.sleep(3000);
        checkImages();
        Thread.sleep(3000);
        System.out.println("Test passed succesfully");
        Thread.sleep(3000);
        driver.quit();

    }

    public void searchFilm(String filmName) throws InterruptedException {
        driver.findElement(By.id("home_img_holder")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("q")).sendKeys(filmName); // elementi bul.yazdır
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='suggestion-search-button']//*[local-name()='svg']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText(filmName)).click();
        Thread.sleep(3000);

    }

    public void checkFilmDetails(String director, String star1, String star2, String star3, String writer) {

        assertEquals(director,"Charles Chaplin" );
        System.out.println(director);

        assertEquals(writer, "Charles Chaplin");
        System.out.println(writer);

        assertEquals(star1, "Charles Chaplin");
        System.out.println(star1);
        assertEquals(star2, "Merna Kennedy");
        System.out.println(star2);
        assertEquals(star3, "Al Ernest Garcia");
        System.out.println(star3);
        System.out.println("All values as expected");


    }

    public void checkImages() throws InterruptedException {

        Thread.sleep(5000);

        String homePage = "http://www.imdb.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {
                //System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            } else if (url.startsWith("https://www.imdb.com/title/tt0018773/mediaviewer/rm")) {
                System.out.println("It's an image from IMDB");
                continue;
            } else if (!url.startsWith(homePage)) {
                //System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }


            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if (respCode >= 400) {
                    System.out.println(url + " is a broken link");
                } else {
                    System.out.println(url + " is a valid link");
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
