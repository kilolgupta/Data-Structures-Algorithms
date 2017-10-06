public class Fibonacci {
    static int fibRec(int n) {
        if(n<=1) return n;
        else return fibRec(n-2) + fibRec(n-1);
    }
    static int pow(int x, int y) {
        if(y==0) return 1;
        else {
            int temp = pow(x, y/2);
            if(x%2==0) return temp*temp;
            else return x*temp*temp;
        }
    }
    public static void main(String[] args) {
        int n=20;
        int fibSeries[] = new int[21];
        fibSeries[0]=0;
        fibSeries[1]=1;
        for(int i=2;i<=n;i++)
            fibSeries[i]=fibSeries[i-1]+fibSeries[i-2];

         System.out.println(fibSeries[20]);
       // System.out.println(pow(5, 3));
    }
}
