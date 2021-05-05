import java.io.*;
import java.util.*;

public class BOJ7568 {
    //덩치
    static class Man{
        public int rank=1;
        public int weight;
        public int height;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        
        ArrayList<Man> ManList = new ArrayList<>();

        for(int i=0;i<input;i++){
            Man temp = new Man();
            String inpuString = br.readLine();
            temp.weight = Integer.parseInt(inpuString.split(" ")[0]);
            temp.height = Integer.parseInt(inpuString.split(" ")[1]);
            ManList.add(temp);
        }

        for (int rank : Solution(ManList)) {
            wr.write(rank+" ");
        }
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int[] Solution(ArrayList<Man> ManList)
    {
        int[] answer = new int[ManList.size()];

        for (Man Man : ManList) {
            for (Man Man2 : ManList) {
                if(Man.height < Man2.height && Man.weight < Man2.weight){
                    Man.rank++;
                }
            }
        }

        for(int i=0;i<answer.length;i++){
            answer[i] = ManList.get(i).rank;
        }
        return answer;
    }
}
