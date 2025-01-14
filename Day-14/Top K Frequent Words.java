class Solution {
    public List<String> topKFrequent(String[] words, int k) {
       HashMap<String, Integer> map = new HashMap<>();
        
        // Count the frequency of each word
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        // Create a list of words sorted by frequency and lexicographical order
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> 
            map.get(a) == map.get(b) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        for(String word: map.keySet()){
             pq.add(word);
        }

         List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }
        
        return result;

    }
}