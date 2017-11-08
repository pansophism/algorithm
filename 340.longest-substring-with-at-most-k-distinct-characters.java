class Solution {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {

        if(s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        char [] dict = new char[256];
        int count = 0, maxLen = 0;

        char [] arr = s.toCharArray();

        int i = 0, j = 0;

        while(j < arr.length) {
            if(dict[arr[j]] == 0) {
                count++;
            }
            dict[arr[j]]++;
            j++;

            while(count > k && i < arr.length) {
                dict[arr[i]]--;
                if(dict[arr[i]] == 0) {
                    count--;
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i);

        }

        return maxLen;
    }
}
