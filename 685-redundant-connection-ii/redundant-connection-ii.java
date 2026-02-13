class Solution {
    int par[];
    int size[];
    public int findPar(int u) {
        if(par[u]==u) {
            return u;
        }
        return par[u]=findPar(par[u]);
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        // case 1: two parents but no cycle
        // case 2: cycle but not two parents
        // case 3: two parents and cycle
        int N=edges.length;
        int indegree[]=new int[N+1];
        int cand1[]=null;
        int cand2[]=null;
        for(int edge[]:edges) {
            int u=edge[0];
            int v=edge[1];
            if(indegree[v]==0) {
               indegree[v]=u;
            }
            else {
               cand1=new int[]{indegree[v],v};
               cand2=new int[]{u,v};
               edge[1]=0;
            }
        } 
        par=new int[N+1];
        size=new int[N+1];
        for(int i=1;i<=N;i++) {
            par[i]=i;
            size[i]=1;
        }
        for(int edge[]:edges) {
            if(edge[1]==0) {
                continue;
            }
            int u=edge[0];
            int v=edge[1];
            int p1=findPar(u);
            int p2=findPar(v);
            if(p1==p2) {  // cycle exists
                if(cand1==null) {  // case 2
                    return edge;
                }
                return cand1; // case 3
            }
            else {
                if(size[p1]<size[p2]) {
                    par[p1]=p2;
                    size[p2]+= size[p1];
                }
                else {
                    par[p2]=p1;
                    size[p1]+= size[p2];
                }
            }
        }
        return cand2; // case 1
    }
}