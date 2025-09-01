
## 🏃‍♂️ Execução da Aplicação

```bash
# Opção 1: Executar com Maven (desenvolvimento)
mvn spring-boot:run

# Opção 2: Executar JAR empacotado (produção)
# Primeiro empacote:
mvn clean package

# Depois execute o JAR:
java -jar target/mercado-livre-api-0.0.1-SNAPSHOT.jar
```

## 🧪 Testes e Verificação

```bash
# Testar se a aplicação está respondendo
curl -X GET http://localhost:8080/health

# Listar todos os itens
curl -X GET http://localhost:8080/api/itens

# Buscar item específico (substitua pelo ID real)
curl -X GET http://localhost:8080/api/itens/MLA123456789
```
## 🔧 Comandos Maven Úteis

```bash
# Compilar sem executar
mvn compile

# Executar testes unitários
mvn test

# Limpar e reempacotar
mvn clean package

# Verificar dependências
mvn dependency:analyze

# Gerar documentação (site com docs)
mvn site
```