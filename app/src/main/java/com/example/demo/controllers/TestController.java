package com.example.demo.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

        WebDriver driver = null;
        try {
            driver = new ChromeDriver(chromeOptions);

            // Navega até a página de login
            driver.get("https://idp.transferegov.sistema.gov.br/idp/");
            driver.findElement(By.linkText("Acesso livre")).click();

            // Adiciona uma pausa de 5 segundos antes de continuar
            Thread.sleep(5000); // Pausa de 5 segundos

            // Precisa clickar no link para navegar para a proxima url
            // Executa JavaScript para encontrar e clicar no link
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(
                "document.querySelector('a.external-link[href*=\"/ConsultarPrograma/ConsultarPrograma.do\"]').click();"
            );

            // Adiciona outra pausa de 5 segundos para garantir que a navegação aconteça
            Thread.sleep(5000); // Pausa de 5 segundos

            // Navega para o próximo URL
            driver.get("https://discricionarias.transferegov.sistema.gov.br/voluntarias/programa/ConsultarPrograma/ConsultarPrograma.do");


            driver.findElement(By.id("consultarProgramaAtende")).click();
            driver.findElement(By.xpath("(//input[@id='consultarProgramaAtende'])[2]")).click();
            driver.findElement(By.xpath("(//input[@id='form_submit'])[3]")).click();
            driver.findElement(By.id("ConteudoDiv")).click();

            // Retorna o HTML da página
            String pageSource = driver.getPageSource();
            
            return pageSource;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao executar o teste: " + e.getMessage();
        } finally {
            // Certifique-se de fechar o driver após o uso
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
