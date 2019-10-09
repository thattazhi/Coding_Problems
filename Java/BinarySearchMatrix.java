import java.io.*;

class BinarySearchMatrix {
    static boolean binarySearchMatrix(int[][] mat, int target) {
        if(mat.length == 0 || mat[0].length == 0) return false;

        int i = 0, j = mat[0].length - 1;

        while(i < mat.length && j > -1)
        {
            if(mat[i][j] == target)
                return true;
            
            else if(mat[i][j] < target)
                i++;
            
            else
                j--;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 5, 9 }, { 14, 20, 21 }, { 30, 34, 43 } };

        System.out.println(binarySearchMatrix(mat, 21));
    }
}