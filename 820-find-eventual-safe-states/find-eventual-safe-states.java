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
        for(int i=0;i<N;i++) {
            int vis[]=new int[N];
            if(topo_dfs(graph,vis,i)) {
                safeNodes.add(i);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}