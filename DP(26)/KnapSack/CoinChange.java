//A type of unbounded knapsack problem
import java.util.*;
public class CoinChange {

    public static void main(String[] args) {
        int coins[]={1,2,3};
        int sum=4;//sum of coins
        int n = coins.length;
        //i=coins, j=sum
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<n+1;i++) {
            dp[i][0] = 1;
        }
        for(int j=1;j<sum+1;j++) {
            dp[0][j] = 0;
        }
        for(int i=1;i<n+1;i++) {
            for(int j=1;j<sum+1;j++) {
                if(coins[i-1]<=j) {
                    //valid
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
                }
                //invalid
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }
}