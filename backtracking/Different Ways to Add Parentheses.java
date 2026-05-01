/**
 * Problem: Different Ways to Add Parentheses
 * Platform: LeetCode
 *
 * Approach (Backtracking):
 * 1. Use a backtracking approach to compute the different ways to add parentheses to the expression.
 * 2. Use a helper function to compute the different ways to add parentheses to the expression.
 * 3. Use a loop to iterate through the expression and compute the different ways to add parentheses to the expression.
 * 4. Return the result.
 */
/**

/**
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a backtracking approach to compute the different ways to add parentheses to the expression.
 * 2. We use a helper function to compute the different ways to add parentheses to the expression.
 * 3. We use a loop to iterate through the expression and compute the different ways to add parentheses to the expression.
 * 4. We return the result.
 */
class Solution {
    private String expression;
    private Map<String, List<Integer>> memo;

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        this.memo = new HashMap<>();
        return compute(0, expression.length() - 1);
    }

    public List<Integer> compute(int l, int r) {
        String key = l + "," + r;
        // check cache
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            char c = expression.charAt(i);

            if (!Character.isDigit(c)) {
                List<Integer> left = compute(l, i - 1);
                List<Integer> right = compute(i + 1, r);

                for (int n1 : left) {
                    for (int n2 : right) {
                        if (c == '+') {
                            list.add(n1 + n2);
                        } else if (c == '-') {
                            list.add(n1 - n2);
                        } else {
                            list.add(n1 * n2);
                        }
                    }
                }
            }
        }

        // Base case
        if (list.isEmpty()) {
            list.add(Integer.parseInt(expression.substring(l, r + 1)));
        }
        memo.put(key, list);
        return list;
    }
}