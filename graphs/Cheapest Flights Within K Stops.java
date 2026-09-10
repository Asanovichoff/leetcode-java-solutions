/** problem: Cheapest Flights Within K Stops
 * 
 * approach 1: dynamic programming
 * time complexity: O(n * k)
 * space complexity: O(n)
 * 
 * explanation:
 * 1. use a array to store the prices of the flights
 * 2. use a pointer to iterate through the flights
 * 3. return the result
 */

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prices = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.MAX_VALUE;
        }
        prices[src] = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) temp[j] = prices[j];
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (prices[from] == Integer.MAX_VALUE) continue;
                if (prices[from] + price < temp[to]) temp[to] = prices[from] + price;
            }
            for (int j = 0; j < n; j++) prices[j] = temp[j];
        }
        
        if (prices[dst] == Integer.MAX_VALUE) return -1;
        else return prices[dst];
    }
}

// 2 <= n, <=100
// src != dst
//is possible to have more that 2 flights betweet 2 cities? NO