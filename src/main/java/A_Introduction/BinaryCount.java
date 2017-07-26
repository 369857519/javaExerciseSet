package A_Introduction;

/**
 * Created by qilianshan on 17/7/25.
 */
public class BinaryCount {
    public static void main(String[] args){
        System.out.print(getCount(512));
    }
    static int getCount(int num){
        int count=0;
        if(num==1)return 1;
        if(num==0)return 0;
        if(num%2!=0){
            count=getCount(num/2)+1;
        }else{
            count=getCount(num/2);
        }
        return count;
    }
}
