package A_Introduction;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by qilianshan on 17/7/14.
 */


public class GuessLetter {
    public static void main(String[] args){
        char[][] letters={
                {'t','h','i','s'},
                {'w','a','t','s'},
                {'o','a','h','g'},
                {'f','g','d','t'}
        };

        String[] word={"this","two","fat","that"};
        print(getIndex(letters,word[0]));
        print(getIndex(letters,word[1]));
        print(getIndex(letters,word[2]));
        print(getIndex(letters,word[3]));
    }
    public static void print(Stack<Integer[]> stk){
        if(stk==null||stk.isEmpty()){
            System.out.printf("no such word \n");
            return;
        }
        for(Integer[] arr:stk){
            System.out.printf("[%d %d]",arr[0],arr[1]);
        }
        System.out.printf("\n");
    }
    public enum Oriantation {TOP,TOPLEFT,TOPRIGHT,RIGHT,BOTTOMRIGHT,BOTTOM,BOTTOMLEFT,LEFT}
    public static Stack<Integer[]> getIndex(char[][] matrix,String word){
        //先进行正向的检查
        char[] letters=word.toCharArray();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==letters[0]){
                    //发现与第一个字母相等，开始向八个方向检查
                    Stack<Integer[]> top=anchorCompare(matrix,word,i,j,Oriantation.TOP);
                    if(top!=null)return top;

                    Stack<Integer[]> topLeft=anchorCompare(matrix,word,i,j,Oriantation.TOPLEFT);
                    if(topLeft!=null)return topLeft;

                    Stack<Integer[]> topRight=anchorCompare(matrix,word,i,j,Oriantation.TOPRIGHT);
                    if(topRight!=null)return topRight;

                    Stack<Integer[]> right=anchorCompare(matrix,word,i,j,Oriantation.RIGHT);
                    if(right!=null)return right;

                    Stack<Integer[]> bottomRight=anchorCompare(matrix,word,i,j,Oriantation.BOTTOMRIGHT);
                    if(bottomRight!=null)return bottomRight;

                    Stack<Integer[]> bottom=anchorCompare(matrix,word,i,j,Oriantation.BOTTOM);
                    if(bottom!=null)return bottom;

                    Stack<Integer[]> bottomLeft=anchorCompare(matrix,word,i,j,Oriantation.BOTTOMLEFT);
                    if(bottomLeft!=null)return bottomLeft;

                    Stack<Integer[]> left=anchorCompare(matrix,word,i,j,Oriantation.LEFT);
                    if(left!=null)return left;
                }
            }
        }
        return null;
    }
    public static Stack<Integer[]> anchorCompare(char[][] matrix,String word,int x,int y,Oriantation direction){
        //向上
        int index=0;
        Stack<Integer[]> stk=new Stack<Integer[]>();
        while(x>=0&&x<=3&&y>=0&&x<=3){
            if(matrix[x][y]==word.charAt(index)){
                stk.push(new Integer[]{y,3-x});
                if(index==word.length()-1){
                    return stk;
                }
            }else{
                stk.clear();
                return null;
            }
            switch (direction){
                case TOP:
                    y--;
                    break;
                case TOPLEFT:
                    y--;
                    x--;
                    break;
                case TOPRIGHT:
                    y--;
                    x++;
                    break;
                case RIGHT:
                    x++;
                    break;
                case BOTTOMRIGHT:
                    x++;
                    y++;
                    break;
                case BOTTOM:
                    y++;
                    break;
                case BOTTOMLEFT:
                    y++;
                    x--;
                    break;
                case LEFT:
                    x--;
                    break;
            }
            index++;
        }
        return null;
    }
}
