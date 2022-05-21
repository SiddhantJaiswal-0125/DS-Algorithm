import java.util.*;

public class testing {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int size = sc.nextInt();
//        int ar[] = new int[size];
//        for(int i =0;i<size;i++)
//            ar[i]=sc.nextInt();
//
//        int ans = chocolateDistribution(size, ar);
//        System.out.println(ans);

//        String s = "itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb";
////      String s = "leetcode";
//        int ans = new testing().firstUniqChar(s);
//
//
//        System.out.println("size " + s.length());
//        System.out.println(ans);


        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String ans  = new testing().largestOddNumber(st);

        System.out.println(ans);
    }

 public String largestOddNumber(String num) {

        int i =  num.length() -1;
        while(i>=0)
        {
            int k = Integer.parseInt(num.charAt(i)+"");
            if(k%2!=0)
                break;
            i--;
        }


    if(i<0)
        return  "";
    return  num.substring(0,i+1);


    }











}
