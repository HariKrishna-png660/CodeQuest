class Solution {
    // here i am using dsu with path compression  
    int par[];
    public int findPar(int u) {
        if(par[u]==u) {
            return u;
        }
        return par[u]=findPar(par[u]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int N=edges.length;
         par=new int[N];
         for(int i=0;i<N;i++) {
            par[i]=i;
         }
         for(int i=0;i<N;i++) {
            int u=edges[i][0]-1;
            int v=edges[i][1]-1;
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1==p2) {
                return new int[]{u+1,v+1};
            }
            else {
                par[p2]=p1;
            }
         }
         return new int[]{0,0};
    }
}