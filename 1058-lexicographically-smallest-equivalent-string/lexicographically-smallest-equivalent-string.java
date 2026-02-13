class Solution {
    int par[];
    public int findPar(int u) {
        if(par[u] == u) {
            return u;
        }
        return par[u]=findPar(par[u]);
    }
    public void merge(int p1,int p2) {
        if(p1<p2) {
            par[p2]=p1;
        }
        else {
           par[p1]=p2;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        par=new int[26];
        for(int i=0;i<26;i++) {
            par[i]=i;
        }
        int n=s1.length();
        for(int i=0;i<n;i++) {
             int u=s1.charAt(i)-'a';
             int v=s2.charAt(i)-'a';
             int p1=findPar(u);
             int p2=findPar(v);
             if(p1!=p2) {
                merge(p1,p2);
             }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<baseStr.length();i++) {
            int val=baseStr.charAt(i)-'a';
            char parentChar=(char)(findPar(val)+'a');
            sb.append(parentChar);
        }
        return sb.toString();
    }
}