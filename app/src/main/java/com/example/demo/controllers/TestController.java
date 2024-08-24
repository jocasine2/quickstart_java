package com.example.demo.controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class TestController {

    private WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless", "--disable-gpu", "--remote-debugging-port=9222", "--no-sandbox");

        return new ChromeDriver(chromeOptions);
    }

    private void login(WebDriver driver) throws InterruptedException {
        // Navega até a página de login
        driver.get("https://idp.transferegov.sistema.gov.br/idp/");
        driver.findElement(By.linkText("Acesso livre")).click();

        // Adiciona uma pausa de 5 segundos antes de continuar
        Thread.sleep(5000); // Pausa de 5 segundos
    }

    private void navigateToProgramList(WebDriver driver) throws InterruptedException {
        // Executa JavaScript para encontrar e clicar no link
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
            "document.querySelector('a.external-link[href*=\"/ConsultarPrograma/ConsultarPrograma.do\"]').click();"
        );

        // Adiciona outra pausa de 5 segundos para garantir que a navegação aconteça
        Thread.sleep(5000); // Pausa de 5 segundos

        // Navega para o próximo URL
        driver.get("https://discricionarias.transferegov.sistema.gov.br/voluntarias/programa/ConsultarPrograma/ConsultarPrograma.do");

        // Preenche o form e vai para a lista
        driver.findElement(By.id("consultarProgramaAtende")).click();
        driver.findElement(By.xpath("(//input[@id='consultarProgramaAtende'])[2]")).click();
        driver.findElement(By.xpath("(//input[@id='form_submit'])[3]")).click();
        driver.findElement(By.id("ConteudoDiv")).click();
    }

    private void performActionsOnProgramPage(WebDriver driver) {
        // Adicione a lógica para realizar ações na página do programa, se necessário
    }

    /**
     * Encontra e extrai o número da página atual e o número total de páginas
     * a partir do texto fornecido usando uma expressão regular.
     *
     * @param text O texto que contém o formato "Página :pagina_atual de :total_paginas".
     * @param regex A expressão regular para encontrar o formato da página.
     * @return Um array de inteiros onde o primeiro elemento é a página atual e o segundo é o total de páginas.
     */
    private int[] extractPageInfoFromText(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        int[] pageInfo = new int[2];
        
        if (matcher.find()) {
            pageInfo[0] = Integer.parseInt(matcher.group(1)); // página_atual
            pageInfo[1] = Integer.parseInt(matcher.group(2)); // total_paginas
        } else {
            // Se não encontrar correspondência, defina os valores como -1 ou qualquer valor padrão
            pageInfo[0] = -1;
            pageInfo[1] = -1;
        }
        
        return pageInfo;
    }

    /**
     * Coleta códigos da tabela na página atual.
     *
     * @param driver O WebDriver usado para interagir com a página.
     * @return Uma lista de códigos encontrados na tabela.
     */
    private List<String> getPageCodes(WebDriver driver) {
        List<String> codigos = new ArrayList<>();
        List<WebElement> codigoElements = driver.findElements(By.cssSelector("#tbodyrow a[href*='Detalhar']"));
        for (WebElement codigoElement : codigoElements) {
            codigos.add(codigoElement.getText());
        }
        return codigos;
    }

    private void navigateToPage(WebDriver driver, int pageNumber) {
        // Navega para o URL da página especificada
        driver.get("https://discricionarias.transferegov.sistema.gov.br/voluntarias/ConsultarPrograma/PreenchaOsDadosDaConsultaDeProgramaDeConvenioConsultar.do?d-16544-t=listaProgramas&d-16544-p=" + pageNumber + "&d-16544-g=33");
    }

    @RequestMapping("/primeiro-projeto")
    public String primeiroProjeto() {
        WebDriver driver = null;
        try {
            driver = initializeDriver();

            // Realiza o login
            login(driver);

            // Navega até a lista de programas
            navigateToProgramList(driver);

            // Realiza outras ações na página
            performActionsOnProgramPage(driver);

            // Encontre a informação da página no HTML da página
            int[] pageInfo = extractPageInfoFromText(driver.getPageSource(), "Página (\\d+) de (\\d+)");
            
            // Coleta os códigos da tabela da primeira página
            List<String> codigos = getPageCodes(driver);
            int totalPaginas = pageInfo[1];

            // Itera sobre as páginas restantes e coleta os códigos
            for (int i = 2; i <= 3; i++) {
                navigateToPage(driver, i);
                // Coleta os códigos da página atual
                List<String> novosCodigos = getPageCodes(driver);
                codigos.addAll(novosCodigos);
            }
        
            // Retorna o HTML da página, informações da página e códigos coletados
            return driver.getPageSource() + "Página Atual: " + pageInfo[0] + " Total de Páginas: " + pageInfo[1] + "<br>" + String.join("<br>", codigos);
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
