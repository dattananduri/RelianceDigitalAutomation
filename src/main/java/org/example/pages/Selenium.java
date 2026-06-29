package org.example.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

    public static void main(String[] args) throws Exception {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.reliancedigital.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



        WebElement ele = driver.findElement(
                By.xpath("//input[@aria-label = 'Search Products & Brands']"));

        ele.click();
        ele.sendKeys("Laptop");

        ele.sendKeys(Keys.ENTER);

        Thread.sleep(3000);

        driver.findElement(
                By.xpath("//div[@aria-label='toggle Brand']")
        ).click();

        WebElement minPrice = driver.findElement(
                By.xpath("//input[@aria-label='Enter minimum value']")
        );

        minPrice.sendKeys("40000");


        Thread.sleep(3000);

        WebElement firstProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("(//a[contains(@class,'product-card-image')])[1]")
                )
        );

        String productName = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div[4]/div/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/a/div[2]")
        ).getText();

        String productPrice = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div[4]/div/div/div[1]/div/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/a/div[3]/div[1]")
        ).getText();


        firstProduct.click();

        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            driver.switchTo().window(win);
        }

        Thread.sleep(5000);



        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement addToCart = driver.findElement(
                By.cssSelector(".button.add-card-btn.base-btn.primary.sm")
        );

        js.executeScript("arguments[0].scrollIntoView();", addToCart);

        Thread.sleep(3000);

        js.executeScript("arguments[0].click();", addToCart);

        driver.findElement(By.xpath("//*[@aria-label='goto cart']")).click();



        String cartProductName = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div[4]/div/div/div/div/div/div[3]/div[1]/div[3]/div/div/div/div/div[1]/div[2]/div[1]/a")
        ).getText();

        String cartProductPrice = driver.findElement(
                By.xpath("//*[@id=\"app\"]/div/div/div[4]/div/div/div/div/div/div[3]/div[1]/div[3]/div/div/div/div/div[1]/div[2]/div[3]/div/div[1]/div[1]/div[1]/span")
        ).getText();

        if(productName.equals(cartProductName))
        {
            System.out.println("Product Name Matched");
        } else
        {
            System.out.println("Product Name Not Matched");
        }

        if(productPrice.equals(cartProductPrice))
        {

            System.out.println("Product Price Matched");
        }
        else
        {
            System.out.println("Product Price Not Matched");
        }

        driver.quit();
    }
}