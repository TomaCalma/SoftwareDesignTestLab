package helper;

public class Transpose {

    public static String[][] transpose(int nrow, int ncol, String[][] matrix){
        String[][] transpose = new String[ncol][nrow];
        for(int i = 0; i < nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

}