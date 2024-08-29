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
import com.example.demo.models.Programa;

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
        driver.findElement(By.xpath("(//input[@id=\'consultarProgramaAtende\'])[2]")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) > .estados:nth-child(9) > #consultarEstadosHabilitado")).click();
        driver.findElement(By.xpath("(//input[@id='form_submit'])[3]")).click();
        
        driver.findElement(By.id("ConteudoDiv")).click();
    }

    private void performActionsOnProgramPage(WebDriver driver) {
        // Adicione a lógica para realizar ações na página do programa, se necessário
    }

    private int[] extractPageInfoFromText(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        
        int[] pageInfo = new int[2];
        
        if (matcher.find()) {
            pageInfo[0] = Integer.parseInt(matcher.group(1)); // página_atual
            pageInfo[1] = Integer.parseInt(matcher.group(2)); // total_paginas
        } else {
            pageInfo[0] = -1;
            pageInfo[1] = -1;
        }
        
        return pageInfo;
    }

    private List<Programa> getPageProgramas(WebDriver driver) {
        List<Programa> programas = new ArrayList<>();
        List<WebElement> codigoElements = driver.findElements(By.cssSelector("#tbodyrow a[href*='Detalhar']"));
        
        for (WebElement codigoElement : codigoElements) {
            String codigo = codigoElement.getText();
            String linkDetalhe = codigoElement.getAttribute("href");
            programas.add(new Programa(codigo, linkDetalhe));
        }
        return programas;
    }

    private void navigateToPage(WebDriver driver, int pageNumber) {
        // Navega para o URL da página especificada
         driver.get("https://discricionarias.transferegov.sistema.gov.br/voluntarias/ConsultarPrograma/PreenchaOsDadosDaConsultaDeProgramaDeConvenioConsultar.do?d-16544-t=listaProgramas&d-16544-p=" + pageNumber + "&d-16544-g=" + pageNumber);
    }

    private String getProgramDetail(WebDriver driver, Programa programa) {
        // Navega para o URL do programa
        driver.get(programa.getLinkDetalhe());
       
        programa.setOrgaoVinculado(driver.findElement(By.id("tr-alterarProgramaOrgaoSubordinado")).findElement(By.cssSelector("td.field")).getText());
        programa.setCodigo(driver.findElement(By.id("tr-alterarProgramaCodigo")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setOrgao(driver.findElement(By.id("tr-alterarProgramaOrgao")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setOrgaoVinculado(driver.findElement(By.id("tr-alterarProgramaOrgaoSubordinado")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setOrgaoExecutor(driver.findElement(By.id("tr-alterarProgramaOrgaoExecutor")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setTipoInstrumento(driver.findElement(By.id("tr-alterarProgramaModalidade")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setSubtipoInstrumento(driver.findElement(By.id("tr-alterarProgramaSubtipoInstrumento")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setQualificacaoProposta(driver.findElement(By.id("tr-alterarProgramaQualificacaoProponente")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setAtende(driver.findElement(By.id("tr-alterarProgramaProgramaAtendea")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setCategorias(driver.findElement(By.id("tr-alterarProgramaCategoriasPrograma")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setNome(driver.findElement(By.id("tr-alterarProgramaNomeDoPrograma")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setDataInicioEmenda(driver.findElement(By.id("alterarProgramaDataInicioEmendaParlamentar")).getAttribute("value").trim());
        programa.setDataFimEmenda(driver.findElement(By.id("alterarProgramaDataFimEmendaParlamentar")).getAttribute("value").trim());
        programa.setAcaoOrcamentaria(driver.findElement(By.id("tr-alterarProgramaAcaoPpaPac")).findElement(By.cssSelector("td.field")).getText().trim());
        programa.setEstadosHabilitados(driver.findElement(By.id("tr-alterarProgramaEstadosHabilitados")).findElement(By.cssSelector("td.field")).getText().trim());
        // Retorna o conteúdo da página de detalhes do programa
        return driver.getPageSource()+"<pre style=\"text-align: left;\">"+programa.toString()+"<pre>";

    }
    
    // consulta convênios
    private void navigateToConvList(WebDriver driver) throws InterruptedException {
        // Executa JavaScript para encontrar e clicar no link
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(
            "document.querySelector('a.external-link[href*=\"/MostraPrincipalConsultarProposta.do\"]').click();"
        );

        // Adiciona outra pausa de 5 segundos para garantir que a navegação aconteça
        Thread.sleep(5000); // Pausa de 5 segundos

        // Navega para o próximo URL
        driver.get("https://discricionarias.transferegov.sistema.gov.br/voluntarias/proposta/ConsultarProposta/ConsultarProposta.do");

        // Preenche o form e vai para a lista
        driver.findElement(By.id("consultarUf")).click();
        driver.findElement(By.id("consultarUf")).findElement(By.xpath("//option[. = 'TO']")).click();
        driver.findElement(By.xpath("(//input[@id=\'form_submit\'])[5]")).click();
    }


    @RequestMapping("/primeiro-projeto")
    public String primeiroProjeto() {
        WebDriver driver = null;
        try {
            driver = initializeDriver();

            // Realiza o login
            login(driver);

            navigateToConvList(driver);

            return driver.getPageSource();
            // =================================== consulta programas =============================
                // Navega até a lista de programas
                // navigateToProgramList(driver);

                // Realiza outras ações na página
                // performActionsOnProgramPage(driver);

                // Encontre a informação da página no HTML da página
                // int[] pageInfo = extractPageInfoFromText(driver.getPageSource(), "Página (\\d+) de (\\d+)");
                
                // Coleta os códigos e links da tabela das páginas
                // List<Programa> programas = new ArrayList<>();
                // int totalPaginas = pageInfo[1];

                // for (int i = 1; i <= totalPaginas; i++) {
                //     // Adiciona um marcador para o início da nova página (opcional)
                //     programas.add(new Programa("========== pagina " + i + " ==========", null));
                    
                //     // Navega para a página correspondente
                //     navigateToPage(driver, i);
                    
                //     // Coleta os programas da página atual
                //     List<Programa> novosProgramas = getPageProgramas(driver);
                //     programas.addAll(novosProgramas);
                // }

                // Exibe a página de detalhes do primeiro programa coletado
                // return getProgramDetail(driver, programas.get(1));
            // =================================== fim consulta programas =========================


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
