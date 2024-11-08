package sliding_window;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1,2,3},7558));
    }
    public static int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++) {
            if (nums[i]%2==0) nums[i]=0;
            else nums[i] = 1;
        }

        int result=0 , i=0, sum=0;
        while(i<nums.length-k) {
            int j=i;
            sum=0;
            System.out.println("I: "+i);
            while(j<nums.length) {
                System.out.println(nums[j]);
                sum += nums[j];
                if (sum == k) {
                    result++;
                    System.out.println("sum:"+sum+ " j:"+nums[j]);
                }
                else if (sum > k) break;
                j++;
            }
            i++;
        }
        return result;
    }
}
