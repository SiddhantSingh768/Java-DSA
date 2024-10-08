//given a rod of length n inches and an array of pieces of length smaller thab n.Determine the max value obtained by cutting the rod and selling the pieces.
import java.util.*;
//similar  to Unbounded Knapsack's algorithm price =value and length =weight ,total rod = W
public class RodCutting {
    public static int rodCut(int length[],int price[],int totRod){
        int n=price.length;
        int dp[][]=new int[n+1][totRod+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<totRod+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
                else if(length[i-1]<=j){
                    //Valid
                    dp[i][j]=Math.max(price[i-1]+dp[i][j-length[i-1]],dp[i-1][j]);
                }
                else{
                    //Invalid
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }
    public static void main(String[] args) {
        int length[]={1,2,3,4,5,6,7,8};
        int price[]={1,5,8,9,10,17,17,20};
        int totRod=8;
        System.out.println(rodCut(length,price,totRod));
    }
}