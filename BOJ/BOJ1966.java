import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

//프린터 큐
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
            //Flag
            boolean tofirst=false;
            boolean toend=false;

            //우선순위가 가장 높은 것부터 체크
            for(int j=9;j>0;j--)
            {
                for(int k=0;k<que.size();k++)
                {
                    printfac val = que.poll();
                    //우선순위가 같고 뽑고자 하는 값일 경우
                    //카운트 증가
                    //결과값에 현재 카운트 추가
                    if(val.pri == j && val.point)
                    {
                        cnt++;
                        res[q]=cnt;
                        toend = true;
                        break;
                    }
                    //우선순위가 같지만 뽑고자 하는 값이 아닐경우 cnt 증가
                    //(우선순위가 같은 값이 여러개 일 경우)
                    else if(val.pri == j)
                    {
                        cnt++;
                        tofirst = true;
                        break;
                    }
                    else
                    {
                        que.add(val);
                    }
                }
                //다시 우선순위 9부터 체크
                if(tofirst)
                {
                    tofirst = false;
                    j=10;
                }
                //for분 종료
                if(toend)
                {
                    toend = false;
                    que.clear();
                    break;
                }
            }
        }

        //출력
        for (int j : res) 
        {
            System.out.println(j);
        }
    }
}
