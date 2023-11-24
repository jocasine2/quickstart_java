package com.example.demo.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/primeiro-projeto")
    public String primeiroProjeto() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--remote-debugging-port=9222", "--no-sandbox");

        try {
            WebDriver driver = new ChromeDriver(chromeOptions);

            // Navega até a página do Google
            driver.get("https://idp.transferegov.sistema.gov.br/idp/");

            // Aguarda alguns segundos para garantir que a página foi totalmente carregada
            Thread.sleep(5000);

            // Obtém o conteúdo da página
            String pageContent = driver.getPageSource();

            // Exibe o conteúdo da página
            System.out.println(pageContent);

            // Certifique-se de fechar o driver após o uso
            driver.quit();

            return pageContent;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao executar o teste: " + e.getMessage();
        }
    }
}
