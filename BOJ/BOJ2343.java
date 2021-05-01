import java.io.*;
import java.util.*;

public class BOJ2343 {
    //기타 레슨
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] input = new int[N];

        int low=0;
        int high=0;

        for (int i = 0; i < N; i++)
        {
            input[i] = sc.nextInt();
            low = Math.max(low,input[i]);
            high += input[i];
        }

        while(low<=high)
        {
            int mid = (low+high)/2;
            int sum=0;
            int cnt = 0;
            for(int i=0;i<input.length;i++)
            {
                if(sum+input[i]>mid)
                {
                    cnt++;
                    sum=0;
                }
                
                sum += input[i];

                if(i+1 == input.length)
                {
                    cnt++;
                }
            }

            if(cnt>M)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }

        System.out.println(low);
        sc.close();
    }
}
 /* 테스트케이스
7 6
100 400 300 100 500 101 400
답: 500

4 2
1 1 1 1
답: 2

7 7
5 9 6 8 7 7 5
답: 9

8 7
3 3 10 10 3 2 6 2
답: 10

7 7
1 5 9 9 9 2 9
답: 9

50 14
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
답: 105

50 1
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
답: 1275

50 3
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
답: 435

50 50
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50
답: 50
*/