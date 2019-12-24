public class Matrix {

    public Matrix(int[][] array) {
        int[][] matrixArray = new int[array.length][array[0].length];
//         can use System.arraycopy() but we didn't lean that
        final int ARRAY_LENGTH = matrixArray.length;
        final int ARRAY_HEIGHT = matrixArray[0].length;
        for (int i = 0; i <= matrixArray.length; i++) {
            for (int j = 0; j <= matrixArray[0].length; j++) {
                matrixArray[i][j] = array[i][j];
            }
        }
    }

    public Matrix(int size1, int size2) {
        int[][] matrixArray = new int[size1][size2];
        final int ARRAY_LENGTH = size1;
        final int ARRAY_HEIGHT = size2;
        for (int i = 0; i <= matrixArray.length; i++) {
            for (int j = 0; j <= matrixArray[0].length; j++) {
                matrixArray[i][j] = 0;
            }
        }
    }

    public String toString() {
        return "i want to die";
    }
}
