package br.com.lucchetta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner SCANNER;
    private int[][] matrix;

    public Main() {
        this.SCANNER = new Scanner(System.in);
    }

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        boolean executing = true;

        while (executing) {
            System.out.println("========== SNAIL PROJECT ==========");
            System.out.println("1 - Jogar");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opcao:");
            int choice = this.SCANNER.nextInt();

            if (choice == 1) {
                System.out.print("\nDigite o tamanho N da matriz NxN: ");
                int matrixLength = this.SCANNER.nextInt();

                this.matrix = generateMatrix(matrixLength);
                List<Integer> result = executeSnail();

                System.out.println("\nResultado: " + result);
                System.out.println("====================================");
            } else {
                executing = false;
            }
        }
    }

    private int[][] generateMatrix(int matrixLength) {
        int[][] matrix = new int[matrixLength][matrixLength];

        System.out.println("Digite os elementos da matriz:");
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrix[i][j] = SCANNER.nextInt();
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
}