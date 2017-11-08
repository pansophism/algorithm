class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) {
            return -1;
        }

        char [] arr1 = word1.toCharArray();
        char [] arr2 = word1.toCharArray();

        int [][] space = new int[arr1.length + 1][arr2.length];

        for(int i = 1; i <= arr1.length; i++) {
            for(int j = 1; j <= arr2.length; j++) {
                if(arr1[i - 1] == arr2[j - 1]) {
                    space[i][j] = space[i - 1][j - 1];
                } else {
                    space[i][j] = Math.max(
                            Math.max(space[i - 1][j], space[i][j - 1]),
                            space[i - 1][j - 1]) + 1;
                }
            }
        }

        return space[arr1.length][arr2.length];
    }
}
