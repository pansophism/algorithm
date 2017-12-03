
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        if(nums == null || nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            if(i == 0 || nums[i] != nums[i - 1]) {
                int target = 0 - nums[i];

                int l = i + 1, r = nums.length - 1;

                while(l < r) {
                    if(nums[l] + nums[r] > target) {
                        r--;
                    } else if(nums[l] + nums[r] < target) {
                        l++;
                    } else {
                        List<Integer> oneEntry = new LinkedList<>();
                        oneEntry.add(nums[i]);
                        oneEntry.add(nums[l]);
                        oneEntry.add(nums[r]);
                        results.add(oneEntry);
                        r++;
                        l--;

                        while(l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while(l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }

        return results;
    }

}
