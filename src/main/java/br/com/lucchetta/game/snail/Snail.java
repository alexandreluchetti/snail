package br.com.lucchetta.game.snail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Snail {

    private Scanner scanner;
    private int[][] matrix;

    public Snail(Scanner scanner) {
        this.scanner = scanner;
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
                int matrixLength = chooseMatrixLength();
                int typeOfGame = typeOfGameMenu();

                if (typeOfGame == 1) {
                    sequentialNumbersTypeOfGame(matrixLength);
                } else if (typeOfGame == 2) {
                    chooseNumbersTypeOfGame(matrixLength);
                } else {
                    System.out.printf("Escolha uma opcao valida!");
                }
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
        System.out.println("\n========== SNAIL PROJECT ==========");
        System.out.println("1 - Jogar");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
        return this.scanner.nextInt();
    }

    private int chooseMatrixLength() {
        System.out.print("\nDigite o tamanho N da matriz NxN: ");
        return this.scanner.nextInt();
    }

    private int typeOfGameMenu() {
        System.out.println("\n1 - Numeros sequenciais");
        System.out.println("2 - Escolher os numeros");
        System.out.print("Escolha uma opcao: ");
        return this.scanner.nextInt();
    }

    private void sequentialNumbersTypeOfGame(int matrixLength) {
        this.matrix = generateMatrix(matrixLength);
        List<Integer> result = executeSnail();
        printResult(result);
    }

    private void chooseNumbersTypeOfGame(int matrixLength) {
        this.matrix = generateMatrixChoosingNumbers(matrixLength);
        List<Integer> result = executeSnail();
        printResult(result);
    }

    private int[][] generateMatrix(int matrixLength) {
        int[][] matrix = new int[matrixLength][matrixLength];

        int index = 1;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                matrix[i][j] = index;
                index++;
            }
        }

        return matrix;
    }

    private int[][] generateMatrixChoosingNumbers(int matrixLength) {
        int[][] matrix = new int[matrixLength][matrixLength];

        System.out.println("\nDigite os elementos da matriz:");
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private List<Integer> executeSnail() {
        if (this.matrix == null || this.matrix.length == 0) throw new RuntimeException("A Matriz é inválida!");

        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = this.matrix.length - 1;
        int left = 0;
        int right = this.matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(this.matrix[top][i]);
            }
            top++;

            // Percorre de cima para baixo na coluna direita
            for (int i = top; i <= bottom; i++) {
                result.add(this.matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(this.matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(this.matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    private void printResult(List<Integer> result) {
        System.out.println("\nResultado: ");
        int matrixLength = this.matrix.length;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                String bar = (j == matrixLength - 1) ? "" : " | ";
                System.out.print(this.matrix[i][j] + bar);
            }
            System.out.println();
        }

        System.out.println("\n=>" + result);
        System.out.println("====================================");
    }
}
