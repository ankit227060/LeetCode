class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> resultSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        queue.offer(expression);
        visited.add(expression);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

           
            if (curr.indexOf('{') == -1) {
                resultSet.add(curr);
                continue;
            }

           
            int right = curr.indexOf('}');
            
            int left = curr.lastIndexOf('{', right);
            String before = curr.substring(0, left);
            String after = curr.substring(right + 1);
            String[] parts = curr.substring(left + 1, right).split(",");
            for (String part : parts) {
                String nextStr = before + part + after;
                if (visited.add(nextStr)) {
                    queue.offer(nextStr);
                }
            }
        }
        List<String> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}