# Love Pets

[![MIT license](https://img.shields.io/badge/License-MIT-blue.svg)](https://lbesson.mit-license.org/)
[![Open Source? Yes!](https://badgen.net/badge/Open%20Source%20%3F/Yes%21/blue?icon=github)](https://github.com/Naereen/badges/)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Bootstrap](https://img.shields.io/badge/bootstrap-%238511FA.svg?style=for-the-badge&logo=bootstrap&logoColor=white)

## Sobre o projeto

[![Product Name Screen Shot][product-screenshot]](https://example.com)

O Love Pets foi criado para facilitar a vida de pessoas que possuem pets e querem o melhor para seu animal de estimação, podendo comprar de rações a medicamento e a camas.

## Construido com

* Java
* Servlets
* Filters
* JSP
* Bootstrap
* PostgreSQL
* TomCat

## ✅ Pré-requisitos

Antes de iniciar o projeto, certifique-se de que os seguintes softwares estão instalados em sua máquina:

### ☕ Java 17

Você pode verificar se o Java está instalado com:

```bash
java -version
```
Se não estiver instalado, você pode instalar no Linux via terminal:

```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

Ou baixe manualmente para Windows/Mac em https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

###🐘 PostgreSQL

Verifique se o PostgreSQL está instalado:

```bash
psql --version
```

Para instalar no Ubuntu:

```bash
sudo apt update
sudo apt install postgresql postgresql-contrib
```

No Windows/Mac, você pode baixar via:
🔗 https://www.postgresql.org/download/

###🧰 Apache Tomcat 10.1

Verifique se o Tomcat está instalado:

```bash
catalina version
```

Caso não esteja, você pode baixar aqui:
🔗 https://tomcat.apache.org/download-90.cgi

Após baixar:

* Extraia o arquivo ZIP/TAR.

* Defina a variável de ambiente CATALINA_HOME.

* Para iniciar o servidor:

  ## Clonando o projeto

1º Faça o clone do repositório.

```bash
git clone https://github.com/Rodrigodx/LovePets.git
```

2º Abra o a pasta do repositório em sua IDE.

3º Rode o servidor TomCat.

4º Acesse a URL "localhost:8080/LovePets" para chegar na página inicial do projeto.

## Uso do projeto

1º Página Inicial:

```bash
url: localhost:8080/LovePets
```

<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Tela Inicial.png" alt="Logo" width="800" height="800">

2º Página de produtos por categoria:

```bash
url: http://localhost:8080/LovePets/ServletProduct?category=(1 a 7)
```

<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Produtos para Cachorros.png" alt="Logo" width="800" height="800">


3º Página do produto:

```bash
url: http://localhost:8080/LovePets/ServletProduct?id= (id do produto)
```
<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Página do Produto.png" alt="Logo" width="800" height="800">

4º Página de login:

```bash
url: http://localhost:8080/LovePets/login.jsp
```
<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Tela de Login.png" alt="Logo" width="800" height="800">

5º Tela de cadastro do usuário:

```bash
url: http://localhost:8080/LovePets/register.jsp
```

<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Registro de usuário.png" alt="Logo" width="800" height="800">

6º Carrinho de compras:

```bash
url: http://localhost:8080/LovePets/cart.jsp
```

<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Tela do carrinho de compras.png" alt="Logo" width="800" height="800">

7º Minhas compras:

```bash
url: http://localhost:8080/LovePets/ViewOrdersServlet
```
<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Tela de minhas compras.png" alt="Logo" width="800" height="800">

8º Cadastro de produtos:

```bash
url: http://localhost:8080/LovePets/register_products.jsp
```

<img src="src/main/webapp/META-INF/imagens/Imagens das páginas/Cadastro de produtos.png" alt="Logo" width="800" height="800">








