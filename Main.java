package main;

import modelo.Financiamento;
import util.AumentoMaiorDoQueJurosException;
import util.GerenciadorArquivo;
import util.InterfaceUsuario;
import util.GerenciadorTexto;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        
        interfaceUsuario.infosBemVindo();
        interfaceUsuario.infosAlertaLimites();
        
        List<Financiamento> listaFinanciamentos = new ArrayList<>();

        int qtdTotal = interfaceUsuario.pedirQuantidadeFinanciamentos();

        for (int i = 1; i <= qtdTotal; i++) {
            
            char tipo = interfaceUsuario.pedirTipoFinanciamento(i);

            GerenciadorTexto.exibirCabecalhoEntradaDados(i);
            double valorImovel = interfaceUsuario.valorimovelForfinanciamento();
            int prazoFinanciamento = interfaceUsuario.prazofinanciamentoForfinanciamento();
            double taxaJurosAnual = interfaceUsuario.taxajurosanualForfinanciamento();

            switch (tipo) {
                case 'c':
                    double area = interfaceUsuario.pedirAreaConstruida();
                    double terrenoSize = interfaceUsuario.pedirTamanhoTerreno();
                    listaFinanciamentos.add(new modelo.Casa(valorImovel, prazoFinanciamento, taxaJurosAnual / 100, area, terrenoSize));
                    break;

                case 'a':
                    int vagas = interfaceUsuario.pedirVagasGaragem();
                    int andar = interfaceUsuario.pedirAndar();
                    listaFinanciamentos.add(new modelo.Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual / 100, vagas, andar));
                    break;

                case 't':
                    String zona = interfaceUsuario.pedirTipoZona();
                    listaFinanciamentos.add(new modelo.Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual / 100, zona));
                    break;
            }
        }

        GerenciadorTexto.exibirCabecalhoRelatorioGeral();

        for (int i = 0; i < listaFinanciamentos.size(); i++) {
            try {
                GerenciadorTexto.exibirDivisorFinanciamento(i + 1);
                listaFinanciamentos.get(i).exibirDadosFinanciamento();
            } 
            catch (AumentoMaiorDoQueJurosException e) {
                GerenciadorTexto.exibirErroImpressao(e.getMessage());
            }
        }

        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f : listaFinanciamentos) {
            totalImoveis += f.getValorImovel();
            try {
                totalFinanciamentos += f.calcularValorTotal();
            } 
            catch (AumentoMaiorDoQueJurosException e) {
                GerenciadorTexto.exibirAvisoExclusaoSoma();
            }
        }

        GerenciadorTexto.exibirResumoTotais(totalImoveis, totalFinanciamentos);
        GerenciadorArquivo.salvarTexto("financiamentos.txt", listaFinanciamentos);
        GerenciadorArquivo.salvarSerializacao("financiamentos.ser", listaFinanciamentos);
        GerenciadorArquivo.lerTexto("financiamentos.txt");

        List<Financiamento> listaRecuperada = GerenciadorArquivo.lerSerializacao("financiamentos.ser");
        
        GerenciadorTexto.exibirCabecalhoComprovacaoSerializado();
        for (Financiamento f : listaRecuperada) {
            try {
                f.exibirDadosFinanciamento();
            }
            catch (AumentoMaiorDoQueJurosException e) {
                GerenciadorTexto.exibirErroImpressao(e.getMessage());
            }
        }
        GerenciadorTexto.exibirRodapeFinal();
    }
}