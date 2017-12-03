
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        if(nums == null || nums.length < 3) {
            return results;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {

            if(i == 0 || nums[i] != nums[i - 1]) {
                // int target = 0 - nums[i];

                for(int j = i + 1; j < nums.length - 1; j++) {
                    for(int k = j + 1; k < nums.length; k++) {
                        if(nums[i] + nums[j] + nums[k] == 0) {
                            List<Integer> oneEntry = new LinkedList<>();
                            oneEntry.add(nums[i]);
                            oneEntry.add(nums[j]);
                            oneEntry.add(nums[k]);

                            results.add(oneEntry);
                        }
                    }
                }
            }

        }

        return results;
    }
}
