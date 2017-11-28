class Solution {

    public List<Integer> countSmaller(int[] nums) {

        List<Integer> res = new LinkedList<>();

        for(int i = 0; i < nums.length; i++) {
            int t = 0;

            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[i]) {
                    t++;
                }
            }

            res.add(t);
        }

        return res;
    }
}
