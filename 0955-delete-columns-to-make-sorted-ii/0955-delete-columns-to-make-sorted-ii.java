class Solution {
    public int minDeletionSize(String[] s) {
        int r = s.length, c = s[0].length();
        int count = 0;

        boolean[] already_sorted = new boolean[r];

        for (int col = 0; col < c; col++) {
            boolean need_to_delete = false;

            for (int row = 1; row < r; row++) {
                if (!already_sorted[row - 1]) {
                    if (s[row].charAt(col) < s[row - 1].charAt(col)) {
                        need_to_delete = true;
                        break;
                    }
                }
            }

            if (need_to_delete) {
                count++;
            } else {
                for (int row = 1; row < r; row++) {
                    if (!already_sorted[row - 1]) {
                        if (s[row].charAt(col) > s[row - 1].charAt(col)) {
                            already_sorted[row - 1] = true;  
                        }
                    }
                }
            }
        }

        return count;
    }
}