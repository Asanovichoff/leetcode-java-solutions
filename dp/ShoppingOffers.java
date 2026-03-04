/**
 * Problem: Shopping Offers
 * Platform: LeetCode
 *
 * Approach (Dynamic Programming):
 * 1. Use a dynamic programming approach to calculate the minimum price of the items.
 * 2. Use a loop to iterate through the items and calculate the minimum price of the items.
 * 3. Return the minimum price of the items.
 */
/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
class Solution {
    public Map<List<Integer>, Integer> dp = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return computeMinPrice(price, special, needs);
    }
    public int computeMinPrice(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if(dp.containsKey(needs)) return dp.get(needs);

        int minPrice = computePrice(price,needs);
        for(List<Integer> offer: special){
            List<Integer> updatedNeeds = new ArrayList<>(needs);
            if (!isOverExeed(needs, offer)){
                for (int i = 0; i<needs.size(); i++){
                    updatedNeeds.set(i, needs.get(i)-offer.get(i));
                }
                int offerCost = offer.get(offer.size()-1);
                minPrice = Math.min(minPrice, offerCost+computeMinPrice(price, special, updatedNeeds));
            }
        }
        dp.put(needs, minPrice);
        return minPrice;
    }

    public int computePrice(List<Integer> price,List<Integer> needs){
        int total = 0;
        for (int i = 0; i<price.size();i++){
            total+=price.get(i)*needs.get(i);
        }
        return total;
    }
    public boolean isOverExeed(List<Integer> needs,List<Integer> special){
        for (int i = 0; i<needs.size(); i++){
            if (special.get(i)>needs.get(i)) return true;
        }
        return false;
    }
}