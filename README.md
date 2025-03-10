# Api Pedidos

Esta API permite gerenciar pedidos de um sistema de e-commerce. Ela oferece operações para criar, 
consultar e atualizar pedidos, além de calcular impostos e gerenciar o status dos pedidos.   

#### Dependências

- Java 17+   
- Maven   
- Banco de dados H2 (em memória)  
- Fila (em memória)

#### Configuração

- Colocar as variaveis de ambiente na IDE  
 
DATABASE_CONSOLE_ENABLED=true   
DATABASE_DRIVER=org.h2.Driver   
DATABASE_PASSWORD=    
DATABASE_PATH=/h2-console   
DATABASE_URL=jdbc:h2:mem:apiPedido_mem   
DATABASE_USERNAME=sa   
SWAGGER_ATIVAR=true   

#### Executando a Aplicação

No diretório raiz da aplicação execute os comandos:
- mvn clean install
- mvn spring-boot:run

#### Melhorias



#### GitHub  
O código-fonte deste projeto está disponível no GitHub:   
- https://github.com/RenatoMK/api-pedido

#### H2 - Base de dados  
O banco de dados H2 está configurado para rodar em memória. Para acessar o console do H2:   

http://localhost:8080/v1/h2-console/login.jsp  
Driver Class=org.h2.Driver  
JDBC URL=jdbc:h2:mem:apiPedido_mem  
User Name=sa  
Password=  

#### Health check
Para verificar o status da aplicação, acesse:   
- http://localhost:8080/v1/actuator/health

#### Swagger
A documentação interativa da API está disponível no Swagger:   
- http://localhost:8080/v1/swagger-ui/index.html

#### Apis  

- Recupera todos os pedidos por status.   
Get: http://localhost:8080/v1/api/pedidos?status=Criado
	
```
##Response:
{
  "pedidos": [
    {
      "pedidoId": 30,
      "clienteId": 1,
      "itens": [
        {
          "produtoId": 1001,
          "quantidade": 2,
          "valor": 52.7
        }
      ],
      "id": 1,
      "imposto": 15.81,
      "status": "Criado"
    },
    {
      "pedidoId": 31,
      "clienteId": 10,
      "itens": [
        {
          "produtoId": 11,
          "quantidade": 2,
          "valor": 52.7
        },
        {
          "produtoId": 121,
          "quantidade": 4,
          "valor": 1521.7
        }
      ],
      "id": 2,
      "imposto": 472.32,
      "status": "Criado"
    },
    {
      "pedidoId": 32,
      "clienteId": 25,
      "itens": [
        {
          "produtoId": 31,
          "quantidade": 12,
          "valor": 200.7
        },
        {
          "produtoId": 121,
          "quantidade": 4,
          "valor": 1521.7
        },
        {
          "produtoId": 121,
          "quantidade": 4,
          "valor": 1521.7
        }
      ],
      "id": 3,
      "imposto": 973.23,
      "status": "Criado"
    }
  ]
}  
```
- Recupera um registro pelo ID.   
Get: http://localhost:8080/v1/api/pedidos/1
   
```
##Response:
{
  "pedidoId": 30,
  "clienteId": 1,
  "itens": [
    {
      "produtoId": 1001,
      "quantidade": 2,
      "valor": 52.7
    }
  ],
  "id": 1,
  "imposto": 15.81,
  "status": "Criado"
}
```
- Cria um pedido na base de dados e envia via fila para o Sistema B.   
Post: http://localhost:8080/v1/api/pedidos
	
```
##Request:
{
  "pedidoId": 32,
  "clienteId": 25,
  "itens": [
   
  {
      "produtoId": 31,
      "quantidade": 12,
      "valor": 200.70
    },
  {
      "produtoId": 121,
      "quantidade": 4,
      "valor": 1521.70
    },
  {
      "produtoId": 121,
      "quantidade": 4,
      "valor": 1521.70
    }
  ]
}

##Response:
{
  "id": 1,
  "status": "Criado"
}

```
- Atualiza a taxa de imposto. Na configuração atual a atualização do valor acontece em 1 em 1 minuto configurado via   
cache para não ir na base de dados sempre.
Patch:
	http://localhost:8080/v1/api/pedidos?taxaImposto=0.5&descri%C3%A7%C3%A3oImposto=Atualizacao%20taxa%20

```
No Content
```