class Solution {
    public boolean checkValidString(String s) {
        int low = 0;   // minimum possible open
        int high = 0;  // maximum possible open
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*'
                low--;      // treat as ')'
                high++;     // treat as '('
            }
            
            if (high < 0) return false;
            if (low < 0) low = 0;
        }
        
        return low == 0;
    }
}
