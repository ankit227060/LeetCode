class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> d = new HashMap<>();

        for (List<String> item : knowledge) {
            d.put(item.get(0), item.get(1));
        }

        StringBuilder ans = new StringBuilder();
        int start = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                start = i;
            }
            else if (c == ')') {
                String key = s.substring(start + 1, i);

                ans.append(d.getOrDefault(key, "?"));
                start = -1;
            }
            else if (start < 0) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}