class ProductOfNumbers {
    private ArrayList<Integer> prefixArr;

    public ProductOfNumbers() {
        prefixArr = new ArrayList<>();
        prefixArr.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefixArr = new ArrayList<>();
            prefixArr.add(1);
            return;
        }

        int lastNum = prefixArr.get(prefixArr.size() - 1);
        prefixArr.add(lastNum * num);
    }

    public int getProduct(int k) {
        int n = prefixArr.size();

        if (k >= n) return 0;

        int lastNum = prefixArr.get(n - 1);
        int kthNum = prefixArr.get(n - 1 - k);

        return lastNum / kthNum;
    }
}
/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */