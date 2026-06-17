class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                if (len > 0) len--;
            } else if (ch == '#') {
                len <<= 1;
            } else if (ch != '%') {
                len++;
            }
        }
        if (k >= len) return '.';
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                len++;
            } else if (ch == '#') {
                long half = len >> 1;
                if (k >= half) k -= half;
                len = half;
            } else if (ch == '%') {
                k = len - k - 1;
            } else {
                if (k == len - 1) return ch;
                len--;
            }
        }
        return '.';
    }
}