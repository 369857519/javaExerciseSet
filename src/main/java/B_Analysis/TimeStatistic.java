package B_Analysis;

import java.sql.Time;
import java.util.concurrent.Callable;

/**
 * Created by qilianshan on 17/7/27.
 */
public class TimeStatistic {

    public static void main(String[] args){
        TimeStatistic ts=new TimeStatistic();
        ts.countTime(2000);
    }

    //n
    public void method1(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            sum++;
        }
    }

    //n*n
    public void method2(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum++;
            }
        }
    }


    public void method3(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n*n;j++){
                sum++;
            }
        }
    }

    public void method4(int n){
        int sum=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                sum++;
            }
        }
    }

    public void method5(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i*i;j++){
                for(int k=0;k<j;k++){
                    sum++;
                }
            }
        }
    }

    public void method6(int n){
        int sum=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<i*i;j++){
                if(j%i==0){
                    for(int k=0;k<j;k++){
                        sum++;
                    }
                }
            }
        }
    }


    public void countTime(int n){
        long startTime = System.currentTimeMillis();
        System.out.print("start running");
        this.method1(n);
        long stopTime = System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime=System.currentTimeMillis();
        System.out.print("start running");
        this.method2(n);
        stopTime=System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime=System.currentTimeMillis();
        System.out.print("start running");
        this.method3(n);
        stopTime=System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime=System.currentTimeMillis();
        System.out.print("start running");
        this.method4(n);
        stopTime=System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime=System.currentTimeMillis();
        System.out.print("start running");
        this.method5(n);
        stopTime=System.currentTimeMillis();
        System.out.println(stopTime - startTime);

        startTime=System.currentTimeMillis();
        System.out.print("start running");
        this.method6(n);
        stopTime=System.currentTimeMillis();
        System.out.println(stopTime - startTime);

    }
    
}
