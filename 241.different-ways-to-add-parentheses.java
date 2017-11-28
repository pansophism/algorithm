
class Solution {

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<>();

        if(intput == null || input.length == 0) {
            return res;
        }

        int v = (input.charAt(0) - '0');
        int c = input.charAt(1);

        List<Integer> next = diffWaysToCompute(input.substring(1));

        for(int i : next) {
            switch(c) {
                '+' :
                    res.add(c + i);
                    break;
                '-' :
                    res.add(c - i);
                    break;
                '*' :
                    res.add(c * i);
                    break;
                '/' :
                    res.add(c / i);
                    break;
                default:
                    throw new RuntimeError("this should not happen");
            }
        }

        return res;

    }
}
