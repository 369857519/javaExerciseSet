package B_Analysis;

/**
 * Created by qilianshan on 17/8/3.
 */
public class Prime {
    public static void main(String[] args){
        System.out.print(getBinary(10));
        long start;
        long end;
        start=System.nanoTime();
        isPrime(1000000);
        end=System.nanoTime();
        System.out.println(end-start);

        System.out.print(getBinary(1000000000));

        start=System.nanoTime();
        isPrime(1000000000);
        end=System.nanoTime();
        System.out.println(end-start);

    }
    public static boolean isPrime(int num){
        int n=(int)Math.sqrt(num)+1;
        for(int i=1;i<n;i++){
            if(num%n!=num){
                return false;
            }
        }
        return true;
    }
    public static int getBinary(int num){
        int n=num;
        StringBuilder sb=new StringBuilder();
        while(num!=0){
            sb.append(num%2);
            num=(int)Math.floor(num/2);
        }
        sb.reverse();
        System.out.println(sb.toString().length());

        return sb.length();
    }

}