package util;
import java.util.Scanner;


public class InterfaceUsuario {

    Scanner scanner = new Scanner(System.in);

    //metodo 1
    public double valorimovelForfinanciamento() {
        double valorImovel;

        do {
            System.out.println("Digite o valor do imóvel (R$): ");
            valorImovel = scanner.nextDouble();
            if (valorImovel <= 0) {
                System.out.println("Valor inválido! O valor do imóvel deve ser maior que zero.");
            }
        } while (valorImovel <= 0);
        System.out.println("Valor do imóvel: R$ " + valorImovel);
        return valorImovel;
    }

    //metodo 2
    public int prazofinanciamentoForfinanciamento() {
        int prazoFinanciamento;

        do {
            System.out.println("Digite o prazo do financiamento em anos: ");
            prazoFinanciamento = scanner.nextInt();
            if (prazoFinanciamento <= 0) {
                System.out.println("Valor inválido! O prazo deve ser maior que zero.");
            }
        } while (prazoFinanciamento <= 0);
        System.out.println("Prazo: " + prazoFinanciamento + " anos");
        return prazoFinanciamento;
    }

    //metodo 3
    public double taxajurosanualForfinanciamento() {
        double taxaJurosAnual;

        do {
            System.out.println("Digite a taxa de juros anual (%): ");
            taxaJurosAnual = scanner.nextDouble();
            if (taxaJurosAnual <= 0) {
                System.out.println("Valor inválido! A taxa deve ser maior que zero.");
            }
        } while (taxaJurosAnual <= 0);
        System.out.println("Taxa: " + taxaJurosAnual + "%");
        return taxaJurosAnual;
    }
}

//dar limites para os inputs em valores muitos altos