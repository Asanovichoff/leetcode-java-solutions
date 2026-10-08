class Solution {
    public String removeOuterParentheses(String s) {
        int idx = 1;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            if (s.charAt(idx) == '(') {
                sb.append(s.charAt(idx));
                count++;
            }else {
                count--;
                if (count == 0) {
                    idx++;
                    count++;
                }else {
                    sb.append(s.charAt(idx));
                }
            }
            idx++;
        }
        return sb.toString();
    }
}
