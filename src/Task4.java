
public class Task4 {
    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix == null || firstMatrix.length < 1 || firstMatrix[0].length < 1 ||
                secondMatrix == null || secondMatrix.length < 1 || secondMatrix[0].length < 1)
            return null;
        if (firstMatrix.length != secondMatrix[0].length)
            return null;
        if (firstMatrix[0].length != secondMatrix.length)
            return null;
        int[][] resultMatrix = new int[firstMatrix.length][secondMatrix[0].length];
        for (int y = 0; y < secondMatrix[0].length; y++) {
            for (int x = 0; x < firstMatrix.length; x++) {
                int result = 0;
                for (int z = 0; z < firstMatrix[0].length; z++) {
                    result += firstMatrix[y][z] * secondMatrix[z][x];
                }
                resultMatrix[y][x] = result;
            }
        }
        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            System.out.println("Empty matrix");
            return;
        }
        for (int y = 0; y < matrix.length; y++) {
            System.out.print("|");
            for (int x = 0; x < matrix[0].length; x++) {
                System.out.print(matrix[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("");
    }

}