import java.util.concurrent.Semaphore;
public class rw{
    static Semaphore wlock=new Semaphore(1);
    static Semaphore rlock=new Semaphore(1);
    static int count=0;

    static class Read implements Runnable{
        public void run()
        {
            try
            {
                rlock.acquire();
                count++;
                if(count==1)
                {
                    wlock.acquire();
                }
                rlock.release();
                System.out.println("Reading "+Thread.currentThread().getName());
                Thread.sleep(3000);
                System.out.println("Reading finished for "+Thread.currentThread().getName());
                rlock.acquire();
                count--;
                if(count==0)
                {
                    wlock.release();
                }
                rlock.release();
            }
            catch(Exception e)
            {
                System.out.println("Error: "+e);
            }
        }
    }
    static class Write implements Runnable{
        public void run()
        {
            try{
                wlock.acquire();
                System.out.println("Writing "+Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("Writing Ended "+Thread.currentThread().getName());
                wlock.release();
            }
            catch(Exception e)
            {
                System.out.println("Error: "+e);
            }
        }
    }

public static void main(String args[])
{
    Read read=new Read();
    Write write=new Write();
    Thread a=new Thread(write);
    a.setName("a");
    Thread b=new Thread(read);
    b.setName("b");
    Thread c=new Thread(read);
    c.setName("c");
    Thread d=new Thread(read);
    d.setName("d");
    Thread e=new Thread(write);
    e.setName("e");
    Thread f=new Thread(write);
    f.setName("f");

    a.start();
    b.start();
    c.start();
    d.start();
    e.start();
    f.start();
}
}