


#  Prompts de IA  - DeepSeek Chat

## Prompt 1: Estrutura inicial do projeto
**Prompt:** 
"Preciso criar uma API Spring Boot para detalhes de itens do Mercado Livre. Deve ter endpoints REST para buscar informações de produtos, similar à página de detalhes de um item. Não posso usar banco de dados real, preciso usar arquivos JSON para persistência. Pode me ajudar com a estrutura do projeto?"

**Dúvida principal:** Como organizar as camadas (controller, service, repository) sem usar JPA com banco de dados real.

## Prompt 2: Persistência em JSON
**Prompt:**
"Como implementar um repositório que leia e escreva em arquivo JSON em Spring Boot? Preciso que os dados persistam entre execuções da aplicação."

**Dúvida principal:** Como fazer leitura e escrita em arquivo JSON de forma eficiente e thread-safe.

## Prompt 3: Tratamento global de exceções
**Prompt:**
"Preciso implementar tratamento global de exceções em Spring Boot com respostas padronizadas em JSON. Como criar um @ControllerAdvice que capture diferentes tipos de exceções e retorne ResponseEntity formatada?"

**Dúvida principal:** Diferença entre @ControllerAdvice e @RestControllerAdvice, e como estruturar as classes de exceção.

## Prompt 4: Injeção de dependências
**Prompt:**
"Qual a melhor prática para injeção de dependências em Spring Boot? Devo usar @Autowired em campos, construtor ou setter?"

**Dúvida principal:** Como properly inject dependencies between Controller → Service → Repository.

