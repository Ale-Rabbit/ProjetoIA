// ajustar movimentos para as direções
// colocar limites da matriz
// novo método para incrementar a capacidade
// nova classe lixeira
// concatenar valores, caso não seja o lixo correspondente

public class AgenteReciclador {

    public String nome;
    public int capacidade;
    public int linha;
    public int coluna;
    public String tipoLixo;
    public String tipoLixeira;

    public AgenteReciclador(String nome, int linha, int coluna, String tipoLixo, String tipoLixeira) {
        this.nome = nome;
        this.capacidade = 0;
        this.linha = linha;
        this.coluna = coluna;
        this.tipoLixo = tipoLixo;
        this.tipoLixeira = tipoLixeira;
    }

    public Boolean temCapacidade(int num){

        if (capacidade == 4){
            return false;
        }else{
            return true;
        }

    }

    public String getApenasLixo(String conteudoAgenteELixo) {

            char[] conteudoEmArray = conteudoAgenteELixo.toCharArray();
            char apenasLixo = conteudoEmArray[conteudoEmArray.length - 1];

            return String.valueOf(apenasLixo);

    }

    public void moveAgenteParaEsquerda(String[][] matriz, AgenteReciclador agente){
        agente.recolheLixo(agente, matriz[agente.getLinha()][agente.getColuna() - 1]);

        if (matriz[agente.getLinha()][agente.getColuna()].length() == 3){
            matriz[agente.getLinha()][agente.getColuna()] = getApenasLixo(matriz[agente.getLinha()][agente.getColuna()]);
        }else {
            matriz[agente.getLinha()][agente.getColuna()] = "-";
        }

        agente.setLinha(agente.getLinha());
        agente.setColuna(agente.getColuna() - 1);
        if (matriz[agente.getLinha()][agente.getColuna()] != "-"){
            matriz[agente.getLinha()][agente.getColuna()] = novoElementoPosicao(matriz[agente.getLinha()][agente.getColuna()], agente);
        }else{
            matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();
        }
    }

    public void moveAgenteParaDireita(String[][] matriz, AgenteReciclador agente){
        agente.recolheLixo(agente, matriz[agente.getLinha()][agente.getColuna() + 1]);

        if (matriz[agente.getLinha()][agente.getColuna()].length() == 3){
            matriz[agente.getLinha()][agente.getColuna()] = getApenasLixo(matriz[agente.getLinha()][agente.getColuna()]);
        }else {
            matriz[agente.getLinha()][agente.getColuna()] = "-";
        }

        agente.setLinha(agente.getLinha());
        agente.setColuna(agente.getColuna() + 1);
        if (matriz[agente.getLinha()][agente.getColuna()] != "-"){
            matriz[agente.getLinha()][agente.getColuna()] = novoElementoPosicao(matriz[agente.getLinha()][agente.getColuna()], agente);
        }else{
            matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();
        }
    }

    public void moveAgenteParaCima(String[][] matriz, AgenteReciclador agente){

        matriz[agente.getLinha()][agente.getColuna()] = "-";
        agente.setLinha(agente.getLinha() - 1);
        agente.setColuna(agente.getColuna());
        matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();
    }

    public void moveAgenteParaBaixo(String[][] matriz, AgenteReciclador agente){

        matriz[agente.getLinha()][agente.getColuna()] = "-";
        agente.setLinha(agente.getLinha() + 1);
        agente.setColuna(agente.getColuna());
        matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();
    }

    public String novoElementoPosicao(String elementoMatriz, AgenteReciclador agente){
        if (agente.getTipoLixo() != elementoMatriz) {
            return agente.getNome() + elementoMatriz;
        }else {
            return agente.getNome();
        }
    }

    public void recolheLixo(AgenteReciclador agente, String elementoMatriz){
        if (agente.getTipoLixo() == elementoMatriz) {
            agente.setCapacidade(agente.getCapacidade() + 1);
        }
    }

    Boolean chegouNoFimDaRua = false;
    public void teste(String[][] matriz, AgenteReciclador agente) {

        Boolean isAgenteEmLinhaEntreCasas = agente.getLinha() == 1 ||
                                            agente.getLinha() == 4 ||
                                            agente.getLinha() == 7 ||
                                            agente.getLinha() == 10;


        if(isAgenteEmLinhaEntreCasas) {

            if(agente.getColuna() > 0 && !chegouNoFimDaRua) {
                moveAgenteParaEsquerda(matriz, agente);

            } else {
                chegouNoFimDaRua = true;

                if(agente.getColuna() < 14) {

                    moveAgenteParaDireita(matriz, agente);

                    if(agente.getColuna() == 14) {
                        chegouNoFimDaRua = false;
                    }
                }
            }
        }else {
            moveAgenteParaBaixo(matriz, agente);

            //moveAgenteParaCima(matriz, agente);
        }
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

    public String getTipoLixo() {
        return tipoLixo;
    }

    public void setTipoLixo(String tipoLixo) {
        this.tipoLixo = tipoLixo;
    }

    public String getTipoLixeira() {
        return tipoLixeira;
    }

    public void setTipoLixeira(String tipoLixeira) {
        this.tipoLixeira = tipoLixeira;
    }
}
