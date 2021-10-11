import java.util.Random;

public class Ambiente {

    private String[][] local;
    Random aleatorio = new Random();
    AgenteReciclador agenteSeco = new AgenteReciclador("As", 0, 7);
    AgenteReciclador agenteOrganico = new AgenteReciclador("Ao", 0, 6);
    AgenteReciclador agenteEletronico = new AgenteReciclador("Ae", 0, 8);

    public static final String pintaAmarelo = "\u001B[43m";
    public static final String pintaVerde = "\u001B[42m";
    public static final String pintaCinza = "\u001B[100m";
    public static final String pintaVermelho = "\u001B[41m";
    public static final String resetaCor = "\u001B[0m";

    public Ambiente() {
        this.local = new String[12][15];

        local[0][6] = agenteOrganico.getNome();
        local[0][7] = agenteSeco.getNome();
        local[0][8] = agenteEletronico.getNome();
        local[11][6] = "Ls";
        local[11][7] = "Le";
        local[11][8] = "Lo";
    }

    public String geraLixo() {
        int propabilidade = aleatorio.nextInt(20);

        if (propabilidade >= 0 && propabilidade <= 5) {
            return "S";
        } else if (propabilidade >= 6 && propabilidade <= 10) {
                return "E";
        } else if (propabilidade >= 11 && propabilidade <= 15) {
                return "O";
        }
        return "-";
    }

    public void movimentoAgente(){
        int l = 0;
        int c = 0;
        for (l = 0; l <= 11; l++) {
            for (c = 0; c <= 14; c++) {

            }
        }
    }

    public void populaMatriz() {

        for (int l = 0; l <= 11; l++) {
            for (int c = 0; c <= 14; c++) {

                Boolean isCampoParaCasas = (l == 0 || l == 2 || l == 3 || l == 5 ||
                                            l == 6 || l == 8 || l == 9 || l == 11) &&
                                            (c <= 5 || c >= 9);

                Boolean isCampoParaAvenida = (l != 0 && l != 11) && (c >= 6 || c != 7 || c != 8);

                if (isCampoParaCasas) {
                    this.local[l][c] = "C";
                } else if (isCampoParaAvenida) {
                    this.local[l][c] = "-";
                }

                Boolean isCampoParaLixo = this.local[l][c] == "-" && c != 6 && c != 7 && c != 8;

                if (isCampoParaLixo) {
                    this.local[l][c] = geraLixo();
                }

            }
        }

    }

    public void exibeAmbiente() {
        for (int l = 0; l <= 11; l++) {
            for (int c = 0; c <= 14; c++) {

                String testaUltimoElemento = (c == 14) ? "\n" : " ";
                String testaEspaco = local[l][c].length() == 2 ? "" : " ";

                if(this.local[l][c].equalsIgnoreCase("C") ) {
                    System.out.print(pintaAmarelo + " " + this.local[l][c] + " " + resetaCor + testaUltimoElemento);

                }else if(this.local[l][c].equalsIgnoreCase("S")){
                    System.out.print(pintaVerde + " " + this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                }else if(this.local[l][c].equalsIgnoreCase("E")) {
                    System.out.print(pintaCinza + " " + this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                }else if(this.local[l][c].equalsIgnoreCase("O")) {
                    System.out.print(pintaVermelho + " " + this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                }else if (this.local[l][c].equalsIgnoreCase("Lo")){
                    System.out.print(pintaVermelho +  this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                }else if (this.local[l][c].equalsIgnoreCase("Ls")){
                    System.out.print(pintaVerde + this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                }else if (this.local[l][c].equalsIgnoreCase("Le")){
                    System.out.print(pintaCinza +  this.local[l][c] + " "  + resetaCor + testaUltimoElemento);

                } else {
                    System.out.print(" " + this.local[l][c] + testaEspaco + testaUltimoElemento);
                }
            }

        }
        //agenteSeco.teste(this.local, agenteSeco);
        agenteOrganico.teste(this.local, agenteOrganico);
        //sagenteEletronico.teste(this.local, agenteEletronico);
    }
}
