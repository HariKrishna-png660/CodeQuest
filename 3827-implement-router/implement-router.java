
class Router {
    int limit;
    Queue<int[]> q;
    Set<String> set;
    Map<Integer, List<Integer>> destMap;
    Map<Integer, Integer> processed;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        q = new ArrayDeque<>();
        set = new HashSet<>();
        destMap = new HashMap<>();
        processed = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "," + destination + "," + timestamp;
        if (set.contains(key)) return false;
        if (q.size() == limit) forwardPacket();
        q.offer(new int[]{source, destination, timestamp});
        set.add(key);
        destMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        processed.putIfAbsent(destination, 0);
        return true;
    }

    public int[] forwardPacket() {
        if (q.isEmpty()) return new int[]{};
        int[] p = q.poll();
        String key = p[0] + "," + p[1] + "," + p[2];
        set.remove(key);
        processed.put(p[1], processed.get(p[1]) + 1);
        return p;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        List<Integer> list = destMap.get(destination);
        int startIdx = processed.get(destination);
        int l = lowerBound(list, startTime, startIdx);
        int r = upperBound(list, endTime, startIdx);
        return r - l;
    }

    private int lowerBound(List<Integer> list, int target, int from) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    private int upperBound(List<Integer> list, int target, int from) {
        int l = from, r = list.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (list.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
