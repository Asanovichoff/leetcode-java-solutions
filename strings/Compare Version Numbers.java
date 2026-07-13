/** problem: Compare Version Numbers
 * 
 * approach 1: two pointers
 * time complexity: O(n + m)
 * space complexity: O(1)
 * 
 * explanation:
 * 1. initialize two pointers to the start of the strings
 * 2. while the pointers are not at the end of the strings
 * 3. compare the numbers at the pointers
 * 4. return the result
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            int num1 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            int num2 = 0;
            while (j < version2.length() && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            i++;
            j++;
        }

        return 0;
    }
}