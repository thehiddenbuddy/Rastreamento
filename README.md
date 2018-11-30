# Trabalho de teste de software: Teste do sistema de rastreamento de encomendas do correios
Neste projeto testamos (uma pequena parte) do sistema de rastreamento de encomendas do correios, este sistema pode ser acessado pelo link a seguir: [rastreamento_correios](https://www2.correios.com.br/sistemas/rastreamento/)
é possível consultar a situação de seus objetos nos Correios.  Podendo ser utilizado o seu CPF/CNPJ ou até 50 códigos de 13 dígitos cada, separando-os com ponto e vírgula.  Ex:  AA987654321BR; AA100833276BR. 

Testaremos apenas o caso de uso (não temos o UC real, logo deveríamos executar um teste exploratório? fica a pergunta) em que o usuário pesquisa apenas  01 (um) código de rastreamento.  Não testaremos entradas múltiplas, nem testaremos consultas utilizando CPF/CNPJ.

Levando em conta estas informações, realizamos um teste caixa-preta utilizando Partição de Equivalência. As classes identificadas, assim como as classes válidas e inválidas estão apresentadas na tabela a seguir:
	

| Variável de entrada 	 | Classe de equivalência válida | Classes de equivalência inválida		|
|------------------------|-------------------------------|----------------------------------------------|
| Codigo de rastreamento | Um codigo valido (1); 	 | Entrada vazia (2) ou Codigo Invalido (3);	|

Acessando este [link](https://www.correios.com.br/precisa-de-ajuda/como-rastrear-um-objeto) podemos obter mais informações sobre a estrutura do código de registro para rastrear uma encomenda e detalhes sobre o uso do serviço de rastreamento.

Com base nas classes identificadas derivamos os seguintes casos de teste:

| CT  | TIpo de entrada codigo de rastreamento | Exemplo de entrada |
|-----|----------------------------------------|--------------------|
| CT1 | Válido                                 | OG206681041BR      |
| CT2 | Em branco                              |                    |
| CT3 | Inválido                               | asdasdndas, 11121  |

Os testes foram implementados no diretório "src/test/java". Nas tabelas a seguir, temos o passo a passo de execução de cada caso de teste derivado:

**CT1** - Implementado pela classe [TesteRastreamentoCodigoValido.java](https://github.com/thehiddenbuddy/Rastreamento/blob/master/src/test/java/br/correios/rastreamento/teste/TesteRastreamentoCodigoValido.java)


| Passo | Ação                                                                         | Resultado esperado                                                |
|-------|------------------------------------------------------------------------------|-------------------------------------------------------------------|
| 1     | Abrir a URL de rastreamento no navegador.                                    | Página de rastreamento carregada.                                 |
| 2     | Inserir um código de rastreamento válido no textfield de entrada de codigos. |                                                                   |
| 3     | Clicar no botão "Buscar"                                                     | O sistema deve carregar o histórico de rastreamento da encomenda. |


**CT2** - Implementado pela classe [TesteRastreamentoCodigoEmBranco.java](https://github.com/thehiddenbuddy/Rastreamento/blob/master/src/test/java/br/correios/rastreamento/teste/TesteRastreamentoCodigoEmBranco.java)

| Passo | Ação                                      | Resultado esperado                                                                                                            |
|-------|-------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| 1     | Abrir a URL de rastreamento no navegador. | Página de rastreamento carregada.                                                                                             |
| 2     | Clicar no botão "Enviar"                  | Não realizar consulta e emitir o alerta, a seguir:  "Por favor, digite de um a 50 códigos de objetos,  ou um CPF/CNPJ válido" |


**CT3** - Implementado pela classe [TesteRastreamentoCodigoInvalido.java](https://github.com/thehiddenbuddy/Rastreamento/blob/master/src/test/java/br/correios/rastreamento/teste/TesteRastreamentoCodigoInvalido.java)


| Passo | Ação                                                                           | Resultado esperado                                                                                                               |
|-------|--------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| 1     | Abrir a URL de rastreamento no navegador.                                      | Página de rastreamento carregada.                                                                                                |
| 2     | Inserir um código de rastreamento invalido no textfield de entrada de codigos. |                                                                                                                                  |
| 3     | Clicar no botão "Buscar"                                                       | Emitir a seguinte mensagem de erro, informando que o codigo  inserido é invalido:  "O(s) código(s) ou CPF/CNPJ estão inválidos". |




FIM


---------------------------------------------------------------------------------------------
Links para leitura



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

	    - Criamos o projeto Maven;
	    - Adicionamos as dependências por meio do Maven;
	    - Alteramos o JRE para a versão 1.8 project->properties->Java compiler -> JDK Compliance: Compiler compliance level v1.8;
	    - Download do tomcat;
	    - Criamos um novo servidor (configuramos tomcat, geracao dinamica de paginas em project->properties->Project Facets: marcamos as opções Java v1.8, Dynamic Web Module v2.4 ou 3.0); Executar o passo a seguir: Project-> Maven-> Update project;
      - Adicionar o chromedriver no projeto (chromedriver.exe no Windows);

	    - Criamos a pagina index.jsp, adicionamos ao servidor, testamos inserindo a url: localhost:8080/Nome_do_projeto, e.g: localhost:8080/Rastreamento ou utilizamos a url do site diretamente: https://www.linkcorreios.com.br/. A diferença aqui é que 
      localmente iremos ter que copiar a pagina desejada a ser testada no arquivo index.jsp;
	    - Inserimos o codigo da nossa pagina alvo de teste;

	    - Criamos um pacote para armazenar testes do cenario Rastreamento em src/test/java (é o diretorio Maven para as classes de teste)
      - Criamos as classes de testes necessárias: TesteRastreamentoCodigoValido, TesteRastreamentoCodigoInvalido;
