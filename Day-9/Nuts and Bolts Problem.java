void matchPairs(int n, char nuts[], char bolts[]) {
        Map<Character, Integer> orderMap = ordering();
        int MAX = 9;
        char[] nutsBolts = new char[MAX];
        /*
        char[] sortedNuts= new char[n];
        char[] sortedBolts= new char[n];
        */
        int i=0;
        for(Map.Entry<Character, Integer> entry: orderMap.entrySet()){
            //if(i>=n || i>=MAX)
            if(i>=n)
                break;
            char key = nuts[i];
            int index = orderMap.get(key);
            nutsBolts[index] = key;
            i++;
        }
        int k=0;  //upto 
        for(int j=0; j<MAX; j++){
            if(nutsBolts[j]!='\u0000' && k<n){
                //System.out.print(nutsBolts[j]+" ");
                nuts[k] = nutsBolts[j];
                bolts[k]= nutsBolts[j];
                k++;
            }
        }
        //System.out.print(nutsBolts[n-1];
        /*
        for(int t=0; t<n; t++)
            System.out.print(sortedNuts[t]+" ");
            
        System.out.println();
        for(int u=0; u<n; u++)
            System.out.print(sortedBolts[u]+" ");
        */
    }
    
    Map<Character, Integer> ordering(){
        char[] order = { '!','#','$','%','&','*','?','@','^' };
        
        Map<Character, Integer> orderMap = new LinkedHashMap<>();
        
        for(int i=0; i<order.length; i++)
            orderMap.put(order[i], i);
            
        return orderMap;
    }