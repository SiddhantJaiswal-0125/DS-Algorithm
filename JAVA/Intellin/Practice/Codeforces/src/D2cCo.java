import java.util.Arrays;
import java.util.Scanner;

public class D2cCo
{
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int production[] = new int[n];

        pair market [] = new pair[m];
        int rentprice[] = new int[k];

        for(int i= 0;i<n;i++)
            production[i] = sc.nextInt();
        for(int i=0;i<m;i++)
        {
            pair p = new pair();
            p.demand = sc.nextInt();
            p.price = sc.nextInt();
            market[i] = p;
        }

        for(int i= 0;i<k;i++)
            rentprice[i] = sc.nextInt();

        Arrays.sort(market);

        Arrays.sort(production);

        Arrays.sort(rentprice);

        System.out.println("MARKET");
        for(pair p : market)
            System.out.println(p.demand+"\t"+p.price);



        System.out.println("PRODUCTION");
        for(int i:production)
            System.out.print(i+"\t");
        System.out.println();


        System.out.println("RENT PRICE");
        for(int i:rentprice)
            System.out.print(i+"\t");
        System.out.println();


        int rentInd = k-1;
        int marketInd = m-1;

        long total = 0l;
        long productstillnow = 0l;

        //solving
        for(int i =0;i<n;i++)
        {

            //for each market
            if(rentInd>=0)
            {



                long item = productstillnow + production[i];

                if(production[i]*market[marketInd].price < rentprice[rentInd])
                {
                    //prodction gives more profit

                    total+=rentprice[rentInd];
                    rentInd--;





                }
                else
                {



                    productstillnow += production[i];
                    if(market[marketInd].demand<= productstillnow)
                    {
                        productstillnow -= market[marketInd].demand;
                        total += (market[marketInd].demand * market[marketInd].price);
                        marketInd--;

                    }






                }




            }

            else if(marketInd>=0)
            {

                //no rent availabe but market is there


            }
        }


        System.out.println(total);

    }


    static  class pair implements Comparable<pair>
    {
        int demand, price;

        @Override
        public int compareTo(pair o) {
            return  this.price - o.price ;
        }
    }



}
