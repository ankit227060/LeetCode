// class Solution {
//     public void rotate(int[][] matrix) {
//         int n = matrix.length;
//         int [][] copy = new int[n][n];
//         for(int i=0; i<n;i++){
//             for(int j=0; j<n;j++){
//                 copy[i][j] =matrix[n-j-1][i];
//             }
//         }

//         for(int i =0; i<n;i++){
//             for (int j =0;j<n;j++){
//                 matrix[i][j]=copy[i][j];
//             }
//         }

//     }
// }


class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        for(int i=0;i<(n+1)/2;i++){
            for(int j=0;j<n/2;j++){
                
                int temp = matrix[n-1-j][i];

                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];

                matrix[j][n - 1 - i] = matrix[i][j];

                matrix[i][j] = temp;
            }
        }
    }
}