/**
 * Problem: Merge Triplets to Form Target Triplet
 * Platform: LeetCode
 *
 * Approach (Greedy):
 * 1. Use a greedy approach to merge the triplets to form the target triplet.
 * 2. Use a loop to iterate through the triplets and merge the triplets.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * 
 * Explanation:
 * 1. We use a greedy approach to merge the triplets to form the target triplet.
 * 2. We use a loop to iterate through the triplets and merge the triplets.
 * 3. We return the result.
 */
class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target){
        int[] curTriplet = new int[]{0,0,0};
        for(int[] triplet: triplets){
            if (isGreater(triplet, target)) continue;
            curTriplet = mergeTriplets(triplet, curTriplet);
        }
        return isEqual(curTriplet, target);
    }
    public boolean isGreater(int[]triplet, int[] target){
        for (int i = 0; i<target.length; i++){
            if (triplet[i]>target[i]) return true;
        }
        return false;
    }
    public int[] mergeTriplets(int[]triplet1, int[]triplet2){
        for (int i = 0; i<triplet1.length; i++){
            triplet1[i] = Math.max(triplet1[i], triplet2[i]);
        }
        return triplet1;
    }
    public boolean isEqual(int[]triplet, int[] target){
        for (int i = 0; i<target.length; i++){
            if(triplet[i]!=target[i]) return false;
        }
        return true;
    }
}
