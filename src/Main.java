import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Ambiente ambiente = new Ambiente();

        ambiente.populaMatriz();
        ambiente.exibeAmbiente();
        System.out.println("\n");
        String input;

        for(int i = 0; i < 10d; i++){
            ambiente.exibeAmbiente();
            System.out.println("\n");
            input = scanner.next();
        }
    }

}
