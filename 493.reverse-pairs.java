
public class Solution {

    private int res;
    private int[] temp;  // for merge

    public int reversePairs(int[] nums) {
        res = 0;
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return res;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        int count = 0;
        int left = start, right = mid + 1;
        while (left <= mid) {
            if (right > end || (long)nums[left] <= 2 * (long)nums[right]) {
                left++;
                res += count;
            } else {
                right++;
                count++;
            }
        }

        left = start; right = mid + 1;
        int index = start;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        while (right <= end) {
            temp[index++] = nums[right++];
        }

        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}
