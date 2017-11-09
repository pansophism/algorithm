class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        if(s.length() == 0) {
            return true;
        }

        for(String w : wordDict) {
            // System.out.println("string : " + s + " word : " + w);
            if(s.startsWith(w)) {
                return wordBreak(s.substring(w.length()), wordDict);
            }
        }

        return false;

    }
}
