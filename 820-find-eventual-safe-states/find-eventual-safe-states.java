class Solution {
    public boolean topo_dfs(int graph[][],int vis[],int src) {
        vis[src]=1;
        for(int nbr:graph[src]) {
            if(vis[nbr]==1) {
                return false;
            }
            else if(vis[nbr]==2) {
                continue;
            }
            else {
                if(topo_dfs(graph,vis,nbr)==false) {
                    return false;
                }
            }
        }
        vis[src]=2;
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N=graph.length;
        List<Integer> safeNodes=new ArrayList<>();
        int vis[]=new int[N];
        for(int i=0;i<N;i++) {
             if(vis[i]==0) {
                 topo_dfs(graph,vis,i);
             }
        }
        for(int i=0;i<N;i++) {
            if(vis[i]==2) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}