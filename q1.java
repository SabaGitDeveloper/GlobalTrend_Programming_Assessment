// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class LongestCommonSubsequence {
    public static void main(String[] args) {
        String str1="abcde";
        String str2="ace";
        System.out.println("Longest find common subsequnce:" + findLCS(str1, str2));
    }
    public static String findLCS(String str1, String str2){
        int m=str1.length();
        int n=str2.length();
        int[][] dp= new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int i=m, j=n;
        StringBuilder lcs=new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                lcs.append(str1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j]>dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        return lcs.reverse().toString();
    }
}
