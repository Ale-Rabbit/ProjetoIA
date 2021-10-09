import java.util.Random;

public class Ambiente {

    private String[][] local;

    public Ambiente() {
        this.local = new String[12][15];

        AgenteReciclador agenteSeco = new AgenteReciclador("As", 0, 7);
        AgenteReciclador agenteOrganico = new AgenteReciclador("Ao", 0, 6);
        AgenteReciclador agenteEletronico = new AgenteReciclador("Ae", 0, 8);

        local[0][0] = "C";
        local[0][1] = "C";
        local[0][2] = "C";
        local[0][3] = "C";
        local[0][4] = "C";
        local[0][5] = "C";
        local[0][6] = agenteOrganico.getNome();
        local[0][7] = agenteSeco.getNome();
        local[0][8] = agenteEletronico.getNome();
        local[0][9] = "C";
        local[0][10] = "C";
        local[0][11] = "C";
        local[0][12] = "C";
        local[0][13] = "C";
        local[0][14] = "C";

        local[1][0] = "-";
        local[1][1] = "-";
        local[1][2] = "-";
        local[1][3] = "-";
        local[1][4] = "-";
        local[1][5] = "-";
        local[1][6] = "-";
        local[1][7] = "-";
        local[1][8] = "-";
        local[1][9] = "-";
        local[1][10] = "-";
        local[1][11] = "-";
        local[1][12] = "-";
        local[1][13] = "-";
        local[1][14] = "-";

        local[2][0] = "C";
        local[2][1] = "C";
        local[2][2] = "C";
        local[2][3] = "C";
        local[2][4] = "C";
        local[2][5] = "C";
        local[2][6] = "-";
        local[2][7] = "-";
        local[2][8] = "-";
        local[2][9] = "C";
        local[2][10] = "C";
        local[2][11] = "C";
        local[2][12] = "C";
        local[2][13] = "C";
        local[2][14] = "C";

        local[3][0] = "C";
        local[3][1] = "C";
        local[3][2] = "C";
        local[3][3] = "C";
        local[3][4] = "C";
        local[3][5] = "C";
        local[3][6] = "-";
        local[3][7] = "-";
        local[3][8] = "-";
        local[3][9] = "C";
        local[3][10] = "C";
        local[3][11] = "C";
        local[3][12] = "C";
        local[3][13] = "C";
        local[3][14] = "C";

        local[4][0] = "-";
        local[4][1] = "-";
        local[4][2] = "-";
        local[4][3] = "-";
        local[4][4] = "-";
        local[4][5] = "-";
        local[4][6] = "-";
        local[4][7] = "-";
        local[4][8] = "-";
        local[4][9] = "-";
        local[4][10] = "-";
        local[4][11] = "-";
        local[4][12] = "-";
        local[4][13] = "-";
        local[4][14] = "-";

        local[5][0] = "C";
        local[5][1] = "C";
        local[5][2] = "C";
        local[5][3] = "C";
        local[5][4] = "C";
        local[5][5] = "C";
        local[5][6] = "-";
        local[5][7] = "-";
        local[5][8] = "-";
        local[5][9] = "C";
        local[5][10] = "C";
        local[5][11] = "C";
        local[5][12] = "C";
        local[5][13] = "C";
        local[5][14] = "C";

        local[6][0] = "C";
        local[6][1] = "C";
        local[6][2] = "C";
        local[6][3] = "C";
        local[6][4] = "C";
        local[6][5] = "C";
        local[6][6] = "-";
        local[6][7] = "-";
        local[6][8] = "-";
        local[6][9] = "C";
        local[6][10] = "C";
        local[6][11] = "C";
        local[6][12] = "C";
        local[6][13] = "C";
        local[6][14] = "C";

        local[7][0] = "-";
        local[7][1] = "-";
        local[7][2] = "-";
        local[7][3] = "-";
        local[7][4] = "-";
        local[7][5] = "-";
        local[7][6] = "-";
        local[7][7] = "-";
        local[7][8] = "-";
        local[7][9] = "-";
        local[7][10] = "-";
        local[7][11] = "-";
        local[7][12] = "-";
        local[7][13] = "-";
        local[7][14] = "-";

        local[8][1] = "C";
        local[8][0] = "C";
        local[8][2] = "C";
        local[8][3] = "C";
        local[8][4] = "C";
        local[8][5] = "C";
        local[8][6] = "-";
        local[8][7] = "-";
        local[8][8] = "-";
        local[8][9] = "C";
        local[8][10] = "C";
        local[8][11] = "C";
        local[8][12] = "C";
        local[8][13] = "C";
        local[8][14] = "C";

        local[9][0] = "C";
        local[9][1] = "C";
        local[9][2] = "C";
        local[9][3] = "C";
        local[9][4] = "C";
        local[9][5] = "C";
        local[9][6] = "-";
        local[9][7] = "-";
        local[9][8] = "-";
        local[9][9] = "C";
        local[9][10] = "C";
        local[9][11] = "C";
        local[9][12] = "C";
        local[9][13] = "C";
        local[9][14] = "C";

        local[10][0] = "-";
        local[10][1] = "-";
        local[10][2] = "-";
        local[10][3] = "-";
        local[10][4] = "-";
        local[10][5] = "-";
        local[10][6] = "-";
        local[10][7] = "-";
        local[10][8] = "-";
        local[10][9] = "-";
        local[10][10] = "-";
        local[10][11] = "-";
        local[10][12] = "-";
        local[10][13] = "-";
        local[10][14] = "-";

        local[11][0] = "C";
        local[11][1] = "C";
        local[11][2] = "C";
        local[11][3] = "C";
        local[11][4] = "C";
        local[11][5] = "C";
        local[11][6] = "Ls";
        local[11][7] = "Le";
        local[11][8] = "Lo";
        local[11][9] = "C";
        local[11][10] = "C";
        local[11][11] = "C";
        local[11][12] = "C";
        local[11][13] = "C";
        local[11][14] = "C";
    }

    Random aleatorio = new Random();

    public String geraValores() {
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

    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_GREY_BACKGROUND = "\u001B[100m";
    public static final String ANSI_MAGENTA_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void exibeAmbiente() {
        int l = 0;
        int c = 0;
        for (l = 0; l <= 11; l++) {
            for (c = 0; c <= 14; c++) {
                String testaEspaco = this.local[l][c].length() == 2 ? "" : " ";

                if (this.local[l][c] == "-" && c != 6 && c != 7 && c != 8){
                    this.local[l][c] = geraValores();
                }
                if (c == 14) {
                    if(this.local[l][c].equalsIgnoreCase("C")) {
                        System.out.print(ANSI_YELLOW_BACKGROUND + " " + this.local[l][c] + " " + ANSI_RESET + "\n");

                    }else {
                        System.out.print(" " + this.local[l][c] + testaEspaco + "\n");
                    }
                } else {
                    if(this.local[l][c].equalsIgnoreCase("C") ) {
                        System.out.print(ANSI_YELLOW_BACKGROUND + " " + this.local[l][c] + testaEspaco + ANSI_RESET + " ");

                    }else if(this.local[l][c].equalsIgnoreCase("S")){
                        System.out.print(ANSI_GREEN_BACKGROUND + " " + this.local[l][c] + testaEspaco + ANSI_RESET + " ");

                    }else if(this.local[l][c].equalsIgnoreCase("E")) {
                        System.out.print(ANSI_GREY_BACKGROUND + " " + this.local[l][c] + testaEspaco + ANSI_RESET + " ");

                    }else if(this.local[l][c].equalsIgnoreCase("O")) {
                        System.out.print(ANSI_MAGENTA_BACKGROUND + " " + this.local[l][c] + testaEspaco + ANSI_RESET + " ");

                    }else {
                        System.out.print(testaEspaco + this.local[l][c] + "  ");
                    }
                }
            }
        }
        System.out.println("");
    }
}
