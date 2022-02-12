import java.io.*;
import java.util.*;

public class MazeTravel {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<String> res = getMazePaths(0,0, n-1,m-1);
        System.out.println(res.toString());



    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {

        ArrayList<String> res = new ArrayList<>();
        if(sr==dr && sc==dc)
        {

            return res;
        }

        solve(sr,sc,dr,dc,res, "");
        return res;


    }
    static void solve(int sr, int sc, int dr, int dc, ArrayList<String> res,String temp)
    {
        int i=1;
        String add = "";
        if(sr==dr && sc==dc)
        {
            res.add(temp);
            return;
        }
        else if(sr>dr || sc>dc)
            return ;



        add = "";
        while(sc+i<=dc)
        {
            add= add+"h"+i;
            solve(sr, sc+i,dr,dc, res, temp+add);
            i++;
        }
        i = 1;
        add = "";
        while(sr+i<=dr)
        {
            add= add+ "v"+i;

            solve(sr+i, sc,dr,dc, res, temp+add);
            i++;

        }



        int  min = Math.min(dr,dc);
//        i =

        return;

    }

}