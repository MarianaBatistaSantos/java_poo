package util;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner = new Scanner(System.in);

    public double valorimovelForfinanciamento() {
        return ValidadorDados.lerDouble(scanner, GerenciadorTexto.obterLabelValorImovel(), 1.0, 50000000.0);
    }
    public int prazofinanciamentoForfinanciamento() {
        return ValidadorDados.lerInt(scanner, GerenciadorTexto.obterLabelPrazo(), 1, 50);
    }
    public double taxajurosanualForfinanciamento() {
        return ValidadorDados.lerDouble(scanner, GerenciadorTexto.obterLabelTaxaJuros(), 0.1, 50.0);
    }
    public int pedirQuantidadeFinanciamentos() {
        return ValidadorDados.lerInt(scanner, GerenciadorTexto.obterLabelQuantidade(), 1, Integer.MAX_VALUE);
    }
    public double pedirAreaConstruida() {
        return ValidadorDados.lerDouble(scanner, GerenciadorTexto.obterLabelAreaConstruida(), 0.001, Double.MAX_VALUE);
    }
    public double pedirTamanhoTerreno() {
        return ValidadorDados.lerDouble(scanner, GerenciadorTexto.obterLabelTamanhoTerreno(), 0.001, Double.MAX_VALUE);
    }
    public int pedirVagasGaragem() {
        return ValidadorDados.lerInt(scanner, GerenciadorTexto.obterLabelVagasGaragem(), 0, 1000);
    }
    public int pedirAndar() {
        return ValidadorDados.lerInt(scanner, GerenciadorTexto.obterLabelAndar(), 1, 200);
    }

    public void infosBemVindo() {
        GerenciadorTexto.exibirBoasVindo();
    }
    public void infosAlertaLimites() {
        GerenciadorTexto.exibirAlertaLimites();
    }

    public char pedirTipoFinanciamento(int numero) {
        char tipo;
        do {
            GerenciadorTexto.exibirMenuTipoFinanciamento(numero);
            tipo = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();

            if (tipo != 'c' && tipo != 'a' && tipo != 't') {
                GerenciadorTexto.exibirErroOpcaoInvalida();
            }
        }
        while (tipo != 'c' && tipo != 'a' && tipo != 't');
        return tipo;
    }

    public String pedirTipoZona() {
        char opcao = ' ';
        boolean entradaValida = false;
        String zona = "";

        do {
            try {
                GerenciadorTexto.exibirPerguntaTipoZona();
                String entrada = scanner.next().trim().toLowerCase();
                scanner.nextLine();

                if (!entrada.isEmpty()) {
                    opcao = entrada.charAt(0);
                    
                    if (opcao == 'r') {
                        zona = "Residencial";
                        entradaValida = true;
                    }
                    else if (opcao == 'c') {
                        zona = "Comercial";
                        entradaValida = true;
                    }
                    else {
                        GerenciadorTexto.exibirErroZonaInvalida();
                    }
                } else {
                    GerenciadorTexto.exibirErroZonaVazia();
                }
            }
            catch (Exception e) {
                GerenciadorTexto.exibirErroInesperadoZona(e.getMessage());
                scanner.nextLine();
            }
        }
        while (!entradaValida);
        return zona;
    }
}