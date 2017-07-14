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

    }
    public static Stack<?> getIndex(char[][] matrix,String word){
        //先进行正向的检查
        char[] letters=word.toCharArray();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(j==letters[0]){
                    //发现与第一个字母相等，开始向八个方向检查
                    Stack<?> topleft=anchorCompare(matrix,word,j,i,"topLeft");
                    if(topleft!=null)return topleft;

                    Stack<?> top=anchorCompare(matrix,word,j,i,"top");
                    if(top!=null)return top;

                    Stack<?> topRight=anchorCompare(matrix,word,j,i,"topRight");
                    if(topRight!=null)return topRight;

                    Stack<?> right=anchorCompare(matrix,word,j,i,"right");
                    if(right!=null)return right;

                    Stack<?> bottomRight=anchorCompare(matrix,word,j,i,"bottomRight");
                    if(bottomRight!=null)return bottomRight;

                    Stack<?> bottom=anchorCompare(matrix,word,j,i,"bottom");
                    if(bottom!=null)return bottom;

                    Stack<?> bottomLeft=anchorCompare(matrix,word,j,i,"bottomLeft");
                    if(bottomLeft!=null)return bottomLeft;

                    Stack<?> left=anchorCompare(matrix,word,j,i,"left");
                    if(left!=null)return left;
                }
            }
        }
    }
    public static Stack<?> anchorCompare(char[][] matrix,String word,int x,int y,String direction){
        //向上
        int index=1;
        Stack<Integer[]> stk=new Stack<>();
        stk.push(new Integer[]{x,y});
        while(x>=0&&x<=3&&y>=0&&x<=3){
            switch (direction){
                case "topLeft":
                    y--;
                    break;
                case "top":
                    y--;
                    x--;
                    break;
                case "topRight":
                    y--;
                    x++;
                    break;
                case "right":
                    x++;
                    break;
                case "bottomRight":
                    x++;
                    y++;
                    break;
                case "bottom":
                    y++;
                    break;
                case "bottomLeft":
                    y++;
                    x--;
                    break;
                case "left":
                    x--;
                    break;
            }
            index++;
            if(matrix[x][y]==word.charAt(index)){
                stk.push(new Integer[]{x,y});
                if(index==3){
                    return stk;
                }
            }else{
                stk.clear();
                return null;
                break;
            }
        }
    }
}
