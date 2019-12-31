/**
 * @author ariel
 * @version maman 13
 */
public class Matrix {
    private int length;
    private int height;
    private int[][] matrix;

    /**
     *copy Constructor build a 2D array of numbers between 0-255
     * @param array the array to copy
     */
    public Matrix(int[][] array) {
        matrix = new int[array.length][array[0].length];
//         can use System.arraycopy() but we didn't lean that
        length = matrix.length - 1;
        height = matrix[0].length - 1;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= height; j++) {
                matrix[i][j] = array[i][j];
            }
        }
    }

    /**
     * Constructor build a 2D array of 0
     * @param size1 the length
     * @param size2 the height
     */
    public Matrix(int size1, int size2) {
        matrix = new int[size1][size2];
        length = size1 - 1;
        height = size2 - 1;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= height; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    /**
     * build the matrix in the terminal visually
     * @return the 2D array in 2D
     */
    public String toString() {
        String toString = "";
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= height; j++) {
                toString = toString + "\t" + matrix[i][j];
            }
            toString = toString + "\n";
        }
        return toString;
    }

    /**
     * change the array so the the numbers will be opposite, if the number is 55 it will become 200
     * @return the opposite matrix
     */
    public Matrix makeNegative() {
        Matrix negative = new Matrix(matrix);
        for (int i = 0; i <= negative.length; i++) {
            for (int j = 0; j <= negative.height; j++) {
                int i1 = 255 - matrix[i][j];
                negative.matrix[i][j] = i1;

            }
        }
        return negative;
    }

    /**
     * take the matrix and change every item to be the average of all the items around him
     * @return the averaged matrix
     */
    public Matrix imageFilterAverage() {
        Matrix average = new Matrix(matrix);
        int[] neighbors = new int[8];
        int numberOfNeighbors = 0;
        for (int i = 0; i <= length; i++) {
            for (int j = 0; j <= height; j++) {
                if (i == 0 && j == 0) {
                    neighbors = new int[3];
                    neighbors[0] = matrix[i + 1][j];
                    neighbors[1] = matrix[i][j + 1];
                    neighbors[2] = matrix[i + 1][j + 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i == 0 && j == height) {
                    neighbors = new int[3];
                    neighbors[0] = matrix[i + 1][j];
                    neighbors[1] = matrix[i][j - 1];
                    neighbors[2] = matrix[i + 1][j - 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i == length && j == 0) {
                    neighbors = new int[3];
                    neighbors[0] = matrix[i - 1][j];
                    neighbors[1] = matrix[i][j + 1];
                    neighbors[2] = matrix[i - 1][j + 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i == length && j == height) {
                    neighbors = new int[3];
                    neighbors[0] = matrix[i - 1][j];
                    neighbors[1] = matrix[i][j - 1];
                    neighbors[2] = matrix[i - 1][j - 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i == 0 && j != 0 && j != height) {
                    neighbors = new int[5];
                    neighbors[0] = matrix[i][j + 1];
                    neighbors[1] = matrix[i][j - 1];
                    neighbors[2] = matrix[i + 1][j - 1];
                    neighbors[3] = matrix[i + 1][j];
                    neighbors[4] = matrix[i + 1][j + 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i == length && j != 0 && j != height) {
                    neighbors = new int[5];
                    neighbors[0] = matrix[i][j + 1];
                    neighbors[1] = matrix[i][j - 1];
                    neighbors[2] = matrix[i - 1][j - 1];
                    neighbors[3] = matrix[i - 1][j];
                    neighbors[4] = matrix[i - 1][j + 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (j == 0 && i != 0 && i != length) {
                    neighbors = new int[5];
                    neighbors[0] = matrix[i + 1][j];
                    neighbors[1] = matrix[i - 1][j];
                    neighbors[2] = matrix[i + 1][j + 1];
                    neighbors[3] = matrix[i - 1][j + 1];
                    neighbors[4] = matrix[i][j + 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (j == height && i != 0 && i != length) {
                    neighbors = new int[5];
                    neighbors[0] = matrix[i + 1][j];
                    neighbors[1] = matrix[i - 1][j];
                    neighbors[2] = matrix[i + 1][j - 1];
                    neighbors[3] = matrix[i - 1][j - 1];
                    neighbors[4] = matrix[i][j - 1];
                    numberOfNeighbors = neighbors.length;
                }
                if (i != 0 && j != 0 && i != length && j != height) {
                    neighbors = new int[8];
                    neighbors[0] = matrix[i + 1][j + 1];
                    neighbors[1] = matrix[i - 1][j - 1];
                    neighbors[2] = matrix[i + 1][j - 1];
                    neighbors[3] = matrix[i - 1][j + 1];
                    neighbors[4] = matrix[i][j - 1];
                    neighbors[5] = matrix[i][j + 1];
                    neighbors[6] = matrix[i - 1][j];
                    neighbors[7] = matrix[i + 1][j];
                    numberOfNeighbors = neighbors.length;
                }
                int averagrePoint = average.matrix[i][j];
                for (int k = 0; k < numberOfNeighbors; k++) {

                    averagrePoint += neighbors[k];
                }
                average.matrix[i][j] = averagrePoint / (numberOfNeighbors + 1);
            }
        }
        return average;
    }

    /**
     * rotate the matrix clockwise and
     * @return the clockwised turned matrix
     */
    public Matrix rotateClockwise() {
        int tmp;
        Matrix rotate = new Matrix(height + 1, length + 1);
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= length; j++) {
                rotate.matrix[i][j] = matrix[length - j][height - i];
            }
        }
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= height - 1; j++) {
                tmp = rotate.matrix[i][j];
                rotate.matrix[i][j] = rotate.matrix[height-i][j];
                rotate.matrix[height-i][j] = tmp;
            }
        }
        return rotate;
    }
    /**
     * rotate the matrix counter clockwise and
     * @return the counter clockwised turned matrix
     */
    public Matrix rotateCounterClockwise() {
        int tmp;
        Matrix rotate = new Matrix(height + 1, length + 1);
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= length; j++) {
                rotate.matrix[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= height - 1; j++) {
                tmp = rotate.matrix[i][j];
                rotate.matrix[i][j] = rotate.matrix[height - i][j];
                rotate.matrix[height - i][j] = tmp;
            }
        }
        return rotate;
    }

}