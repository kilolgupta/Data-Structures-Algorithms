package CodingCompetition;

import java.util.*;

public class PostfixExpressionStack {
    public int solution(String S) {
        if(S.isEmpty()) return -1;

        String[] splitted = S.split("\\s+");
        Stack<Integer> expression = new Stack<>();
        for(String s : splitted){
            boolean checkIfNumber = true;
            for(int i=0;i<s.length();i++) {
                if(!Character.isDigit(s.charAt(i))) {
                    checkIfNumber = false;
                }
            }
            if(checkIfNumber) {
                expression.add(Integer.parseInt(s));
            }
            else if(s.matches("DUP")){
                if(expression.size()==0) return -1;
                expression.add(expression.peek());
            }
            else if(s.matches("POP")) {
                if(expression.size()==0) return -1;
                expression.pop();
            }
            else if(s.matches("\\+")) {
                if(expression.size()<2) return -1;
                int number1 = expression.pop();
                int number2 = expression.pop();
                long sum = number1+number2;
                if(sum > Integer.MAX_VALUE) return -1;
                expression.push(number1+number2);
            }
            else if(s.matches("\\-")) {
                if(expression.size()<2) return -1;
                int number1 = expression.pop();
                int number2 = expression.pop();
                long difference = number1-number2;
                if(difference< Integer.MIN_VALUE) return -1;
                expression.push(number1-number2);
            }
        }
        return expression.peek();
    }
}
