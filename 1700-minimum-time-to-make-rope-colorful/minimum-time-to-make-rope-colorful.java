class Solution {
    public int findMinCost(int neededTime[],int start,int end) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=start;i<=end;i++) {
            max=Math.max(max,neededTime[i]);
            sum += neededTime[i];
        }
        return sum-max;
    }
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        if(n==1) {
            return 0;
        }
        ArrayList<ArrayList<Integer>> intervals=new ArrayList<>();
        int start=-1;
        int end=-1;
        for(int i=1;i<n;i++) {
            char curr=colors.charAt(i);
            char prev=colors.charAt(i-1);
            if(start==-1 && prev==curr) {
                start=i-1;
                end=i;
            }
            else if(start!=-1 && prev==curr) {
                end=i;
            }
            else {
                if(start!=-1 && end!=-1) {
                     ArrayList<Integer> interval=new ArrayList<>();
                     interval.add(start);
                     interval.add(end);
                     intervals.add(interval);
                }
                start=-1;
                end=-1;
            }
        }
        if(start!=-1 && end!=-1) {
             ArrayList<Integer> interval=new ArrayList<>();
                     interval.add(start);
                     interval.add(end);
                     intervals.add(interval);
        }
        int cost=0;
        int size=intervals.size();
        System.out.println(intervals);
        for(int i=0;i<size;i++) {
            int st=intervals.get(i).get(0);
            int en=intervals.get(i).get(1);
            cost += findMinCost(neededTime,st,en);
        }
        return cost;
    }
}