import java.io.*;
import java.util.*;

public class SkillTree {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        //String cnt = br.readLine();
        //String input = br.readLine();
        String skiil = "CBDK";
        String[] skill_trees={"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};

        //"CBDK" ["CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"] 4
        //"CBD", ["BACDE", "CBADF", "AECB", "BDA", "AQWER"] 3
        wr.write(Integer.toString(Solution(skiil,skill_trees)));
        
        wr.flush();
        wr.close();
        br.close();
    }
    public static int Solution(String skill, String[] skill_trees)
    {
        int answer=0;
        String[] skillArr = skill.split("");
        for(int i=0;i<skill_trees.length;i++)
        {
            String[] temp = skill_trees[i].split("");
            boolean[] checkskill = new boolean[skillArr.length+1];
            for(int j=0;j<temp.length;j++)
            {
                if(Arrays.asList(skillArr).contains(temp[j]))
                {
                    int loc = Arrays.asList(skillArr).indexOf(temp[j])+1;
                    if(loc!=1 && !checkskill[loc-1])
                    {
                        break;
                    }
                    checkskill[loc] = true;
                }
                if(j+1==temp.length)
                {
                    answer++;
                }
            }
        }
        return answer;
    }
}
