class Solution {
    static class Trie{
        class Node{
            int val;
            Node zero;
            Node one;
        }
        private Node root;
        public Trie(){
            root = new Node();
        }
        public  void add(int val){
            Node curr = root;
            for(int i=31 ; i>=0 ; i--){
                int bit = (val & (1<<i)); // checking if the curr bit is set or not;
                if(bit == 0){
                    if(curr.zero !=null){
                        curr = curr.zero;
                    }else{
                        Node nn = new Node();
                        nn.val = 0;
                        curr.zero = nn;
                        curr = nn;
                    }

                }else{
                    if(curr.one !=null){
                        curr = curr.one;
                    }else{
                        Node nn = new Node();
                        nn.val = 1;
                        curr.one = nn;
                        curr = nn;
                    }

                }

            }
        }
        public int getMaxXOR(int val){
            Node curr = root;
            int ans = 0;
            for(int i=31 ; i>=0 ;i--){
                int bit = (val & (1<<i));
                if(bit == 0){
                    if(curr.one !=null){
                        ans = ans + (1<<i);
                        curr = curr.one;
                    }else{
                        curr = curr.zero;
                    }
                }else{
                    if(curr.zero !=null){
                        ans = ans + (1<<i);
                        curr = curr.zero;
                    }else{
                        curr = curr.one;
                    }

                }

            }
            return ans;
        }
    }
    class Pair{
        int x;
        int m;
        int i;
        public Pair(int x,int m,int i){
            this.x = x;
            this.m = m;
            this.i = i;
        }
    }
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Pair[] p = new Pair[queries.length];
        for(int i=0 ; i<p.length ; i++){
            p[i] = new Pair(queries[i][0] , queries[i][1],i);
        }
        Arrays.sort(p,new Comparator<Pair>(){
            @Override
            public int compare(Pair o1,Pair o2){
                return o1.m-o2.m;
            }
        });
        Arrays.sort(nums);
        int j = 0;// track for arrays index;
        Trie t = new Trie();
        int[] ans = new int[queries.length];
        for(Pair q : p){
            while(j<nums.length && q.m>=nums[j]){
                t.add(nums[j]);
                j++;
            }
            if(j==0){
                ans[q.i] = -1; 
            }else{
                ans[q.i] = t.getMaxXOR(q.x);
            }
        }
        return ans;
    }
}