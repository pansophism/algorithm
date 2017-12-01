public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }

        long[] aux = new long[n + 1];
        int[] count = new int[1];

        mergeSort(sums, aux, count, 0, n, lower, upper);

        return count[0];
    }

    private void mergeSort(long[] sums, long[] aux, int[] count,
                           int start, int end, int lower, int upper) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(sums, aux, count, start, mid, lower, upper);
        mergeSort(sums, aux, count, mid + 1, end, lower, upper);
        merge(sums, aux, count, start, mid, end, lower, upper);
    }

    private void merge(long[] sums, long[] aux, int[] count,
                       int start, int mid, int end, int lower, int upper) {
        for (int i = start; i <= end; i++) {
            aux[i] = sums[i];
        }
        int i = start, j = mid + 1, k = mid + 1, l = mid + 1, m = start;
        while (i <= mid || j <= end) {
            while (i <= mid &&  k <= end && aux[k] - aux[i] < lower) {
                k++;    // find first element that is  valid for the lower bound
            }
            while (i <= mid &&  l <= end && aux[l] - aux[i] <= upper) {
                l++; // find first element that is larger than the upper bound
            }

            if (i <= mid && (j > end || aux[i] <= aux[j])) {
                count[0] += (l - k); // only add this to count when merge sums[i] to the big array since it is the count of all sums that satisfy the condition when it starts with i
                sums[m++] = aux[i++];
            } else {
                sums[m++] = aux[j++];
            }
        }
    }
}

//version 1: Merge Sort
/*public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        int[] idxes = new int[n + 1], idxesAux = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            idxes[i] = i;
        }
        int[] count = new int[1];
        mergeSort(sums, idxes, idxesAux, count, 0, n, lower, upper);
        return count[0];
    }
    private void mergeSort(long[] sums, int[] idxes, int[] idxesAux, int[] count,
                           int start, int end, int lower, int upper) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(sums, idxes, idxesAux, count, start, mid, lower, upper);
        mergeSort(sums, idxes, idxesAux, count, mid + 1, end, lower, upper);
        merge(sums, idxes, idxesAux, count, start, mid, end, lower, upper);
    }
    private void merge(long[] sums, int[] idxes, int[] idxesAux, int[] count,
                       int start, int mid, int end, int lower, int upper) {
        for (int i = start; i <= end; i++) {
            idxesAux[i] = idxes[i];
        }
        int i = start, j = mid + 1, k = mid + 1, l = mid + 1, m = start;
        while (i <= mid || j <= end) {
            while (i <= mid &&  k <= end && sums[idxesAux[k]] - sums[idxesAux[i]] < lower) {
                k++;    // find first element that is  valid for the lower bound
            }
            while (i <= mid &&  l <= end && sums[idxesAux[l]] - sums[idxesAux[i]] <= upper) {
                l++; // find first element that is larger than the upper bound
            }

            if (i <= mid && (j > end || sums[idxesAux[i]] <= sums[idxesAux[j]])) {
                count[0] += (l - k); // only add this to count when merge sums[i] to the big array since it is the count of all sums that satisfy the condition when it starts with i
                idxes[m++] = idxesAux[i++];
            } else {
                idxes[m++] = idxesAux[j++];
            }
        }
    }
} */

/* Segment tree
public class Solution {
    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;
        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }
    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if(low > high) return null;
        SegmentTreeNode stn = new SegmentTreeNode(valArr[low], valArr[high]);
        if(low == high) return stn;
        int mid = (low + high)/2;
        stn.left = buildSegmentTree(valArr, low, mid);
        stn.right = buildSegmentTree(valArr, mid+1, high);
        return stn;
    }
    private void updateSegmentTree(SegmentTreeNode stn, Long val) {
        if(stn == null) return;
        if(val >= stn.min && val <= stn.max) {
            stn.count++;
            updateSegmentTree(stn.left, val);
            updateSegmentTree(stn.right, val);
        }
    }
    private int getCount(SegmentTreeNode stn, long min, long max) {
        if(stn == null) return 0;
        if(min > stn.max || max < stn.min) return 0;
        if(min <= stn.min && max >= stn.max) return stn.count;
        return getCount(stn.left, min, max) + getCount(stn.right, min, max);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {

        if(nums == null || nums.length == 0) return 0;
        int ans = 0;
        Set<Long> valSet = new HashSet<Long>();
        long sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);

        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length-1);

        for(int i = nums.length-1; i >=0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long)lower+sum, (long)upper+sum);
        }
        return ans;
    }

}*/

/*//binary search tree
public class Solution {
    private class TreeNode {
        long val = 0;
        int count = 1;
        int leftSize = 0;
        int rightSize = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(long v) {
            this.val = v;
            this.count = 1;
            this.leftSize = 0;
            this.rightSize = 0;
        }
    }

    private TreeNode insert(TreeNode root, long val) {
        if(root == null) {
            return new TreeNode(val);
        } else if(root.val == val) {
            root.count++;
        } else if(val < root.val) {
            root.leftSize++;
            root.left = insert(root.left, val);
        } else if(val > root.val) {
            root.rightSize++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    private int countSmaller(TreeNode root, long val) {
        if(root == null) {
            return 0;
        } else if(root.val == val) {
            return root.leftSize;
        } else if(root.val > val) {
            return countSmaller(root.left, val);
        } else {
            return root.leftSize + root.count + countSmaller(root.right, val);
        }
    }

    private int countLarger(TreeNode root, long val) {
        if(root == null) {
            return 0;
        } else if(root.val == val) {
            return root.rightSize;
        } else if(root.val < val) {
            return countLarger(root.right, val);
        } else {
            return countLarger(root.left, val) + root.count + root.rightSize;
        }
    }

    private int rangeSize(TreeNode root, long lower, long upper) {
        int total = root.count + root.leftSize + root.rightSize;
        int smaller = countSmaller(root, lower);    // Exclude everything smaller than lower
        int larger = countLarger(root, upper);      // Exclude everything larger than upper
        return total - smaller - larger;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0) {
            return 0;
        }
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        TreeNode root = new TreeNode(sums[0]);
        int output = 0;
        for(int i = 1; i < sums.length; i++) {
            output += rangeSize(root, sums[i] - upper, sums[i] - lower);
            insert(root, sums[i]);
        }
        return output;
    }
}*/
