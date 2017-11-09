class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int [] a = new int[triangle.size() + 1];

        for(int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                a[j] = Math.min(a[j], a[j + 1]) + triangle.get(i).get(j);
            }
        }
        return a[0];
    }
}
