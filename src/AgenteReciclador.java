// ajustar movimentos para as direções
// colocar limeites da matriz
// novo método para incrementar a capacidade
// nova classe lixeira
// concatenar valores, caso não seja o lixo correspondente

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

        ag.setCapacidade(ag.getCapacidade() + 1); // TODO: colocar em outro lugar
        matriz[ag.getLinha()][ag.getColuna()] = "-";
        ag.setLinha(ag.getLinha());
        ag.setColuna(ag.getColuna() - 1);
        matriz[ag.getLinha()][ag.getColuna()] = ag.getNome();

    }

    public void moveAgenteParaDireita(String[][] matriz, AgenteReciclador ag){
        ag.setCapacidade(ag.getCapacidade() + 1); // TODO: colocar em outro lugar
        matriz[ag.getLinha()][ag.getColuna()] = "-";
        ag.setLinha(ag.getLinha());
        ag.setColuna(ag.getColuna() + 1);
        matriz[ag.getLinha()][ag.getColuna()] = ag.getNome();
    }

    public void moveAgenteParaCima(String[][] matriz, AgenteReciclador ag){
        ag.setCapacidade(ag.getCapacidade() + 1); // TODO: colocar em outro lugar
        matriz[ag.getLinha()][ag.getColuna()] = "-";
        ag.setLinha(ag.getLinha() - 1);
        ag.setColuna(ag.getColuna());
        matriz[ag.getLinha()][ag.getColuna()] = ag.getNome();
    }

    public void moveAgenteParaBaixo(String[][] matriz, AgenteReciclador agente){

        agente.setCapacidade(agente.getCapacidade() + 1); // TODO: colocar em outro lugar
        matriz[agente.getLinha()][agente.getColuna()] = "-";
        agente.setLinha(agente.getLinha() + 1);
        agente.setColuna(agente.getColuna());
        matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();

    }

    public void teste(String[][] matriz, AgenteReciclador agente) {

        Boolean isAgenteEmLinhaEntreCasas = agente.getLinha() == 1 ||
                                            agente.getLinha() == 4 ||
                                            agente.getLinha() == 7 ||
                                            agente.getLinha() == 10;

        if(isAgenteEmLinhaEntreCasas) {

            //======================================================= ESQUERDA

            if(agente.getNome() == "As"){
                // Olha a coluna da esquerda
                if(matriz[agente.getLinha()][agente.getColuna() - 1] == "S"){
                    moveAgenteParaEsquerda(matriz, agente);
                }
            }else if(agente.getNome() == "Ae"){
                // Olha a coluna da esquerda
                if(matriz[agente.getLinha()][agente.getColuna() - 1] == "E"){
                    moveAgenteParaEsquerda(matriz, agente);
                }
            }else {
            // Olha a coluna da esquerda
                if (matriz[agente.getLinha()][agente.getColuna() - 1] == "O") {
                    moveAgenteParaEsquerda(matriz, agente);
                }else{
                    moveAgenteParaEsquerda(matriz, agente);
                }
            }
//================================================================================DIREITA
            if(agente.getNome() == "As"){
                // Olha a coluna da DIREITA
                if(matriz[agente.getLinha()][agente.getColuna() + 1] == "S"){
                    moveAgenteParaDireita(matriz, agente);
                }
            }else if(agente.getNome() == "Ae"){
                // Olha a coluna da DIREITA
                if(matriz[agente.getLinha()][agente.getColuna() + 1] == "E"){
                    moveAgenteParaDireita(matriz, agente);
                }
            }else {
                // Olha a coluna da DIREITA
                if (matriz[agente.getLinha()][agente.getColuna() + 1] == "O") {
                    moveAgenteParaDireita(matriz, agente);
                }
            }
        } else {

            // TODO: caso o agente esteja na ultima linha, deve subir

            moveAgenteParaBaixo(matriz, agente);

        }
//            matriz[agente.getLinha() + 1][agente.getColuna()]
//            matriz[agente.getLinha() - 1][agente.getColuna()]
//            matriz[agente.getLinha()][agente.getColuna() - 1]
//            matriz[agente.getLinha()][agente.getColuna() + 1]
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
