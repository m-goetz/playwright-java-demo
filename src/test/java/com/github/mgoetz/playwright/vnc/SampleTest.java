package com.github.mgoetz.playwright.vnc;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.util.List;

class SampleTest {

    @Test
    void sampleTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setArgs(List.of("--start-maximized"))
            );
            Page page = browser.newContext(
                    new Browser.NewContextOptions().setViewportSize(null)).newPage();
            for (int i = 0; i < 10; i++) {
                page.navigate("https://playwright.dev/");
                Thread.sleep(3000);
                page.navigate("https://google.com/");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
