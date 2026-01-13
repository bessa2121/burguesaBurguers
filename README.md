# Projeto BurguesaBurguer
Projeto criado para pratica com intuito de simular uma situação profissional...
Projeto realizado por dois coders





# 🍽️ Sistema de Gestão de Restaurante

## 📌 Descrição
Este projeto consiste em um sistema web para controle e gerenciamento de pedidos em um restaurante.  
O sistema permite organizar mesas, pratos e pedidos, automatizando o cálculo da conta e o controle do fluxo de atendimento, desde o pedido até o fechamento da conta.

O objetivo é reduzir erros manuais, melhorar a organização e simular um sistema real utilizado em restaurantes.

---

## 🧩 O que o sistema faz

O sistema permitirá:

- Cadastro de pratos (nome, preço, descrição e categoria)
- Cadastro de mesas
- Abertura de pedidos por mesa
- Inclusão e remoção de itens nos pedidos
- Controle do status do pedido:
  - Em preparo
  - Pronto
  - Entregue
- Cálculo automático do valor total
- Fechamento do pedido
- Geração de relatório diário de vendas

---

## 👥 Divisão de responsabilidades

### 👤 Coder 1 — SQL + HTML + CSS

Responsável pela interface do sistema e estrutura do banco de dados.

**Banco de dados (SQL):**
- Criar tabelas:
  - mesas
  - pratos
  - pedidos
  - itens_pedido
  - funcionarios (opcional)
- Definir relacionamentos entre tabelas
- Garantir integridade dos dados

**Interface (HTML + CSS):**
- Criar telas de:
  - Cadastro de pratos
  - Cadastro de mesas
  - Abertura de pedidos
  - Adição de itens ao pedido
  - Visualização dos pedidos
  - Fechamento de conta
- Desenvolver layout, botões e formulários

---

### 👤 Coder 2 — Java + Conexão com Banco

Responsável pela lógica do sistema e integração com o banco de dados.

**Java:**
- Implementar conexão com o banco de dados (JDBC ou framework)
- Criar funcionalidades de:
  - Inserir pedidos
  - Adicionar e remover itens
  - Atualizar status dos pedidos
  - Calcular total automaticamente
  - Fechar pedidos
  - Gerar relatório de vendas

**Regras de negócio:**
- Não permitir fechar pedidos vazios
- Não permitir adicionar itens após o fechamento
- Garantir que uma mesa só tenha um pedido ativo

---

## 🎯 Motivo para escolha do projeto

Este projeto é ideal porque:

- Simula um sistema comercial real
- Envolve CRUD e regras de negócio
- Trabalha com relacionamentos no banco de dados
- Exige cálculos e validações no Java
- Possui interface web funcional
- É um ótimo projeto para portfólio e apresentações

---

## ⚙️ Nível de dificuldade

**Média (⭐⭐⭐☆☆)**

O projeto é equilibrado:
- Mais avançado que um CRUD simples
- Não é complexo demais para uma dupla
- Permite divisão clara de tarefas
- Possui desafios reais de programação

---

## 🛠️ Tecnologias

- Java
- SQL (MySQL, PostgreSQL ou similar)
- HTML
- CSS

---

## 📊 UML

<img width="931" height="496" alt="Captura de tela 2026-01-13 201936" src="https://github.com/user-attachments/assets/f51296d6-d813-4244-bb43-f810febf632d" />

<img width="900" height="653" alt="Captura de tela 2026-01-13 201941" src="https://github.com/user-attachments/assets/dc295b61-08b8-4ea6-8e50-8857c37b3e80" />
