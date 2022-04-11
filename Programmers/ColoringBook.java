import java.io.*;
import java.util.*;

public class ColoringBook {
    public static void main(String[] args) throws IOException
    {
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 0, 3}, {3, 3, 3, 3}};
        solution(6, 4, picture);
    }
    static boolean[][] visited;
    static int cnt=0;
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;


        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                cnt=0;
                Work(picture[i][j], i, j, picture);
                if(cnt > 0){
                    numberOfArea++;
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea,cnt);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public static void Work(int val, int x, int y, int[][] picture){
        if(x>=picture.length || x<0 || y<0 || y>=picture[0].length || val==0){
            return;
        }
        if(!visited[x][y] && picture[x][y]==val){
            visited[x][y] = true;
            cnt++;

            Work(val, x-1, y, picture);

            Work(val, x+1, y, picture);

            Work(val, x, y+1, picture);

            Work(val, x, y-1, picture);
        }
    }
}
