import java.util.Scanner;

class DiagonalMatrix extends SquareMatrix {
    DiagonalMatrix(int order) {
        super(order);
        Scanner sc = new Scanner(System.in);
        double[][] data = getData();
        for (int i = 0; i < order; i++) {
            System.out.println("Enter The[" + (i + 1) + "][" + (i + 1) + "]th Element:");
            double temp = sc.nextDouble();
            data[i][i] = temp;
        }
        setData(data);
    }
}