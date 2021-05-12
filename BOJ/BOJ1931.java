import java.io.*;
import java.util.*;


public class BOJ1931 {
    //회의실 배정
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        @Override
        public int compareTo(Meeting o) {
            //return this.start - o.start;
            if(this.end>o.end){
                return 1;
            }
            else if(this.end<o.end){
                return -1;
            }
            else{
                return this.start - o.start;
            }
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Meeting> meetingList = new ArrayList<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Meeting meeting = new Meeting();
            meeting.start = Integer.parseInt(st.nextToken());
            meeting.end =  Integer.parseInt(st.nextToken());
            meetingList.add(meeting);
        }
        Collections.sort(meetingList);
        int tmp;
        int cnt=0;
        //int answer=0;
        //for(int i=0;i<meetingList.size();i++){
        //    tmp = meetingList.get(i).end;
        //    cnt++;
        //    for(int j=0;j<meetingList.size();j++){
        //        if(i!=j && tmp <= meetingList.get(j).start){
        //            tmp=meetingList.get(j).end;
        //            cnt++;
        //        }
        //    }
        //    answer = Math.max(answer,cnt);
        //    cnt=0;
        //}
        
        List<Meeting> ansList = new ArrayList<>();
        ansList.add(meetingList.get(0));
        tmp = meetingList.get(0).end;
        cnt++;
        for(int j=1;j<meetingList.size();j++){
            if(tmp <= meetingList.get(j).start){
                tmp=meetingList.get(j).end;
                ansList.add(meetingList.get(j));
                cnt++;
            }
        }

        wr.write(Integer.toString(cnt));
        wr.flush();
        wr.close();
        br.close();
    }
}
