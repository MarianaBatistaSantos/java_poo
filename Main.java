package main;
import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        ///Ola prof! Eu nao sei se vamos usar essa versao futuramente, entao vou deixar por aqui por enquanto. :)
        
        ///InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ///double valorImovel = interfaceUsuario.valorimovelForfinanciamento();
        ///int prazoFinanciamento = interfaceUsuario.prazofinanciamentoForfinanciamento();
        ///double taxaJurosAnual = interfaceUsuario.taxajurosanualForfinanciamento();
        ///Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        ///financiamento.exibirDadosFinanciamento();

        List<Financiamento> listaFinanciamentos = new ArrayList<Financiamento>();
        double totalImoveis = 0;
        double totalFinanciamentos = 0;
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        interfaceUsuario.infosAlertaLimites();

        for (int i = 0; i < 4; i++) {
            double valorImovel = interfaceUsuario.valorimovelForfinanciamento();
            int prazoFinanciamento = interfaceUsuario.prazofinanciamentoForfinanciamento();
            double taxaJurosAnual = interfaceUsuario.taxajurosanualForfinanciamento();
            Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            listaFinanciamentos.add(financiamento);
            System.out.println("Financiamento " + (i + 1) + " registrado com sucesso!\n");
            System.out.println("======================================\n");
        }

        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            System.out.println("======== * FINANCIAMENTO " + (i + 1) + " * =========");
            listaFinanciamentos.get(i).exibirDadosFinanciamento();
        }

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
}
