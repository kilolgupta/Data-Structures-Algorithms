import java.util.*;

class EditDistance {
  private static int min(int x,int y,int z)
  {
    if (x < y && x <z) return x;
    if (y < x && y < z) return y;
    else return z;
  }

  private static int editDistance(String str1, String str2)
  {
    int m= str1.length(), n=str2.length();
    int ed[][] = new int[m+1][n+1];
    for (int i=0; i<=m; i++)
    {
      for (int j=0; j<=n; j++)
      {
        if (i==0)
          ed[i][j] = j;
        else if (j==0)
          ed[i][j] = i;
        else if (str1.charAt(i-1) == str2.charAt(j-1))
          ed[i][j] = min(ed[i-1][j-1], ed[i-1][j]+1, ed[i][j-1]+1);
        else
          ed[i][j] = 1 + min(ed[i][j-1], ed[i-1][j], ed[i-1][j-1]);
      }
    }

    return ed[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    String t = scan.next();
    System.out.println(editDistance(s, t));
  }

}