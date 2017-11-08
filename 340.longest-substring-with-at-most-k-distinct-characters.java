class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(s == null || s.length == 0) {
            return 0;
        }

        char [] dict = new char[256];
        int count = 0, maxLen = 0;

        char [] arr = s.toCharArray();

        int i = 0, j = 0;

        while(j < arr.length) {
            if(count == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }

            while(count >= k) {
                dict[arr[i]]--;
                if(dict[arr[i]] == 0) {
                    count--;
                }
                i++;
            }

            if(dict[arr[j]] == 0) {
                count++;
            }
            dict[arr[j]]++;
            j++;
        }

        return maxLen;
    }
}
