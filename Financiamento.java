package modelo;
import util.AumentoMaiorDoQueJurosException;
import java.io.Serializable;


public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    //atributos
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

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

    public abstract double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException;

    public double calcularValorTotal() throws AumentoMaiorDoQueJurosException {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void exibirDadosFinanciamento() throws AumentoMaiorDoQueJurosException {
        System.out.println("\n===== * DADOS DO FINANCIAMENTO * =====");
        System.out.printf("Valor do imóvel:      R$ %,.2f%n", this.valorImovel);
        System.out.printf("Prazo:                %d anos%n", this.prazoFinanciamento);
        System.out.printf("Taxa de juros anual:  %.2f%%%n", this.taxaJurosAnual * 100);
        System.out.printf("Pagamento mensal:     R$ %,.2f%n", this.calcularPagamentoMensal());
        System.out.printf("Valor total do pag:   R$ %,.2f%n", this.calcularValorTotal());
    }
}