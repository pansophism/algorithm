
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n - 2; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i];

            int l = i + 1, r = n - 1;

            while(l < r) {
                if(nums[l] + nums[r] == target) {
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while(l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }

                    while(l < r && r < n - 1 && nums[r] == nums[r + 1]) {
                        r--;
                    }
                } else if(nums[l] + nums[r] > target) {
                    r--;
                } else if(nums[l] + nums[r] < target) {
                    l++;
                }
            }
        }

        return results;
    }

}
