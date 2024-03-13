import java.util.Random;
import java.util.Scanner;
public class LC1_Q4 {
        private int[][] matrix;

        public LC1_Q4() {
            Random random = new Random();
            int rows = random.nextInt(10) + 1;
            int cols = random.nextInt(10) + 1;
            matrix = new int[rows][cols];

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a range of no.: ");
            int n = sc.nextInt();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = random.nextInt(n) + 1;
                }
            }
        }
        public void displayMatrix() {
            for (int[] row : matrix) {
                for (int value : row) {
                    System.out.print(value + "\t");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {


            LC1_Q4 matrix = new LC1_Q4();
            System.out.println("Randomly generated matrix:");
            matrix.displayMatrix();
        }
    }
