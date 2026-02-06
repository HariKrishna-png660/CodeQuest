class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // dis array to track the distances from the src vtx to other vertex
        int dis[]=new int[n+1];
        Arrays.fill(dis,(int)1e8);
        dis[k]=0;
        // create a graph using the edges
        ArrayList<int[]> graph[]=new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int edge[]:times) {
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            graph[u].add(new int[]{v,w});
            // graph[v].add(new int[]{u,w});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((int a[],int b[])-> {
                 return a[1]-b[1];
        });
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()) {
            int top[]=pq.remove();
            int vtx=top[0];
            int wsf=top[1];
            if(dis[vtx]<wsf) {
                continue;
            }
            for(int edge[]:graph[vtx]) {
                int nbr=edge[0];
                int wt=edge[1];
                if(dis[nbr]>wsf+wt) {
                    dis[nbr]=wsf+wt;
                    pq.add(new int[]{nbr,wsf+wt});
                }
            }
        }
        int maxTime=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            if(i==k) {
                continue;
            }
            maxTime=Math.max(maxTime,dis[i]);
        }
        return maxTime==(1e8)?-1:maxTime;
    }
}