
public class BinarySearch {

    public static int binarySearchForFirstTarget(int [] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return nums[lo] == target ? lo : -1;
    }

    public static int binarySearchForLastTarget(int [] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return nums[lo - 1] == target ? lo - 1 : -1;
    }

    public static int binarySearchForFirstGreater(int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        if(nums[lo] > target) {
            return nums[lo];
        }

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;

            }
        }

        return nums[lo - 1] == target ? nums[lo] : -1;
    }

    public static int binarySearchForFirstSmaller(int [] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        if(nums[hi] < target) {
            return nums[hi];
        }

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return nums[hi + 1] == target ? nums[hi] : - 1;
    }

    public static void main(String [] args) {

        int[] inputArr = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 7, 8, 8, 8, 8, 9};

        System.out.println("first target : " + binarySearchForFirstTarget(inputArr, 6));
        System.out.println("last target : " + binarySearchForLastTarget(inputArr, 6));
        System.out.println("first greater : " + binarySearchForFirstGreater(inputArr, 6));
        System.out.println("first greater : " + binarySearchForFirstGreater(inputArr, -6));
        System.out.println("first smaller : " + binarySearchForFirstSmaller(inputArr, 6));
        System.out.println("first smaller : " + binarySearchForFirstSmaller(inputArr, 60));

    }
}
