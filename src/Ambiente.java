import java.util.Random;

public class Ambiente {

    private String[][] matriz;
    Boolean isFirstTime = true;

    AgenteReciclador agenteSeco = new AgenteReciclador("As", 0, 7, "S", "Ls");
    AgenteReciclador agenteOrganico = new AgenteReciclador("Ao", 0, 6, "O", "Lo");
    AgenteReciclador agenteEletronico = new AgenteReciclador("Ae", 0, 8, "E", "Le");

    AgenteLixeira lixeiraSeca = new AgenteLixeira("Ls", "S");
    AgenteLixeira lixeiraOrganica = new AgenteLixeira("Lo", "O");
    AgenteLixeira lixeiraEletronica = new AgenteLixeira("Le", "E");

    public static final String pintaAmarelo = "\u001B[43m";
    public static final String pintaVerde = "\u001B[42m";
    public static final String pintaCinza = "\u001B[100m";
    public static final String pintaVermelho = "\u001B[41m";
    public static final String resetaCor = "\u001B[0m";

    public Ambiente() {

        this.matriz = new String[12][15];

        matriz[0][6] = agenteOrganico.getNome();
        matriz[0][7] = agenteSeco.getNome();
        matriz[0][8] = agenteEletronico.getNome();
        matriz[11][6] = lixeiraSeca.getNome();
        matriz[11][7] = lixeiraEletronica.getNome();
        matriz[11][8] = lixeiraOrganica.getNome();

    }

    public String geraLixo() {

        int numeroAleatorio = new Random().nextInt(20);

        if (numeroAleatorio >= 1 && numeroAleatorio <= 5) {
            return "S";
        } else if (numeroAleatorio >= 6 && numeroAleatorio <= 10) {
                return "E";
        } else if (numeroAleatorio >= 11 && numeroAleatorio <= 15) {
                return "O";
        }

        return "-";

    }

    public void populaMatriz() {

        for (int l = 0; l <= 11; l++) {
            for (int c = 0; c <= 14; c++) {

                boolean isCampoParaCasas = (l == 0 || l == 2 || l == 3 || l == 5 ||
                                            l == 6 || l == 8 || l == 9 || l == 11) &&
                                            (c <= 5 || c >= 9);

                boolean isCampoParaAvenida = (l != 0 && l != 11) && (c >= 6 || c != 7 || c != 8);

                if (isCampoParaCasas) {
                    this.matriz[l][c] = "C";
                } else if (isCampoParaAvenida) {
                    this.matriz[l][c] = "-";
                }

                boolean isCampoParaLixo = this.matriz[l][c].equalsIgnoreCase("-") &&
                                          c != 6 && c != 7 && c != 8;

                if (isCampoParaLixo) {
                    this.matriz[l][c] = geraLixo();
                }

            }
        }

    }


    public Boolean exibeAmbiente() {

        Boolean agentesAindaEmFuncionamento = !agenteSeco.getAgenteDesligou() ||
                                              !agenteOrganico.getAgenteDesligou() ||
                                              !agenteEletronico.getAgenteDesligou();

        if (agentesAindaEmFuncionamento) {

            if (isFirstTime) {
                isFirstTime = false;
            } else {

                Boolean executarAgenteEletronico = false;
                Boolean executarAgenteSeco = agenteOrganico.teste(this.matriz, agenteOrganico, lixeiraOrganica);


                if (executarAgenteSeco) {
                    executarAgenteEletronico = agenteSeco.teste(this.matriz, agenteSeco, lixeiraSeca);
                }

                if (executarAgenteEletronico) {
                    agenteEletronico.teste(this.matriz, agenteEletronico, lixeiraEletronica);
                }

            }

            for (int l = 0; l <= 11; l++) {
                for (int c = 0; c <= 14; c++) {

                    String testaUltimoElemento = (c == 14) ? "\n" : " ";
                    String testaEspaco = matriz[l][c].length() == 2 ? "" : " ";

                    if (this.matriz[l][c].equalsIgnoreCase("C")) {
                        System.out.print(pintaAmarelo + " " + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("S")) {
                        System.out.print(pintaVerde + " " + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("E")) {
                        System.out.print(pintaCinza + " " + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("O")) {
                        System.out.print(pintaVermelho + " " + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("Lo")) {
                        System.out.print(pintaVermelho + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("Ls")) {
                        System.out.print(pintaVerde + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].equalsIgnoreCase("Le")) {
                        System.out.print(pintaCinza + this.matriz[l][c] + " " + resetaCor + testaUltimoElemento);

                    } else if (this.matriz[l][c].length() == 3) {

                        if (this.matriz[l][c].equalsIgnoreCase("AsO") || this.matriz[l][c].equalsIgnoreCase("AeO")) {
                            System.out.print(pintaVermelho + this.matriz[l][c] + resetaCor + testaUltimoElemento);

                        } else if (this.matriz[l][c].equalsIgnoreCase("AsE") || this.matriz[l][c].equalsIgnoreCase("AoE")) {
                            System.out.print(pintaCinza + this.matriz[l][c] + resetaCor + testaUltimoElemento);

                        } else if (this.matriz[l][c].equalsIgnoreCase("AeS") || this.matriz[l][c].equalsIgnoreCase("AoS")) {
                            System.out.print(pintaVerde + this.matriz[l][c] + resetaCor + testaUltimoElemento);

                        }
                    } else {
                        System.out.print(" " + this.matriz[l][c] + testaEspaco + testaUltimoElemento);
                    }
                }

            }

        }

        return agentesAindaEmFuncionamento;

    }
}
