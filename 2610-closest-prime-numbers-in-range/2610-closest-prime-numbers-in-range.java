class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] ans=new int[2];
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isPrime(i))ls.add(i);
        }
        if(ls.size()<2)return new int[] { -1, -1 };;
        int d1=ls.get(0);
        int d2=ls.get(1);
        //System.out.println(ls);
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i+1)-ls.get(i)<d2-d1){
                d2=ls.get(i+1);
                d1=ls.get(i);
            }
        }

        return new int[] {d1,d2};
    }
    public static boolean isPrime(int n){
        if(n==1)return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
}