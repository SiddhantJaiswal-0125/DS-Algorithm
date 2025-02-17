package Graph;


import java.util.*;
public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {

        int degree[] = new int[n];
        HashSet<String> hs = new HashSet<>();
        for(int i[]:roads)
        {
            degree[i[0]]++;
            degree[i[1]]++;

            hs.add(":-"+i[0]+"::"+i[1]+"-:");
            hs.add(":-"+i[1]+"::"+i[0]+"-:");

        }

        for(int i =0;i<n;i++)
            System.out.print(degree[i]+"\t");
        System.out.println();
        int mx = -1;

        for(int i =0;i<n;i++)
        {
            for(int j =i+1; j<n;j++)
            {
                int r1 = degree[i];
                int r2 =  degree[j];

                System.out.println("PAIR "+i+"\t"+j);
                if(hs.contains(":-"+i+"::"+j+"-:"))
                {
                    int t1 = r1+r2-1;
                    System.out.println("EDGE CONTAINS "+t1+" and MX is "+mx);

//                    System.out.println("PAIR "+i+"\t"+j);
                    if(r1+r2-1 > mx)
                        mx = r1+r2-1;
                }
                else
                {
                    int t1 = r1+r2;

                    System.out.println("NO EDGE "+t1+" and MX is "+mx);
                    if(mx < r1+r2)
                        mx = r1+r2;

                }
            }
        }

        // for(int rd[] : roads)
        // {
        //  int r1 = degree[rd[0]];
        //  int r2 =  degree[rd[1]];

        //  if(r1+r2-1>mx)
        //  mx = r1+r2-1;
        // }
        return mx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int ed = sc.nextInt();

        int edges[][]  = new int[ed][2];
        for(int i=0; i<ed;i++)
        {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        int ans = new MaximalNetworkRank().maximalNetworkRank(n,edges);
        System.out.println("ANS "+ans);
    }
}


//4
//        4
//        0
//        1
//        0
//        3
//        1
//        2
//        1
//        3