

class Solution {
    public int hammingWeight(int n) {
        int numOfBits = 0;
        for (int i = 0; i<32; i++){
            if((n&1)==1) numOfBits++;
            n>>>=1;
        }
        return numOfBits;
    }
}
