/**
 * Problem: Find the Prefix Common Array of Two Arrays
 * Platform: LeetCode
 *
 * Approach (Prefix Sum):
 * 1. Use a prefix sum to find the prefix common array of two arrays.
 * 2. Use a loop to iterate through the arrays and find the prefix common array.
 * 3. Return the prefix common array.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a prefix sum to find the prefix common array of two arrays.
 * 2. We use a loop to iterate through the arrays and find the prefix common array.
 * 3. We return the prefix common array.
 */
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int[] C = new int[A.length];
        if (A[0] == B[0]) {
            C[0] = 1;
        }else {
            C[0] = 0;
            setA.add(A[0]);
            setB.add(B[0]);
        }

        for (int i = 1; i < C.length; i++) {
            if (A[i] == B[i]) C[i]++;
            else {
                if (setB.contains(A[i])){
                    C[i]++;
                    setB.remove(A[i]);
                }else {
                    setA.add(A[i]);
                }
                if (setA.contains(B[i])) {
                    C[i]++;
                    setA.remove(B[i]);
                }else {
                    setB.add(B[i]);
                }
            }
            C[i]+=C[i-1];
        }
        return C;
    }
}
