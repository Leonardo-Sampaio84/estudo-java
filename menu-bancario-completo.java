import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Exercicio_11 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double saldo = 0;
        int menu = 0;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        ArrayList<String> extrato = new ArrayList<>();

        while (true) {
            System.out.println(" 1 - Extrato");
            System.out.println(" 2 - Ver saldo");
            System.out.println(" 3 - Depositar");
            System.out.println(" 4 - Sacar");
            System.out.println(" 5 - Sair");

            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.nextInt();
                continue;
            }

            menu = scanner.nextInt();

            if (menu < 1 || menu > 5) {
                System.out.println("Opção inválida! Digite um número entre 1 e 5.");
                continue;
            } else if (menu == 5) {
                System.out.println("Obrigado!");
                break;
            }

            switch (menu) {
                case 1:
                    if (extrato.isEmpty()) {
                        System.out.println("Você ainda não tem movimentação!");
                    } else {
                        for (String linha : extrato) {
                            System.out.println(linha);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Saldo atual: R$ " + saldo);
                    break;

                case 3:
                    System.out.println("Digite o valor para depositar:");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida! Digite apenas números.");
                        scanner.nextDouble();
                    } else {
                        double depositar = scanner.nextDouble();
                        if (depositar <= 0) {
                            System.out.println("Valor inválido! O depósito deve ser positivo.");
                        } else {
                            saldo += depositar;
                            String agora = LocalDateTime.now().format(formato); //captura o momento exato
                            extrato.add("Depósito: +R$ " + depositar + " | " + agora);
                            System.out.println("Depósito realizado. Saldo atual: R$ " + saldo);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite o valor para Sacar:");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida! Digite apenas números.");
                        scanner.nextDouble();
                    } else {
                        double sacar = scanner.nextDouble();

                        if (sacar <= 0) {
                            System.out.println("Valor inválido! O valor deve ser positivo.");
                        } else if (sacar > saldo) {
                            System.out.println("Saldo insuficiente!");
                        } else {
                            saldo -= sacar;
                            String agora = LocalDateTime.now().format(formato); //captura o momento exato
                            extrato.add("Saque:    -R$ " + sacar + " | " + agora);
                            System.out.println("Saque realizado. Saldo atual: R$ " + saldo);
                        }
                    }
                    break;

                default:
                    System.out.println("Menu inválido, digite a opção correta!");
                    break;
            }
        }
        scanner.close();
    }
}
