class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int count = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                count++;
            }else {
                if (i == s.length()-1) {
                    res++;
                }else {
                    if (s.charAt(i+1) == ')') {
                        i ++;
                    }else {
                        res++;
                    }
                }
                if (count == 0) res++;
                else count--;
            }
            i++;
        }
        res+= count * 2;a
        return res;
    }
}
