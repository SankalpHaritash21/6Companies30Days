static void linkdelete(Node head, int n, int m) {
        
        Node curr = head;
        Node prev = curr;
        
        for(int i=0; curr!=null; i++){
            if(i!=0&&i%m==0){
                int j=n;
                while(j>0&&prev!=null&&curr!=null){
                    prev.next = curr.next;
                    curr = curr.next;
                    j--;
                }
            }
            prev = curr;
            if(curr!=null)
                curr = curr.next;
           
        }
       
        
        head = prev;
    }