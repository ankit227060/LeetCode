class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();

        int cols = n / rows;
        char arr[][] = new char[rows][cols];
        int r = 0, c = 0;
        for(int i=0; i<n; ++i) {
            arr[r][c] = encodedText.charAt(i);
            c = (c + 1) % cols;
            if(c == 0) {
                r = (r + 1) % rows;
            }
        }

        StringBuilder sb = new StringBuilder("");
        int round = 0;
        r = 0; c = 0;
        for(int i=0; i<n; ++i) {
            sb.append(arr[r][c]);
            if(r == 0 && c == cols-1) {
                break;
            }
            r = (r + 1) % rows;
            c = (c + 1) % cols;
            if(r == 0 || c == 0) {
                ++round;
                r = 0;
                c = round;
            }
        }

        String res = sb.toString().stripTrailing();
        
        return res;
    }
}