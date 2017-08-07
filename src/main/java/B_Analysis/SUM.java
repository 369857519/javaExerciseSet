package B_Analysis;

import java.util.Stack;

/**
 * Created by 祁连山 on 2017/8/2.
 */
public class SUM {
    public static void main(String[] args){
        int[] arr={1,-3,2,3,-5,-6,-7,4,0,5,6,11};
//        System.out.print(getMostSmall(arr));
        System.out.println(binarySearchOnlyWithLessThan(new Integer[]{1,2,3,4,5,7,10,33,40},11));
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

    public static <T extends Comparable<? super T>> int binarySearch(T[] a,T x){
        int low=0,high=a.length-1;
        //不能，如果x处于两个数中间，那么a[mid]永远小于x，这个时候回到值low一直死循环在mid中
        while(low<=high){
            int mid=(low+high)/2;

            if(a[mid].compareTo(x)<0){
                low=mid+1;
            }else if(a[mid].compareTo(x)>0){
                high=mid-1;
            }else{
                return mid;
            }
        }
        return  1;
    }
    //只有二路查找的二分查找法
    public static <T extends Comparable<? super T>> int binarySearchOnlyWithLessThan(T[] a,T x){
        int low=0,high=a.length-1;
        //不能，如果x处于两个数中间，那么a[mid]永远小于x，这个时候回到值low一直死循环在mid中
        while(low<high){
            int mid=(low+high)/2;

            if(a[mid].compareTo(x)<0){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        if(a[low]==x){
            return low;
        }
        return 0;
    }
    //改了之后不能正常运行
    private static int maxSumRec(int[] a,int left,int right){
        if(left==right)
            if(a[left]>0)
                return a[left];
            else
                return 0;

        int center=(left+right)/2;
        int maxLeftSum=maxSumRec(a,left,center);
        int maxRightSum=maxSumRec(a,center+1,right);

        int maxLeftBorderSum=0,leftBorderSum=0;
        for(int i=center;i>=left;i--){
            leftBorderSum+=a[i];
            if(leftBorderSum>maxLeftBorderSum){
                maxLeftBorderSum=leftBorderSum;
            }
        }

        int maxRightBorderSum=0,rightBorderSum=0;
        for(int i=center+1;i<=right;i++){
            rightBorderSum+=a[i];
            if(rightBorderSum>maxRightBorderSum)
                maxRightBorderSum=rightBorderSum;
        }

        return Math.max(maxLeftSum,Math.max(maxRightSum,maxLeftBorderSum+maxRightBorderSum));
    }
}
