class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> tCount = new HashMap<>();
        for(char c : t.toCharArray()){
            tCount.put(c, tCount.getOrDefault(c, 0)+ 1);
        }
        int required = tCount.size();
        int formed = 0;
        HashMap<Character,Integer>windowCount = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        for(int right =0; right <s.length(); right++){
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            if(tCount.containsKey(c)&& windowCount.get(c).equals(tCount.get(c))){
                formed++;
                
            }
            while(formed == required && left <= right){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if(tCount.containsKey(leftChar) && windowCount.get(leftChar) < tCount.get(leftChar)){
                    formed--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE?"": s.substring(minLeft, minLeft + minLen);

    }
}