
// find the number of important reverse pairs with the first element of the pair coming from the left subarray nums[0, m] while the second element of the pair coming from the right subarray nums[m + 1, n - 1]

public class Solution {
    public int res;
    public int[] temp;  // for merge

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

        // count and merge
        // count elements: we want nums[left] > 2 * nums[right]
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

        // merge sort
        // Arrays.sort(nums, start, end + 1);

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

        // copy temp back to nums
        for (index = start; index <= end; index++) {
            nums[index] = temp[index];
        }
    }
}

// merge sort algorithm
/*
public class Solution {

    int[] temp;
    public void sortIntegers2(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        temp = new int[A.length];
        mergeSort(A, 0, A.length - 1);
    }

    private void mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(A, start, mid);
        mergeSort(A, mid + 1, end);

        merge(A, start, mid, end);
    }

    private void merge(int[] A, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int index = start;

        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }

        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }
}*/
