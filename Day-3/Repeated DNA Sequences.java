class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
      HashSet x= new HashSet(), r= new HashSet();

      for(int i=0; i+9< s.length();i++){
        String t= s.substring(i, i+10);
        if(!x.add(t)){
            r.add(t);
        }
      }

      return new ArrayList(r);

    }
}