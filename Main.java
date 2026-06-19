import modelo.Terreno;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        interfaceUsuario.infosAlertaLimites();
        
        List<Financiamento> listaFinanciamentos = new ArrayList<>();

        Casa casa1 = new Casa(500000, 10, 0.10, 120.5, 250.0);
        Casa casa2 = new Casa(300000, 15, 0.08, 90.0, 180.0);     

        Apartamento apto1 = new Apartamento(400000, 20, 0.09, 2, 5);
        Apartamento apto2 = new Apartamento(250000, 12, 0.07, 1, 3);

        double valorImovel = interfaceUsuario.valorimovelForfinanciamento();
        int prazoFinanciamento = interfaceUsuario.prazofinanciamentoForfinanciamento();
        double taxaJurosAnual = interfaceUsuario.taxajurosanualForfinanciamento();

        Terreno terrenoDigitado = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual / 100, "Residencial");

        listaFinanciamentos.add(casa1);
        listaFinanciamentos.add(casa2);
        listaFinanciamentos.add(apto1);
        listaFinanciamentos.add(apto2);
        listaFinanciamentos.add(terrenoDigitado);

        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            System.out.println("======== * FINANCIAMENTO " + (i + 1) + " * =========");
           listaFinanciamentos.get(i).exibirDadosFinanciamento();
        }

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f : listaFinanciamentos) {
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularValorTotal();
        }

        System.out.println("========= * TOTAIS * =================");
        System.out.printf("Total de todos os imóveis:        R$ %,.2f%n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %,.2f%n", totalFinanciamentos);
        System.out.println("======================================");
    }
}
