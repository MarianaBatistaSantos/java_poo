import java.util.Scanner;

class Financiamento {
//atributos
double valorImovel;
int prazoFinanciamento;
double taxaJurosAnual;
//construtor - metodo 0
public Financiamento(double valordesejadoimovel, int prazodesejadofinanciamento, double taxadesejadojurosanual) {
    this.valorImovel = valordesejadoimovel;
    this.prazoFinanciamento = prazodesejadofinanciamento;
    this.taxaJurosAnual = taxadesejadojurosanual;
}
//metodo1
double calcularPagamentoMensal() {
return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));

//metodo2
}
double calcularValorTotal() {
return (this.calcularPagamentoMensal() * this.prazoFinanciamento * 12);
}


}



class Interfaceusuario {
    Scanner scanner = new Scanner(System.in);

    double valorimovelForfinanciamento() {
    System.out.println("Digite o valor do imóvel: ");
    double valorimovel = scanner.nextDouble();
    System.out.println("O valor do imóvel é: " + valorimovel);
    return valorimovel;
    }

    int prazofinanciamentoForfinanciamento() {
    System.out.println("Digite o prazo do financiamento em anos: ");
    int prazofinanciamento = scanner.nextInt();
    System.out.println("O prazo do financiamento em anos é: " + prazofinanciamento);
    return prazofinanciamento;
    }


    double taxajurosanualForfinanciamento() {
    System.out.println("Digite a taxa de juros anual: ");
    double taxajurosanual = scanner.nextDouble();
    System.out.println("A taxa de juros anual é: " + taxajurosanual);
    return taxajurosanual;
    }
}

public class Main {

    public static void main(String[] args) {

        Interfaceusuario interfaceusuario = new Interfaceusuario();

        double valorImovel = interfaceusuario.valorimovelForfinanciamento();
        int prazoFinanciamento = interfaceusuario.prazofinanciamentoForfinanciamento();
        double taxaJurosAnual = interfaceusuario.taxajurosanualForfinanciamento();

        Financiamento newFinanciamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        System.out.println("O valor do pagamento mensal é: " + newFinanciamento.calcularPagamentoMensal());
        System.out.println("O valor total pago no financiamento é: " + newFinanciamento.calcularValorTotal());
    }
}