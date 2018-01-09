package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qilianshan on 18/1/3.
 */
public class countThePath {
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        list.add("100");
        list.add("100");
        list.add("001");
        System.out.print(count_the_paths(list));
    }
    public static int count_the_paths(List<String> grid) {
        int N=grid.size();
        int n=1;
        // Write your solution here
        int[][] fn=new int[512][512];
        int a=N-1;int b=0;
        //memorize初始值
        fn[a][b]=1;
        while(a>=0&&b<=N-1){
            if(a==N-n&&b==n-1){
                fn[a][b]=getSum(grid,fn,a,b,N);
                n++;
                //回到横着的初始位置
                a=N-n;
                b=0;
            }else if(a==N-n&&b<=n-2){
                //从左向右
                fn[a][b]=getSum(grid,fn,a,b,N);
                //先获取左边的不烦

                b++;
                //如果循环到了最左边，开始从下向上循环
                if(b==n-1){
                    b=n-1;a=N-1;
                    continue;
                }

            }else if(a>=N-n&&b==n-1){
                //从下向上
                fn[a][b]=getSum(grid,fn,a,b,N);
                a--;
                //如果走到了最顶，则进行下一轮
                if(a==N-n){
                    a=N-n;b=n-1;
                    continue;
                }
            }
        }
        return fn[0][N-1];
    }
    public static int getSum(List<String> grid,int[][] fn,int a,int b,int n){
        if(a==n-1&&b==0){
            return 1;
        }
        int leftValue=0;
        int bottomValue=0;
        //leftValue
        if(b-1>=0&&b-1<=n-1){
            if(Character.getNumericValue(grid.get(a).charAt(b-1))==0){
                leftValue=fn[a][b-1];
            }
        }
        //bottom value
        if(a+1>=0&&a+1<=n-1){
            if(Character.getNumericValue(grid.get(a+1).charAt(b))==0){
                bottomValue=fn[a+1][b];
            }
        }
        //如果这个节点左边有值而且
        System.out.print("jump[" + a + "][" + b + "]" + grid.get(a).charAt(b));
        System.out.println("    result:"+leftValue+bottomValue+"   "+(leftValue+bottomValue));

        return leftValue+bottomValue;
    }
}
