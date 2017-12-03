class Solution {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) {
            return "";
        }

        String minStr = null;
        for(String s : strs) {
            if(minStr == null || s.length() < minStr.length()) {
                minStr = s;
            }
        }

        for(int i = minStr.length() - 1; i > 0; i--) {

            String candidate = minStr.substring(0, i + 1);
            if(fitAll(strs, candidate)) {
                return candidate;
            }

        }

        return "";
    }

    private boolean fitAll(String [] strs, String candidate) {
        for(String s : strs) {
            if(!s.startsWith(candidate)) {
                return false;
            }
        }
        return true;
    }
}
