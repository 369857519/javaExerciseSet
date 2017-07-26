package A_Introduction;

import java.util.Stack;

/**
 * Created by qilianshan on 17/7/25.
 */
public class Permute {
    public static void main(String[] args){
        permute("abcd");
    }
    public static void permute(String str){
        stack.clear();
        char[] strToChar=str.toCharArray();
        permuteRecursive(strToChar);
    }

    public static Stack<Character> stack=new Stack<Character>();

    private static void permuteRecursive(char[] str){
        if(stack.size()==str.length){
            String st="";
            for(Character ch:stack){
                st+=ch.toString();
            }
            System.out.println(st);
            stack.toArray();
            return;
        }
        for(char i:str){
            if(!stack.contains(i)){
                stack.push(i);
                permuteRecursive(str);
                stack.pop();
            }
        }
    }
}
