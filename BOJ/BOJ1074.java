import java.io.*;
import java.util.*;

public class BOJ1074 {
    //Z
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(input.nextToken());
        r = Integer.parseInt(input.nextToken());
        c = Integer.parseInt(input.nextToken());

        wr.write(Integer.toString(Solution(N,r,c)));

        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int N, int r, int c)
    {
        Calc(N,0,0);
        return ans;
    }
    static int ans=0;
    static int r=0;
    static int c=0;
    static boolean stop = false;
    public static void Calc(int N, int i, int j)
    {
        int pow = (int)Math.pow(2,N);
        //2x2 에서 r,c가 존재할 경우
        if(pow==2)
        {
            if(i==r&&j==c)
            {
                stop = true;
                return;
            }
            else if(i==r&&j+1==c)
            {
                ans += 1;
                stop = true;
                return;
            }
            else if(i+1==r&&j==c)
            {
                ans += 2;
                stop = true;
                return;
            }
            else if(i+1==r&&j+1==c)
            {
                ans += 3;
                stop = true;
                return;
            }
        }
        //i,j의 2의 n-1승 넓이의 사각형에 r,c가 존재하는지 확인
        if((i<=r&&r<=(int)Math.pow(2, N)-1+i)&&(j<=c&&c<=(int)Math.pow(2, N)-1+j))
        {
            for(int k=0;k<2;k++)
            {
                for(int l=0;l<2;l++)
                {
                    if(!stop)
                    {
                        Calc(N-1,i+(k*(pow/2)),j+(l*(pow/2)));
                    }
                }
            }
        }
        //존재하지 않을 경우 사각형의 넓이를 더해줌
        else
        {
            ans += (int)Math.pow(2, N)*(int)Math.pow(2, N);
        }
    }
}
