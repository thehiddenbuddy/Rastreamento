# Rastreamento
Trabalho de teste de software. Estou testando o sistema de consulta de encomendas do correios (https://www.linkcorreios.com.br/).

Um bom tutorial ae: https://www.devmedia.com.br/introducao-aos-testes-funcionais-automatizados-com-junit-e-selenium-webdriver/28037

Outro tutorial com selenium (não li): http://blog.caelum.com.br/testes-de-aceitacao-com-o-selenium/

Tecnologias adotadas pelo Correios: https://stackshare.io/empresa-brasileira-de-correios-e-telegrafo

Pra quem for usar o cucumber: https://docs.cucumber.io/guides/10-minute-tutorial/

Dicas pra escrita de caso de teste: https://medium.com/cwi-software/dicas-para-escrita-de-casos-de-teste-ccea14a7fdd9

Sobre o Selenium: https://www.quora.com/What-kind-of-Software-testing-Black-box-or-White-box-is-done-by-Selenuim

Sobre teste exploratório: http://www.linhadecodigo.com.br/artigo/1102/testes-exploratorios-de-a-a-z.

Sobre teste de sistema web: https://www.softwaretestingclass.com/category/web-testing/

Sobre teste caixa-preta (usar para elaborar caso de teste): https://www.softwaretestingclass.com/what-is-black-box-testing/

Decidir se isto é um teste exploratório???

---------------------------------------------------------------------------------------------------------
Etapas de execução do trabalho 

- Planejamento dos testes (Criação e implementação dos cenários de teste)
  	
	 [ ] TODO Criação dos casos de teste
	  (Falta Terminar)

	 [ ] TODO Implementação

	    - Criamos o projeto Maven;
	    - Adicionamos as dependências por meio do Maven;
	    - Alteramos o JRE para a versão 1.8 project->properties->Java compiler -> JDK Compliance: Compiler compliance level v1.8;
	    - Criamos um novo servidor (configuramos tomcat, geracao dinamica de paginas em project->properties->Project Facets: marcamos as opções Java v1.8, Dynamic Web Module v2.4 ou 3.0); Executar o passo a seguir: Project-> Maven-> Update project;
      - Adicionar o chromedriver no projeto (chromedriver.exe no Windows);

	    - Criamos a pagina index.jsp, adicionamos ao servidor, testamos inserindo a url: localhost:8080/Nome_do_projeto, e.g: localhost:8080/Rastreamento ou utilizamos a url do site diretamente: https://www.linkcorreios.com.br/. A diferença aqui é que 
      localmente iremos ter que copiar a pagina desejada a ser testada no arquivo index.jsp;
	    - Inserimos o codigo da nossa pagina alvo de teste;

	    - Criamos um pacote para armazenar testes do cenario Rastreamento em src/test/java (é o diretorio Maven para as classes de teste)
      - Criamos as classes de testes necessárias: TesteRastreamentoCodigoValido, TesteRastreamentoCodigoInvalido;

- Execução
  [ ] TODO
- Avaliação dos resultados
  [ ] TODO
- Finalização
  [ ] TODO
