import java.lang.reflect.Array;
import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        List<List<Integer>> res = new ArrayList<>();
//
//        for(int i = 0;i<4;i++)
//        {
//            res.add(new ArrayList<>());
//            for(int j =0 ;j<i+1;j++)
//                res.get(i).add(sc.nextInt());
//
//        }
//
//        int min = new Triangle().minimumTotal(res);
//        System.out.println(min);
        HashSet<ArrayList> hs = new HashSet<>();
        ArrayList ar = new ArrayList();
        ar.add(1);
        ar.add(2);
        ar.add(3);

        hs.add(ar);
        hs.add( new ArrayList(ar));
        System.out.println(hs.size());

    }
    String resv(String number)
    {
        return  "";
    }
    public int minimumTotal(List<List<Integer>> triangle) {

        List<Integer> prev = new ArrayList<>();
        prev = triangle.get(0);


        int trisize = triangle.size();
        for(int i = 1;i<trisize;i++)
        {
            List<Integer> curr = new ArrayList<>();
            List<Integer>  now = triangle.get(i);

            int size = triangle.get(i).size();

            for(int j = 0; j< size; j++)
            {
                int val =   now.get(j);
                if(j==0)
                    val += prev.get(0);
                else if(j==size-1)
                   val+= prev.get(prev.size()-1) ;
                else
                    val+= Math.min(prev.get(j-1), prev.get(j) );

                curr.add(val);
            }
            prev = new ArrayList<>(curr);
        }

        int min = Integer.MAX_VALUE;
        for(int i : prev)
            min = Math.min(i, min);
        return min;

    }
}


//2
//        3
//        4
//        6
//        5
//        7
//        4
//        1
//        8
//        3