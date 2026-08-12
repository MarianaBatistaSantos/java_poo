package util;
// a justificativa da criacao dessa classe e devido a bagunca que estava ficando no main e outros files,
// os textos misturados estavam me confundindo e dificultando a correcao de erros
public class GerenciadorTexto {

    //mensagem inicial
    public static void exibirBoasVindo() {
        System.out.println("\n==========================================================");
        System.out.println("          BEM-VINDO AO SISTEMA DE FINANCIAMENTOS          ");
        System.out.println("==========================================================");
    }

    public static void exibirAlertaLimites() {
        System.out.println("                     LIMITES ACEITOS                      ");
        System.out.println("  Valor do imovel:  R$ 1,00 ate R$ 50.000.000,00");
        System.out.println("  Prazo maximo:     50 anos");
        System.out.println("  Taxa de juros:    0.1% ate 50.00%");
        System.out.println("==========================================================");
    }

    //perguntas e menu
    public static String obterLabelQuantidade() {
        return "Quantos financiamentos deseja fazer? ";
    }

    public static void exibirMenuTipoFinanciamento(int numero) {
        System.out.println("\n==========================================================");
        System.out.println("Qual e o tipo do financiamento " + numero + "?");
        System.out.println("----------------------------------------------------------");
        System.out.println(" [C] - Casa");
        System.out.println(" [A] - Apartamento");
        System.out.println(" [T] - Terreno");
        System.out.print("Sua opcao: ");
    }

    public static void exibirCabecalhoEntradaDados(int numero) {
        System.out.println("\n>>> ENTRADA DE DADOS - FINANCIAMENTO " + numero + " <<<");
    }

    public static String obterLabelValorImovel() {
        return "Digite o valor do imovel (R$): ";
    }

    public static String obterLabelPrazo() {
        return "Digite o prazo do financiamento (em anos): ";
    }

    public static String obterLabelTaxaJuros() {
        return "Digite a taxa de juros anual (%): ";
    }

    public static String obterLabelAreaConstruida() {
        return "Digite o tamanho da area construida (m²): ";
    }

    public static String obterLabelTamanhoTerreno() {
        return "Digite o tamanho do terreno (m²): ";
    }

    public static String obterLabelVagasGaragem() {
        return "Digite o numero de vagas na garagem: ";
    }

    public static String obterLabelAndar() {
        return "Digite o numero do andar: ";
    }

    public static void exibirPerguntaTipoZona() {
        System.out.print("Digite o tipo de zona [R]esidencial ou [C]omercial: ");
    }

    //mensagem de erro e validacao
    public static void exibirErroOpcaoInvalida() {
        System.out.println("[Erro]: Opcao invalida! Tente novamente.");
    }

    public static void exibirErroIntervaloDouble(double min, double max) {
        System.out.printf("[Erro]: Invalido! O valor deve estar entre %,.2f e %,.2f%n", min, max);
    }

    public static void exibirErroInputMismatchDouble() {
        System.out.println("[Erro]: Invalido! Digite apenas valores numericos.");
    }

    public static void exibirErroIntervaloInt(int min, int max) {
        System.out.printf("[Erro]: Invalido! O numero deve estar entre %d e %d.%n", min, max);
    }

    public static void exibirErroInputMismatchInt() {
        System.out.println("[Erro]: Invalido! Digite apenas numeros inteiros.");
    }

    public static void exibirErroZonaInvalida() {
        System.out.println("[Erro]: Opcao invalida! Digite apenas 'R' para Residencial ou 'C' para Comercial.");
    }

    public static void exibirErroZonaVazia() {
        System.out.println("[Erro]: Entrada vazia! Por favor, escolha uma opcao.");
    }

    public static void exibirErroInesperadoZona(String msg) {
        System.out.println("[Erro]: Erro inesperado na leitura da zona: " + msg);
    }

    //relatorio e comprovacao
    public static void exibirCabecalhoRelatorioGeral() {
        System.out.println("\n==========================================================");
        System.out.println("       RELATORIO DOS FINANCIAMENTOS CADASTRADOS          ");
        System.out.println("==========================================================");
    }

    public static void exibirDivisorFinanciamento(int numero) {
        System.out.println("\n---------------- [ FINANCIAMENTO " + numero + " ] ----------------");
    }

    public static void exibirErroImpressao(String msg) {
        System.out.println("[Erro]: Falha ao exibir dados: " + msg);
    }

    public static void exibirAvisoExclusaoSoma() {
        System.out.println("\n[Aviso]: O valor de um financiamento foi excluido do total geral devido a uma violacao de juros.");
    }

    public static void exibirResumoTotais(double totalImoveis, double totalFinanciamentos) {
        System.out.println("\n=================== RESUMO DOS TOTAIS ===================");
        System.out.printf("Total de todos os imoveis:        R$ %,.2f%n", totalImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %,.2f%n", totalFinanciamentos);
        System.out.println("=========================================================");
    }

    public static void exibirCabecalhoComprovacaoSerializado() {
        System.out.println("\n==========================================================");
        System.out.println("      COMPROVACAO: DADOS SERIALIZADOS RECUPERADOS        ");
        System.out.println("==========================================================");
    }

    public static void exibirRodapeFinal() {
        System.out.println("=========================================================");
    }
}