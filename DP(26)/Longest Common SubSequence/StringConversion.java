//same as the previous one but this time we will not use replace operation
import java.util.*;
public class StringConversion {
    public static int editDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n+1][m+1];
        //initialization
       for(int i=0;i<n+1;i++){
        for(int j=0;j<m+1;j++){
            if(i==0){
                dp[i][j]=j;
            }
            if(j==0){
                dp[i][j]=i;
            }
        }
       }
        //filling the dp matrix
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){//same character
                    dp[i][j]=dp[i-1][j-1];
                }
                else{//diffrent character
                    int add=dp[i][j-1]+1;
                    int delete=dp[i-1][j]+1;
                    dp[i][j]=Math.min(add,delete);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println("Minimum number of operations required to convert Word1 to Word2 = "+editDistance(word1,word2));
    }
}