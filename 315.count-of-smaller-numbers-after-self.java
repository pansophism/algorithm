class Solution {

    public List<Integer> countSmaller(int[] nums) {

        int [] ans = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            if(i == nums.length - 1) {
                ans[i] = 0;
            } else {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] < nums[i]) {
                        ans[i] = ans[j] + 1;
                        break;
                    }
                }
            }
        }

        List<Integer> converted = new ArrayList<Integer>();

        for(int i : ans) {
            converted.add(i);
        }

        return converted;
    }

}
