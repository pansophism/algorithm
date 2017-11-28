class Solution {

    public List<Integer> countSmaller(int[] nums) {

        int [] ans = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i++) {
            if(i == nums.length - 1) {
                ans[i] = 0;
            } else {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] < nums[i]) {
                        ans[j] = ans[i] + 1;
                        break;
                    }
                }
            }
        }

        return Arrays.asList(ans);
    }

}
