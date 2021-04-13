import java.io.*;
import java.util.*;

public class ChuseokTraffic {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();

        String[] input = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        Solution(input);

        wr.write("");
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(String[] lines)
    {
        int answer=0;
        int[] startTimes = new int[lines.length];
        int[] endTimes = new int[lines.length];
        getTimes(lines,startTimes,endTimes);

        for(int i=0;i<lines.length;i++)
        {//A작업
            int cnt=0;
            for(int j=i;j<lines.length;j++)
            {//B작업
                //B가 시작하는 시간에서 1초를 뺀시간이 A가 끝나는 시간보다 먼저면 같이 처리하는 것으로 본다.
                if(startTimes[j]-1000 < endTimes[i]){
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
    //밀리초로 파싱
    private static void getTimes(String[] lines, int[] startTimes, int[] endTimes) {
		for(int i = 0 ; i < lines.length ; ++i) {
			String[] log = lines[i].split(" ");
			String[] responseTime = log[1].split(":");
			int processingTime = (int)(Double.parseDouble(log[2].substring(0, log[2].length() - 1)) * 1000);
			int startTime = 0;
			int endTime = 0;
			
			endTime += Integer.parseInt(responseTime[0]) * 60 * 60 * 1000;
			endTime += Integer.parseInt(responseTime[1]) * 60 * 1000;
			endTime += (int)(Double.parseDouble(responseTime[2]) * 1000);
			startTime = endTime - processingTime + 1;
			
			startTimes[i] = startTime;
			endTimes[i] = endTime;
		}
	}
}
