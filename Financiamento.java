package modelo;


public class Financiamento {
    //atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //          *IDEAIS*
    //colocar futuramente mais coisas como infos do cliente, lista de parcelas pagas e pendentes e horaio e tudo registrado,
    //e local do imovel (usar algo aleatorio para sortear uma regiao, ter varias regioes listadas)


    //construtor 
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //getters
    public double getValorImovel() {
        return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    //metodo 1
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    //metodo 2
    public double calcularValorTotal() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    //metodo 3 exibicao das infos 
    public void exibirDadosFinanciamento() {
        System.out.println("\n===== * DADOS DO FINANCIAMENTO * =====");
        System.out.printf("Valor do imóvel:      R$ %,.2f%n", this.valorImovel);
        System.out.printf("Prazo:                %d anos%n", this.prazoFinanciamento);
        System.out.printf("Taxa de juros anual:  %.2f%%%n", this.taxaJurosAnual);
        System.out.printf("Parcela mensal:       R$ %,.2f%n", this.calcularPagamentoMensal());
        System.out.printf("Valor total pago:     R$ %,.2f%n", this.calcularValorTotal());
        System.out.println("======================================\n");
}
}
