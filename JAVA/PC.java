import java.util.*;
public class PC
{
    int n;
    LinkedList<Integer> l = new LinkedList<Integer>();  
    public PC(int n)
    {
        this.n=n;
    }
    
    public void producer()
    {
        try
        {
            while(true)
            {
                synchronized(this)
                {
                    while(l.size()==n)
                    {
                        wait();
                    }
                    Random r = new Random();
                    int ele = r.nextInt(50);
                    l.add(ele);
                    System.out.println("Produce : "+ele);
                    notify();
                }
                Thread.sleep(500);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    public void consumer()
    {
        try
        {
            while(true)
            {
                synchronized(this)
                {
                    while(l.isEmpty())
                    {
                        wait();
                    }
                    Object ele = l.removeFirst();
                    System.out.println("Consume : "+ele);
                    notify();
                }
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) 
    {
        PC pc = new PC(5);
        Thread p = new Thread(()->{pc.producer();});
        Thread c = new Thread(()->{pc.consumer();});
        p.start();
        c.start();
    }
}