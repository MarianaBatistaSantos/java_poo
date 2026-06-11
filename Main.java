package main;
import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        double valorImovel = interfaceUsuario.valorimovelForfinanciamento();
        int prazoFinanciamento = interfaceUsuario.prazofinanciamentoForfinanciamento();
        double taxaJurosAnual = interfaceUsuario.taxajurosanualForfinanciamento();
        Financiamento financiamento = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
        financiamento.exibirDadosFinanciamento();
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
        listaFinanciamentos.add(financiamento);
 
 
 
 
 
 
    }
    
    ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();
    listaFinanciamentos.add(Financiamento);

    
}