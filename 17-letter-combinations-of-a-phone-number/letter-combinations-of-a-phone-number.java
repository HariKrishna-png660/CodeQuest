class Solution {
    // create an array of strings
    static String letters[]={"/",".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            ArrayList<String> baseAns=new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        char firstChar=digits.charAt(0);
        String remString=digits.substring(1);
        List<String> smallAns=letterCombinations(remString);
        List<String> ans=new ArrayList<>();
        String currString=letters[firstChar-'0'];
        for(int i=0;i<currString.length();i++) {
            char letter=currString.charAt(i);
            for(String s:smallAns) {
                ans.add(letter+s);
            } 
        }
        return ans;
    }
}