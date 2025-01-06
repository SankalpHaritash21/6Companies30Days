class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contacts[], String s)
    {
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        for(int i = 1; i <= s.length(); i++){
            
            String prefix = s.substring(0, i);
            HashSet<String> hs = new HashSet<>();
            
            for(int j = 0; j < n; j++){
                
                int len = contacts[j].length();
                
                if(len < i){
                    continue;
                }else{
                    String prefixContact = contacts[j].substring(0, i);
                    
                    if(prefix.equals(prefixContact)){
                        hs.add(contacts[j]);
                    }
                }
                
            }
            
            ArrayList<String> temp;
            if(hs.size() == 0){
                
                temp = new ArrayList<>();
                temp.add("0");
                
            }else{
                
                temp = new ArrayList<>(hs);
                Collections.sort(temp);
                
            }
            
            ans.add(temp);
        }
        
        return ans;
    }
}