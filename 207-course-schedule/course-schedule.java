class Solution {
    public boolean isPossibleToFinish(int src,ArrayList<Integer> graph[],int vis[]) {
        vis[src]=1;
        for(int nbr:graph[src]) {
            if(vis[nbr]==1) {
                return false;
            }
            else if(vis[nbr]==2) {
                continue;
            }
            else {
                if(isPossibleToFinish(nbr,graph,vis)==false) {
                    return false;
                }
            }
        }
        vis[src]=2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int N=numCourses;
        ArrayList<Integer> graph[]=new ArrayList[N];
        for(int i=0;i<N;i++) {
            graph[i]=new ArrayList<>();
        }
        for(int edge[]:prerequisites) {
            int u=edge[0];
            int v=edge[1];
            graph[u].add(v);
        }
        int vis[]=new int[N];
        for(int i=0;i<N;i++) {
            if(vis[i]==0) {
                if(isPossibleToFinish(i,graph,vis)==false) {
                    return false;
                }
            }
        }
        return true;
    }
}