import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class BOJ1966 {
    

    public static class printfac
    {
        int pri;
        boolean point=false;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        Queue<printfac> que = new LinkedList<printfac>();
        int[] res = new int[testcase];

        for(int q=0;q<testcase;q++)
        {
            String[] str2 = br.readLine().split(" ");
            String[] printque = br.readLine().split(" ");
            //큐에 push
            for(int i=0;i<printque.length;i++)
            {
                printfac pf = new printfac();
                pf.pri = Integer.parseInt(printque[i]);
                if(i==Integer.parseInt(str2[1]))
                {
                    pf.point = true;
                }
                que.add(pf);
            }

            int cnt=0;
            boolean tofirst=false;
            boolean toend=false;
            for(int j=9;j>0;j--)
            {
                for(int k=0;k<que.size();k++)
                {
                    printfac temp = que.poll();
                    if(temp.pri == j && temp.point)
                    {
                        cnt++;
                        res[q]=cnt;
                        toend = true;
                        break;
                    }
                    else if(temp.pri == j)
                    {
                        cnt++;
                        tofirst = true;
                        break;
                    }
                    else
                    {
                        que.add(temp);
                    }
                }
                if(tofirst)
                {
                    tofirst = false;
                    j=10;
                }
                if(toend)
                {
                    toend = false;
                    que.clear();
                    break;
                }
            }
        }

        for (int j : res) 
        {
            System.out.println(j);
        }
    }
}
