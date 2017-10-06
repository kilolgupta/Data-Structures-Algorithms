package Strings;
import java.util.*;
import java.io.*;
import java.util.zip.CheckedInputStream;

public class SuffixArray {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class Suffix implements Comparable {
        String suffix;
        int start;

        Suffix(String suffix, int start) {
            this.suffix = suffix;
            this.start = start;
        }

        @Override
        public int compareTo(Object o) {
            Suffix other = (Suffix) o;
            return suffix.compareTo(other.suffix);
        }
    }

    // Build suffix array of the string text and
    // return an int[] result of the same length as the text
    // such that the value result[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        int[] result = new int[text.length()];
        List<Suffix> suffixesAndIndexes = new ArrayList<>();
        for(int i=text.length()-1;i>=0;i--) {
            Suffix suffix = new Suffix(text.substring(i), i);
            suffixesAndIndexes.add(suffix);
        }
        Collections.sort(suffixesAndIndexes);
//
//        List<String> matrix = new ArrayList<>();
//        List<Integer> indexes = new ArrayList<>();
//        for(int i=text.length()-1;i>=0;i--) {
//            matrix.add("" + text.substring(i));
//            indexes.add(i);
//        }
//
//        List<String> sortedMatrix = new ArrayList<>();
//        for(int i=text.length()-1;i>=0;i--) {
//            sortedMatrix.add("" + text.substring(i));
//        }
//        Collections.sort(sortedMatrix);
//
//        int k=0;
//        for(String suffix:sortedMatrix) {
//            for(int i=0;i<matrix.size();i++) {
//                if(suffix.equals(matrix.get(i))) {
//                    result[k++] = indexes.get(i);
//                    break;
//                }
//            }
//        }

//        Collections.sort(indexes, (o1, o2) -> matrix.get(o1).compareTo(matrix.get(o2)));
        for(int i=0;i<suffixesAndIndexes.size();i++) result[i]=suffixesAndIndexes.get(i).start;
        return result;
    }


    static public void main(String[] args) throws IOException {
        new SuffixArray().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] SuffixArray = computeSuffixArray(text);
        print(SuffixArray);
    }
}
