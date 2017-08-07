package B_Analysis;

import java.util.ArrayList;

/**
 * Created by qilianshan on 17/8/4.
 */
public class Exponential {
    public static void main(String[] args){

//        System.out.println(pow(2, 5));
//        caculate(1000000);
//        caculate(1000);
//        caculate(100);
        int[][] arr=new int[][]{
                {1,3,5,7,9},
                {3,5,7,9,11},
                {5,7,9,11,13},
                {7,9,11,13,15},
                {11,13,17,19,21}
        };
        System.out.println(isExist(arr,13));
    }

    public static int E(int x,int e){
        while (--e!=0){
            x*=x;
        }
        return x;
    }
    //o(n)
    public static int pow(int x,long N){
        int ans,n;
        ans=1;
        n=x;
        while(N!=0){
            if((N&1)==1){
                ans*=n;
            }
            n*=n;
            N=N >> 1;
        }
        return ans;
    };
    public static void caculate(int n){
        System.out.println(150*n*Math.log(n));
        System.out.println(n*n);
    }
    public static boolean isExist(int[][] arr,int num) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i][0]<num){
                //如果在最后一列
                if(i+1==n){
                    for(int j=0;j<n;j++){
                        if(arr[i][i]==num){
                            return true;
                        }
                    }
                }else if(i+1<n&&arr[i+1][0]>n){
                    //如果不是最后一列的话
                    for(int j=0;j<n;j++){
                        if(arr[i][j]==num||arr[i+1][j]==num){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
