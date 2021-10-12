import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Ambiente ambiente = new Ambiente();

        System.out.println("Matriz inicial:");

        ambiente.populaMatriz();
        ambiente.exibeAmbiente();

        System.out.println("\nDigite para os agentes andarem na matriz\n");

        String input;

        do {
            ambiente.exibeAmbiente();
            System.out.println("\n");
            input = scanner.next();
        } while (!input.equalsIgnoreCase("x"));

        System.out.println("\nProcesso finalizado\n");

    }

}
