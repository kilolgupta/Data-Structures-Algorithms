package Week5;

public class LCS {
    private static int max(int a, int b) {
        return (a>b)?a:b;
    }
    private static int lcs(String a, String b) {
        int m=a.length(), n=b.length();
        int[][] l = new int[m+1][n+1];
        for(int i=0;i<=m;i++) {
            for(int j=0;j<=n;j++) {
                if(i==0 || j==0) l[i][j] = 0;
                else {
                    if(a.charAt(i-1)==b.charAt(j-1)) l[i][j] = l[i-1][j-1] +1;
                    else l[i][j] = max(l[i-1][j], l[i][j-1]);
                }
            }
        }
        int index = l[m][n];
        Character[] lcs = new Character[index+1];
        lcs[index] = '\0';
        int i=m, j=n;
        while(i>0 && j>0) {
            if(a.charAt(i-1)==b.charAt(j-1)) {
                lcs[index - 1] = a.charAt(i - 1);
                i--;
                j--;
                index--;
            }
            else {
                if(l[i-1][j]>l[i][j-1]) i--;
                else j--;
            }
        }
        i=0;
        while(lcs[i]!='\0') {
            System.out.print(lcs[i++]);
        }
        return l[m][n];
    }
    public static void main(String[] args) {
        String str1 = "rilcolp";
        String str2 = "akbicldoelf";
        System.out.println("\nThe length of longest common subsequence is - " + lcs(str1, str2));
        int i=0, j=0, l=0, editDistance = 0;
    }
}
