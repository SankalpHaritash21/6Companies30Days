class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int arr[], int k) {
         ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> deq = new ArrayDeque<>();
      
        int n = arr.length;
        
        
        int i = 0;
        int j = 0;
        
        while(j<n){
            
            while(j-i+1<=k){
                int element = arr[j++];
                if(deq.isEmpty()){
                   deq.addFirst(element); 
                } 
                else{
                    int firstElement = deq.peekFirst();
                    
                    if(element>firstElement){
                        deq.clear();
                        deq.addFirst(element);
                    }else{
                        
                        while(element>deq.peekLast()){
                            deq.removeLast();
                        }
                        
                        deq.addLast(element);
                    }
                    
                }
            }

            
            list.add(deq.peekFirst());
            
            if(arr[i]==deq.peekFirst()){
                deq.removeFirst();
            }
            i++;
        }
        
        return list;
    }
}