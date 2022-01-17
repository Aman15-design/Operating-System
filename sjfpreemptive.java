import java.util.*;
public class sjfpreemptive{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of Processes: ");
        int n=sc.nextInt();
        int at[]=new int[n];
        int bt[]=new int[n];
        int tempbt[]=new int[n];
        int pid[]=new int[n];
        boolean flag[]=new boolean[n];
        int i;
        for(i=0;i<n;i++)
        {
            i++;
            System.out.println("Enter the arrival time and burst time for Process "+i);
            i--;
            pid[i]=i+1;
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
            flag[i]=false;
            tempbt[i]=bt[i];
        }
        int count=0;
        int check=0;
        int ct[]=new int[n];
        int total=0;
        while(total!=n)
        {
            int minimum_val=Integer.MAX_VALUE;
            for(i=0;i<n;i++)
            {
                if((at[i]<=count) && (flag[i]==false) && (bt[i]<minimum_val))
                {
                    minimum_val=bt[i];
                    check=i;
                }
            }
            if(check==n)
            {
               count++;
            }
            else
            {
                bt[check]--;
                count++;
            }

            if(bt[check]==0)
            {
                ct[check]=count;
                flag[check]=true;
                total++;
            }
            
        }
        float sumtt=0;
        float sumwt=0;
        int tt[]=new int[n];
        int wt[]=new int[n];
        for(i=0;i<n;i++)
        {
         tt[i] = ct[i] - at[i];
         wt[i] = tt[i] - tempbt[i];
         sumwt=sumwt+wt[i];
         sumtt=sumtt+tt[i];
        }
        System.out.println(" ");
        System.out.println(
            "Process ID\tArrival Time\tBurst"
            + " Time\tComp. Time\tTurnaround Time\t"+"   "+"Waiting Time");
        
        for (i = 0; i < n; i++) {
            System.out.printf(
                "%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d\n",pid[i],at[i],tempbt[i],ct[i],tt[i],wt[i]);
        }
        System.out.println(" ");
        System.out.println("Average turn around time: "+(sumtt/n));
        System.out.println(" ");
        System.out.println("Average Waiting time: "+(sumwt/n));
    }
}