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
    public int minCostConnectPoints(int[][] points) {
        int N=points.length;
        int edges[][]=new int[N*(N-1)/2][3];
        int k=0;
        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                int u=i;
                int v=j; 
                int w=Math.abs(points[i][0]-points[j][0])+Math.abs( points[i][1]-points[j][1]);
                edges[k][0]=u;
                edges[k][1]=v;
                edges[k][2]=w;
                k++;
            }
        }
        Arrays.sort(edges,(a,b)->{
            return Integer.compare(a[2],b[2]);
        });
        par=new int[N];
        size=new int[N];
        for(int i=0;i<N;i++) {
            par[i]=i;
            size[i]=1;
        }
        int cost=0;
        for(int edge[]:edges) {
             int u=edge[0];
             int v=edge[1];
             int w=edge[2];
             int p1=findPar(u);
             int p2=findPar(v);
             if(p1!=p2) {
                 merge(p1,p2);
                 cost+=w;
             }
        }
        return cost;
    }
}