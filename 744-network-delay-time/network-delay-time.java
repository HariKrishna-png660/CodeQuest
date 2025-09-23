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
    class Pair {
        int par;
        int vtx;
        int wsf;
        public Pair(int par,int vtx,int wsf) {
              this.par=par;
              this.vtx=vtx;
              this.wsf=wsf;
        }
    }
    public int[] dijkstra(ArrayList<Edge> graph[],int n,int src) {
        int dis[]=new int[n];
        Arrays.fill(dis,(int)(1e8));
        dis[src]=0;

        int parent[]=new int[n];
        Arrays.fill(parent,-1);
        PriorityQueue<Pair> pq=new PriorityQueue<>((Pair a,Pair b)-> {
               return a.wsf-b.wsf;
        });
        pq.add(new Pair(-1,src,0));
        while(pq.size()>0) {
            Pair top=pq.remove();
            int par=top.par;
            int vtx=top.vtx;
            int wsf=top.wsf;

            if(dis[vtx]<wsf) {
                continue;
            }
            if(par!=-1) {
                parent[vtx]=par;
            }
            for(Edge e:graph[vtx]) {
                int nbr=e.v;
                int wt=e.w;
                if(dis[nbr]>wsf+wt) {
                    System.out.println(dis[nbr]);
                    dis[nbr]=wsf+wt;
                    pq.add(new Pair(vtx,nbr,wsf+wt));
                }
            }
        }
        return dis;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int time[]:times) {
            int u=time[0]-1;
            int v=time[1]-1;
            int w=time[2];
            graph[u].add(new Edge(u,v,w));
        }
        int dis[]=dijkstra(graph,n,k-1);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(dis[i]==(1e8)) {
                return -1;
            }
            max=Math.max(max,dis[i]);
        }
       return max;
    }
}