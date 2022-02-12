import java.util.*;
public class MaximumUnitsonaTruck
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][2];
        for(int i=0;i<n;i++){
            mat[i][0] = sc.nextInt();
            mat[i][1] = sc.nextInt();

        }

        int trucksize = sc.nextInt();
        int ans = new MaximumUnitsonaTruck().maximumUnits(mat,trucksize);
        System.out.println(" ans  is "+ans);

    }


    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        int size = boxTypes.length;
        Pair p[] = new Pair[size];
        for(int  i =0;i<size;i++)
        p[i] = new Pair(boxTypes[i][0],boxTypes[i][1]);




        Arrays.sort(p, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return   o2.boxquan - o1.boxquan;
            }
        });
        int sum =0;

        for(int i=0;i<size && truckSize>0;i++ )
        {
            if(truckSize>=p[i].boxtype)
            {


                sum += (p[i].boxtype * p[i].boxquan);
               truckSize -= p[i].boxtype;

            }
            else
            {
                sum += (truckSize * p[i].boxquan);


                truckSize -= p[i].boxtype;
                break;
            }

        }
        return  sum;
    }

    static  class Pair
    {
        int boxtype;
        int boxquan;
        Pair(int a, int b)
        {
            boxtype = a;
            boxquan = b;
        }
    }
}


