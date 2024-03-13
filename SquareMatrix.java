class SquareMatrix extends LC2_Matrix {
    private int order;

    public SquareMatrix(int order) {
        super(order, order);
        this.order = order;
    }

    public boolean isSymmetric() {
        double[][] data = getData();
        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                if (data[i][j] != data[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSingular() {
        double det = determinant(getData());
        return det == 0;
    }

    public double findTrace() {
        double trace = 0;
        for (int i = 0; i < order; i++) {
            trace += getData()[i][i];
        }
        return trace;
    }

    public double determinant(double[][] data) {
        double det = 0;
        if (data.length == 1) {
            return data[0][0];
        } else if (data.length == 2) {
            return (data[0][0] * data[1][1]) - (data[0][1] * data[1][0]);
        } else {
            for (int i = 0; i < data.length; i++) {
                det += Math.pow(-1, i) * data[0][i] * determinant(sub_matrix(data, 0, i));
            }
        }
        return det;
    }

    public double[][] sub_matrix(double[][] dataSquare, int ex_row, int ex_col) {
        int sub_order = dataSquare.length - 1;
        double[][] subMatrix = new double[sub_order][sub_order];
        for (int i = 1; i < dataSquare.length; i++) {
            for (int j = 0, col = 0; j < dataSquare.length; j++) {
                if (j == ex_col) {
                    continue;
                }
                subMatrix[i - 1][col++] = dataSquare[i][j];
            }
        }
        return subMatrix;
    }
}



