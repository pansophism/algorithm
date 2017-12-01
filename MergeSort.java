
public class MergeSort {

    public static void mergeSort(int [] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int [] aux = new int[nums.length];

        sort(nums, aux, 0, nums.length - 1);
    }

    public static void sort(int [] nums, int [] aux, int lo, int hi) {

        if(lo < hi) {
            int mid = lo + (hi - lo) / 2;

            sort(nums, aux, lo, mid);
            sort(nums, aux, mid + 1, hi);

            merge(nums, aux, lo, mid, hi);
        }
    }

    public static void merge(int [] nums, int [] aux, int lo, int mid, int hi) {
        for(int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }

        int i = lo, j = mid + 1, k = lo;

        while(i <= mid && j <= hi) {
            if(aux[i] <= aux[j]) {
                nums[k++] = aux[i++];
            } else {
                nums[k++] = aux[j++];
            }
        }

        while(i <= mid) {
            nums[k++] = aux[i++];
        }

        while(j <= hi) {
            nums[k++] = aux[j++];
        }

    }

    public static void main(String [] args) {

        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};

        mergeSort(inputArr);

        for(int i:inputArr) {
            System.out.print(i);
            System.out.print(" ");

        }
        System.out.println();

    }
}
