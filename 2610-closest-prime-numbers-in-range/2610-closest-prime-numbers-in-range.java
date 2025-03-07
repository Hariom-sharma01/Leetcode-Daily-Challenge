class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime=new boolean[right+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=isPrime[1]=false;
        for(int i=2;i*i<=right;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=right;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isPrime[i])ls.add(i);
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
}