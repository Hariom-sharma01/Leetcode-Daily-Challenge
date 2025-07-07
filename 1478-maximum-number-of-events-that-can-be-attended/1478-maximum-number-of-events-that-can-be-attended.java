class Solution {
    public int maxEvents(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[0]-b[0]==0)return a[1]-b[1];
            return a[0]-b[0];
        });
        int c=1;
        int et=arr[0][0]+1;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(arr[0][0],0);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i][1] < et) {
                for (int j = arr[i][0]; j <= arr[i][1]; j++) {
                    int ind = map.get(j);
                    if (arr[ind][1] >= et) {
                        c++;
                        map.put(et++, ind);
                        map.put(j, i);
                        break;
                    }
                }
            } else {
                c++;
                et = Math.max(et, arr[i][0]);
                map.put(et++, i);
            }
        }
        return c;
    }
}
