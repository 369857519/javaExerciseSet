package B_Analysis;

import java.text.DecimalFormat;

/**
 * Created by qilianshan on 17/8/3.
 */
public class FUNCTIONEqualsToZero {
    public static void main(String[] args){
        FUNCTIONEqualsToZero f=new FUNCTIONEqualsToZero();
        System.out.println(f.findZero(-500, 500));
    }
    public double findZero(double x,double y){
        double mid=(y-x)/2+x;
        double fmid=this.customFunction(mid);
        double fx=this.customFunction(x);
        double fy=this.customFunction(y);
        double result=0;
        DecimalFormat df = new DecimalFormat("#.000");
//        System.out.println(df.format(x));
//        System.out.println(df.format(y));
//        System.out.println(df.format(x).equals(df.format(y)));
//        if(df.format(x).equals(df.format(y))){
        if(Math.floor(x*10000)==Math.floor(y*10000)){
            return x;
        }
        if(fx<0&&fy>0){
            if(fmid>0){
                result=this.findZero(x,mid);
            }else if(fmid<0){
                result=this.findZero(mid,y);
            }
        }else if(fx>0&&fy<0){
            if(fmid>0){
                result=this.findZero(mid,y);
            }else if(fmid<0){
                result=this.findZero(x,mid);
            }
        }
        return result;
    }
    public double customFunction(double x){
        return x*3+1;
    }
}
