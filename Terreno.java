package modelo;
import util.AumentoMaiorDoQueJurosException;

public class Terreno extends Financiamento {
    private static final long serialVersionUID = 1L;

    //atributos
    private String tipoZona;

    //construtor
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        double base = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
        return base * 1.02;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public void exibirDadosFinanciamento() throws AumentoMaiorDoQueJurosException {
        super.exibirDadosFinanciamento();
        System.out.printf("Tipo de zona:         %s%n", this.tipoZona);
        System.out.println("======================================\n");
    }
}
