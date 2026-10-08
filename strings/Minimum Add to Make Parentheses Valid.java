class Solution {
    public int minAddToMakeValid(String s) {
        int counter = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                counter++;
                continue;
            }else{
                if (counter == 0) {
                    result++;
                }else {
                    counter--;
                }
            }

        }
        return result + counter;
    }
}
