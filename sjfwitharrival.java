import java.util.*;
public class sjfwitharrival{
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
            System.out.println("Enter the arrival time and burst time for Process "+i);
            pid[i-1]=i;
            i--;
            at[i]=sc.nextInt();
            bt[i]=sc.nextInt();
        }
        bubblesort_(at,bt,pid);
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
        int short_bt=Integer.MAX_VALUE;
        Set<Integer> a=new HashSet<>();
        int index=Integer.MAX_VALUE;
        int j=0;
        int clock=at[0];
        while(a.size()!=n)
        {
        j=0;
        while(j<n && at[j]<=clock)
        {
            if(bt[j]<short_bt && a.contains(j)==false)
            {
                short_bt=bt[j];
                index=j;
            }
            j++;
        }
        if(index>=0 && index<n)
        {
        a.add(index);
        tt[index]=(clock-at[index])+bt[index];
        ct[index]=(tt[index]+at[index]);
        wt[index]=(tt[index]-bt[index]);
        sumtt=sumtt+tt[index];
        sumwt=sumwt+wt[index];
        clock=clock+bt[index];

        short_bt=Integer.MAX_VALUE;
        }
        else
        {
            clock=clock+1;
        }
    }
    System.out.println(" ");
    System.out.println(
        "Process ID\tArrival Time\tBurst"
        + " Time\tComp. Time\tTurnaround Time\t"+"   "+"Waiting Time");
    
    for (i = 0; i < n; i++) {
        System.out.printf(
            "%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\t%d\n",pid[i],at[i],bt[i],ct[i],tt[i],wt[i]);
    }
      System.out.println(" ");
      System.out.println("Average turn around time: "+(sumtt/n));
      System.out.println(" ");
      System.out.println("Average Waiting time: "+(sumwt/n));
    }
}