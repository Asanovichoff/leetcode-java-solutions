class Solution {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;

        StringBuilder sb = new StringBuilder(s);
        StringBuilder temp = new StringBuilder();

        while (sb.length() > k) {
            int i = 0;

            while (i < sb.length()) {
                int num = 0;
                int count = 0;

                while (i < sb.length() && count < k) {
                    num += sb.charAt(i) - '0';
                    count++;
                    i++;
                }

                temp.append(num);
            }

            sb = new StringBuilder(temp);
            temp.setLength(0);
        }

        return sb.toString();
    }
}