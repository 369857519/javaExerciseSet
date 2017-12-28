package List;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by qilianshan on 17/12/25.
 */
public class Jump {
    public static void main(String[] args)
    {
        System.out.println(is_numeric_palindrome(1011));
    }
    public static int jump_over_numbers(List<Integer> list)
    {
        int jump=0;
        for(int i=0;i<list.size();i+=list.get(i))
        {
            if(list.get(i)==0){
                return -1;
            }else{
                jump++;
            }
        }
        return jump;
    }
    public static int digit_sum(long number){
        int i=0;
        for(number=Math.abs(number);number>0;number/=10){
            i+=number%10;
        }
        return i;
    }

    public static boolean is_numeric_palindrome(long number)
    {
        //使用arr来记录位数
        ArrayList<Long> bitArr=new ArrayList<Long>();
        for(;number>0;number/=10){
            bitArr.add(number%10);
        }
        //声明要返回的值
        boolean isPalindrome=true;
        for(int i=0;i<bitArr.size()/2;i++){
            if(bitArr.get(i)!=bitArr.get(bitArr.size()-i-1)){
                isPalindrome=false;
            }
        }
        return isPalindrome;
    }
}
