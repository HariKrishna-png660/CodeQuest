class Solution {
    class Pair {
        int vtx;
        int wsf;
        public Pair(int vtx,int wsf) {
            this.vtx=vtx;
            this.wsf=wsf;
        }
    }
    public int[] dijkstra(ArrayList<int[]> graph[],int src,int n) {
        int dis[]=new int[n];
        Arrays.fill(dis,(int)(1e8));
        PriorityQueue<Pair> pq=new PriorityQueue<>((Pair a,Pair b)->{
              return a.wsf-b.wsf;
        });
        dis[src]=0;
        pq.add(new Pair(src,0));
        while(pq.size()>0) {
            Pair top=pq.remove();
            int vtx=top.vtx;
            int wsf=top.wsf;
            if(dis[vtx]<wsf) {
                continue;
            } 
            for(int edge[]:graph[vtx]) {
                int nbr=edge[0];
                int wt=edge[1];
                if(dis[nbr]>wsf+wt) {
                    dis[nbr]=wsf+wt;
                    pq.add(new Pair(nbr,wsf+wt));
                }
            }
        }
        return dis;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<int[]> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int edge[]:times) {
            int u=edge[0]-1;
            int v=edge[1]-1;
            int w=edge[2];
            graph[u].add(new int[]{v,w});
        }
        int dis[]=dijkstra(graph,k-1,n);
        int maxDis=Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            if(dis[i]==(int)(1e8)) {
                return -1;
            }
            maxDis=Math.max(maxDis,dis[i]);
        }
        return maxDis;
    }
}