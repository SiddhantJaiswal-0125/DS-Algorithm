import java.util.*;

public class CellsUnderAttaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long ans[] = new long[m];


        HashSet<Integer> vert = new HashSet<>();
        HashSet<Integer> hori = new HashSet<>();
        int  i =0;
        long total = 1l*n*n;
        while(m-->0)
        {
            int xi = sc.nextInt();
            int yi = sc.nextInt();
            hori.add(yi);
            vert.add(xi);
            long count = (hori.size() * 1l * n) +(vert.size() * 1l*n) - (hori.size()*1l*vert.size());
            ans[i++] = (long)(total - (count));


//            List<Set<Integer>> abc = new ArrayList<>();
//            abc.add(new TreeSet<>());
//            abc.get(0);
//










        }






        for(long l : ans)
            System.out.print(l+" ");
        System.out.println();
    }
}
