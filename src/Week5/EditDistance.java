package Week5;
import java.util.*;

class EditDistance {
    private static int min(int x,int y,int z)
    {
        if (x < y && x <z) return x;
        if (y < x && y < z) return y;
        else return z;
    }

    private static int editDistDP(String str1, String str2, int m, int n)
    {
        int dp[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = min(dp[i-1][j-1], dp[i-1][j] +1, dp[i][j-1]+1);
                else
                    dp[i][j] = 1 + min(dp[i][j-1],  // Insert
                            dp[i-1][j],  // Remove
                            dp[i-1][j-1]); // Replace
            }
        }
        return dp[m][n];
    }

//    private static int max(int a, int b) {
//        return (a>b)?a:b;
//    }
//    private static Character[] lcs(String a, String b) {
//        int m=a.length(), n=b.length();
//        int[][] l = new int[m+1][n+1];
//        for(int i=0;i<=m;i++) {
//            for(int j=0;j<=n;j++) {
//                if(i==0 || j==0) l[i][j] = 0;
//                else {
//                    if(a.charAt(i-1)==b.charAt(j-1)) l[i][j] = l[i-1][j-1] +1;
//                    else l[i][j] = max(l[i-1][j], l[i][j-1]);
//                }
//            }
//        }
//        int index = l[m][n];
//        Character[] lcs = new Character[index];
//        int i=m, j=n;
//        while(i>0 && j>0) {
//            if(a.charAt(i-1)==b.charAt(j-1)) {
//                lcs[index - 1] = a.charAt(i - 1);
//                i--;
//                j--;
//                index--;
//            }
//            else {
//                if(l[i-1][j]>l[i][j-1]) i--;
//                else j--;
//            }
//        }
//        return lcs;
//    }
//    private static int editDistance(String str1, String str2) {
//        int length1 = str1.length(), length2 = str2.length();
//        int i=0, j=0, l=0, editDistance = 0;
//        Character[] lcs = lcs(str1, str2);
//        while(i<length1 && j<length2 && l<lcs.length) {
//            if(str1.charAt(i) == lcs[l] && str2.charAt(j)!=lcs[l]) {
//                editDistance++;
//                j++;
//            }
//            else if (str1.charAt(i) != lcs[l] && str2.charAt(j)==lcs[l]) {
//                editDistance++;
//                i++;
//            }
//            else if (str1.charAt(i) != lcs[l] && str2.charAt(j)!=lcs[l]){
//                editDistance++;
//                i++;
//                j++;
//            }
//            else {
//                l++;
//                i++;
//                j++;
//            }
//        }
//        while(i<length1 || j<length2) {
//            editDistance++;
//            i++;
//            j++;
//        }
//        return editDistance;
//    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        String t = scan.next();
        System.out.println(editDistDP(s, t, s.length(), t.length()));
    }

}



