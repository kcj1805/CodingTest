import java.io.*;
import java.util.*;

public class Program3 {
    public static void main(String[] args) throws IOException
    {
        //기본시간, 기본요금, 단위시간, 단위요금
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", 
                            "06:00 0000 IN", 
                            "06:34 0000 OUT", 
                            "07:59 5961 OUT", 
                            "07:59 0148 IN", 
                            "18:59 0000 IN", 
                            "19:09 0148 OUT", 
                            "22:59 5961 IN", 
                            "23:00 5961 OUT"};
        solution(fees, records);
    }
    public static int[] solution(int[] fees, String[] records) {

        TreeMap<Integer, Car> Feemap = new TreeMap<>();
        for (String str : records) {
            String[] strArr = str.split(" ");

            String[] Time = strArr[0].split(":");
            int CarNum = Integer.parseInt(strArr[1]);
            int MinTime = Integer.parseInt(Time[0])*60+Integer.parseInt(Time[1]);
            Car car = new Car(0, 0, 0);

            if(Feemap.containsKey(CarNum)){
                car = Feemap.get(CarNum);
                if(strArr[2].equals("IN")){
                    car.ifnotout = 23*60 + 59-MinTime;
                    car.LastMin = MinTime;
                }
                else{
                    car.ifnotout =0;
                    car.totalMin += (MinTime - car.LastMin);
                }
            }
            else{
                car.ifnotout = 23*60 + 59-MinTime;
                car.LastMin = MinTime;
                Feemap.put(CarNum,car);
            }
        }

        int[] answer = new int[Feemap.size()];
        for(int i=0;i<answer.length;i++){
            Car tmp = Feemap.get(Feemap.firstKey());
            Feemap.remove(Feemap.firstKey());
            int totalMin = tmp.totalMin+tmp.ifnotout;

            answer[i] += fees[1];

            if(totalMin > fees[0]){
                answer[i] += (Math.ceil((double)(totalMin-fees[0])/fees[2]) *fees[3]);
            }
        }
        return answer;
    }

    public static class Car{
        int totalMin=0;
        int LastMin=0;
        int ifnotout=0;

        public Car(int Total, int LMin, int If){
            totalMin = Total;
            LastMin = LMin;
            ifnotout = If;
        }
    }
}
