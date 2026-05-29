public class Tabuleiro {
    private char[][] casas = new char[3][3];

    public Tabuleiro()
    {
        for (int i=0;i<3;i++)
        {
            for (int j=0;j<3;j++)
            {
                this.casas[i][j] = ' ';
            }        
        }
    }

    public boolean jogar(char simbolo, int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2 || this.casas[linha][coluna] != ' '){
            return false;
        }
        this.casas[linha][coluna] = simbolo;
        return true;
    }

    public boolean acabouOJogo() {
        return this.todasAsCasasPreenchidas() ||
                this.haUmVencedor();
    }

    public boolean todasAsCasasPreenchidas() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.casas[i][j] != 'O' && this.casas[i][j] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean haUmVencedor() {

        for (int i = 0; i < 3; i++) {
            if (this.casas[i][0] != ' ' && this.casas[i][0] == this.casas[i][1] &&
                    this.casas[i][1] == this.casas[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (this.casas[0][i] != ' ' && this.casas[0][i] == this.casas[1][i] &&
                    this.casas[1][i] == this.casas[2][i]) {
                return true;
            }
        }

        if (this.casas[0][0] != ' ' && this.casas[0][0] == this.casas[1][1] &&
            this.casas[1][1] == this.casas[2][2]) {
            return true;            
        }
        if (this.casas[0][2] != ' ' && this.casas[0][2] == this.casas[1][1] &&
            this.casas[1][1] == this.casas[2][0]) {
            return true;
        }
        return false;        
    }


    public char getSimboloVencedor() {

        for (int i = 0; i < 3; i++) {
            if (this.casas[i][0] != ' ' && this.casas[i][0] == this.casas[i][1] &&
                    this.casas[i][1] == this.casas[i][2]) {
                return this.casas[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (this.casas[0][i] != ' ' && this.casas[0][i] == this.casas[1][i] &&
                    this.casas[1][i] == this.casas[2][i]) {
                return this.casas[0][i];
            }
        }

        if (this.casas[0][0] != ' ' && this.casas[0][0] == this.casas[1][1] &&
            this.casas[1][1] == this.casas[2][2]) {
            return this.casas[0][0];            
        }
        if (this.casas[0][2] != ' ' && this.casas[0][2] == this.casas[1][1] &&
            this.casas[1][1] == this.casas[2][0]) {
            return this.casas[0][2];
        }
        return ' ';
    }

    public void mostrar()
    {
        for(int i=0;i<3;i++)
        {
            System.out.println(" _  _  _");
            for(int j=0;j<3;j++)
            {
                System.out.print("|" + this.casas[i][j] + "|");
            }
            System.out.println(" ");
        }
        System.out.println(" ");    
    }

}
