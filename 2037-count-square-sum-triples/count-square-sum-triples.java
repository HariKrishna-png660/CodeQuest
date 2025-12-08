class Solution {
    public int countTriples(int n) {
        int count=0;
        for(int i=1;i<=n;i++) {
            int asquare=i*i;
            for(int j=1;j<=n;j++) {
                if(j==i) {
                    continue;
                }
                int bsquare=j*j;
                for(int k=1;k<=n;k++) {
                   if(k==i || k==j) {
                      continue;
                   }
                   int csquare=k*k;
                   if(csquare==asquare+bsquare) {
                      count++;
                   }
                }
            }
        }
        return count;
    }
}