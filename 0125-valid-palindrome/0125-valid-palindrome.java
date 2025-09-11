class Solution {
    public boolean isPalindrome(String s) {
        // Step 1: Create a StringBuilder to hold the cleaned characters
        StringBuilder cleaned = new StringBuilder();

        // Step 2: Loop through each character in the input string
        for (char c : s.toCharArray()) {
            // Step 3: Keep only alphanumeric characters (letters and digits)
            if (Character.isLetterOrDigit(c)) {
                // Step 4: Convert character to lowercase and add to cleaned string
                cleaned.append(Character.toLowerCase(c));
            }
        }

        // Step 5: Convert the cleaned StringBuilder to a string
        String str = cleaned.toString();

        // Step 6: Call the recursive function to check if it's a palindrome
        return isPalindromeRecursive(str, 0, str.length() - 1);
    }

    // Recursive function to check if a string is a palindrome
    private boolean isPalindromeRecursive(String s, int left, int right) {
        // Base case: if the two pointers cross or meet, it's a palindrome
        if (left >= right) return true;

        // If characters at current pointers don't match, it's not a palindrome
        if (s.charAt(left) != s.charAt(right)) return false;

        // Recursive call: move inward by one position on both sides
        return isPalindromeRecursive(s, left + 1, right - 1);
    }
}
