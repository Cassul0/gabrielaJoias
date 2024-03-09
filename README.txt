Esse arquivo tem como objetivo auxiliar na execução desse projeto.

Como utilizei um banco H2, não é necessário alterar as configurações do banco, sendo assim,
basta ter o Java 17 na máquina e o Maven instalado na máquina, e executar o Jar que está dentro da pasta target.  
Caso não tenha nenhum JAR presente, deve acessar o projeto pelo CMD, e executar os seguintes comandos:
    -> mvn clean install (Se tiver problemas com os testes executar mvn clean install -DskipTests)
Esse comando irá gerar um jar na pasta target do projeto, e para executá-lo, utilizar o comando:
    -> java -jar "nomedoarquivo".jar
    -> java -jar gabriela-Joias-0.0.1-SNAPSHOT.jar
Isso deve ser o suficiente para subir o projeto. 
Se não funcionar, pode utilizar o spring tool suite 4, importando o projeto como maven project.
Realizar o Update Project marcando a opção force update of Snpashots/Releases, em Project > Update Maven Project
Após esses comandos, já pode subir o projeto.