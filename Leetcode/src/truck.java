import java.util.Arrays;
import java.util.Scanner;

public class truck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][2];
        for(int i =0;i<n;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            mat[i][0] = a;
            mat[i][1] = b;
        }


        int size = sc.nextInt();
     int ans =   new truck().maximumUnits(mat, size);
        System.out.println(ans);
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare( b[1], a[1]));
        int total = 0;
        int ind =0;
        while(truckSize>0 && ind < boxTypes.length)
        {
            int amt = truckSize>boxTypes[ind][0]?boxTypes[ind][0]:truckSize;
            truckSize-=amt;
            total+= (amt*boxTypes[ind][1]);
            ind++;
        }
        return  total;




    }

}
