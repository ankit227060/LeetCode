class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        if (restrictions.length == 0) {
            return n - 1;
        }
        Arrays.sort(restrictions, (a, b) -> a[0] - b[0]);
        int idx = 1, h = 0;
        for (int i = 0; i < restrictions.length; i++) {
            int x = restrictions[i][0];
            int y = restrictions[i][1];
            restrictions[i][1] = Math.min(y, x - idx + h);
            idx = x;
            h = restrictions[i][1];
        }
        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(
                restrictions[i][1],
                restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]
            );
        }
        int res = n - restrictions[restrictions.length - 1][0] + restrictions[restrictions.length - 1][1];
        idx = 1;
        h = 0;
        for (int[] r : restrictions) {
            int x = r[0];
            int y = r[1];
            int steps = x - idx - Math.abs(y - h);
            int higher = Math.max(y, h);
            res = Math.max(res, higher + steps / 2);
            idx = x;
            h = y;
        }
        return res;
    }
}