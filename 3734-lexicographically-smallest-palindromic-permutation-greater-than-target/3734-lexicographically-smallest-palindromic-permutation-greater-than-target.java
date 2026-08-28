class Solution {

    private String buildPalindrome(String half, char middle) {
        StringBuilder result = new StringBuilder(half);

        if (middle != 0) {
            result.append(middle);
        }

        for (int i = half.length() - 1; i >= 0; --i) {
            result.append(half.charAt(i));
        }

        return result.toString();
    }

    private String smallestGreaterOrEqual(int[] originalCount, String targetHalf) {
        int[] count = originalCount.clone();
        int k = targetHalf.length();
        int matched = 0;

        while (matched < k && count[targetHalf.charAt(matched) - 'a'] > 0) {
            count[targetHalf.charAt(matched) - 'a']--;
            matched++;
        }

        if (matched == k) {
            return targetHalf;
        }

        for (int pos = matched; pos >= 0; --pos) {
            if (pos < matched) {
                count[targetHalf.charAt(pos) - 'a']++;
            }

            for (int c = targetHalf.charAt(pos) - 'a' + 1; c < 26; ++c) {
                if (count[c] == 0) continue;

                StringBuilder result = new StringBuilder(targetHalf.substring(0, pos));
                result.append((char) ('a' + c));
                count[c]--;

                for (int ch = 0; ch < 26; ++ch) {
                    while (count[ch]-- > 0) {
                        result.append((char) ('a' + ch));
                    }
                    count[ch] = Math.max(count[ch], 0);
                }

                return result.toString();
            }
        }

        return "";
    }

    private boolean nextPermutation(char[] half) {
        int pivot = half.length - 2;

        while (pivot >= 0 && half[pivot] >= half[pivot + 1]) {
            pivot--;
        }

        if (pivot < 0) {
            return false;
        }

        int swapPos = half.length - 1;

        while (half[swapPos] <= half[pivot]) {
            swapPos--;
        }

        char temp = half[pivot];
        half[pivot] = half[swapPos];
        half[swapPos] = temp;

        int left = pivot + 1;
        int right = half.length - 1;

        while (left < right) {
            temp = half[left];
            half[left] = half[right];
            half[right] = temp;
            left++;
            right--;
        }

        return true;
    }

    public String lexPalindromicPermutation(String s, String target) {
        int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        char middle = 0;
        int oddCount = 0;

        for (int c = 0; c < 26; ++c) {
            if ((frequency[c] & 1) == 1) {
                oddCount++;
                middle = (char) ('a' + c);
            }
        }

        if (oddCount > 1) {
            return "";
        }

        int[] halfCount = new int[26];

        for (int c = 0; c < 26; ++c) {
            halfCount[c] = frequency[c] / 2;
        }

        int k = s.length() / 2;
        String targetHalf = target.substring(0, k);

        String halfString = smallestGreaterOrEqual(halfCount, targetHalf);

        if (halfString.isEmpty() && k > 0) {
            return "";
        }

        String candidate = buildPalindrome(halfString, middle);

        if (candidate.compareTo(target) > 0) {
            return candidate;
        }

        char[] half = halfString.toCharArray();

        if (!nextPermutation(half)) {
            return "";
        }

        return buildPalindrome(new String(half), middle);
    }
}