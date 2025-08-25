class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);
        int number = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                number += map.get(s.charAt(n - 1));
                break;
            }
            char a = s.charAt(i), b = s.charAt(i + 1);
            if (map.get(a) >= map.get(b))
                number += map.get(a);
            else
                number -= map.get(a);
        }
        return number;
    }
}