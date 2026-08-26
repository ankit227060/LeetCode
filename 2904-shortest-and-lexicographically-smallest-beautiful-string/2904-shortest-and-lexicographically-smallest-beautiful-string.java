class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String answer = "";
        int left = 0;
        int ones = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            if (ones == k) {
                String candidate = s.substring(left, right + 1);

                if (answer.isEmpty() ||
                    candidate.length() < answer.length() ||
                    (candidate.length() == answer.length() &&
                     candidate.compareTo(answer) < 0)) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }
}