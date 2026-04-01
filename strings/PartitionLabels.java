/**
 * Problem: Partition Labels
 * Platform: LeetCode
 *
 * Approach (Greedy):
 * 1. Use a greedy approach to partition the string into the maximum number of parts.
 * 2. Use a loop to iterate through the string and partition the string into the maximum number of parts.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a greedy approach to partition the string into the maximum number of parts.
 * 2. We use a loop to iterate through the string and partition the string into the maximum number of parts.
 * 3. We return the result.
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] dictionary = new int[26];
        for (char c : s.toCharArray()){
            dictionary[c-'a']++;
        }
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        while (r<s.length()){
            int idx = s.charAt(r)-'a';
            set.add(s.charAt(r));
            dictionary[idx]--;
            if (dictionary[idx] == 0){
                set.remove(s.charAt(r));
                if (set.size() == 0){
                    result.add(r-l+1);
                    l = r+1;
                    r = l;
                    continue;
                }
            }
            r++;
        }
        return result;
    }
}
