# 🚀 Projeto de Automação Selenium

Este projeto implementa testes automatizados usando Selenium WebDriver, JUnit 5 e Page Object Model (POM) para automação de testes web.

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- Navegadores: Chrome, Firefox ou Edge

## 🛠️ Tecnologias Utilizadas

- **Selenium WebDriver 4.20.0** - Framework de automação web
- **JUnit 5** - Framework de testes
- **WebDriverManager** - Gerenciamento automático de drivers
- **Page Object Model** - Padrão de design para Page Objects
- **Allure Reports** - Geração de relatórios de teste
- **Faker** - Geração de dados de teste
- **Maven** - Gerenciamento de dependências

## 📁 Estrutura do Projeto

```
src/
├── main/java/
│   ├── Pages/           # Page Objects
│   │   ├── BasePage.java
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   └── RegistrationPage.java
│   └── config/
│       └── WebDriverConfig.java
└── test/java/
    ├── BaseTest.java    # Classe base para testes
    ├── RegisterUser.java
    ├── SeleniumCadastro.java
    └── Slogan.java
```

## 🚀 Como Executar

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd selenium-automation
```

### 2. Execute os testes
```bash
# Executar todos os testes
mvn test

# Executar testes específicos
mvn test -Dtest=RegisterUser

# Executar com relatório Allure
mvn clean test allure:report
```

### 3. Visualizar relatórios
```bash
# Abrir relatório Allure
mvn allure:serve
```

## 📊 Relatórios

O projeto gera relatórios detalhados usando Allure Reports, incluindo:
- Screenshots de falhas
- Logs de execução
- Métricas de performance
- Análise de tendências

## 🧪 Casos de Teste

### RegisterUser.java
- **registerUser()**: Cadastro completo de usuário
- **loginUserCorrectCredentials()**: Login com credenciais válidas
- **loginComCredenciaisIncorretas()**: Login com credenciais inválidas

### SeleniumCadastro.java
- **createDonationPoint()**: Cadastro de ponto de doação

### Slogan.java
- **addsTwoNumbers()**: Verificação do slogan do site

## 🔧 Configurações

### Navegadores Suportados
- Chrome (padrão)
- Firefox
- Edge

### Configurações de Timeout
- Implicit Wait: 10 segundos
- Page Load Timeout: 30 segundos
- Explicit Wait: 10 segundos

## 📝 Melhorias Implementadas

1. **WebDriverManager**: Gerenciamento automático de drivers
2. **BasePage**: Classe base com métodos utilitários
3. **Explicit Waits**: Esperas explícitas para maior estabilidade
4. **Logging**: Sistema de logs para debug
5. **Faker**: Geração automática de dados de teste
6. **Allure Reports**: Relatórios detalhados
7. **Page Object Model**: Padrão de design implementado
8. **Configuração Centralizada**: WebDriverConfig para múltiplos navegadores

## 🐛 Troubleshooting

### Problemas Comuns

1. **Driver não encontrado**: WebDriverManager resolve automaticamente
2. **Elementos não encontrados**: Verificar se os seletores estão atualizados
3. **Timeouts**: Ajustar configurações de wait conforme necessário

### Logs
Os logs são gerados automaticamente e podem ser encontrados em:
- Console durante execução
- Relatórios Allure
- Arquivos de log do Maven

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor
Alexandre Gullo 
Desenvolvido como projeto de estudo em automação de testes com Selenium.
