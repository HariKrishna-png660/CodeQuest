class Solution {
    static int par[];
    static int size[];
    public int findPar(int u) {
        if(par[u]==u) {
            return u;
        }
        return par[u]=findPar(par[u]);
    }
    public void merge(int p1,int p2) {
        if(size[p1]<size[p2]) {
            par[p1]=p2;
            size[p2]+=size[p1];
        }
        else {
            par[p2]=p1;
            size[p1]+=size[p2];
        }
    }
    public int minCost(int n, int[][] edges, int k) {
       Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
       int comp=n;
       par=new int[n];
       size=new int[n];
       for(int i=0;i<n;i++) {
          par[i]=i;
          size[i]=1;
       }
       for(int edge[]:edges) {
            int u=edge[0];
            int v=edge[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1!=p2) {
                merge(p1,p2);
                comp--;
            }
            if(comp==k) {
                return edge[2];
            }
       }
       return 0;
    }
}