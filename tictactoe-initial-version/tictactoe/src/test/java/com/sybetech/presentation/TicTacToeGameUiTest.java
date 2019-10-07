package com.sybetech.presentation;

import com.sybetech.business.TicTacToeGame;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * System Test.
 * Works only after deployment
 */
public class TicTacToeGameUiTest {

    private WebDriver chrome;
    private TicTacToeGame game;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/web-drivers/chromedriver.exe");
        chrome = new ChromeDriver();
        game = new TicTacToeGame();
    }

    @Test
    public void whenPlayAndWholeHorizontalLineFilled_ThenWinner() throws Exception {
        chrome.get(Constants.APP_URL);
        assertEquals(Constants.APP_TITLE, chrome.getTitle());
        assertEquals("X", play(1, 1));
        assertEquals("O", play(1, 2));
        assertEquals("X", play(2, 1));
        assertEquals("O", play(2, 3));
        assertEquals("X", play(3, 1));

        WebElement result = chrome.findElement(By.name("f:result"));
        assertEquals(String.format(TicTacToeGame.RESULT_WINNER, 'X'), result.getText());
    }

    private String play(int x, int y) {
        WebElement button = chrome.findElement(By.name(String.format("f:btn%s_%s", x, y)));
        button.submit();
        button = chrome.findElement(By.name(String.format("f:btn%s_%s", x, y)));
        return button.getText();
    }

}
