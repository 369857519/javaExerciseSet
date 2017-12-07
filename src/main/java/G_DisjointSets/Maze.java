package G_DisjointSets;

/**
 * Created by qilianshan on 17/11/21.
 */
public class Maze {
    public static void main(String[] args){
        int[][] a;
    }
    public Maze(int width,int height)
    {
         int[][] matrix=new int[width][height];
         int num=0;
         for(int i=0;i<width;i++){
             for(int j=0;j<width;j++){
                 matrix[i][j]=num++;
             }
         }
    }

    private class wall {
        private road top;
        private road right;
        private road bottom;
        private road left;
        public boolean isOpen;
    }

    private class road{
        public int code;
        public wall top;
        public wall right;
        public wall bottom;
        public wall left;
    }
}