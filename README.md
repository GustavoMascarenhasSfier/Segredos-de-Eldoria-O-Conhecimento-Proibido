# 🏛️ Segredos de Eldoria — O Conhecimento Proibido

> *"Os segredos de Eldoria ainda não terminaram..."*

Um jogo de aventura e exploração top-down desenvolvido em **Java**, onde o jogador embarca em uma jornada por uma biblioteca ancestral repleta de enigmas, itens escondidos e conhecimentos proibidos.

---

## 📖 História

Em uma antiga região esquecida pelo tempo, existe uma biblioteca cercada por histórias proibidas e mistérios que jamais deveriam ser descobertos. Dizem que em suas salas escondidas está guardado um livro capaz de revelar verdades sobre o passado, o presente e até o destino das pessoas que ousassem procurá-lo.

O protagonista cresce ouvindo esses rumores — até encontrar símbolos estranhos na praça de sua vila. Movido pela curiosidade, decide iniciar uma jornada em busca da verdade. Mas nenhum conhecimento é entregue facilmente: apenas resolvendo os enigmas deixados pelos antigos guardiões ele descobrirá onde está a chave da biblioteca antiga.

---

## 🎮 Funcionalidades

- **Exploração top-down** com animação de personagem em 4 direções
- **7 cenários** interligados com transições e sistema de teleporte
- **Sistema de inventário** com até 5 itens, empilhamento e navegação por teclas
- **Coleta de itens** e interação com objetos no cenário
- **Charadas e enigmas** com overlay interativo de múltipla escolha
- **Lanterna coletável** que altera o sprite do jogador
- **Tela inicial** animada com fade-in/fade-out e menu de navegação
- **Tela de história** com 7 páginas de lore navegáveis
- **Detecção de colisão** com objetos, paredes e limites de mapa
- **Game loop** rodando a 60 FPS com controle de tempo via `Thread`

---

## 🕹️ Controles

| Tecla | Ação |
|-------|------|
| `W` `A` `S` `D` | Mover o personagem |
| `F` | Interagir / Pegar item |
| `Q` | Slot de inventário anterior |
| `E` | Próximo slot de inventário |
| `ESC` | Fechar overlay / Voltar |
| `V` | Alternar exibição de hitboxes (debug) |

---

## 🗂️ Estrutura do Projeto

```
Segredos-de-Eldoria/
├── src/
│   └── jogoBiblioteca/
│       ├── Principal.java              # Ponto de entrada (main)
│       ├── TelaInicial.java            # Menu principal animado
│       ├── Moldura.java                # Janela principal do jogo
│       ├── Painel.java                 # Painel de renderização central
│       ├── PainelSul.java              # Painel do inventário (parte inferior)
│       ├── GameLoop.java               # Loop principal a 60 FPS
│       ├── Player.java                 # Lógica e sprites do jogador
│       ├── EscutadorTeclado.java       # Captura de input do teclado
│       ├── VerificadorDeColisao.java   # Detecção de colisões
│       ├── GerenciadorSprites.java     # Carregamento e gestão de sprites
│       ├── SpriteLoop.java             # Animação de sprites
│       ├── RenderizadorCena.java       # Renderização da cena
│       ├── Inventario.java             # Sistema de inventário (5 slots)
│       ├── Item.java                   # Modelo de item
│       ├── OverlayCharada.java         # UI da charada interativa
│       ├── OverlayMensagemSucesso.java # UI de mensagem de sucesso
│       ├── Tiles.java                  # Carregamento de tiles do mapa
│       ├── tileMap.java                # Renderização do tile map
│       ├── Final.java                  # Tela de encerramento ("Continua...")
│       └── cenarios/
│           ├── CenarioBase.java        # Classe abstrata base dos cenários
│           ├── Cenario1.java           # Vila / Praça inicial
│           ├── Cenario2.java
│           ├── Cenario3.java
│           ├── Cenario4.java
│           ├── Cenario5.java
│           ├── Cenario6.java
│           ├── Cenario7.java           # Sala final da biblioteca
│           └── desenho/
│               ├── DesenhistaCenario.java      # Interface de desenho
│               ├── DesenhistaCenario1.java
│               ├── DesenhistaCenario2.java
│               ├── DesenhistaCenario3.java
│               ├── DesenhistaCenario4.java
│               ├── DesenhistaCenario5.java
│               ├── DesenhistaCenario6.java
│               └── DesenhistaCenario7.java
└── res/
    ├── PLAYERS/
    │   ├── Normal/         # Sprites padrão (up/down/left/right × 3 frames)
    │   └── ComLanterna/    # Sprites com lanterna coletada
    ├── TILES/              # Tiles de chão, grama, areia, água, paredes
    ├── OBJECTS/            # Sprites de objetos (casa, árvores, baú, cerca...)
    └── cenarios/
        └── cenario1/       # Assets específicos de cada cenário (estátua, etc.)
```

---

## ⚙️ Arquitetura

### Game Loop
O `GameLoop` roda em uma `Thread` separada a **60 FPS**. A cada frame ele:
1. Lê o estado do teclado via `EscutadorTeclado`
2. Atualiza a animação do sprite do jogador
3. Verifica colisões antes de mover
4. Processa transições de cenário e proximidade com objetos
5. Gerencia ações do inventário (selecionar, usar, coletar)
6. Chama `repaint()` no painel principal e no painel do inventário

### Sistema de Cenários
Cada cenário herda de `CenarioBase` e define:
- `MAPA[][]` — matriz de IDs de tiles para montagem do tile map
- `inicializarHitboxes()` — lista de `Rectangle` para colisão com objetos
- `verificarTransicao()` — detecta quando o jogador entra em área de transição
- `verificarProximidade()` — detecta interações com objetos próximos
- `processarInteracao()` — lógica de pegar/depositar itens

### Inventário
Capacidade de **5 slots**. Itens de mesmo nome são empilhados automaticamente. O jogador navega pelos slots com `Q`/`E` e usa/descarta com `F`.

### Colisão
O `VerificadorDeColisao` projeta a área de colisão do jogador na direção do movimento e verifica interseção com os hitboxes do cenário antes de atualizar a posição.

---

## 🚀 Como Executar

**Requisitos:** Java 17 ou superior

```bash
# Compilar
javac -d out src/jogoBiblioteca/**/*.java src/jogoBiblioteca/*.java

# Executar (a partir da pasta raiz do projeto)
java -cp out jogoBiblioteca.Principal
```

> **Importante:** o jogo deve ser executado a partir da raiz do projeto, pois os assets são carregados com caminhos relativos a partir de `res/`.

Também é possível abrir e rodar diretamente pela **IntelliJ IDEA** — o projeto já inclui os arquivos `.idea/` de configuração.

---

## 🧩 Enigma da Charada

Dentro do jogo, o jogador encontra uma charada guardada por um antigo oráculo:

> *"A sabedoria não está na força, mas na observação.*
> *Brilho durante o dia, desapareço à noite."*
>
> **Qual porta você deve cruzar?** ☀️ Sol · 🌙 Lua · ⭐ Estrela

A resposta correta desbloqueia o caminho para a sala final da biblioteca.

---

## 🛠️ Tecnologias

- **Java** — linguagem principal
- **Java Swing** (`JFrame`, `JPanel`, `Timer`) — interface gráfica
- **Java AWT** (`Graphics2D`, `Rectangle`, `GradientPaint`) — renderização 2D
- **IntelliJ IDEA** — ambiente de desenvolvimento

---

## 👥 Equipe

Projeto desenvolvido como trabalho acadêmico.

---

## 📜 Licença

Este projeto é de uso educacional.
