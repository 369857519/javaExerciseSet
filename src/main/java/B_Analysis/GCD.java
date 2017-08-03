package B_Analysis;

/**
 * Created by qilianshan on 17/8/1.
 */
public class GCD {
    public static void main(String[] args){
        System.out.println(gcd(100,50));
    }

    public static int gcd(int a,int b){
        if(a==b)return a;
        //判断奇偶性
        Boolean aEven=a%2==0;
        Boolean bEven=b%2==0;
        if(aEven&&bEven){
            return 2*gcd(a/2,b/2);
        }
        if(aEven&&!bEven){
            return gcd(a/2,b);
        }
        if(!aEven&&bEven){
            return gcd(a,b/2);
        }
        if(!aEven&&!aEven){
            return gcd((a+b)/2,(a-b)/2);
        }
        return 0;
    }
}
