
class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();

        dfs(result, s, 0, dict, "");

        return result;
    }

    private void dfs(List<String> result, String s, int index, Set<String> dict, String previous) {
        if(index == s.length()) {
            result.add(previous);
            return;
        }

        for(int j = index + 1; j <= s.length(); j++) {
            String t = s.substring(index, j);
            if(dict.contains(t)) {
                dfs(result, s, j, dict, previous + (previous.length() == 0 ? "" : " ") + t);
            }
        }

    }
}
