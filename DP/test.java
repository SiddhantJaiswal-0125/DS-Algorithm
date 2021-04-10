
public class test 
{
    public static void main(String[] args) 
    {

        int n = 3;
        int k = n;
        while(n>0)
        {
            //NO of lines print krega

            for(int i = k;i>=1;i--)
            {
                //per line kitne no. h
                int j = n;
                while(j>0)
                {
                    //har no. per line me kitne baar h

                    System.out.print(i+" ");
                    j--;
                }

            }
            System.out.println();
            n--;
        }
        
    }
    
}