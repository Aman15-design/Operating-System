import java.util.*;
public class priority{
static void sort_acc_to_arrival_and_priority(int at[], int bt[], int pid[],int prt[]) 
{ 
    int n = at.length; 
    for (int i = 0; i < n-1; i++)
    { 
        for (int j = 0; j < n-i-1; j++) 
            if (at[j] > at[j+1]) 
            {
                int temp = at[j]; 
                at[j] = at[j+1]; 
                at[j+1] = temp;
                
                temp=bt[j];
                bt[j]=bt[j+1];
                bt[j+1]=temp;

                temp=pid[j];
                pid[j]=pid[j+1];
                pid[j+1]=temp;

                temp = prt[j];
                prt[j] = prt[j + 1];
                prt[j + 1] = temp;
            }
            else if (at[j]==at[j + 1]) 
            {
                  if (prt[j] < prt[j + 1]) 
                  {
                      int temp = at[j];
                      at[j] = at[j + 1];
                      at[j + 1] = temp;

 
                      temp = bt[j];
                      bt[j] = bt[j + 1];
                      bt[j + 1] = temp;

                      temp = prt[j];
                      prt[j] = prt[j + 1];
                      prt[j + 1] = temp;

                      temp = pid[j];
                      pid[j] = pid[j + 1];
                      pid[j + 1] = temp;
                  }
            }
    }
} 
public static void main(String args[])
{
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of Processes: ");
    int n=sc.nextInt();
    int at[]=new int[n];
    int bt[]=new int[n];
    int pt[]=new int[n];
    int pid[]=new int[n];
    boolean flag[]=new boolean[n];
    int i;
    for(i=0;i<n;i++)
    {
        i++;
        System.out.println("Enter the arrival time, burst time for Process and Priority for process: "+i);
        pid[i-1]=i;
        i--;
        at[i]=sc.nextInt();
        bt[i]=sc.nextInt();
        pt[i]=sc.nextInt();
        flag[i]=false;
    }
    sort_acc_to_arrival_and_priority(at,bt,pid,pt);

    System.out.println(" ");
    System.out.println(
        "Process ID\tArrival Time\tBurst"
        + " Time\tPriority");
    
    for (i = 0; i < n; i++) {
        System.out.printf(
            "%d\t\t%d\t\t%d\t\t%d\n",pid[i],at[i],bt[i],pt[i]);
    }
        int ct[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        float sumtt=0;
        float sumwt=0;
        int count=1;
        ct[0]=at[0]+bt[0];
        int timetillnow=ct[0];
        int max=Integer.MAX_VALUE;
        flag[0]=true;
        int index=0;
        while(count!=n)
        {
            max=Integer.MIN_VALUE;
            i=0;
            while(i<n && at[i]<=timetillnow)
            {
                if(flag[i]==false && pt[i]>max)
                {
                    max=pt[i];
                    index=i;
                }
                i++;
            }
            flag[index]=true;
            ct[index]=timetillnow+bt[index];
            timetillnow=ct[index];
            count++;
        }
        for(i=0;i<n;i++)
        {
            tt[i]=ct[i]-at[i];
            wt[i]=tt[i]-bt[i];

            sumtt=sumtt+tt[i];
            sumwt=sumwt+wt[i];
        }
        System.out.println(" ");
        System.out.println(
            "Process ID\tArrival Time\tPriority\tBurst"
            + " Time\tComp. Time\tTurnaround Time\t\tWaiting Time");
        
        for (i = 0; i < n; i++) {
            System.out.printf(
                "%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d\n",pid[i],at[i],pt[i],bt[i],ct[i],tt[i],wt[i]);
        }
        System.out.println(" ");
        System.out.println("Average turn around time: "+(sumtt/n));
        System.out.println(" ");
        System.out.println("Average Waiting time: "+(sumwt/n));
}
}