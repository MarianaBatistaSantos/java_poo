package modelo;
import util.AumentoMaiorDoQueJurosException;

public class Apartamento extends Financiamento {
    private static final long serialVersionUID = 1L;


    //atributos
    private int vagasGaragem;
    private int numeroAndar;


    //construtor
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        double totalPagamento = this.valorImovel * (1 + (this.taxaJurosAnual * this.prazoFinanciamento));
        return totalPagamento / (this.prazoFinanciamento * 12);
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }
    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public void exibirDadosFinanciamento() throws AumentoMaiorDoQueJurosException {
        super.exibirDadosFinanciamento();
        System.out.printf("Vagas de garagem:     %d%n", this.vagasGaragem);
        System.out.printf("Número do andar:      %d%n", this.numeroAndar);
        System.out.println("======================================\n");
    }
}
