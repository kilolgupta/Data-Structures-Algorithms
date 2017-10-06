public class Gcd
{
    static int gcd(int n1, int n2) {
        int divisor =1;
        for(int i=2;i<= ((n1 > n2) ? n1 : n2);i++)
        {
            if(n1%i==0 && n2%i==0) divisor=i;
        }
        return divisor;
    }

    static int recGcd(int a, int b) {
        if(b ==0) return a;
        else return recGcd(b, a%b);
    }

    static int recSubGcd(int a, int b) {
        if(a==b) return a;
        else return (a>b) ? recSubGcd(a-b, b) : recSubGcd(a, b-a);
    }
    public static void main(String[] args) {
        Long time1 = System.currentTimeMillis();
        int a = 234;
        int b = 357;
//        int n1 = (a>=b) ? a:b;
//        int n2 = (a>=b) ? b:a;
        System.out.println(recGcd(a,b));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time1);
    }
}
