class Solution {
    public static void gp(List<String> list,String current,int open,int close,int max) {
        if(current.length()==2*max) {
            list.add(current);
            return;
        }
        if(open<max) {
            gp(list,current+"(",open+1,close,max);
        }
        if(close<open) {
            gp(list,current+")",open,close+1,max);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        gp(list,"",0,0,n);
        return list;
    }
}