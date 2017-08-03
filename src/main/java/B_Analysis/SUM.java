package B_Analysis;

/**
 * Created by 祁连山 on 2017/8/2.
 */
public class SUM {
    public static void main(String[] args){

    }
    public static int getMostSmall(int[] arr){
        int small=0,currentSum=0;
        for(int i=0;i<arr.length;i++){
            currentSum=currentSum+arr[i];
            if(currentSum<small){
                small=currentSum;
            }else if(currentSum>0){
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
