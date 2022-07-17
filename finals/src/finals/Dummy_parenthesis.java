/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finals;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class Dummy_parenthesis {
    public static GooGooLang Instance;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String s = "(1+2)+(5+6)";
        String n = "";

        Stack<String> stack = new Stack<>();
        for(int i=0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                if (!"".equals(n)){
                    stack.push(n);
                    n = "";
                }
                
                stack.push("(");
            } else if (s.charAt(i) == ')'){
                stack.push(n);
                stack.push(")");
                n = "";
            } else {
                n = n.concat(Character.toString(s.charAt(i)));
                if(i==s.length()-1){
                    stack.push(n);
                }
            }
        }   
        String values = Arrays.toString(stack.toArray());
        System.out.println(values);
    }
}
