package C_ADT;

/**
 * Created by qilianshan on 17/8/29.
 */
public class Fibonacci {
    public static void main(String[] args){
        Cal(50);
    }
    //需要2^(n-1)入栈，大概是1*e15，就算1024k的堆栈大小，根本也不够存的。1024000
    public static int Cal(int n){
        if(n<=2){
            return 1;
        }else{
            return Cal(n-1)+Cal(n);
        }
    }
}
