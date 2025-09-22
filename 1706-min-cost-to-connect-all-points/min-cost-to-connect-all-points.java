class Solution {
    class Edge {
        int u;
        int v;
        int w;
        public Edge(int u,int v,int w) {
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
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
           size[p1] +=size[p2];
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int N=points.length;
        par=new int[N];
        size=new int[N];
        // ArrayList<Edge> graph[]=new ArrayList[N];
        for(int i=0;i<N;i++) {
            // graph[i]=new ArrayList<>();
            par[i]=i;
            size[i]=1;
        }
        // create edges 
        ArrayList<Edge> edges=new ArrayList<>();

        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                int u=i;
                int v=j;
                int w=Math.abs(points[u][1]-points[v][1])+Math.abs(points[u][0]-points[v][0]);
                edges.add(new Edge(u,v,w));
            }
        }
        edges.sort((e1,e2)->Integer.compare(e1.w,e2.w));
        int cost=0;
        for(Edge edge:edges) {
            int u=edge.u;
            int v=edge.v;
            int w=edge.w;
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