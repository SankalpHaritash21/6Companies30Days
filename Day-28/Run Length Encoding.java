class Solution {
    public static String encode(String s) {
        // code here
        StringBuilder encodedString = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            char ch = s.charAt(i);
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                count++;
                i++;
            }
            encodedString.append(ch);
            encodedString.append(count);
        }
        return encodedString.toString();

    }
}