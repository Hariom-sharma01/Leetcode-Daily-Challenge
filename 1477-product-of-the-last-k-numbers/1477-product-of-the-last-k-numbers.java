class ProductOfNumbers {
    public List<Integer> Products;
    public ProductOfNumbers() {
        Products = new ArrayList<>();
        Products.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            Products.clear();
            Products.add(1); 
        } else {
            int lp=Products.get(Products.size()-1);
            Products.add(lp*num); 
        }
    }
    
    public int getProduct(int k) {
        int n= Products.size();
        if (k>=n) {
            return 0;
        }
        return Products.get(n - 1) / Products.get(n - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */