import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Ambiente ambiente = new Ambiente();

        ambiente.populaMatriz();
        ambiente.exibeAmbiente();

        for(int i = 0; i < 4; i++){
            ambiente.exibeAmbiente();
            System.out.println("\n\n\n");
            String input = scanner.nextLine();
        }
    }

}
