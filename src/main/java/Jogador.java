public class Jogador {
    private char simbolo;
    private String nome;

    public Jogador(String nome, char simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Jogador(char simbolo) {
        this.nome = "Jogador";
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    public String getNome() {
        return this.nome;
    }
}
