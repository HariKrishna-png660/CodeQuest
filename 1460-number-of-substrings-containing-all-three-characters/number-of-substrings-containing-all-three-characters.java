class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int si = 0, ei = 0;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (ei < n) {
            char ch = s.charAt(ei);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() == 3) {
                count += (n - ei);  
                char leftChar = s.charAt(si);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                si++;
            }
            ei++;
        }
        return count;
    }
}