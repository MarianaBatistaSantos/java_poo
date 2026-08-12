package modelo;
import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private static final long serialVersionUID = 1L;

    //atributos
    private double areaConstruida;
    private double areaTerreno;

    //construtor
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }
    
    @Override
    public double calcularPagamentoMensal() throws AumentoMaiorDoQueJurosException {
        
        double parcelaBase = this.valorImovel / (this.prazoFinanciamento * 12);
        double valorJurosMensal = parcelaBase * (this.taxaJurosAnual / 12);
        
        if (80 > (valorJurosMensal / 2)) {
            throw new AumentoMaiorDoQueJurosException("Erro: O acréscimo de R$ 80,00 é maior que a metade dos juros mensais (R$ " + (valorJurosMensal / 2) + ")");
        }
        return parcelaBase * (1 + (this.taxaJurosAnual / 12)) + 80;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }
    public double getAreaTerreno() {
        return areaTerreno;
    }

    @Override
    public void exibirDadosFinanciamento() throws AumentoMaiorDoQueJurosException {
        super.exibirDadosFinanciamento();
        System.out.printf("Área construída:      %.2f m²%n", this.areaConstruida);
        System.out.printf("Área do terreno:      %.2f m²%n", this.areaTerreno);
        System.out.println("======================================\n");
    }
}
