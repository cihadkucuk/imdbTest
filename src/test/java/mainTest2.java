import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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

public class mainTest2 {
    private WebDriver driver;

    @Test
    public void main() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\ChromeDriver\\chromedriver.exe");
        String filmName = "The Jazz Singer";
        driver = new ChromeDriver();

        driver.get("https://www.imdb.com");

        driver.manage().window().maximize();

        driver.findElement(By.id("imdbHeader-navDrawerOpen--desktop")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@href='/oscars/?ref_=nv_ev_acd']")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("1929")).click();
        Thread.sleep(3000);


        driver.findElement(By.linkText(filmName)).click();
        Thread.sleep(3000);

        String director = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        String writer1 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        String writer2 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).getText();
        String writer3 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")).getText();
        String star1 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        String star2 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)")).getText();
        String star3 = driver.findElement(By.cssSelector("body > div:nth-child(2) > main:nth-child(3) > div:nth-child(1) > section:nth-child(4) > section:nth-child(1) > div:nth-child(4) > section:nth-child(1) > section:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(1) > li:nth-child(3) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")).getText();

        searchFilm(filmName);
        Thread.sleep(3000);

        checkFilmDetails(director, star1, star2, star3, writer1, writer2, writer3);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='ipc-title ipc-title--section-title ipc-title--base ipc-title--on-textPrimary PhotosHeader__PhotoSectionTitle-pzwaan-0 fwspOK ipc-title-link-wrapper']//h3[@class='ipc-title__text']")).click();
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
        driver.findElement(By.cssSelector("body > div:nth-child(13) > div:nth-child(1) > div:nth-child(2) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > a:nth-child(1)")).click();


    }
    public void checkFilmDetails(String director, String star1, String star2, String star3, String writer1, String writer2, String writer3) {

        assertEquals(director,"Alan Crosland" );
        System.out.println(director);

        assertEquals(writer1, "Samson Raphaelson");
        System.out.println(writer1);
        assertEquals(writer2, "Alfred A. Cohn");
        System.out.println(writer2);
        assertEquals(writer3, "Jack Jarmuth");
        System.out.println(writer3);

        assertEquals(star1, "Al Jolson");
        System.out.println(star1);
        assertEquals(star2, "May McAvoy");
        System.out.println(star2);
        assertEquals(star3, "Warner Oland");
        System.out.println(star3);

        System.out.println("All values as expected");


    }
    public void checkImages() throws InterruptedException {

        Thread.sleep(5000);

        String homePage = "http://www.imdb.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        //driver.get(homePage);
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();

        while (it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);

            if (url == null || url.isEmpty()) {
                //System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            } else if (url.startsWith("https://www.imdb.com/title/tt0018037/mediaviewer/rm")) {
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
