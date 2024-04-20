import java.util.*;

public class StringVovel extends Thread
{
    public String str;
    public StringVovel(String str)
    {
        this.str = str;
    }

    public void run()
    {
        try
        {
            int length = str.length();
            for(int i=0;i<length;i++)
            {
                char c = str.charAt(i);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                {
                    System.out.println(c);
                    Thread.sleep(1000);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter A String : ");
        String str = sc.nextLine();

        StringVovel t = new StringVovel(str);
        t.start();

    }
}
