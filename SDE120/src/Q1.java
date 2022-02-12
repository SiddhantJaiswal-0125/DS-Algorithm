// Java implementation of the approach
import java.util.*;

class GFG
{

    // Function that will find the
// card number which is remaining
    static int remainingCard(int n)
    {
        Queue<Integer> queCards = new LinkedList<>();

        // Inserting all the numbers from 1 to n
        for (int i = 1; i <= n; i++)
        {
            queCards.add(i);
        }

        // While there are atleast two
        // elements in the queue
        while (((int) queCards.size()) >= 2)
        {

            // Push the front element at the back

            for(int as=0; as <50000-1; as++) {

                queCards.add(queCards.peek());

                // Remove the front element
                queCards.remove();
            }

            queCards.remove();
        }

        return queCards.peek();
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 10000000;

       int ans=  solve();
        System.out.println("ANS IS "+ans);
//        System.out.println(remainingCard(n));
    }
    static int solve()
    {
        int n = 100;
        try{
            System.out.println(n/0);
            return 0;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

            return  -1;

        }
        finally {
            System.out.println("AT FiNNALY");

//            return -2;

        }
    }
}