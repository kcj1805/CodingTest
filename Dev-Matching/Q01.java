import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Q01 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] purchase = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        solution(purchase);
        wr.write("");
        wr.flush();
        wr.close();
        br.close();

        Scanner sc = new Scanner(System.in);
        sc.close();
    }
    public static int[] solution(String[] purchase) {
        data[] dataArr = new data[purchase.length];

        SimpleDateFormat dateParser = new SimpleDateFormat("yyyy/MM/dd");
        for(int i=0;i<purchase.length;i++){
            Calendar date = Calendar.getInstance();
            try{
                Date a = dateParser.parse(purchase[i].split(" ")[0]);
                date.setTime(a);
            }
            catch(ParseException e){
                e.printStackTrace();
            }
            int pay = Integer.parseInt(purchase[i].split(" ")[1]);
            dataArr[i]=new data(date, pay);
        }
        Date nowDate = new Date();
        Date EndDate = new Date();
        try{
            nowDate = dateParser.parse("2019/01/01");
            EndDate = dateParser.parse("2019/12/31");
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        Calendar nowCal = Calendar.getInstance();
        Calendar EndCal = Calendar.getInstance();
        nowCal.setTime(nowDate);
        EndCal.setTime(EndDate);
        EndCal.add(Calendar.DATE, 1);
        int[] answer = new int[5];
        while(!nowCal.equals(EndCal)){
            int totalpay = 0;
            for(int i=0;i<dataArr.length;i++){
                if((nowCal.equals(dataArr[i].date) || nowCal.after(dataArr[i].date)) && 
                (nowCal.equals(dataArr[i].End) || nowCal.before(dataArr[i].End))){
                    totalpay += dataArr[i].pay;
                }
            }
            if(totalpay >= 0 && totalpay < 10000){
                answer[0]++;
            }
            else if(totalpay >= 10000 && totalpay < 20000){
                answer[1]++;
            }
            else if(totalpay >= 020000 && totalpay < 50000){
                answer[2]++;
            }
            else if(totalpay >= 50000 && totalpay < 100000){
                answer[3]++;
            }
            else if(totalpay >= 100000){
                answer[4]++;
            }
            nowCal.add(Calendar.DATE, 1);
        }

        return answer;
    }
    public static class data{
        Calendar date;
        Calendar End;
        int pay;

        data(Calendar d, int p){
            date = d;
            pay = p;
            End = Calendar.getInstance();
            End = (Calendar)date.clone();
            End.add(Calendar.DATE,29);
        }
    }
}
