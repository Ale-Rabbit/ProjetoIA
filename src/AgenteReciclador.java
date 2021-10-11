public class AgenteReciclador {

    public String nome;
    public int capacidade;
    public int linha;
    public int coluna;

    public AgenteReciclador(String nome, int linha, int coluna) {
        this.nome = nome;
        this.capacidade = 0;
        this.linha = linha;
        this.coluna = coluna;
    }

    public Boolean temCapacidade(int num){
        if (capacidade == 4){
            return false;
        }else{
            return true;
        }
    }

    public void moveAgenteParaEsquerda(String[][] matriz, AgenteReciclador ag){
        ag.setCapacidade(ag.getCapacidade() + 1);
        matriz[ag.getLinha()][ag.getColuna()] = "-";
        ag.setLinha(ag.getLinha());
        ag.setColuna(ag.getColuna() - 1);
        matriz[ag.getLinha()][ag.getColuna() - 1] = ag.getNome();
    }

    public void teste(String[][] matriz, AgenteReciclador ag) {
        if(ag.getLinha() == 1 || ag.getLinha() == 4 || ag.getLinha() == 7 || ag.getLinha() == 10){
            if(ag.getNome() == "As"){
                // Olha a coluna da esquerda
                if(matriz[ag.getLinha()][ag.getColuna() - 1] == "S"){
                    moveAgenteParaEsquerda(matriz, ag);
                }
            }else if(ag.getNome() == "Ae"){
                // Olha a coluna da esquerda
                if(matriz[ag.getLinha()][ag.getColuna() - 1] == "E"){
                    moveAgenteParaEsquerda(matriz, ag);
                }
            }else {
            // Olha a coluna da esquerda
                if (matriz[ag.getLinha()][ag.getColuna() - 1] == "O") {
                    moveAgenteParaEsquerda(matriz, ag);
                }
            }
        }else{
            //baixo ou cima
        }
//            matriz[ag.getLinha() + 1][ag.getColuna()]
//            matriz[ag.getLinha() - 1][ag.getColuna()]
//            matriz[ag.getLinha()][ag.getColuna() - 1]
//            matriz[ag.getLinha()][ag.getColuna() + 1]
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
