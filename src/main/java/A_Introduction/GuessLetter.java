package A_Introduction;
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
        System.out.println(getIndex(letters,word[0]));

    }
    public enum Oriantation {TOP,TOPLEFT,TOPRIGHT,RIGHT,BOTTOMRIGHT,BOTTOM,BOTTOMLEFT,LEFT}
    public static Stack<?> getIndex(char[][] matrix,String word){
        //先进行正向的检查
        char[] letters=word.toCharArray();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==letters[0]){
                    //发现与第一个字母相等，开始向八个方向检查
                    Stack<?> top=anchorCompare(matrix,word,j,i,Oriantation.TOP);
                    if(top!=null)return top;

                    Stack<?> topLeft=anchorCompare(matrix,word,j,i,Oriantation.TOPLEFT);
                    if(topLeft!=null)return topLeft;

                    Stack<?> topRight=anchorCompare(matrix,word,j,i,Oriantation.TOPRIGHT);
                    if(topRight!=null)return topRight;

                    Stack<?> right=anchorCompare(matrix,word,j,i,Oriantation.RIGHT);
                    if(right!=null)return right;

                    Stack<?> bottomRight=anchorCompare(matrix,word,j,i,Oriantation.BOTTOMRIGHT);
                    if(bottomRight!=null)return bottomRight;

                    Stack<?> bottom=anchorCompare(matrix,word,j,i,Oriantation.BOTTOM);
                    if(bottom!=null)return bottom;

                    Stack<?> bottomLeft=anchorCompare(matrix,word,j,i,Oriantation.BOTTOMLEFT);
                    if(bottomLeft!=null)return bottomLeft;

                    Stack<?> left=anchorCompare(matrix,word,j,i,Oriantation.LEFT);
                    if(left!=null)return left;
                }
            }
        }
        return null;
    }
    public static Stack<?> anchorCompare(char[][] matrix,String word,int x,int y,Oriantation direction){
        //向上
        int index=0;
        Stack<Integer[]> stk=new Stack<Integer[]>();
        stk.push(new Integer[]{x,y});
        while(x>=0&&x<=3&&y>=0&&x<=3){
            if(matrix[x][y]==word.charAt(index)){
                stk.push(new Integer[]{x,y});
                if(index==3){
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
