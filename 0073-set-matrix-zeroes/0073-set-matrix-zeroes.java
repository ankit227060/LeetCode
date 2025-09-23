class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length ;
        int columns = matrix[0].length; 
        boolean[] rowMarker =new boolean[rows];
        boolean[] columnMarker =new boolean[columns];
        for (int i =0; i < rows; i++){
            for (int j =0; j < columns; j++){
                if(matrix[i][j]==0){
                    rowMarker[i] = true;
                    columnMarker[j] = true; 
                }
            }
        }

        for (int i =0; i < rows; i++){
            for (int j =0; j < columns; j++){
                if(rowMarker[i] || columnMarker[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}