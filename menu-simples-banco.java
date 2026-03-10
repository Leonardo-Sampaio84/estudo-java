import java.util.Scanner;
public class Exercicio_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double saldoInicial = 0;
        int menu = 0;

        while (true) {
            System.out.println(" 1 - Ver saldo");
            System.out.println(" 2 - Depositar");
            System.out.println(" 3 - Sacar");
            System.out.println(" 4 - Sair");

            // Validação da entrada
            if (!scanner.hasNextDouble()) {
                System.out.println("Entrada inválida! Digite apenas números.");
                scanner.next(); // limpa entrada inválida
                continue;
            }

            menu = scanner.nextInt();

            if (menu < 1 || menu > 4) {
                System.out.println("Opção inválida! Digite um número entre 1 e 4.");
                continue;
            }else if (menu == 4){
                System.out.println("Obrigado!");
                break;
            }

            switch (menu) {
                case 1:
                    System.out.println("Saldo atual: " + saldoInicial);
                    break;

                case 2:
                    System.out.println("Digite o valor para depositar:");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida! Digite apenas números.");
                        scanner.next(); // limpa entrada inválida
                    } else {
                        double depositar = scanner.nextDouble();

                        if (depositar <= 0) {
                            System.out.println("Valor inválido! O depósito deve ser positivo.");
                        } else {
                            saldoInicial += depositar;
                            System.out.println("Depósito realizado. Saldo atual: " + saldoInicial);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o valor para Sacar:");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida! Digite apenas números.");
                        scanner.next(); // limpa entrada inválida
                    } else {
                        double Sacar = scanner.nextDouble();
                        if (Sacar <= 0) {
                            System.out.println("Valor inválido! O valor deve ser positivo.");
                        } else if (Sacar >= saldoInicial) {
                            System.out.println("Saldo insuficiente");
                        }else {
                            saldoInicial -= Sacar;
                            System.out.println("Saque realizado. Saldo atual: " + saldoInicial);
                        }
                    } break;

                default:
                    System.out.println("Menu inválido, digite a opção correta!");
                    break;
            }
        }
        scanner.close();

    }
}
