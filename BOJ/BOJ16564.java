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
        while(low<=high)
        {
            int mid= (high+low)/2;
            long sum = 0;
            for(int i=0;i<level.length;i++)
            {
                if(mid-level[i]>0)
                {
                    sum += mid-level[i];
                }
            }
            if(sum>K)
            {
                high = mid-1;
            }
            else
            {
                answer = Math.max(answer, mid);
                low = mid+1;
            }
        }


        return answer;
    }
}
