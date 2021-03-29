package array;

public class MaxScoreFromMultiplicationOperation {
    static int[][] calValues = new int[1000][1000];

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));
    }
    public static int maximumScore(int[] nums, int[] multipliers) {
        return maximumScoreHelper(nums, multipliers, 0, 0);
    }

    public static int maximumScoreHelper(int[] nums, int[] multipliers, int i, int left) {
        if (i == multipliers.length) return 0;
        if (calValues[i][left] != 0) return calValues[i][left];

        int right = nums.length-(i-left)-1;

        int leftVal = multipliers[i] * nums[left] + maximumScoreHelper(nums, multipliers, i+1, left+1);
        int rightVal = multipliers[i] * nums[right] + maximumScoreHelper(nums, multipliers, i+1, left);
        calValues[i][left] = Math.max(leftVal,rightVal);
        return calValues[i][left];
    }
}
