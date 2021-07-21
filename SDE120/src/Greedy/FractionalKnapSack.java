package Greedy;

import java.util.*;

public class FractionalKnapSack
{
    static class Item
    {
        int value, weight;
        Item(int x, int y)
        {
            this.value =x;
            this.weight = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int wt = sc.nextInt();
        Item it[] = new Item[n];
        for(int i =0;i<n;i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            it[i] = new Item(a,b);
        }
        System.out.println(new FractionalKnapSack()
                .fractionalKnapsack(wt, it,n));


    }
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        // Your code here


        Arrays.sort(arr,  new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2)
            {
                double d1 = (o1.value/(double)o1.weight) ;
                double d2 = (o2.value/(double)o2.weight) ;

                if(d1>d2)
                    return - 1;
                else return 1;
            }
        } );
        for(Item i : arr)
            System.out.println(i.value+"\t"+i.weight+"\t"+((double)i.value/i.weight));


        double val = 0;
        for(Item i : arr)
        {
            if(W<=0)
                break;

            if(i.weight<=W)
            {
                W-=i.weight;
                val+= i.value;
            }
            else
            {
                double p = i.value/(double) i.weight;
                val += (p * W);
                W = 0;

            }

        }

        return val;

    }
}
