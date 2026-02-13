class Solution {
    int par[];
    int size[];
    public int findPar(int u) {
        if(par[u]==u) {
            return u;
        }
        return par[u]=findPar(par[u]);
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++) {
            par[i]=i;
            size[i]=1;
        }
        int totalProvinces=n;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i!=j && isConnected[i][j]==1) {
                     int p1=findPar(i);
                     int p2=findPar(j);
                     if(p1!=p2) {
                         if(size[p1]<size[p2]) {
                            par[p1]=p2;
                            size[p2]+= size[p1];
                         }
                         else {
                            par[p2]=p1;
                            size[p1] += size[p2];
                         }
                         totalProvinces--;
                     }
                }
            }
        }
        return totalProvinces;
    }
}