package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://ecommercepractice.letskodeit.com/");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testLoginValidUser() {
        loginPage.login("test@email.com", "abc123");
        Assert.assertTrue(homePage.getTitle().contains("My Account"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}