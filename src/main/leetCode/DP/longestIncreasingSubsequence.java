package DP;

/**
 * Created by qilianshan on 17/12/27.
 */
import java.util.ArrayList;
import java.util.List;


class longestIncreasingSubsequence {

    public static void main(String[] args){
        ArrayList<Integer> list=new ArrayList<Integer>(){{
            add(16);add(3);add(5);add(19);add(10);add(14);add(12);add(0);add(15);
//            add(10);add(8);add(6);add(4);add(2);
//            add(3);add(3);add(4);add(1);add(2);add(4);add(5);
        }};

        longest_increasing_subsequence(list);
    }

    public static List<Integer> longest_increasing_subsequence(final List<Integer> sequence) {
        int max=1;
        ArrayList<ArrayList<Integer>> Fn=new ArrayList<ArrayList<Integer>>(1000);
        ArrayList<Integer> item=new ArrayList<Integer>();
        Fn.add(item);
        Fn.add(item);//initialize

        ArrayList<Integer> initialList=new ArrayList<Integer>();
        initialList.add(sequence.get(0));
        Fn.set(1, initialList);
        //开始更新状态

        for(int i=1;i<sequence.size();i++){
            int currentNum=sequence.get(i);
            for(int j=1;j<=max;j++){
                //进行扩容
                if(Fn.size()-1==max){
                    Fn.add(item);
                }
                //如果currentNum小于它，则进行对比
                ArrayList<Integer> currentArr=Fn.get(j);
                if(currentArr.size()==0)continue;
                //遍历后一共有三种情况，第一种是大于某一个列表的最后一个
                //第二种是小于第一个，在中间的，则不进行处理，因为在此状态下，没有作用。前面的状态不依赖于后者，后面的状态缺依赖于前者
                if(currentNum>currentArr.get(currentArr.size() - 1)){
                    ArrayList<Integer> newStateList=new ArrayList<Integer>();
                    newStateList.addAll(currentArr);
                    newStateList.add(currentNum);
                    //看有没有已经存在的状态
                    ArrayList<Integer> formerStateList=Fn.get(newStateList.size());
                    if(formerStateList.size()==0){
                        //如果这个长度的状态为空，则放入新的状态
                        Fn.set(newStateList.size(),newStateList);
                    }else{
                        //不为空，则比较最后一位大小，保留小的
                        if(formerStateList.get(formerStateList.size()-1)>newStateList.get(newStateList.size()-1)){
                            Fn.set(newStateList.size(),newStateList);
                        }
                    }
                    //更新一下size

                    if(max<newStateList.size())max=newStateList.size();
                }else if(currentNum<currentArr.get(0)&&currentArr.size()==1){
                    currentArr.remove(0);
                    currentArr.add(currentNum);
                    if(max<1)max=1;
                }
            }
        }
        return Fn.get(max);
    }
}