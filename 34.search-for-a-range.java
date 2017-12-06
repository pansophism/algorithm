
class Solution {

    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        if(nums == null || nums.length < 1) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }

        int start = findFirstGreater(nums, target);
        if(start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        return new int[] {start, findFirstGreater(nums, target + 1) - 1};
    }

    public int findFirstGreater(int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while(lo + 1 < hi) {

            int mid = lo + (hi - lo) / 2;

            if(nums[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if(nums[lo] > target) {
            return lo;
        }

        if(nums[hi] < target) {
            return hi + 1;
        }

        return hi;
    }

    public static void main(String [] args) {
        Solution s = new Solution();

        int [] d = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 9};

        System.out.println("first greater 0 : " + s.findFirstGreater(d, 0));
        System.out.println("first greater 7 : " + s.findFirstGreater(d, 7));
        System.out.println("first greater 8 : " + s.findFirstGreater(d, 8));
        System.out.println("first greater 10 : " + s.findFirstGreater(d, 10));

    }
}
