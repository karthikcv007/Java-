import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class LC_Q5 {
    private static int count = 0;
    private int[][] matrix;
    public Timestamp uniqueID;

    public LC_Q5() {
        count++;
        uniqueID = Timestamp.from(Instant.now());
        Random random = new Random();
        int rows = random.nextInt(10) + 1;
        int cols = random.nextInt(10) + 1;
        matrix = new int[rows][cols];

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range of no. (Natural Number): ");
        int n = sc.nextInt();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(n) + 1;
            }
        }
    }


    public void displayMatrix() {
        System.out.println("Matrix with Unique ID: " + uniqueID);
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LC_Q5 matrix1 = new LC_Q5();
        LC_Q5 matrix2 = new LC_Q5();
        LC_Q5 matrix3 = new LC_Q5();

        matrix1.displayMatrix();
        matrix2.displayMatrix();
        matrix3.displayMatrix();
    }
}