    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

    class CFB {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
             int t = sc.nextInt();
             int c = sc.nextInt();
             String i = sc.next();
             String ans = findCost(t,c,i);
            System.out.println(ans);

        }
        static String findCost(int tableCost, int cardinality, String indexType)
        {
            int million = 1000000;
            if(indexType.equalsIgnoreCase("standard"))
            {

                int tc = 0;

                if(tableCost > million)
                {
                    tc = (int)(0.3 * million)/1;
                    tableCost -=million;
                    tc = tc + (int) (tableCost * 0.15/100);

                }
                else
                {
                    tc = (tableCost * 30) /100;

                }
                if(cardinality/tc < 1)
                    return "Yes";
                else

                    return "No";
            }
            else {
                int tc = 0;
                if(tableCost > million)
                {
                    tc = (int)(0.1 * million)/1;
                    tableCost -=million;
                    tc = tc + (int) (tableCost * 0.05/100);

                }
                else
                    tc = (tableCost * 10) /100;

                if(cardinality/tc < 1)
                    return "Yes";
                else
                    return "No";


            }

        }
    }
