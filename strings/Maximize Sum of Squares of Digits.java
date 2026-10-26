class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int numOfNines = sum / 9;
        int remaining = sum % 9;
        int temp = numOfNines;
        if (sum % 9 != 0) temp++;
        if (num < temp) return "";
        StringBuilder sb = new StringBuilder();
        while (numOfNines > 0) {
            sb.append('9');
            numOfNines--;
        }
        if (remaining > 0) {
            sb.append(remaining);
        }

        while (sb.length() < num) {
            sb.append('0');
        }
        return sb.toString();
    }    
}