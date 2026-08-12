package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidadorDados {

    public static double lerDouble(Scanner scanner, String mensagem, double min, double max) {
        double valor = -1;
        do {
            System.out.print(mensagem);
            try {
                valor = scanner.nextDouble();
                if (valor < min || valor > max) {
                    GerenciadorTexto.exibirErroIntervaloDouble(min, max);
                    valor = -1;
                }
            }
            catch (InputMismatchException e) {
                GerenciadorTexto.exibirErroInputMismatchDouble();
                scanner.nextLine();
                valor = -1;
            }
        }
        while (valor == -1);
        return valor;
    }

    public static int lerInt(Scanner scanner, String mensagem, int min, int max) {
        int valor = -1;
        do {
            System.out.print(mensagem);
            try {
                valor = scanner.nextInt();
                if (valor < min || valor > max) {
                    GerenciadorTexto.exibirErroIntervaloInt(min, max);
                    valor = -1;
                }
            }
            catch (InputMismatchException e) {
                GerenciadorTexto.exibirErroInputMismatchInt();
                scanner.nextLine();
                valor = -1;
            }
        }
        while (valor == -1);
        return valor;
    }
}