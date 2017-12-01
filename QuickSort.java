
public class QuickSort {

    public static void quickSort(int [] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int [] nums, int lo, int hi) {

        if(lo >= hi) {
            return;
        }

        int pivot = nums[hi];

        int i = lo, j = hi;

        while(i <= j) {
            while(nums[i] < pivot) i++;
            while(nums[j] > pivot) j--;

            if(i <= j) {
                swap(nums, i, j);
                j--;
                i++;
            }
        }

        if(lo < j) {
            quickSort(nums, lo, j);
        }

        if(i < hi) {
            quickSort(nums, i, hi);
        }

    }

    private static void swap(int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String [] args) {

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};

        quickSort(inputArr);

        for(int i:inputArr) {
            System.out.print(i);
            System.out.print(" ");

        }
        System.out.println();

    }
}
