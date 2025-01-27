class Solution{
    static String printMinNumberForPattern(String S){
        char res[] = new char[S.length()+1];
        int st = 1;
        
        for(int i = 0; i <= S.length(); i++){
            if(i == S.length() || S.charAt(i) == 'I'){
                res[i] =(char) (st+'0');
                st++;
                int t = i-1;
                while(t>=0 && res[t] == (char) 0){
                    res[t] = (char) (st + '0');
                    st++;
                    t--;
                }
            }
        }
        return new String(res);
    }
}
