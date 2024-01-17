# Bowling Score Calculator

Este é um programa simples para calcular a pontuação em um jogo de boliche de dez pinos. O programa oferece uma classe ou módulo que expõe duas funções:

- void roll(int pins): Registra a quantidade de pinos derrubados em um arremesso.
- int score(): Calcula e retorna a pontuação total do jogo.

## Regras do Boliche de Dez Pinos

Um jogo de boliche é composto por dez "frames". Em cada frame, um jogador tem dois arremessos para tentar derrubar todos os 10 pinos.

- O número de pinos derrubados em um frame é a pontuação para aquele frame, e a pontuação total do jogo é a soma das pontuações de cada frame.

- Se um jogador derruba todos os 10 pinos com dois arremessos, isso é chamado de "spare". A pontuação do próximo arremesso é adicionada aos 10 pontos do spare.

- Se um jogador derruba todos os 10 pinos com um arremesso, isso é chamado de "strike". O frame termina, e a pontuação dos próximos dois arremessos é adicionada aos 10 pontos do strike.

- Se um jogador faz um strike ou spare no último (10º) frame, então eles podem fazer arremessos adicionais necessários para calcular a pontuação final do strike ou spare.

Para mais informações sobre a prática de TDD (Desenvolvimento Orientado por Testes) e a Kata do Boliche, você pode visitar [o site da Codurance](https://www.codurance.com/katas/bowling).