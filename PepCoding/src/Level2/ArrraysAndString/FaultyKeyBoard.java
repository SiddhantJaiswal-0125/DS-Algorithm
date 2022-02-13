package Level2.ArrraysAndString;
import java.util.*;

public class FaultyKeyBoard {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    static class pair
    {
        char c; int count ;
        pair(char ch, int ct)
        {
            c = ch;
            count =  ct;

        }

    }
    public static boolean isPossible(String name, String typed) {
        // Write your code here

        int size1 = name.length();
        int size2 = typed.length();
        ArrayList<pair> ar1 = new ArrayList<>();
        ArrayList<pair> ar2 = new ArrayList<>();

        int count = 1;
        char ch = name.charAt(0);
        for(int i = 1;i<size1;i++)
        {
            if(name.charAt(i) != ch)
            {
                pair p = new pair(ch, count);
                ar1.add(p);
                ch = name.charAt(i);
                count = 1;
            }
            else
                count++;

        }
        pair p = new pair(ch, count);
        ar1.add(p);



        ch = typed.charAt(0);
        count = 1;
        for(int i = 1;i<size2;i++)
        {
            if(typed.charAt(i) != ch)
            {
                pair pi = new pair(ch, count);
                ar2.add(pi);
                ch = typed.charAt(i);
                count = 1;
            }
            else
                count++;

        }
        pair pi = new pair(ch, count);
        ar2.add(pi);





      if(ar1.size()!=ar2.size())
          return false;
      for(int i =0;i<ar1.size();i++)
      {
          if(ar1.get(i).c != ar2.get(i).c)
              return  false;
          if(ar1.get(i).count > ar2.get(i).count)
              return  false;
      }




        return  true;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String name = scn.next();
        String typed = scn.next();

        boolean res = isPossible(name, typed);

        System.out.println(res);
    }
}