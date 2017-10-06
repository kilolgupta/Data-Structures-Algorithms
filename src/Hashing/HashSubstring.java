package Hashing;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static int prime = 100000007;
    private static int multiplier = 263;

    private static int polyHash(String s) {
        long hash = 0;
        for (int i = 0; i<s.length();i++)
            hash = (hash + (long)s.charAt(i)*(long)Math.pow((double)multiplier, (double)i)%prime)%prime;
        return (int)hash%prime;
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        for (Integer cur : ans) {
            out.print(cur);
            out.print(" ");
        }
    }

    private static boolean isEqual(String s1, String s2) {
        return s1.equals(s2);
    }


    private static void preComputeHash(String text, int p, long[] preComputedHashes) {
        int t = text.length();
        int arrayLength = t - p + 1;
        preComputedHashes[arrayLength-1] = polyHash(text.substring(t-p, t));
        long y = 1;
        for(int j=0;j<p;j++) {
            y= (y*multiplier) % prime;
        }
        for(int i=t-p-1;i>=0;--i) {
            long a = (multiplier*preComputedHashes[i+1]) % prime;
            long b = text.charAt(i);
            long c = (y*text.charAt(i+p)) % prime;
            preComputedHashes[i] = (a + b -  c + prime) % prime;
        }
    }

    private static List<Integer> getOccurrences(Data input) {
        String pattern = input.pattern, text = input.text;
        int p = pattern.length(), t = text.length();
        long pHash = polyHash(pattern);
        long[] preComputedHashes = new long[t-p+1];
        preComputeHash(text, p, preComputedHashes);
        List<Integer> occurrences = new ArrayList<>();
        for(int i =0; i<=t-p;i++) {
            if(pHash==preComputedHashes[i]) {
                if(isEqual(pattern, text.substring(i, i+p))) occurrences.add(i);
            }
        }
        return occurrences;
    }

    private static class Data {
        String pattern;
        String text;
        private Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}