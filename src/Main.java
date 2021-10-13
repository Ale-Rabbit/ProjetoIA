import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Ambiente ambiente = new Ambiente();
        ambiente.populaMatriz();

        System.out.println("Digite 1 para executar passo a passo ou 2 para executar automaticamente: ");
        String resposta = scanner.next();

        if (resposta.equalsIgnoreCase("1")) {

            String input;

            do {

                ambiente.exibeAmbiente();
                System.out.println("\n");
                System.out.println("Digite qualquer coisa e tecle enter ou escreva 'Sair'.");
                input = scanner.next();

            } while (!input.equalsIgnoreCase("Sair"));

            System.out.println("\nProcesso finalizado\n");

        } else if (resposta.equalsIgnoreCase("2")) {

            Boolean continuar;

            do {

                System.out.println("\n");
                continuar = ambiente.exibeAmbiente();
                System.out.println("\n");

                TimeUnit.SECONDS.sleep(2);

            } while (continuar);

        } else {

            System.out.println("Opção incorreta!");

        }
    }

}

