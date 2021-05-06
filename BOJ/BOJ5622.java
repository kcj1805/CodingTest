import java.io.*;
import java.util.*;

public class BOJ5622 {
    //다이얼
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] dial = input.split("");
        ArrayList<Integer> phoneNum = new ArrayList<>();
        dialTophoneNum(dial,phoneNum);
        int answer =0;
        for(int i=0;i<phoneNum.size();i++){
            answer += phoneNum.get(i);
        }
        answer += phoneNum.size();

        wr.write(Integer.toString(answer));
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static void dialTophoneNum(String[] dial, ArrayList<Integer> phoneNum)
    {
        for (String str : dial) {
            switch(str.toUpperCase()){
                case "A":
                case "B":
                case "C":{
                    phoneNum.add(2);
                    break;
                }
                case "D":
                case "E":
                case "F":{
                    phoneNum.add(3);
                    break;
                }
                case "G":
                case "H":
                case "I":{
                    phoneNum.add(4);
                    break;
                }
                case "J":
                case "K":
                case "L":{
                    phoneNum.add(5);
                    break;
                }
                case "M":
                case "N":
                case "O":{
                    phoneNum.add(6);
                    break;
                }
                case "P":
                case "Q":
                case "R":
                case "S":{
                    phoneNum.add(7);
                    break;
                }
                case "T":
                case "U":
                case "V":{
                    phoneNum.add(8);
                    break;
                }
                default:{
                    phoneNum.add(9);
                    break;
                }
            }
        }
    }
}
