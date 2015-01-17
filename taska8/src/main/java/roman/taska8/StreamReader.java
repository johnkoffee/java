package roman.taska8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

public class StreamReader implements Runnable{
    public Thread 
    
    StreamReader( String name, FileInputStream streamin, Semaphore s1, Semaphore s2, Semaphore s3, BlockingQueue bq)
    {
        this.threadName = name;
        this.threadInStream = streamin;
        this.semaphore1 = s1;
        this.semaphore2 = s2;
        this.semaphore3 = s3;
        this.queue = bq;
        System.out.println(threadName + ": creating thread...");
    }
    
    @Override
    public void run() 
    {
        System.out.println(threadName + ": running thread...");
        //start reading
        try 
        {
            String data;
            byte b = 2;
            //keep reading until \1 is met (designated stream-end character)
            while (b != 1)
            {
                data = "";
                b = (byte) this.threadInStream.read();
                //keep reading current message, till \0 is met (designated message-end character)
                while ((b != 0)&&(b != 1))
                {
                    data += (char) b;
                    b = (byte) this.threadInStream.read();
                }
                
                if (data.length() != 0 )
                {
                    //start synchronizing to send data
                    this.semaphore1.acquire();
                    //send data to the blocking queue
                    while (!this.queue.offer(this.threadName+":"+data));
                    //start synchronizing to continue work
                    this.semaphore2.acquire();
                }
            }
            //stream-end is met
            System.out.println(threadName + ": end of data stream");
        }  
        catch (IOException | InterruptedException ex) 
        {
            System.out.println(threadName + ": " + ex.toString());
        }
        //start synchronizing to exit
        System.out.println(threadName + ": exiting...");
        try 
        {
            this.semaphore3.acquire();
        } 
        catch (InterruptedException ex) 
        {
            System.out.println(threadName + ": " + ex.toString());
        }
    }
   
    public void start ()
    {
        System.out.println(threadName + ": starting...");
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
        this.semaphore2.release(1);
    }
}
