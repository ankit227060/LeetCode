class Solution {
    public long sumAndMultiply(int n) {
        String num = Integer.toString(n);
        StringBuilder x = new StringBuilder();

        for (char ch : num.toCharArray()) {
            if (ch != '0') {
                x.append(ch);
            }
        }

        if (x.length() == 0) {
            return 0;
        }

        int sum = 0;
        for (char ch : x.toString().toCharArray()) {
            sum += ch - '0';
        }

        long value = Long.parseLong(x.toString());

        return value * sum;
    }
}