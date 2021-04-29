import java.io.*;
import java.util.*;

public class BOJ11664 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        inputArr = new double[9];
        for(int i=0;i<inputArr.length;i++)
        {
            inputArr[i]=Double.parseDouble(input.split(" ")[i]);
        }

        //inputArr = new double[]{0, 0, 0, 1, 1, 1, 2, 2, 2};

        //0, 0, 0, 1, 1, 1, 2, 2, 2 -> 1.7320508076
        //10, 20, 30, 40, 50, 60, 45, 35, 25 -> 28.2842712475

        System.out.printf("%.10f",ternary(0,1));
        //wr.write(Double.toString(ternary(0,1)));
        
        wr.flush();
        wr.close();
        br.close();
    }
    static double[] inputArr = null;

    public static double GetLength(double x1, double y1, double z1, double x2, double y2, double z2)
    {
        return Math.sqrt(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2)+Math.pow(z2-z1, 2));
    }

    public static double GetLength(double val)
    {
        return GetLength(inputArr[0]*(1-val)+inputArr[3]*val, inputArr[1]*(1-val)+inputArr[4]*val, inputArr[2]*(1-val)+inputArr[5]*val,inputArr[6], inputArr[7], inputArr[8]);
    }

    public static double ternary(double lo, double hi)
    {
        double ans = 0;
        while(hi-lo > 1e-9)
        {
            double a = (2*lo + hi) / 3.0;
            double b = (lo + 2*hi) / 3.0;

            double ALength = GetLength(a);
            double BLength = GetLength(b);
            if(ALength<BLength)
            {
                hi = b;
            }
            else
            {
                lo = a;
            }
            if(ALength==BLength)
            {
                ans = ALength;
            }
        }
        return ans;
    }
}
