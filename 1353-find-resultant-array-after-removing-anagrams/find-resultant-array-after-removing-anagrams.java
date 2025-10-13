class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        String prev = "";
        for (String w : words) {
            char[] ch = w.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);
            if (!sorted.equals(prev)) res.add(w);
            prev = sorted;
        }
        return res;
    }
}
