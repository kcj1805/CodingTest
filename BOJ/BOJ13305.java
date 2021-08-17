import java.io.*;

public class BOJ13305 {
    //주유소
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] RoadStr = br.readLine().split(" ");
        String[] FuelStr = br.readLine().split(" ");
        br.close();

        long[] Road = new long[N];
        long[] Fuel = new long[N];

        for(int i=0;i<RoadStr.length;i++){
            Road[i] = Long.parseLong(RoadStr[i]);
        }
        for(int i=0;i<FuelStr.length;i++){
            Fuel[i] = Long.parseLong(FuelStr[i]);
        }

        wr.write(String.valueOf(Solution(N, Road, Fuel)));
        wr.flush();
        wr.close();
    }
    public static long Solution(int N, long[] Road, long[] Fuel)
    {
        long answer = 0;
        long min = Fuel[0];
        for(int i=0;i<N;i++){
            if(i==0){
                answer += (Road[i]*Fuel[i]);
            }
            else{
                if(Fuel[i]<min){
                    min = Fuel[i];
                }
                answer += (Road[i]*min);
            }
        }
        return answer;
    }
}
