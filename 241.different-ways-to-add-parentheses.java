
class Solution {

    private Map<String, List<Integer>> cache = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {

        if(cache.containsKey(input)) {
            return cache.get(input);
        }

        List<Integer> res = new LinkedList<>();
        for(int i = input.length() - 1; i >= 0; i--) {

            if(input.charAt(i) == '*' || input.charAt(i) == '+' || input.charAt(i) == '-') {

                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(input.substring(i + 1));

                for(int lr : leftRes) {
                    for(int rr : rightRes) {
                        res.add(
                                input.charAt(i) == '+' ? lr + rr :
                                input.charAt(i) == '-' ? lr - rr :
                                lr * rr);
                    }
                }
            }
        }

        if(res.size() == 0) {
            res.add(Integer.parseInt(input));
        }

        cache.put(input, res);

        return res;
    }
}
