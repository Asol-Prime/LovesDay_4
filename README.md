
[readme_md.md](https://github.com/user-attachments/files/35392756/readme_md.md)
# 💘 LOVES DAY

```text
 █     ███  █   █ █████  ████   ████   ███  █   █
 █    █   █ █   █ █     █       █   █ █   █  █ █ 
 █    █   █ █   █ ████   ███    █   █ █████   █  
 █    █   █  █ █  █         █   █   █ █   █   █  
 █████ ███    █   █████ ████    ████  █   █   █  
```

> Um simulador de encontros (*Dating Sim*) com elementos de **Roguelite**, humor ácido e estética retrô de terminal (BBS) desenvolvido em **Java puro**.

## 📖 Sobre o Jogo

**Loves Day** é um jogo de texto interativo onde o seu objetivo é conquistar o máximo de *matchs* possíveis antes que suas vidas acabem!

A cada dia, você visita **3 cenários diferentes** da cidade e encontra personagens dos mais variados estilos e tribos urbanas — de *Emos*, *Nerds* e *Patricinhas* a *Agroboys*, *GymRats*, *TikTokers*, *Funkeiros* e *Coaches*.

Escolha suas respostas com sabedoria, gerencie seu dinheiro na loja, compre itens estratégicos para aumentar sua lábia e, quando a rejeição bater forte demais e suas vidas zerarem, utilize o sistema de **Renascimento** para voltar ainda mais forte e desbloquear novos estilos!

## ✨ Principais Funcionalidades

* **🎨 Interface Estilizada no Terminal (ANSI / BBS):** Caixas de diálogo desenhadas em caracteres ASCII e esquema de cores dinâmico que muda conforme o gênero escolhido pelo jogador (Azul, Rosa ou Ciano).
* **🧑‍🎤 Criação de Personagem:** Personalize seu nome, corte de cabelo, altura, gênero, sexualidade e estilo inicial.
* **🎭 16 Tribos / Estilos Únicos de NPCs:** Cada NPC possui ações próprias, diálogos exclusivos, preferências de sexualidade e reações hilárias às suas respostas:
  * *Emo, Playboy, Nerd, Pai de Pet, Noia, Agroboy, GymRats, Hippie, TikToker, K-poper, Patricinha, Twink, Playboy Gay, Gamer, Funkeiro e Coach.*
* **🗺️ 10 Cenários Desbloqueáveis:** Comece no *Parque*, *Praia* e *Biblioteca*, e desbloqueie novos locais a cada 3 dias sobrevividos (*Academia, Fazenda, Pet Shop, Festival, Balada, Shopping* e *Show de K-pop*). Cada local garante bônus de compatibilidade para estilos específicos!
* **🎲 Eventos Aleatórios:** Antes dos encontros, imprevistos podem acontecer — desde encontrar dinheiro no chão ou ganhar amostra grátis de perfume até dar de cara com o seu ex em público.
* **🛒 Loja e Sistema de Itens (RPG/Roguelite):** Use o *Cash* ganho para comprar e evoluir upgrades permanentes ou consumíveis:
  * **Itens Gerais:** *Trufilho* (segunda chance no dia), *Seguro de Vida* (mantém parte do cash ao renascer), *Perfume*, *Livro de Cantadas*, *Energético* e *Coração Extra*.
  * **Itens de Estilo:** 16 acessórios específicos (como *Lápis de Olho*, *Pote de Whey*, *Headset RGB*, *Kenner*, *Ring Light*) que aumentam a chance de match com cada tribo.
* **🔄 Sistema de Renascimento (Prestige):** Ao perder todas as vidas, você renasce desbloqueando novos estilos jogáveis e acumulando progresso.
* **💾 Sistema de Save Local:** Salve e carregue seu progresso a qualquer momento através do arquivo `save.txt`.

## 🕹️ Como Jogar

O jogo é totalmente controlado pelo teclado através de menus numéricos:

1. No menu inicial, escolha **`[1] - JOGAR`** para criar seu personagem ou **`[2] - CONTINUAR`** para carregar um jogo salvo.
2. No **Menu Principal**, você pode:
   * **`[1]`** Iniciar um novo dia (3 encontros por dia).
   * **`[2]`** Acessar a **Loja** para melhorar seus atributos e comprar itens de estilo.
   * **`[3]`** Conferir seu **Inventário**.
   * **`[4]`** Salvar o progresso.
3. Durante um encontro, avalie o estilo do NPC e o cenário. Puxar assunto inicia um diálogo de múltipla escolha que define sua porcentagem de chance de **Match** (atenção: ignorar alguém compatível com seu interesse ou abandonar o dia custa vidas!).

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java (JDK 11 ou superior)
* **Bibliotecas:** Java Standard Library (`java.util.*`, `java.io.*`) — zero dependências externas.
* **Formatação:** ANSI Escape Codes & Box-Drawing Characters.

## 🚀 Como Executar o Projeto

### Pré-requisitos

* Ter o **Java JDK** instalado na máquina.
* Um terminal com suporte a cores ANSI e codificação UTF-8 (Windows Terminal, VS Code, IntelliJ, Linux/macOS Terminal).

### Passo a passo

1. **Clone este repositório:**
   ```bash
   git clone https://github.com/seu-usuario/loves-day.git
   ```

2. **Acesse a pasta do projeto:**
   ```bash
   cd loves-day
   ```

3. **Compile os arquivos Java:**
   ```bash
   javac *.java
   ```

4. **Execute o jogo:**
   ```bash
   java App
   ```

> **💡 Dica para usuários Windows (CMD):** Caso os caracteres das caixas ou acentos apareçam desconfigurados no terminal padrão, execute o comando `chcp 65001` antes de rodar `java App`.

## 📂 Estrutura do Projeto

```text
├── App.java             # Ponto de entrada e loop principal do jogo
├── Personagem.java      # Criação e atributos do jogador + desbloqueio de estilos
├── Dias.java            # Gerenciamento dos dias, cenários e dificuldade progressiva
├── Eventos.java         # Sistema de eventos aleatórios pré-encontro
├── NPCs.java            # Classe base abstrata e fábrica de geração de NPCs
├── NPC*.java            # Classes específicas para cada um dos 16 estilos de NPCs
├── Inventario.java      # Catálogo e gerenciamento de níveis dos itens
├── Loja.java            # Sistema de compra e upgrade de itens
├── Status.java          # Controle de vidas, cash, matchs, dias e renascimentos
├── Renascer.java        # Mecânica de prestige/renascimento após Game Over
├── Save.java            # Persistência de dados em arquivo (save.txt)
└── Tela.java            # Motor visual ASCII, caixas de diálogo e cores ANSI
```

## 👨‍💻 Autores

Desenvolvido por **[Seu Nome / Nomes da Equipe]**.
