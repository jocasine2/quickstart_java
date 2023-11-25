package com.example.demo.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

            // Navega até a página de login
            driver.get("https://idp.transferegov.sistema.gov.br/idp/");
            driver.findElement(By.linkText("Acesso livre")).click();
            driver.findElement(By.cssSelector(".col1 > .button:nth-child(2)")).click();
            driver.findElement(By.linkText("Consultar Programas")).click();
            driver.findElement(By.id("consultarProgramaAtende")).click();
            driver.findElement(By.xpath("(//input[@id='consultarProgramaAtende'])[2]")).click();
            driver.findElement(By.xpath("(//input[@id='form_submit'])[3]")).click();
            driver.findElement(By.id("ConteudoDiv")).click();

            // Aguarda alguns segundos para garantir que a página foi totalmente carregada
            // Thread.sleep(5000);

            // Coleta os códigos da tabela
            List<String> codigos = new ArrayList<>();
            List<WebElement> codigoElements = driver.findElements(By.cssSelector("#tbodyrow a[href*='Detalhar']"));
            for (WebElement codigoElement : codigoElements) {
                codigos.add(codigoElement.getText());
            }

            // Certifique-se de fechar o driver após o uso
            driver.quit();

            // Retorna os códigos como uma string
            return String.join("<br>", codigos);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao executar o teste: " + e.getMessage();
        }
    }
}
