import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CorruptedArray{

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);

        int t=s.nextInt();

        for(int ie=0;ie<t;ie++) {

            int m=s.nextInt();
            int n=m+2;
            Long[] arr=new Long[n];
            for(int i=0;i<n;i++) {
                arr[i]=s.nextLong();
            }
            Arrays.sort(arr);


            long sum=0;

            for(int i=0;i<n-2;i++) {
                sum=sum+arr[i];
            }

            if(sum==arr[n-2]) {
                for(int i=0;i<n-2;i++) {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }else{

                HashMap<Long,Integer> map=new HashMap<>();

                for(int i=0;i<n-1;i++) {
                    map.put(arr[i], 1);
                }

                sum=sum+arr[n-2];

                if(map.containsKey(sum-arr[n-1])) {

                    int g=0;
                    for(int i=0;i<n-1;i++) {
                        if(g==0 && arr[i]== sum-arr[n-1]) {
                            g=1;
                        }else {
                            System.out.print(arr[i]+" ");
                        }


                    }

                    System.out.println();



                }else{
                    System.out.println(-1);
                }




            }





        }
    }
}