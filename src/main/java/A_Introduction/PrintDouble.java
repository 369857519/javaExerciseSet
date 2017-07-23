package A_Introduction;

/**
 * Created by 祁连山 on 2017/7/22.
 */
public class PrintDouble {
    public static void main(String[] args){
        output(1321123.321321);
    }

    static void output(double num){
        if(num<0){
            System.out.print("-");
        }
        //整数部分
        long digit=Math.abs((long)num);

        if(digit<1){
            System.out.print("0");
        }else{
            printDigit(digit,getDecCount(num));
        }

        System.out.print(".");
        //判断小数位
        double decimal=num-(int)num;

        if(decimal>0){
            printDigit(decimal,getDecCount(num));
        }else{
            System.out.print("0");
        }
        System.out.println();
    }

    static int getDecCount(double num){
        String numStr=Double.toString(num);
        return numStr.split("[.]").length>1?numStr.split("[.]")[1].length():0;
    }
    static void printDigit(double num,int round){
        if(num>=1){
            printDigit((long)(num/10),round-1);
            System.out.printf("%d",(long)num%10);
        }else if(num>0&&num<1){
            if(round==0)return;
            long digit=(long)(num*10);
            System.out.print(digit);
            printDigit(num*10-digit,round-1);
        }
    }


}
