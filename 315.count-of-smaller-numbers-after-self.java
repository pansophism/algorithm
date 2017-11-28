class Solution {

    private class Node {
        int val, leftSum = 0, count = 0;
        Node left, right;

        public Node(int v) {
            this.val = v;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer [] count = new Integer[nums.length];

        if(nums == null || nums.length == 0) {
            return Arrays.asList(count);
        }

        Node root = new Node(nums[nums.length - 1]);
        count[count.length - 1] = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            count[i] = insert(root, nums[i]);
        }

        return Arrays.asList(count);

    }

    private int insert(Node node, int num) {
        int sum = 0;

        while(node.val != num) {
            if(node.val > num) {
                if(node.left == null) node.left = new Node(num);
                node.leftSum++;
                node = node.left;
            } else {
                sum += node.leftSum + node.count;
                if(node.right == null) node.right = new Node(num);
                node = node.right;
            }
        }

        node.count++;

        return sum + node.leftSum;
    }
}

