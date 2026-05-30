/**
 * Problem: Longest Common Suffix Queries
 * Platform: LeetCode
 *
 * Approach (Trie):
 * 1. Use a trie to store the words.
 * 2. Use a loop to iterate through the words and store the words in the trie.
 * 3. Return the longest common suffix of the words.
 */
/**
 * Time Complexity: O(n)

/**
 * Space Complexity: O(n)
 * 
 * Explanation:
 * 1. We use a trie to store the words.
 * 2. We use a loop to iterate through the words and store the words in the trie.
 * 3. We return the longest common suffix of the words.
 */
class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;
    }
    TrieNode root = new TrieNode();
    String[] wordsContainer;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        this.wordsContainer = wordsContainer;
        // Build Trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
    private void insert(String word, int index) {
        TrieNode node = root;
        // update root answer too
        updateBest(node, index);

        // insert reversed word
        for (int i = word.length() - 1; i >= 0; i--) {

            char c = word.charAt(i);
            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];

            updateBest(node, index);
        }
    }

    private void updateBest(TrieNode node, int newIndex) {

        if (node.index == -1) {
            node.index = newIndex;
            return;
        }

        String current = wordsContainer[node.index];
        String next = wordsContainer[newIndex];

        // choose shorter word
        if (next.length() < current.length()) {
            node.index = newIndex;
        }
        // if same length -> smaller index
        else if (next.length() == current.length()
                && newIndex < node.index) {

            node.index = newIndex;
        }
    }

    private int search(String query) {

        TrieNode node = root;

        // walk reversed query
        for (int i = query.length() - 1; i >= 0; i--) {

            char c = query.charAt(i);
            int idx = c - 'a';

            if (node.children[idx] == null) {
                break;
            }

            node = node.children[idx];
        }

        return node.index;
    }
}
