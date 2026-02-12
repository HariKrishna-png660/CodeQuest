class Solution {
    // this is the solution with only union by size
    int par[];
    int size[];
    public int findPar(int u) {
        if(par[u]==u) {
            return u;
        }
        return findPar(par[u]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int N=edges.length;
        par=new int[N];
        size=new int[N];
        for(int i=0;i<N;i++) {
            par[i]=i;
            size[i]=1;
        }
        for(int edge[]:edges) {
            int u=edge[0]-1;
            int v=edge[1]-1;
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2) {
                if(size[p1]<size[p2]) {
                    par[p1]=p2;
                    size[p2] += size[p1];
                }
                else {
                    par[p2]=p1;
                    size[p1] += size[p2];
                }
            }
            else {
                return new int[]{u+1,v+1};
            }
        } 
        return new int[]{0,0};
    }
}