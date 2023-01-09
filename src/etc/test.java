package etc;

import java.util.*;
import java.io.*;

public class test {

    public static void main(String args[]) throws Exception
    {
        
    }

    static char[][] ops = {{'-', '+', '*'}, {'-', '*', '+'}, {'+', '-', '*'}, {'+', '*', '-'}, {'*', '+', '-'}, {'*', '-', '+'}};
    
    public static long solution(String expression) {
        long answer = 0;
        
        ArrayList<String> exp = new ArrayList<>();
        
        int cur = 0;
        for(int i=0, size = expression.length(); i<size; i++) {
            if(expression.charAt(i) == '+'
               || expression.charAt(i) == '-'
               || expression.charAt(i) == '*') {
                exp.add(expression.substring(cur, i));
                exp.add(expression.substring(i, i+1));
                cur = i + 1;
            }
        }
        
        exp.add(expression.substring(cur));
        
        for(int i=0; i<6; i++) {
            ArrayList<String> sub = new ArrayList<String>(exp);
            
            for(int j=0; j<3; j++) {
                for(int k=0; k<sub.size(); k++) {
                    char op = sub.get(k).charAt(0);
                    
                    if(ops[i][j] == op) {
//                        sub.set(k-1, calc(op, sub.get(k-1), sub.get(k+1)));
                        sub.remove(k);
                        sub.remove(k);
                        k--;
                    }
                }
            }
            
            System.out.println(sub);
        }
        
        return answer;
    }
    
    public static int calc(char op, String num1, String num2) {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        
        if(op == '+')
            return n1 + n2;
        else if(op == '-')
            return n1 - n2;
        else
            return n1 * n2;
    }
}
