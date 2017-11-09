class Solution {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int [] arr = new int[nums.length];
        arr[0] = 0;
        arr[1] = nums[1];

        for(int i = 2; i < nums.length; i++) {
            arr[i] = Math.max(arr[i - 2] + nums[i], arr[i - 1]);
        }

        return arr[nums.length - 1];
    }
}
