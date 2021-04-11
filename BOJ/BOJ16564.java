import java.io.*;

public class BOJ16564 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] cnt = br.readLine().split(" ");

        int N=Integer.parseInt(cnt[0]);
        int[] level = new int[N];

        int K=Integer.parseInt(cnt[1]);

        for(int i=0;i<N;i++)
        {
            level[i] = Integer.parseInt(br.readLine());
        }

        wr.write(Integer.toString(Solution(K,level)));

        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(int K, int[] level)
    {
        int answer=1;
        int low = 1;
        int high = 100000000;
        //이진 탐색
        while(low<=high)
        {
            int mid= (high+low)/2;
            long sum = 0;
            //중간레벨에 맞춰서 레벨업 횟수 추가
            for(int i=0;i<level.length;i++)
            {
                if(mid-level[i]>0)
                {
                    sum += mid-level[i];
                }
            }
            //주어진 횟수보다 높을경우 왼쪽반(?)으로 재계산
            if(sum>K)
            {
                high = mid-1;
            }
            //오른쪽반(?)으로 재계산
            else
            {
                answer = Math.max(answer, mid);
                low = mid+1;
            }
        }


        return answer;
    }
}
