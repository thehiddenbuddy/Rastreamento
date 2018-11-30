package br.correios.rastreamento.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteRastreamentoCodigoValido{

	//Sistema web online
	private String url = "https://www2.correios.com.br/sistemas/rastreamento/";
	//ou
	//Copia da pagina web desejada, para rodar localmente no tomcat
	//private String url = "localhost:8080/Rastreamento";

	WebDriver driver;

	//setup dos ids dos elementos da pagina
	private String inputCodigoValido = "OG206681041BR";
	private String idTextField = "objetos";
	private String idBotaoPesquisar = "btnPesq";
	private String classeCampoCodigoSaida = "codSro";


	//Comparação no assert teste
	private String resultadoEsperado = "OG206681041BR";		//esperamos um campo contendo o cod de rastreamento
	private String resultadoObtidoTeste = null;

	@Before
	public void inicia() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(25,
				TimeUnit.SECONDS);
	}

	/*@After
    public void tearDownTest(){
		driver.close();		//Fecha a janela do navegador
    }*/

	@Test
	public void testaConsultaCodigoValido() {

		//Verifico se o campo textfield para entrada de codigo de rastreamento existe
		try {
			driver.findElement(By.id(idTextField)).sendKeys(inputCodigoValido);
			driver.manage().timeouts().implicitlyWait(25,
					TimeUnit.SECONDS);
			System.out.println("----------------Textfield encontrado!------------------------");
		}catch(NoSuchElementException e) {
			System.out.println("CAMPO TEXFIELD NÃO ENCONTRADO PELA ID INFORMADA: " + idTextField);
		}

		//Verifico se o botao para pesquisa de codigo de rastreamento existe
		try {
			driver.findElement(By.id(idBotaoPesquisar)).click();
			driver.manage().timeouts().implicitlyWait(25,
					TimeUnit.SECONDS);
			System.out.println("----------------Botão encontrado!------------------------");
		}catch(NoSuchElementException e) {
			System.out.println("BOTÃO DE PESQUISA FORMULARIO NÃO ENCONTRADO PELA ID INFORMADA: " + idBotaoPesquisar);
		}


		//Verifico se o o codigo de rastreamento foi buscado e está no campo espeficado
		try {
			resultadoObtidoTeste = 
					driver.findElement(By.className(classeCampoCodigoSaida)).getText();
			driver.manage().timeouts().implicitlyWait(25,
					TimeUnit.SECONDS);
			System.out.println("----------------Classe encontrada no resultado da busca!------------------------");
		}catch(NoSuchElementException e) {
			System.out.println("A classe não foi localizada no resultado da consulta: " + classeCampoCodigoSaida);
		}


		//Teste encerrado
		/*
		 * Verificamos se a pagina com o resultado da consulta contém
		 * o codigo de rastreamento no campo espeficiado pela classe codSro.
		 * Senão, o teste deve falhar. 
		 */
		
		assertEquals(resultadoEsperado, resultadoObtidoTeste);

		System.out.println("Teste concluido!");

	}
}
