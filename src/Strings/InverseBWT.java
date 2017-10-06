package Strings;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWT {
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

    int lastColumnIndexOfFirstColumnCharacter(Character c, int occurrence, Character[] lastColumn) {
        int count = 0;
        for(int i=0;i<lastColumn.length;i++) {
            if(lastColumn[i]==c){
                count++;
                if(count==occurrence) return i;
            }
        }
        return -1;
    }

    int findOccurrenceinFirstColumn(Character[] firstColumn, Character c, int index) {
        int count = 0;
        int i =0;
        while(i!=index) {
            if(firstColumn[i]==c) count++;
            i++;
        }
        return count+1;
    }

    private class Suffix implements Comparable {
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


//    String inverseBWT(String bwt) {
//        StringBuilder result = new StringBuilder();
//        List<Suffix> suffixList = new ArrayList<>();
//        for(int i=0;i<bwt.length();i++) {
//            Suffix suffix = new Suffix("" + bwt.charAt(i), i);
//            suffixList.add(suffix);
//        }
//        Collections.sort(suffixList);
//        Integer current = suffixList.get(0).start;
//        Suffix s = new Suffix("", current);
//        for(int i=0;i<bwt.length()-1;i++) {
//            int index=0;
//            for(int j=0;j<suffixList.size();j++) {
//                if(suffixList.get(j).start==current) {
//                    index = j;
//                    break;
//                }
//            }
//            String next = String.valueOf(bwt.charAt(index));
//            result.append(next);
//            current = index;
//            s = new Suffix("", current);
//        }
//        return result.reverse().toString() + "$";
//    }

//    String inverseBWT(String bwt) {
//        StringBuilder result = new StringBuilder();
//        List<String> matrix = new ArrayList<>();
//        List<Integer> indexes = new ArrayList<>();
//        for (int i = 0; i < bwt.length(); i++) {
//            matrix.add("" + bwt.charAt(i));
//            indexes.add(i);
//        }
//        Collections.sort(indexes, (o1, o2) -> matrix.get(o1).compareTo(matrix.get(o2)));
//        Integer current = indexes.get(0);
//        for (int i = 0; i < bwt.length() - 1; i++) {
//            int index = indexes.indexOf(current);
//            String next = String.valueOf(bwt.charAt(index));
//            result.append(next);
//            current = index;
//        }
//
//        return result.reverse().toString() + "$";
//    }

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();
        Character[] lastColumn = new Character[bwt.length()];
        Character[] firstColumn = new Character[bwt.length()];

        for(int i=0;i<bwt.length();i++) firstColumn[i] = bwt.charAt(i);
        Arrays.sort(firstColumn);

        for(int i=0;i<bwt.length();i++) lastColumn[i] = bwt.charAt(i);

        int occurrence=1;
        Character c = firstColumn[0]; // '$' character
        for(int i=0;i<bwt.length();i++) {
            int index = lastColumnIndexOfFirstColumnCharacter(c, occurrence, lastColumn);
            result.insert(0, firstColumn[index]);
            c = firstColumn[index];
            occurrence = findOccurrenceinFirstColumn(firstColumn, c, index);
        }

        return result.reverse().toString();
    }

    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
