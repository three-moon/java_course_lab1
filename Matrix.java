import java.util.Random;

public class Matrix {
    private final int rows;
    private final int cols;
    private Number[][] numbers;

    private String name;

    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Wrong matrix size");
        }
        this.rows = rows;
        this.cols = cols;
        numbers = new Number[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setNumber(int i, int j, Number number) {
        numbers[i][j] = number;
    }

    public Number getNumber(int i, int j) {
        return numbers[i][j];
    }

    public static Matrix add(Matrix left, Matrix right) {
        if (left.getRows() != right.getRows() || left.getCols() != right.getCols()) {
            throw new IllegalArgumentException("Wrong matrix sizes");
        } else {
            Matrix addMatrix = new Matrix(left.getRows(), left.getCols());
            for (int i = 0; i < left.getRows(); ++i) {
                for (int j = 0; j < left.getCols(); ++j) {
                    addMatrix.setNumber(i, j, Number.add(left.getNumber(i, j), right.getNumber(i, j)));
                }
            }
            return addMatrix;
        }
    }

    public static Matrix subtract(Matrix left, Matrix right) {
        if (left.getRows() != right.getRows() || left.getCols() != right.getCols()) {
            throw new IllegalArgumentException("Wrong matrix sizes");
        } else {
            Matrix subMatrix = new Matrix(left.getRows(), left.getCols());
            for (int i = 0; i < left.getRows(); ++i) {
                for (int j = 0; j < left.getCols(); ++j) {
                    subMatrix.setNumber(i, j, Number.subtract(left.getNumber(i, j), right.getNumber(i, j)));
                }
            }
            return subMatrix;
        }
    }

    public static Matrix multiply(Matrix left, Matrix right) {
        if (left.getCols() != right.getRows()) {
            throw new IllegalArgumentException("Wrong matrix sizes");
        } else {
            Matrix multipliedMatrix = new Matrix(left.getRows(), right.getCols());
            for (int i = 0; i < left.getRows(); ++i) {
                for (int j = 0; j < right.getCols(); ++j) {
                    Number sum = new Number(0, 0);
                    for (int k = 0; k < left.getCols(); ++k) {
                        sum = Number.add(sum, Number.multiply(left.getNumber(i, k), right.getNumber(k, j)));
                    }
                    multipliedMatrix.setNumber(i, j, sum);
                }
            }
            return multipliedMatrix;
        }
    }

    public static Matrix transpose(Matrix matrix) {
        Matrix transposedMatrix = new Matrix(matrix.getCols(), matrix.getRows());
        for (int i = 0; i < matrix.getRows(); ++i) {
            for (int j = 0; j < matrix.getCols(); ++j) {
                transposedMatrix.setNumber(j, i, matrix.getNumber(i, j));
            }
        }
        return transposedMatrix;
    }

    public Number getDeterminant() {
        if (this.getRows() != this.getCols()) {
            throw new IllegalArgumentException("Wrong matrix sizes");
        } else if (this.getRows() == 1) {
            return this.getNumber(0, 0);
        } else if (this.getRows() == 2) {
            return Number.subtract(Number.multiply(this.getNumber(0, 0), this.getNumber(1, 1)), Number.multiply(this.getNumber(1, 0), this.getNumber(0, 1)));
        } else {
            Number determinant = new Number(0);
            Matrix subMatrix = new Matrix(this.getRows() - 1, this.getCols() - 1);
            for (int extractedCol = 0; extractedCol < this.getRows(); ++extractedCol) {
                int iSubMatrix = 0;
                for (int i = 1; i < this.getRows(); ++i) {
                    int jSubMatrix = 0;
                    for (int j = 0; j < this.getRows(); ++j) {
                        if (j == extractedCol) {
                            continue;
                        }
                        subMatrix.setNumber(iSubMatrix, jSubMatrix, this.getNumber(i, j));
                        ++jSubMatrix;
                    }
                    ++iSubMatrix;
                }
                Number tmp = Number.multiply(this.getNumber(0, extractedCol), subMatrix.getDeterminant());
                if (extractedCol % 2 == 0) {
                    determinant = Number.add(determinant, tmp);
                } else {
                    determinant = Number.subtract(determinant, tmp);
                }
            }
            return determinant;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.getRows(); ++i) {
            for (int j = 0; j < this.getCols(); ++j) {
                stringBuilder.append(this.getNumber(i, j));
                if (j != this.getCols() - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void fillRandom(){
        Random r = new Random();
        for (int i = 0; i < this.getRows(); ++i) {
            for (int j = 0; j < this.getCols(); ++j) {
              this.setNumber(i, j, new Number((r.nextInt() % 10000)/ 100.0, (r.nextInt() % 10000)/ 100.0));
            }}
    }
}