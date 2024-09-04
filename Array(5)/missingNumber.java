import java.util.Arrays;
public class missingNumber{
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int sum=0;
        int N=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
         sum+=nums[i];   
        }
        int tot = (N*(N+1))/2;
        int res = tot-sum;
        System.out.println(res);
    }
}