package br.com.lucchetta;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Resistors {

    private static final String THOUSAND_OR_MORE = "k";
    private static final String MILLION_OR_MORE = "m";
    private static final Map<Integer, String> COLOR_CODE = new HashMap<>();

    private String firstBand;
    private String secondBand;
    private String multiplier;
    private String tolerance;
    private Scanner scanner;

    public Resistors(Scanner scanner) {
        this.firstBand = "";
        this.secondBand = "";
        this.multiplier = "";
        this.tolerance = "dourado";
        this.scanner = scanner;
    }

    static {
        COLOR_CODE.put(0, "preto");
        COLOR_CODE.put(1, "marrom");
        COLOR_CODE.put(2, "vermelho");
        COLOR_CODE.put(3, "laranja");
        COLOR_CODE.put(4, "amarelo");
        COLOR_CODE.put(5, "verde");
        COLOR_CODE.put(6, "azul");
        COLOR_CODE.put(7, "violeta");
        COLOR_CODE.put(8, "cinza");
        COLOR_CODE.put(9, "branco");
    }

    public void start() {
        boolean executing = true;

        while (executing) {
            executing = executeGame();
        }
    }

    private boolean executeGame() {
        try {
            int choice = mainMenu();

            if (choice == 0) {
                return false;
            } else if (choice == 1) {
                String resistorValue = enterValueMenu();
                execute(resistorValue);
            } else {
                System.out.println("\n### Digite uma opcao valida! ###\n");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private int mainMenu() {
        System.out.println("\n========== RESISTORS PROJECT ==========");
        System.out.println("1 - Jogar");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    private String enterValueMenu() {
        System.out.println("\n- Para valores acima de 1.000 e ate 1.000.000, divida por 1.000 e insira um \"k\" apos o numero. Ex: 4.7k ohms");
        System.out.println("- Para valores acima ou igual a 1.000.000, divida por 1.000.000 e insira um \"M\" apos o numero. Ex: 1M ohms");
        System.out.print("\nDigite o valor seguido de ohms: ");
        scanner.nextLine();
        return scanner.nextLine();
    }

    private void execute(String resistorValue) {
        resistorValue = filterResisterValue(resistorValue);

        if (resistorValue.contains(THOUSAND_OR_MORE)) {
            getThousandOrMore(resistorValue);
        } else if (resistorValue.contains(MILLION_OR_MORE)) {
            getMillionOrMore(resistorValue);
        } else {
            getLessThanThousand(resistorValue);
        }
    }

    private String filterResisterValue(String resistorValue) {
        if (!resistorValue.contains(" ohms")) throw new RuntimeException("Valor de entrada invalido!");

        try {
            return resistorValue.replace(" ohms", "").toLowerCase();
        } catch (Exception e) {
            throw new RuntimeException("!!! Valor de entrada invalido !!!\n");
        }
    }

    private int getBaseValue(String resistorValue) {
        if (resistorValue.contains(THOUSAND_OR_MORE)) {
            double value = Double.parseDouble(resistorValue.replace(THOUSAND_OR_MORE, ""));
            return (int) (value * 10);
        } else if (resistorValue.contains(MILLION_OR_MORE)) {
            double value = Double.parseDouble(resistorValue.replace(MILLION_OR_MORE, ""));
            return (int) (value * 10);
        } else {
            return Integer.parseInt(resistorValue);
        }
    }

    private void getThousandOrMore(String resistorValue) {
        int baseValue = getBaseValue(resistorValue);
        firstBand = COLOR_CODE.get(baseValue / 10);
        secondBand = COLOR_CODE.get(baseValue % 10);
        multiplier = COLOR_CODE.get(2);
        getResult();
    }

    private void getMillionOrMore(String resistorValue) {
        int baseValue = getBaseValue(resistorValue);
        firstBand = COLOR_CODE.get(baseValue / 10);
        secondBand = COLOR_CODE.get(baseValue % 10);
        multiplier = COLOR_CODE.get(5);
        getResult();
    }

    private void getLessThanThousand(String resistorValue) {
        int value = getBaseValue(resistorValue);
        if (value < 10) {
            firstBand = COLOR_CODE.get(0);
            secondBand = COLOR_CODE.get(value);
            multiplier = COLOR_CODE.get(0);
        } else if (value < 100) {
            firstBand = COLOR_CODE.get(value / 10);
            secondBand = COLOR_CODE.get(value % 10);
            multiplier = COLOR_CODE.get(0);
        } else {
            firstBand = COLOR_CODE.get(value / 100);
            secondBand = COLOR_CODE.get((value / 10) % 10);
            multiplier = COLOR_CODE.get(1);
        }
        getResult();
    }

    private void getResult() {
        System.out.println("Resultado => " + firstBand + " " + secondBand + " " + multiplier + " " + tolerance);
        System.out.println();
    }
}
