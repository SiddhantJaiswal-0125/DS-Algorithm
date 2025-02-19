package Multithreading;

public class MultithreadingDemo {
    public static void main(String[] args) {

        for(int i =0;i<5;i++)
        {
            classExtendsThread ci = new classExtendsThread();
            ci.start();
        }

//        for(int i =0;i<5;i++)
//        {
//           Thread ci = new Thread(new classimplementsRunnable());
//            ci.run();
//        }


    }
}


class classExtendsThread extends Thread
{
    @Override
    public void run()
    {
        try
        {
            System.out.println("classExtendsThread Thread "+Thread.currentThread().getId()+" is running");
        }
        catch (Exception e)
        {
            System.out.println("Caught Exception : "+e.getMessage() );
        }
    }
}


class classimplementsRunnable implements  Runnable
{
    @Override
    public void run()
    {
        try
        {
            System.out.println("Thread "+Thread.currentThread().getId()+" is running");
        }
        catch (Exception e)
        {
            System.out.println("Caught Exception : "+e.getMessage() );
        }
    }
}
