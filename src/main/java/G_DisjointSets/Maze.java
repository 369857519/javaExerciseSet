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