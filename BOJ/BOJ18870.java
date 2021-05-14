import java.io.*;
import java.util.*;

public class BOJ18870 {
    //좌표 압축
    static class X{
        int index;
        int val;
        int res;
        public X(int i, int v){
            index = i;
            val = v;
        }
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        //List<X> XList = new ArrayList<>();
        X[] XArr = new X[N];
        int index=0;
        int[] resArr = new int[N];
        for (String str : br.readLine().split(" ")) {
            //XList.add(new X(index++, Integer.parseInt(str)));
            X x = new X(index, Integer.parseInt(str));
            XArr[index++]=x;
        }
        Arrays.sort(XArr, (a,b)->a.val-b.val);

        for(int i=0;i<XArr.length;i++){
            if(i!=0 && XArr[i-1].val == XArr[i].val){
                XArr[i].res = XArr[i-1].res;
            }
            else if(i!=0 && XArr[i-1].val != XArr[i].val){
                XArr[i].res = XArr[i-1].res+1;
            }
            else{
                XArr[i].res = 0;
            }
            resArr[XArr[i].index] = XArr[i].res;
        }
        for (int res : resArr) {
            wr.write(res + " ");
        }
        //Collections.sort(XList, (a,b)->a.val-b.val);
//
        //for(int i=0;i<XList.size();i++){
        //    if(i!=0 && XList.get(i-1).val == XList.get(i).val){
        //        XList.get(i).res = XList.get(i-1).res;
        //    }
        //    else if(i!=0 && XList.get(i-1).val != XList.get(i).val){
        //        XList.get(i).res = XList.get(i-1).res+1;
        //    }
        //    else{
        //        XList.get(i).res = 0;
        //    }
        //}
//
        //Collections.sort(XList, (a,b)->a.index-b.index);
        //for (X x : XList) {
        //    wr.write(x.res + " ");
        //}

        wr.flush();
        wr.close();
        br.close();
    }
}
