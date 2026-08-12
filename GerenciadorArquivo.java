package util;

import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivo {
    //gravacao em arquivo de texto
    public static void salvarTexto(String nomeArquivo, List<Financiamento> lista) {
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(nomeArquivo);
            for (Financiamento f : lista) {
                String linha = f.getValorImovel() + ";" + f.getPrazoFinanciamento() + ";" + f.getTaxaJurosAnual();

                //polimorfismo
                if (f instanceof Casa) {
                    Casa c = (Casa) f;
                    linha += ";Casa;" + c.getAreaConstruida() + ";" + c.getAreaTerreno();
                }
                else if (f instanceof Apartamento) {
                    Apartamento a = (Apartamento) f;
                    linha += ";Apartamento;" + a.getVagasGaragem() + ";" + a.getNumeroAndar();
                }
                else if (f instanceof Terreno) {
                    Terreno t = (Terreno) f;
                    linha += ";Terreno;" + t.getTipoZona();
                }
                escritor.write(linha + "\n");
                }
            System.out.println("Dados salvos em texto com sucesso!");
        }
        catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de texto: " + e.getMessage());
        }
        finally {
            try {
                if (escritor != null) {
                    escritor.close();
                }
            }
            catch (IOException e) {
                System.out.println("Erro ao fechar o escritor de texto: " + e.getMessage());
            }
        }
    }
    //leitura do arquivo de texto
    public static void lerTexto(String nomeArquivo) {
        FileReader leitor = null;
        BufferedReader bufferLeitura = null;
        try {
            leitor = new FileReader(nomeArquivo);
            bufferLeitura = new BufferedReader(leitor);
            String linha;
            System.out.println("\n--- LENDO DADOS DO ARQUIVO DE TEXTO ---");
            while ((linha = bufferLeitura.readLine()) != null) {
                System.out.println(linha);
            }
        }
        catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de texto: " + e.getMessage());
        }
        finally {
            try {
                if (bufferLeitura != null) bufferLeitura.close();
                if (leitor != null) leitor.close();
            }
            catch (IOException e) {
                System.out.println("Erro ao fechar leitores de texto: " + e.getMessage());
            }
        }
    }

    //gravacao serializacao
    public static void salvarSerializacao(String nomeArquivo, List<Financiamento> lista) {
        FileOutputStream arquivoSaida = null;
        ObjectOutputStream fluxoObjetos = null;

        try {
            arquivoSaida = new FileOutputStream(nomeArquivo);
            fluxoObjetos = new ObjectOutputStream(arquivoSaida);
            fluxoObjetos.writeObject(lista);
            System.out.println("Objetos serializados e salvos com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro na serialização: " + e.getMessage());
        } finally {
            try {
                if (fluxoObjetos != null) fluxoObjetos.close();
                if (arquivoSaida != null) arquivoSaida.close();
            }
            catch (IOException e) {
                System.out.println("Erro ao fechar fluxos de serialização: " + e.getMessage());
            }
        }
    }
    //leiturada serializacao
    @SuppressWarnings("unchecked")
    public static List<Financiamento> lerSerializacao(String nomeArquivo) {
        FileInputStream arquivoEntrada = null;
        ObjectInputStream fluxoLeituraObjetos = null;
        List<Financiamento> listaRecuperada = new ArrayList<>();

        try {
            arquivoEntrada = new FileInputStream(nomeArquivo);
            fluxoLeituraObjetos = new ObjectInputStream(arquivoEntrada);
            listaRecuperada = (List<Financiamento>) fluxoLeituraObjetos.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler serialização: " + e.getMessage());
        }
        finally {
            try {
                if (fluxoLeituraObjetos != null) fluxoLeituraObjetos.close();
                if (arquivoEntrada != null) arquivoEntrada.close();
            }
            catch (IOException e) {
                System.out.println("Erro ao fechar fluxos de leitura serializada: " + e.getMessage());
            }
        }
        return listaRecuperada;
    }
}