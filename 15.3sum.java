
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

                int j = i + 1, k = nums.length - 1;

                while(j < k) {
                    if(nums[j] + nums[k] > target) {
                        k--;
                    } else if(nums[j] + nums[k] < target) {
                        j++;
                    } else {
                        List<Integer> oneEntry = new LinkedList<>();
                        oneEntry.add(nums[i]);
                        oneEntry.add(nums[j]);
                        oneEntry.add(nums[k]);
                        results.add(oneEntry);
                        j++;
                        k--;

                        while(j < k && nums[j] == nums[j - 1]) j++;
                        while(j < k && k <= nums.length - 1 && nums[k] == nums[k + 1]) j++;
                    }
                }
            }
        }

        return results;
    }

}
