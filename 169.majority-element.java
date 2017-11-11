class Solution {
    public int majorityElement(int[] nums) {

        int candidate = nums[0], count = 1;

        if(nums.length == 1) {
            return candidate;
        }
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if(count == 0) {
                candidate = nums[i];
            }
        }

        return candidate;
    }
}

