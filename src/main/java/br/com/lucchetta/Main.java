package br.com.lucchetta;

import java.util.Scanner;

public class Main {

    private Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        boolean executiung = true;

        while (executiung) {
            executiung = executeMenu();
        }
    }

    private boolean executeMenu() {
        try {
            int choice = mainMenu();

            if (choice == 0) {
                return false;
            } else if (choice == 1) {
                Snail snail = new Snail(scanner);
                snail.start();
            } else if (choice == 2) {
                Resistors resistors = new Resistors(scanner);
                resistors.start();
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
        System.out.println("========== TEST PROJECT ==========");
        System.out.println("1 - Snail");
        System.out.println("2 - Resistors");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }
}