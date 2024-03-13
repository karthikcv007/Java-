public class Mmain {
    public static void main(String[] args) {

        SquareMatrix squareMatrix = new SquareMatrix(3);
        squareMatrix.setElements();
        System.out.println("Square Matrix:");
        squareMatrix.getElements();

        boolean isSymmetric = squareMatrix.isSymmetric();
        System.out.println("Is Symmetric: " + isSymmetric);

        boolean isSingular = squareMatrix.isSingular();
        System.out.println("Is Singular: " + isSingular);

        double trace = squareMatrix.findTrace();
        System.out.println("Trace of the Matrix: " + trace);

        DiagonalMatrix diagonalMatrix = new DiagonalMatrix(3);
        System.out.println("Diagonal Matrix:");
        diagonalMatrix.getElements();
    }
}
