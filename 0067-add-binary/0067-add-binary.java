class Solution {
    public String addBinary(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        int max = Math.max(n1, n2);
        int C_in = 0, i = 0;
        String res = "";

        while (i < max || C_in > 0) {
            int A = 0;
            int B = 0;

            if (i < n1)
                A = a.charAt(n1 - 1 - i) - '0';

            if (i < n2)
                B = b.charAt(n2 - 1 - i) - '0';

            int S = (A ^ B) ^ C_in;
            int C_out = ((A ^ B) & C_in) | (A & B);

            res = (char)(S + '0') + res;
            C_in = C_out;

            i++;
        }

        return res;
    }
}
