package com.github.mgoetz.playwright.vnc;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    void sampleTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();
            for (int i = 0; i < 10; i++) {
                page.navigate("https://playwright.dev/");
                Thread.sleep(3000);
                page.navigate("https://google.com/");
                Thread.sleep(3000);
            }
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
