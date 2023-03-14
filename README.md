# Seven-Days-Of-Code-Java
☕ #7DaysOfCode

- Projeto inspirado no desafio da Alura ["7 days of code Java"](https://7daysofcode.io/matricula/java)

- Foi utilizado o teste grátis da API do [iSportsAPI](https://www.isportsapi.com/)

O programa irá **criar** um arquivo **json** com todos os nomes e o logo de times que contiverem o nome que será passado no terminal. Após a consulta com a API, o arquivo com os dados encontrados estará em: `src/main/resources`.

## Requisitos
Ter uma chave da API e coloca-la como o valor da variável de ambiente `PERSONAL_API_KEY`.


## Funcionamento linha a linha da classe Main

- (linha 16) Primeiramente, a classe `AskTeamToSearch` será responsável por armazenar em memória o nome do time a ser pesquisado. 
- (linha 17) Este nome, será armazenado na classe `Main` para ser passado á classe `RequestData`. 
- (linha 19) A classe `RequestData` é responsável por fazer a requisição HTTP para a API do iSportsAPI e irá conter a resposta da requisição com as informações de todos os times que contém a palavra passada. 
- (linha 22) A resposta HTTP retornada da classe `RequestData` será parseada baseado na classe `JsonModel` através da classe `MyJsonParser` (é uma espécie de "casting" de String para JsonModel). 
- Em toda instância de `JsonModel` há informações da requisição como `code` que exibe o status da requisição, `message` que informará uma mensagem que é correspondente ao status da requisição e `data` que contém uma coleção (lista) das informações encontradas (todos os times que contém o nome passado).
- (linha 27) A lista de times que o objeto de `JsonModel` possui é escrito em um arquivo json pela classe `WriteJson` que faz o tratamento dos dados inserindo no json apenas o nome e logo do time. 
- O arquivo criado se encontra no diretorio: `src/main/resources` com o nome de `team.json`
- se não existir o arquivo neste diretório, o arquivo será criado, se ja houver o arquivo, sera sobrescrito.

## Pacotes utilizados

- [java.net.http](https://docs.oracle.com/en/java/javase/17/docs/api/java.net.http/java/net/http/package-summary.html) para requisições http.
- [java.io.FileWriter](https://docs.oracle.com/javase/7/docs/api/java/io/FileWriter.html) para criação do arquivo json.

###  Pacotes externos (maven)
- [jackson core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core/2.12.3) para parsear dados.
- [JSON Library From Android SDK](https://mvnrepository.com/artifact/com.vaadin.external.google/android-json/0.0.20131108.vaadin1) para estruturar o JSON (pacote org.json incluso).