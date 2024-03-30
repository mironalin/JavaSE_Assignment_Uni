package eu.deic.oop;

public class Matrix implements Printable {
    private int rows;
    private int columns;
    private int[][] matrix;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new int[rows][columns];
    }

    public Matrix(int[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.matrix = matrix;
    }

    public int getMatrixData(int i, int j) {
        return this.matrix[i][j];
    }

    public void setMatrixData(int i, int j, int value) {
        this.matrix[i][j] = value;
    }

    public Matrix add(Matrix otherMatrix) {
        if (this.rows != otherMatrix.rows || this.columns != otherMatrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                resultMatrix.setMatrixData(i, j, this.matrix[i][j] + otherMatrix.getMatrixData(i, j));
            }
        }

        return resultMatrix;
    }

    public Matrix subtract(Matrix otherMatrix) {
        if (this.rows != otherMatrix.rows || this.columns != otherMatrix.columns) {
            throw new IllegalArgumentException("Matrices must have the same dimensions.");
        }

        Matrix resultMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                resultMatrix.setMatrixData(i, j, this.matrix[i][j] - otherMatrix.getMatrixData(i, j));
            }
        }

        return resultMatrix;
    }

    public Matrix multiply(Matrix otherMatrix) {
        if (this.columns != otherMatrix.rows) {
            throw new IllegalArgumentException(
                    "Number of columns of the first matrix must be equal to the number of rows of the second matrix.");
        }

        Matrix resultMatrix = new Matrix(this.rows, otherMatrix.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < otherMatrix.columns; j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.matrix[i][k] * otherMatrix.getMatrixData(k, j);
                }
                resultMatrix.setMatrixData(i, j, sum);
            }
        }

        return resultMatrix;
    }

    public Matrix scalarMultiply(int scalar) {
        Matrix resultMatrix = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                resultMatrix.setMatrixData(i, j, this.matrix[i][j] * scalar);
            }
        }

        return resultMatrix;
    }

    public void print() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                System.out.printf("%4d", this.matrix[i][j]);
            }
            System.out.println();
        }
    }

}
