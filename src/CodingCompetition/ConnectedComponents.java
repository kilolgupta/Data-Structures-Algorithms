package CodingCompetition;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectedComponents {


    public class Pair {
        public final int x;
        public final int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean check(int x, int y, int rows, int columns){
        return (x>=0 && x<=rows-1 && y>=0 && y<=columns-1);
    }

    public int solution(int[][] A) {

        int[] x_dir = {-1, 0, 0, 1};
        int[] y_dir = {0, 1, -1, 0};
        Queue<Pair> myQueue = new LinkedList<Pair>();
        int rows = A.length;
        int columns = A[0].length;

        if(rows==0) return 0;
        boolean[][] visited = new boolean[rows][columns];

        int no_of_connected_components = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++) {
                Pair pair = new Pair(i, j);
                if(visited[i][j]==false){
                    no_of_connected_components++;
                    myQueue.add(pair);
                    visited[i][j]=true;
                    while(!myQueue.isEmpty()){
                        Pair entry = myQueue.remove();
                        int x_index = entry.x;
                        int y_index = entry.y;
                        for(int dir=0;dir<4;dir++){
                                x_index = x_index + x_dir[dir];
                                y_index = y_index + y_dir[dir];
                                if(check(x_index, y_index, rows, columns) && visited[x_index][y_index]==false && A[x_index][y_index]==A[i][j]) {
                                    myQueue.add(new Pair(x_index, y_index));
                                    visited[x_index][y_index]=true;
                                }
                                x_index = x_index-x_dir[dir];
                                y_index = y_index-y_dir[dir];
                        }
                    }
                }
            }
        }


        return no_of_connected_components;
    }
}
