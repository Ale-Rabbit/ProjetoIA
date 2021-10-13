
public class AgenteReciclador {

    public String nome;
    public int capacidade;
    public int linha;
    public int coluna;
    public int linhaInicio;
    public int colunaInicio;
    public String tipoLixo;
    public String tipoLixeira;
    public Boolean agenteDesligou;

    Boolean chegouNoFimDaRua = false;
    Boolean limpouTodaRua = false;
    Boolean voltarParaOInicio = false;
    Boolean lixeiraCorreta = true;
    Boolean posicaoParaIniciarTesteLixeira = false;
    Boolean retorno = false;
    Boolean percorreuTodaMatriz = false;
    Boolean terminouServico = false;

    public AgenteReciclador(String nome, int linha, int coluna, String tipoLixo, String tipoLixeira) {
        this.nome = nome;
        this.capacidade = 0;
        this.linha = linha;
        this.coluna = coluna;
        this.linhaInicio = linha;
        this.colunaInicio = coluna;
        this.tipoLixo = tipoLixo;
        this.tipoLixeira = tipoLixeira;
        this.agenteDesligou = false;
    }

    public Boolean temCapacidade(){

        return capacidade != 4;

    }

    public String getApenasLixo(String conteudoAgenteELixo) {

            char[] conteudoEmArray = conteudoAgenteELixo.toCharArray();
            char apenasLixo = conteudoEmArray[conteudoEmArray.length - 1];

            return String.valueOf(apenasLixo);

    }

    public void moveAgenteParaEsquerda(String[][] matriz, AgenteReciclador agente){

        if (agente.temCapacidade()) {
            agente.recolheLixo(agente, matriz[agente.getLinha()][agente.getColuna() - 1]);
        }

        if (matriz[agente.getLinha()][agente.getColuna()].length() == 3){
            matriz[agente.getLinha()][agente.getColuna()] = getApenasLixo(matriz[agente.getLinha()][agente.getColuna()]);
        }else {
            matriz[agente.getLinha()][agente.getColuna()] = "-";
        }

        agente.setLinha(agente.getLinha());
        agente.setColuna(agente.getColuna() - 1);
        if (!matriz[agente.getLinha()][agente.getColuna()].equalsIgnoreCase("-")){
            matriz[agente.getLinha()][agente.getColuna()] = novoElementoPosicao(matriz[agente.getLinha()][agente.getColuna()], agente);
        }else{
            matriz[agente.getLinha()][agente.getColuna()] = agente.getNome();
        }

    }

    public void moveAgenteParaDireita(String[][] matriz, AgenteReciclador agente){

        if(agente.temCapacidade()) {
            agente.recolheLixo(agente, matriz[agente.getLinha()][agente.getColuna() + 1]);
        }

        if (matriz[agente.getLinha()][agente.getColuna()].length() == 3){
            matriz[agente.getLinha()][agente.getColuna()] = getApenasLixo(matriz[agente.getLinha()][agente.getColuna()]);
        }else {
            matriz[agente.getLinha()][agente.getColuna()] = "-";
        }

        agente.setLinha(agente.getLinha());
        agente.setColuna(agente.getColuna() + 1);
        if (!matriz[agente.getLinha()][agente.getColuna()].equalsIgnoreCase("-")){
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

        if (!agente.getTipoLixo().equalsIgnoreCase(elementoMatriz)) {
            return agente.getNome() + elementoMatriz;
        }else {
            return agente.getNome();
        }

    }

    public void recolheLixo(AgenteReciclador agente, String elementoMatriz){

        if (agente.getTipoLixo().equalsIgnoreCase(elementoMatriz)) {
            agente.setCapacidade(agente.getCapacidade() + 1);
        }

    }

    public void irParaLixeira(String[][] matriz, AgenteReciclador agente, AgenteLixeira lixeira){

        if(!posicaoParaIniciarTesteLixeira) {

            if (agente.getColuna() < 6) {
                moveAgenteParaDireita(matriz, agente);
            } else if (agente.getColuna() >= 7) {
                moveAgenteParaEsquerda(matriz, agente);
            } else if (agente.getLinha() < 10) {
                moveAgenteParaBaixo(matriz, agente);
            } else if (agente.getLinha() == 10 && agente.getColuna() == 6) {
                posicaoParaIniciarTesteLixeira = true;
            }

        } else {

            boolean agenteEstaAcimaDaSuaLixeira = agente.getTipoLixeira().equalsIgnoreCase(matriz[agente.getLinha() + 1][agente.getColuna()]);

            if (agenteEstaAcimaDaSuaLixeira) {

                lixeira.setCapacidade(lixeira.getCapacidade() + agente.getCapacidade());
                agente.setCapacidade(0);
                voltarParaOInicio = true;
                posicaoParaIniciarTesteLixeira = false;
                lixeira.listaDeDetritos.add(agente.getTipoLixo());
                lixeiraCorreta = lixeira.testaTipoLixo(lixeira);
                if(terminouServico){
                    terminouServico = false;
                }

            } else {
                agente.moveAgenteParaDireita(matriz, agente);
            }
        }

    }

    public Boolean desligaAgente(String[][] matriz, AgenteReciclador agente){

        if (agente.getColuna() > agente.getColunaInicio()) {
            moveAgenteParaEsquerda(matriz, agente);
        } else if (agente.getColuna() < agente.getColunaInicio()) {
            moveAgenteParaDireita(matriz, agente);
        } else {
            if(agente.getLinha() != agente.getLinhaInicio()) {
                moveAgenteParaCima(matriz, agente);
            } else {
                agente.setAgenteDesligou(true);
                return true;
            }
        }

        return false;

    }

    public void irParaInicio(String[][] matriz, AgenteReciclador agente){

        if(agente.getLinha() > 1) {
            if (agente.getColuna() < 6) {
                moveAgenteParaDireita(matriz, agente);
            } else if (agente.getColuna() >= 7) {
                moveAgenteParaEsquerda(matriz, agente);
            } else {
                moveAgenteParaCima(matriz, agente);
            }
        }else {
            voltarParaOInicio = false;
        }

    }

    public Boolean teste(String[][] matriz, AgenteReciclador agente, AgenteLixeira agenteLixeira) {

        if(lixeiraCorreta) {
            if (!agenteLixeira.isCheio() && !percorreuTodaMatriz) {

                if (agente.temCapacidade()) {

                    if (voltarParaOInicio) {
                        agente.irParaInicio(matriz, agente);
                    } else {

                        boolean isAgenteEmLinhaEntreCasas = agente.getLinha() == 1 ||
                                agente.getLinha() == 4 ||
                                agente.getLinha() == 7 ||
                                agente.getLinha() == 10;


                        if (isAgenteEmLinhaEntreCasas) {

                            if (agente.getColuna() > 0 && !chegouNoFimDaRua) {

                                if (agente.getColuna() == 6 && limpouTodaRua) {
                                    moveAgenteParaBaixo(matriz, agente);
                                    limpouTodaRua = false;
                                } else {
                                    moveAgenteParaEsquerda(matriz, agente);
                                }

                            } else {
                                chegouNoFimDaRua = true;

                                if (agente.getColuna() < 14) {

                                    moveAgenteParaDireita(matriz, agente);

                                    if (agente.getColuna() == 14) {
                                        chegouNoFimDaRua = false;
                                        limpouTodaRua = true;

                                        if (agente.getLinha() == 10) {
                                            percorreuTodaMatriz = true;
                                            terminouServico = true;
                                        }
                                    }
                                }
                            }
                        } else {

                            moveAgenteParaBaixo(matriz, agente);

                        }
                    }
                } else {

                    agente.irParaLixeira(matriz, agente, agenteLixeira);

                }
            } else {

                if (terminouServico) {
                    agente.irParaLixeira(matriz, agente, agenteLixeira);
                } else {
                    retorno = agente.desligaAgente(matriz, agente);
                }

            }
        }

        if (agente.getNome().equalsIgnoreCase("Ao") && agente.getLinha() == 0 && agente.getColuna() == 6){
            retorno = true;
        } else if (agente.getNome().equalsIgnoreCase("Ae") && agente.getLinha() == 0 && agente.getColuna() == 8){
            retorno = true;
        } else if(agente.getNome().equalsIgnoreCase("As") && agente.getLinha() == 0 && agente.getColuna() == 7){
            retorno = true;
        }

        return retorno;

    }

    public String getNome() {
        return nome;
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

    public String getTipoLixeira() {
        return tipoLixeira;
    }

    public int getLinhaInicio() {
        return linhaInicio;
    }

    public int getColunaInicio() {
        return colunaInicio;
    }

    public Boolean getAgenteDesligou() {
        return agenteDesligou;
    }

    public void setAgenteDesligou(Boolean agenteDesligou) {
        this.agenteDesligou = agenteDesligou;
    }

}
