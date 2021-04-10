import java.io.*;
import java.util.*;

public class TriangleSnail {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();
        int input = 4;
        Solution(input);

        wr.write("");
        
        wr.flush();
        wr.close();
        br.close();
    }

    static int[][] snail;
    static int total=0;
    static int val = 0;

    public static int[] Solution(int n)
    {
        snail = new int[n][n];
        total = n*(n+1)/2;

        int[] answer= new int[total];
        int line=0;

        while(total!=val)
        {
            SetDown(n, line);
            SetRight(n, line);
            SetUp(n, line);
            line++;
        }

        //이차원배열 숫자부분만 배열에 추가
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(snail[i][j]!=0)
                {
                    answer[cnt++] = snail[i][j];
                }
            }
        }
        
        return answer;
    }
    //내려가면서 숫자넣기(좌측변)
    public static void SetDown(int n, int line)
    {
        for(int i=line;i<n;i++)
        {
            if(GetLength(n, i) != (snail[i][0]==0 ? 1 : snail[i][0]))
            {
                if(total != val)
                {
                    snail[i][line] = ++val;
                }
            }
        }
    }
    //오른쪽으로 숫자넣기(가로변)
    public static void SetUp(int n, int line)
    {
        for(int i=n-2-line;i>=1;i--)
        {
            if(GetLength(n, i) != (snail[i][0]==0 ? 1 : snail[i][0]))
            {
                if(total != val)
                {
                    snail[i][(n-1)-line]=++val;
                }
            }
        }
    }
    //위로 숫자넣기(우측변)
    public static void SetRight(int n, int line)
    {
        for(int j=line+1;j<n;j++)
        {
            if(GetLength(n, j) != (snail[j][0]==0 ? 1 : snail[j][0]))
            {
                if(total != val)
                {
                    snail[(n-1)-line][j] = ++val;
                }
            }
        }
    }
    //해당 행 숫자 개수 체크
    public static int GetLength(int n, int input)
    {
        int count=0;
        for(int j=0;j<n;j++)
        {
            if(snail[input][j] != 0)
            {
                count++;
            }
        }
        return count;
    }
}
