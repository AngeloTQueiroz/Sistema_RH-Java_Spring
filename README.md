# 🏢 Sistema RH - Spring Boot

<div align="center">

![Java](https://img.shields.io/badge/Java-22-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.0-purple?style=for-the-badge&logo=bootstrap)

**Sistema completo de Recursos Humanos para gestão de vagas e candidatos**

[🚀 Começar](#-como-executar) • [📋 Funcionalidades](#-funcionalidades) • [🛠 Tecnologias](#-tecnologias)

</div>

## 📸 Preview

| Lista de Vagas | Cadastro de Vaga | Candidatos por Vaga |
|:--------------:|:----------------:|:-------------------:|
| ![Lista](https://via.placeholder.com/300x200/4A90E2/FFFFFF?text=Lista+Vagas) | ![Cadastro](https://via.placeholder.com/300x200/50C878/FFFFFF?text=Cadastro+Vaga) | ![Candidatos](https://via.placeholder.com/300x200/F39C12/FFFFFF?text=Candidatos) |

## ✨ Funcionalidades

### 🎯 Gestão de Vagas
- ✅ **Cadastrar** novas vagas de emprego
- 📋 **Listar** todas as vagas disponíveis
- ✏️ **Editar** informações das vagas
- 🗑️ **Excluir** vagas do sistema

### 👥 Gestão de Candidatos
- 👤 **Adicionar** candidatos às vagas
- 📧 **Validação** de email e RG
- 🔍 **Visualizar** candidatos por vaga
- 🚫 **Remover** candidatos

### 🛡️ Validações Inteligentes
- 🔒 **RG**: Apenas números (8-10 dígitos)
- 📧 **Email**: Formato válido automático
- ⚠️ **Campos obrigatórios**: Validação em tempo real

## 🛠 Tecnologias

| Camada          | Tecnologia                                                                 |
|-----------------|----------------------------------------------------------------------------|
| **Backend**     | Java 17 • Spring Boot 3 • Spring MVC • Spring Data JPA • Bean Validation  |
| **Frontend**    | Thymeleaf • Bootstrap 5 • HTML5 • CSS3                                    |
| **Banco**       | MySQL 8.0 • JPA • Hibernate                                               |
| **Ferramentas** | Maven • Git • Spring DevTools                                            |

## 🚀 Como Executar

### 📋 Pré-requisitos
- Java 17+
- MySQL 8.0+
- Maven 3.6+

### ⚙️ Configuração Rápida

1. **Clone o projeto**
```bash
git clone https://github.com/AngeloTQueiroz/Sistema_RH-Java_Spring.git
cd Sistema_RH-Java_Spring
