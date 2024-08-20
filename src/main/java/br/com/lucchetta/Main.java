package br.com.lucchetta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private Scanner scanner;
    private int[][] matrix;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    private void start() {
        this.matrix = generateMatrix();
        List<Integer> result = executeSnail();
        System.out.println("Resultado: " + result);
        System.out.println("====================================");
    }

    private int[][] generateMatrix() {
        System.out.println("========== SNAIL PROJECT ==========");
        System.out.print("Digite o tamanho N da matriz NxN: ");
        int matrixLength = this.scanner.nextInt();

        int[][] matrix = new int[matrixLength][matrixLength];

        System.out.println("Digite os elementos da matriz:");
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
            // Percorre da esquerda para a direita na linha superior
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
                // Percorre da direita para a esquerda na linha inferior
                for (int i = right; i >= left; i--) {
                    result.add(this.matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Percorre de baixo para cima na coluna esquerda
                for (int i = bottom; i >= top; i--) {
                    result.add(this.matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}