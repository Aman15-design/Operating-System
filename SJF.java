import java.util.*;
public class SJF{
    static void bubblesort_(int arr[], int bt[], int pid[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++)
        { 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                {
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp;
                    
                    int temp2=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp2;

                    int temp3=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp3;
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
        int pid[]=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            i++;
            System.out.println("Enter burst time for Process "+i);
            pid[i-1]=i;
            i--;
            at[i]=0;
            bt[i]=sc.nextInt();
        }
        bubblesort_(bt,at,pid);
        System.out.println("ID  AT  BT");
        for(i=0;i<n;i++)
        {
            System.out.println(pid[i]+"    "+at[i]+"   "+bt[i]);
        }
        int ct[]=new int[n];
        int tt[]=new int[n];
        int wt[]=new int[n];
        float sumtt=0;
        float sumwt=0;
        int clock=0;
        for(i=0;i<n;i++)
        {
            ct[i]=bt[i]+clock;
            clock=clock+bt[i];
        }
        for(i=0;i<n;i++)
        {
            tt[i]=ct[i];
            wt[i]=tt[i]-bt[i];

            sumtt=sumtt+tt[i];
            sumwt=sumwt+wt[i];
        }
        System.out.println(" ");
        System.out.println(
            "Process ID\tArrival Time\tBurst"
            + " Time\tComp. Time\tTurnaround Time\t"+"   "+"Waiting Time");
        
        for (i = 0; i < n; i++) {
            System.out.printf(
                "%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d\n",pid[i],at[i],bt[i],ct[i],tt[i],wt[i]);
        }
      System.out.println("Average turn around time: "+(sumtt/n));
      System.out.println("Average Waiting time: "+(sumwt/n));
      sc.close();

    }
}