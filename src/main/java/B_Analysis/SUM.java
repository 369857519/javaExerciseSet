package B_Analysis;

import java.util.Stack;

/**
 * Created by 祁连山 on 2017/8/2.
 */
public class SUM {
    public static void main(String[] args){
        int[] arr={1,-3,2,3,-5,-6,-7,4,0,5,6,11};
        System.out.print(getMostSmall(arr));
    }
    public static int getMostSmall(int[] arr){
        int small=0,currentSum=0;
        Stack<Integer> stk=new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum+arr[i];
            if(currentSum<small){
                small=currentSum;
                stk.push(arr[i]);
            }else if(currentSum>0){
                System.out.print(stk);
                stk.clear();
                currentSum=0;
            }
        }
        return small;
    }
    public static int getMostSmallPositive(int[] arr){
        int small=0,currentSum=0;
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum+arr[i];
            if(currentSum<small&&currentSum>0){
                small=currentSum;
            }else if(currentSum>0){
                currentSum=0;
            }
        }
        return small;
    }

    public static int getMostSmallProdPositive(int[] arr){
        int small=0,currentSum=0;
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum*arr[i];
            if(currentSum<small){
                small=currentSum;
            }else if(currentSum<1){
                currentSum=1;
            }
        }
        return small;
    }
}
