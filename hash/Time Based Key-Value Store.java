/**
 * Problem: Time Based Key-Value Store
 * Platform: LeetCode
 *
 * Approach (Hash Table):
 * 1. Use a hash table to store the key-value pairs.
 * 2. Use a loop to iterate through the hash table and store the key-value pairs.
 * 3. Return the result.
 */
/**
 * Time Complexity: O(1)
 * Space Complexity: O(n)   
 * 
 * Explanation:
 * 1. We use a hash table to store the key-value pairs.
 * 2. We use a loop to iterate through the hash table and store the key-value pairs.
 * 3. We return the result.
 */


class TimeMap {
    private Map<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        ArrayList<Pair> list = map.get(key);

        int l = 0, r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int m = (l + r) / 2;

            if (list.get(m).timestamp <= timestamp) {
                result = list.get(m).value;
                l = m + 1;  // move right
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}
