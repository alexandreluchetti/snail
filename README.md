# Snail Project

Projeto com dois desafios.
1. [Desafio Resistores – Código de Cores
2. Desafio Snail (Matriz Caracol)

### 1. Desafio Resistores – Código de Cores
Este projeto contém uma função que converte o valor de resistências elétricas, especificadas em ohms, para uma sequência de cores que representam esse valor em resistores. Os resistores são componentes eletrônicos que têm listras coloridas para indicar seu valor de resistência em ohms e a tolerância permitida.

#### Regras:
1. Resistores menores que 1000 ohms: O valor é representado por um número simples.
- Exemplo: "47 ohms" retorna "amarelo violeta preto dourado".
2. Resistores entre 1000 ohms e 999999 ohms: O valor é seguido por 'k'.
- Exemplo: "4.7k ohms" retorna "amarelo violeta vermelho dourado".
3. Resistores de 1.000.000 ohms ou mais: O valor é seguido por 'M'.
- Exemplo: "1M ohms" retorna "marrom preto verde dourado".

#### Exemplos de Utilização:
- "10 ohms" => "marrom preto preto dourado"
- "330 ohms" => "laranja laranja marrom dourado"
- "1k ohms" => "marrom preto vermelho dourado"
- "2M ohms" => "vermelho preto verde dourado"

### 2. Desafio Snail (Matriz Caracol)
Este projeto também contém uma função que percorre uma matriz N x N, retornando os valores dos elementos em ordem, do mais externo para o mais interno, seguindo um padrão de caracol no sentido horário.

#### Regras:
1. A função deve percorrer a matriz em um padrão caracol, começando pelo canto superior esquerdo e movendo-se no sentido horário.
2. A função deve ser capaz de lidar com matrizes vazias.

#### Exemplos de Utilização:

- Para a matriz:
```text
1 | 2 | 3
4 | 5 | 6
7 | 8 | 9
```
A função deve retornar: `[1, 2, 3, 6, 9, 8, 7, 4, 5]`

- Para a matriz:
```text
1 | 2 | 3
4 | 10 | 12
6 | 7 | 33
```
A função deve retornar: `[1, 2, 3, 12, 33, 7, 6, 4, 10]`

#### Observação:
A função deve tratar matrizes de diferentes tamanhos e formatos, incluindo o caso de matrizes vazias.

<hr>

## Sumário

- [Requisitos](#requisitos)
- [Instalação](#instalação)
- [Uso](#uso)
- [Testes](#testes)
- [Docker](#docker)
- [Contribuição](#contribuição)
- [Licença](#licença)

## Requisitos

- Java 21 JDK
- Maven 3.8.6 ou superior

## Instalação

### Clonando o Repositório

```sh
git https://github.com/alexandreluchetti/snail-project.git
cd Snail
```

### Compilando o Projeto

1. Navegue até o diretório do projeto:
    ```sh
    cd Snail
    ```

2. Compile o projeto e empacote o JAR:
    ```sh
    mvn clean package
    ```

## Uso

### Executando a Aplicação

Depois de compilar o projeto, você pode executar o JAR gerado com o seguinte comando:

```sh
java -jar target/Snail-1.0.0.jar
```

[//]: # (## Testes)

[//]: # ()
[//]: # (Para rodar os testes do projeto, use o seguinte comando:)

[//]: # ()
[//]: # (```sh)

[//]: # (mvn test)

[//]: # (```)

## Docker

### Construindo a Imagem Docker

Para construir a imagem Docker do projeto, execute:

```sh
docker build -t snail-supera-project-java .
```

### Executando o Contêiner Docker

Depois de construir a imagem, você pode executar o contêiner usando:

```sh
docker run -it --rm snail-supera-project-java
```

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature: `git checkout -b minha-feature`
3. Commit suas mudanças: `git commit -am 'Adiciona minha feature'`
4. Faça push para a branch: `git push origin minha-feature`
5. Envie um Pull Request

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.