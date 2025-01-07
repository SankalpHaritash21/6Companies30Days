class Solution {
    public int firstUniqChar(String s) {
        // int[] freq = new int[26]; 
        // for (int i = 0; i < s.length(); i++) {
        //     freq[s.charAt(i) - 'a']++;
        // }

        // for (int i = 0; i < s.length(); i++) {
        //     if (freq[s.charAt(i) - 'a'] == 1) {
        //         return i;  // Return the index of the first unique character
        //     }
        // }

        // return -1;

         HashMap<Character, Integer> freq = new HashMap<>();


         for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
         }

         for(int i=0;i<s.length();i++){
            if(freq.get(s.charAt(i))==1)
            return i;
         }

         return -1;
    }
}