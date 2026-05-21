/**
 * Problem: Minimum Consecutive Cards to Pick Up
 * Platform: LeetCode
 *
 * Approach (Hash Table):
 * 1. Use a hash table to store the indices of the cards.
 * 2. Use a loop to iterate through the cards and find the minimum consecutive cards to pick up.
 * 3. Return the minimum consecutive cards to pick up.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a hash table to store the indices of the cards.
 * 2. We use a loop to iterate through the cards and find the minimum consecutive cards to pick up.
 * 3. We return the minimum consecutive cards to pick up.
 */
class Solution {
    public int minimumCardPickup(int[] cards) {
        // edge 
        if (cards.length <= 1) return -1;

        int[] num_to_i = new int[1000001]; // constant O(1)
        // map -> # key = # of distinc numbers best case - key = 1; [1,1,1,1,1,1,1,1,]
                                            // worse case - key = 10^5 // O(n)
        Arrays.fill(num_to_i, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (num_to_i[cards[i]] > -1) {
                int len = i-num_to_i[cards[i]]+1;
                res = Math.min(res, len);
            }
            num_to_i[cards[i]] = i;
        }
        
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }
    // num_to_i = [-1, 2, 0, 1, -1, -1, -1]
    
    // res = 4
    // [3,4,2,3,4,7]
    //          i
}

// - Read the promlem [Done]
// - learn about constraints [Done]
// - Approaches
// - naive

// res = 4 <-- Answer
// [3,4,2,3,4,7]
//      i j
// i
// j + 1
    
// res = -1 
// [1]
//  i
 
// Time: O(n^2)
// Space: O(1)
// // Akan 
// [3,4,2,3,4,7]
// i  j
// [1]

//  if (len ==1) return -1;
 
// res = Integer.MAX_VALUE;
// res.Matt.min
// [3,4,2,3,4,7]
//  i     j
 
// return -1 ? res == Integer.MAX_VALUE : res

// - optional solution

// // optimal;
// map<value, idx>
// [3,4,2,3,4,3,7]
//        i   i
  
//  map.add(3,idx->3);
//  res = min(res, i-map.get(nums[i])+1)
// time -> n, 
// space -> n



// //edge nums.len -> 2^31-1 
// // i = -2^31-2.  j = -2^31-4
 
// // TDD

// 4 assert minimumCardPickup([3,4,2,3,4,7])

// // Code solution - the best possible approach

// // Validate - edge cases
// // []; -> -1;
// //[1] -> -1;