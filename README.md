# 🏛️ Segredos de Eldoria — O Conhecimento Proibido

> *"Os segredos de Eldoria ainda não terminaram..."*

Um jogo de aventura e exploração **top-down** desenvolvido em **Java puro**, onde o jogador embarca em uma jornada por uma biblioteca ancestral repleta de enigmas, itens escondidos e conhecimentos proibidos.

---

## 📖 História

Em uma antiga região esquecida pelo tempo, existe uma biblioteca cercada por histórias proibidas e mistérios que jamais deveriam ser descobertos. Dizem que em suas salas escondidas está guardado um livro capaz de revelar verdades sobre o passado, o presente e até o destino das pessoas que ousassem procurá-lo.

O protagonista cresce ouvindo esses rumores — até encontrar símbolos estranhos na praça de sua vila. Movido pela curiosidade, decide iniciar uma jornada em busca da verdade. Mas nenhum conhecimento é entregue facilmente: apenas resolvendo os enigmas deixados pelos antigos guardiões ele descobrirá onde está a chave da biblioteca antiga.

---

## 🎮 Funcionalidades

- **Exploração top-down** com animação de personagem em 4 direções (3 frames por direção)
- **7 cenários** interligados com transições e sistema de teleporte entre áreas
- **Sistema de inventário** com até 5 slots, empilhamento automático de itens e navegação por teclas
- **Coleta de itens** e interação com objetos no cenário via tecla de ação
- **Charadas e enigmas** com overlay interativo de múltipla escolha
- **Lanterna coletável** que altera visualmente o sprite do jogador
- **Tela inicial** animada com fade-in/fade-out e menu de navegação
- **Tela de história** com 7 páginas de lore navegáveis
- **Detecção de colisão** precisa com objetos, paredes e limites de mapa
- **Game loop** rodando a 60 FPS com controle de tempo via `Thread` dedicada
- **Modo de debug** para visualização de hitboxes (tecla `V`)

---

## 🕹️ Controles

| Tecla | Ação |
|-------|------|
| `W` `A` `S` `D` | Mover o personagem (cima / esquerda / baixo / direita) |
| `F` | Interagir com objetos / Pegar item |
| `Q` | Slot de inventário anterior |
| `E` | Próximo slot de inventário |
| `ESC` | Fechar overlay / Voltar ao menu |
| `V` | Alternar exibição de hitboxes (modo debug) |

---

## 🗺️ Cenários

O jogo é composto por **7 cenários** conectados entre si, cada um com sua identidade visual e jogabilidade:

| Cenário | Descrição |
|---------|-----------|
| **Cenário 1** | Vila / Praça inicial — ponto de partida da aventura. Possui estátua interativa, casa e árvores. |
| **Cenário 2** | Vilarejo externo — ruas com casas, chafariz, moitas e postes. |
| **Cenário 3** | Biblioteca ancestral — ambiente interno com estantes, lareira, lanterna, piano e criaturas. |
| **Cenário 4** | Sala dos segredos — mobília especial, globo, chaves dourada e prateada, teias de aranha. |
| **Cenário 5** | Área de transição / exploração intermediária. |
| **Cenário 6** | Sala dos livros proibidos — contém os 4 livros do conhecimento. |
| **Cenário 7** | Sala final da biblioteca — desfecho da jornada. |

---

## 🧩 Enigma da Charada

Dentro do jogo, o jogador encontra uma charada guardada por um antigo oráculo:

> *"A sabedoria não está na força, mas na observação.*
> *Brilho durante o dia, desapareço à noite."*
>
> **Qual porta você deve cruzar?** ☀️ Sol · 🌙 Lua · ⭐ Estrela

A resposta correta desbloqueia o caminho para a sala final da biblioteca.

---

## 🗂️ Estrutura do Projeto

```
Segredos-de-Eldoria/
├── src/
│   └── jogoBiblioteca/
│       ├── Principal.java                  # Ponto de entrada (main)
│       ├── TelaInicial.java                # Menu principal animado com fade
│       ├── Moldura.java                    # Janela principal do jogo (JFrame)
│       ├── Painel.java                     # Painel de renderização central
│       ├── PainelSul.java                  # Painel do inventário (parte inferior)
│       ├── GameLoop.java                   # Loop principal a 60 FPS
│       ├── Player.java                     # Lógica, posição e sprites do jogador
│       ├── EscutadorTeclado.java           # Captura de input do teclado
│       ├── VerificadorDeColisao.java       # Detecção de colisões por projeção
│       ├── GerenciadorSprites.java         # Carregamento e gestão de sprites
│       ├── SpriteLoop.java                 # Controle de animação de sprites
│       ├── RenderizadorCena.java           # Renderização da cena atual
│       ├── Inventario.java                 # Sistema de inventário (5 slots)
│       ├── Item.java                       # Modelo de item (nome + quantidade)
│       ├── OverlayCharada.java             # UI da charada interativa
│       ├── OverlayMensagemSucesso.java     # UI de mensagem de sucesso
│       ├── Tiles.java                      # Carregamento de tiles do mapa
│       ├── tileMap.java                    # Renderização do tile map
│       ├── Final.java                      # Tela de encerramento ("Continua...")
│       └── cenarios/
│           ├── CenarioBase.java            # Classe abstrata base dos cenários
│           ├── Cenario1.java               # Vila / Praça inicial
│           ├── Cenario2.java               # Vilarejo externo
│           ├── Cenario3.java               # Biblioteca ancestral (interior)
│           ├── Cenario4.java               # Sala dos segredos
│           ├── Cenario5.java               # Área intermediária
│           ├── Cenario6.java               # Sala dos livros proibidos
│           ├── Cenario7.java               # Sala final da biblioteca
│           └── desenho/
│               ├── DesenhistaCenario.java      # Interface de desenho de cenário
│               ├── DesenhistaCenario1.java
│               ├── DesenhistaCenario2.java
│               ├── DesenhistaCenario3.java
│               ├── DesenhistaCenario4.java
│               ├── DesenhistaCenario5.java
│               ├── DesenhistaCenario6.java
│               └── DesenhistaCenario7.java
└── res/
    ├── PLAYERS/
    │   ├── Normal/            # Sprites padrão: down/up/left/right × 3 frames
    │   └── ComLanterna/       # Sprites com lanterna equipada × 3 frames
    ├── TILES/                 # Tiles: grama, areia, água, paredes, chão, decoração
    ├── OBJECTS/               # Objetos globais: casa, árvores, baú, cerca...
    └── cenarios/
        ├── cenario1/          # Assets do cenário 1: estátua, banco, árvores, casa
        ├── cenario2/          # Assets do cenário 2: casas, chafariz, moitas, poste
        ├── cenario3_biblioteca/ # Assets da biblioteca: estantes, lareira, lanterna...
        ├── cenario4/          # Assets da sala de segredos: chaves, globo, teias...
        └── cenario6/          # Assets dos livros proibidos: livro1 a livro4
```

---

## ⚙️ Arquitetura Técnica

### Game Loop

O `GameLoop` roda em uma `Thread` separada a **60 FPS**. A cada frame ele:

1. Lê o estado do teclado via `EscutadorTeclado`
2. Verifica a direção de movimento e aplica debounce nas teclas de inventário
3. Consulta o `VerificadorDeColisao` antes de mover o jogador
4. Atualiza a animação do sprite do jogador via `SpriteLoop`
5. Processa transições de cenário ao detectar áreas de teleporte
6. Detecta proximidade com objetos interativos e processa ações (`F`)
7. Gerencia ações do inventário (selecionar slot, coletar, usar itens)
8. Chama `repaint()` no painel principal e no painel de inventário

### Sistema de Cenários

Cada cenário herda de `CenarioBase` e implementa:

- `MAPA[][]` — matriz de IDs de tiles para composição do tile map
- `inicializarHitboxes()` — lista de `Rectangle` para colisão com objetos
- `verificarTransicao()` — detecta quando o jogador entra em área de transição entre cenas
- `verificarProximidade()` — detecta objetos próximos passíveis de interação
- `processarInteracao()` — lógica de pegar/depositar/usar itens

A renderização visual fica separada nas classes `DesenhistaCenarioN`, seguindo o princípio de responsabilidade única.

### Sistema de Inventário

- Capacidade fixa de **5 slots** (`Inventario.CAPACIDADE = 5`)
- Itens de mesmo nome são **empilhados automaticamente** (sem ocupar novo slot)
- O jogador navega pelos slots com `Q` (anterior) e `E` (próximo)
- A remoção de itens decrementa a quantidade; ao chegar a zero o item é removido da lista

### Detecção de Colisão

O `VerificadorDeColisao` **projeta a área de colisão** do jogador na direção do movimento e verifica interseção com os retângulos de hitbox do cenário antes de atualizar a posição — evitando sobreposição com paredes e objetos.

### Sistema de Sprites

O `Player` carrega dois conjuntos de sprites:
- **Normal** — 4 direções × 3 frames = 12 imagens
- **ComLanterna** — 4 direções × 3 frames = 12 imagens (visual alternativo após coletar a lanterna)

A troca de conjunto é automática ao coletar o item de lanterna no cenário 3.

---

## 🚀 Como Executar

### Pré-requisitos

- **Java 17** ou superior instalado (`java -version` para verificar)
- IDE recomendada: **IntelliJ IDEA** (configuração `.idea/` já incluída no projeto)

### Compilar e rodar via terminal

```bash
# Na raiz do projeto, compile todos os arquivos .java
javac -d out src/jogoBiblioteca/**/*.java src/jogoBiblioteca/*.java

# Execute a partir da raiz (obrigatório para carregar os assets em res/)
java -cp out jogoBiblioteca.Principal
```

> ⚠️ **Importante:** o jogo **deve ser executado a partir da pasta raiz** do projeto, pois os assets são carregados com caminhos relativos (`res/PLAYERS/...`, `res/TILES/...` etc.).

### Rodar via IntelliJ IDEA

1. Abra a pasta do projeto no IntelliJ IDEA
2. Aguarde a indexação (o arquivo `JogoBiblioteca.iml` já configura os source roots)
3. Localize `Principal.java` e clique em **Run ▶**
4. Verifique que o **working directory** da run configuration aponta para a raiz do projeto

---

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Uso |
|------------|-----|
| **Java 17+** | Linguagem principal |
| **Java Swing** (`JFrame`, `JPanel`, `Timer`) | Interface gráfica e janela do jogo |
| **Java AWT** (`Graphics2D`, `Rectangle`, `GradientPaint`) | Renderização 2D e sistema de colisão |
| **`Thread` + `System.nanoTime()`** | Controle preciso do game loop a 60 FPS |
| **`ImageIcon`** | Carregamento de imagens PNG dos sprites e tiles |
| **IntelliJ IDEA** | Ambiente de desenvolvimento (`.idea/` incluso) |

---

## 📦 Assets

### Sprites do jogador

| Pasta | Conteúdo |
|-------|----------|
| `res/PLAYERS/Normal/` | `down1-3`, `up1-3`, `left1-3`, `right1-3` |
| `res/PLAYERS/ComLanterna/` | Mesmas animações com lanterna na mão |

### Tiles do mapa

Localizados em `res/TILES/`: `grass1-6`, `sand1`, `SandH/V/D/T/L/R/SL/SR/IL/IR`, `water1`, `wall1`, `chao`, `gray`, `white`, `GrassDecoration1-2`, `MuroMundo1-2`

### Objetos e cenários

| Pasta | Principais assets |
|-------|------------------|
| `res/OBJECTS/` | `House`, `Trees`, `chest`, `Cerca`, `Spring Crops`, `Interior`, `Road` |
| `res/cenarios/cenario1/` | `BancoEstatua`, `Plants`, `Tree1-2`, `chest` |
| `res/cenarios/cenario2/` | `house1-4`, `chafariz`, `moita1-4`, `poste`, `cerca` |
| `res/cenarios/cenario3_biblioteca/` | `estante`, `lareira`, `lanterna`, `piano`, `livroAberto/Fechado`, `tapete`, `velas`, `bicho1-2` |
| `res/cenarios/cenario4/` | `Golden Key`, `Silver Key`, `Globo`, `Teia1-5`, `furniture_and_props` |
| `res/cenarios/cenario6/` | `livro1-4` (livros do conhecimento proibido) |

---

## 👥 Equipe

Projeto desenvolvido como **trabalho acadêmico**.

---

## 📜 Licença

Este projeto é de uso **educacional**. Todos os assets gráficos foram utilizados no contexto de aprendizado e desenvolvimento acadêmico.
