# 📅 Sistema de Gestão de Escalas de Funcionários

Um sistema Full Stack para gerenciamento de turnos e escalas de trabalho, desenvolvido para resolver o problema de alocação de recursos e conflitos de horários.

## 🚀 Tecnologias Utilizadas

* **Java 21** & **Spring Boot 3**
* **Spring Data JPA** (PostgreSQL)
* **Thymeleaf** (Server-side rendering) & **Bootstrap 5**
* **Validation API** (Regras de negócio e integridade de dados)
* **Lombok**

## ⚙️ Funcionalidades

* ✅ **CRUD Completo:** Gerenciamento de Funcionários, Turnos e Escalas.
* 🛡️ **Validações de Negócio:** Impede que um funcionário seja escalado duas vezes no mesmo dia.
* 🎨 **Interface Responsiva:** Layout padronizado com Thymeleaf Layout Dialect.
* 🔍 **Tratamento de Erros:** Global Exception Handler para mensagens amigáveis ao usuário.

## 🛠️ Como executar

1. Clone o repositório.
2. Configure as variáveis de ambiente no seu `application.properties` ou IDE:
   * `DB_URL`, `DB_USER`, `DB_PASSWORD`
3. Execute a classe `EscalaFuncionariosApplication`.
4. Acesse: `http://localhost:8080/ui/escalas`

---
Desenvolvido como projeto prático de aprofundamento em Java Backend.
