/**
 * 179. Largest Number
 * https://leetcode.com/problems/largest-number/
 */ 
/**
 * approach: greedy
 * 1. We can solve this problem using a greedy approach.
 * 2. We will maintain a reference to the input array `nums` and convert each integer in the array to a string representation.
 * 3. We will then sort the array of strings based on a custom comparator that compares the concatenation of two strings in both possible orders (i.e., `num1 + num2` and `num2 + num1`).
 * 4. After sorting, we will concatenate the sorted strings to form the largest number.
 * 5. Finally, we will return the concatenated string as the result, ensuring that if the largest number is "0", we return "0" instead of multiple leading zeros.
 * time complexity: O(n log n), where n is the number of elements in the input array `nums`, as we need to sort the array of strings.
 * space complexity: O(n), where n is the number of elements in the input array `nums`, which is the space required for storing the string representations of the integers.
 */

class Solution {
    private String[] list;
    public String largestNumber(int[] nums) {
        list = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            list[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(list, (a,b) -> compare(a,b));
        if (list[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : list) sb.append(s);
        return sb.toString();
    }
    private int compare(String num1, String num2) {
        String s1 = num1 + num2;
        String s2 = num2 + num1;
        return s2.compareTo(s1);
    }
}