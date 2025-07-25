class LFUCache {
    class Pair {
        int freq;
        int val;

        Pair(int freq, int val) {
            this.freq = freq;
            this.val = val;
        }
    }

    HashMap<Integer, Pair> lfu = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
    int cap;
    int minf;

    public LFUCache(int capacity) {
        cap = capacity;
        minf = 0;
    }

    public int get(int key) {
        if (!lfu.containsKey(key)) return -1;

        Pair p = lfu.get(key);
        LinkedHashSet<Integer> keys = freqMap.get(p.freq);
        keys.remove(key);

        if (keys.isEmpty()) {
            freqMap.remove(p.freq);
            if (minf == p.freq) {
                minf++;
            }
        }

        insert(key, p.val, p.freq + 1);
        return p.val;
    }

    public void put(int key, int value) {
        if (cap <= 0) return;

        if (lfu.containsKey(key)) {
            lfu.get(key).val = value;
            get(key); 
            return;
        }

        if (lfu.size() == cap) {
            LinkedHashSet<Integer> keys = freqMap.get(minf);
            int keyToRemove = keys.iterator().next();
            keys.remove(keyToRemove);
            if (keys.isEmpty()) {
                freqMap.remove(minf);
            }
            lfu.remove(keyToRemove);
        }

        minf = 1;
        insert(key, value, 1);
    }

    private void insert(int key, int value, int freq) {
        lfu.put(key, new Pair(freq, value));
        freqMap.putIfAbsent(freq, new LinkedHashSet<>());
        freqMap.get(freq).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */