import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {
    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2, Tabuleiro tabuleiro) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.tabuleiro = tabuleiro;
    }

    private void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Jogador jogadorAtual = jogador1;

        while (!tabuleiro.acabouOJogo()) {
            System.out.println("Vez de: " + jogadorAtual.getNome());
            int linha, coluna;

            if (jogadorAtual == jogador1) {
                while (true) {
                    try {
                        System.out.print("Digite a linha (0, 1 ou 2): ");
                        linha = Integer.parseInt(scanner.nextLine());
                        System.out.print("Digite a coluna (0, 1 ou 2): ");
                        coluna = Integer.parseInt(scanner.nextLine());

                        if (tabuleiro.jogar(jogadorAtual.getSimbolo(), linha, coluna)) {
                            break;
                        } else {
                            System.out.println("Posição inválida ou já preenchida. Tente novamente.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, digite um número válido.");
                    }
                }
            } else {
                do {
                    linha = random.nextInt(3);
                    coluna = random.nextInt(3);
                } while (!tabuleiro.jogar(jogadorAtual.getSimbolo(), linha, coluna));
                System.out.println("O computador jogou na linha " + linha + " e coluna " + coluna);
            }

            tabuleiro.mostrar();

            if (tabuleiro.acabouOJogo()) {
                break;
            }

            jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
        }

        if (tabuleiro.haUmVencedor()) {
            char vencedor = tabuleiro.getSimboloVencedor();
            if (vencedor == jogador1.getSimbolo()) {
                System.out.println("O jogador 1 ganhou");
            } else {
                System.out.println("O jogador 2 ganhou");
            }
        } else {
            System.out.println("O jogo terminou empatado.");
        }

        System.out.println("Criado por Diego Alexandre");
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Velha Interativo!");

        char simboloHumano;
        do {
            System.out.print("Qual símbolo você deseja usar? (X ou O): ");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() > 0) {
                simboloHumano = input.charAt(0);
                if (simboloHumano == 'X' || simboloHumano == 'O') {
                    break;
                }
            }
            System.out.println("Opção inválida. Por favor, escolha X ou O.");
        } while (true);

        char simboloComputador = (simboloHumano == 'X') ? 'O' : 'X';

        Jogador jogador1 = new Jogador("Jogador 1", simboloHumano);
        Jogador jogador2 = new Jogador("Jogador 2", simboloComputador);
        Tabuleiro tabuleiro = new Tabuleiro();

        JogoDaVelha jogoDaVelha = new JogoDaVelha(jogador1, jogador2, tabuleiro);
        jogoDaVelha.iniciar();

        scanner.close();
    }
}
