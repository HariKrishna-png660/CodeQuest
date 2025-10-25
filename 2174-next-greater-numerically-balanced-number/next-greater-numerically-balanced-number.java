class Solution {
    public int nextBeautifulNumber(int n) {
        int min=n+1;
        int max=(int)(1e9);
        for(int i=min;i<=max;i++) {
            HashMap<Integer,Integer> map=new HashMap<>();
            int num=i;
           while(num!=0) {
              int rem=num%10;
              map.put(rem,map.getOrDefault(rem,0)+1);
              num=num/10;
           }
           int f=1;
           for(int key:map.keySet()) {
              int val=map.get(key);
              if(val!=key) {
                 f=0;
                 break;
              }
           }
           if(f==1) {
              return i;
           }
        }
        return -1;
    }
}