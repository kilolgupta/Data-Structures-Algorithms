public class RunLengthEncoding {

    private static String rle(String input){
        String rleString = "" + input.charAt(0);
        int count = 0;
        char currentChar = input.charAt(0);
        for(int i=0;i<input.length();i++){
            char prevChar = currentChar;
            currentChar = input.charAt(i);
            if(prevChar==currentChar) count+=1;
            else {
                rleString = rleString + Integer.toString(count);
                rleString = rleString + currentChar;
                count = 1;
            }
        }
        rleString += Integer.toString(count);
        return rleString;
    }

    public static void main(String[] args){
        System.out.println(rle("looll"));
    }
}
