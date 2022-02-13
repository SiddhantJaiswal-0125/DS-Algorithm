package Level2.SearchingSorting;
import java.util.*;
import java.io.*;

public class MarksOfPCM {

    /*You have to complete the body of customSort function,
    after sorting final changes should be made in given arrays only. */

    static class student implements Comparable<student>
    {
        int math, phy, chem;
        student(int m, int p, int c)
        {
            math = m;
            phy =  p;
            chem = c;

        }
        public  int compareTo(student oth)
        {
            if(this.phy < oth.phy)
                return  -1;
            else if(this.phy == oth.phy)
            {
                if(this.chem  > oth.chem )
                    return  -1;
                else if(this.chem == oth.chem)
                {
                    //physic and chem same
                return  this.math - oth.math;
                }
                else return  1;
            }
            else
                return  1;


        }
    }
    public static void customSort(int[]phy,int[]chem,int[]math) {

        int size = phy.length;
        student s[] = new student[size];
        for(int i  =0 ;i<size; i++)
            s[i] = new student(math[i],phy[i],chem[i]);
        Arrays.sort(s);
        for(int i =0;i<size;i++)
        {
            phy[i] = s[i].phy;
            math[i] = s[i].math;
            chem[i] = s[i].chem;
        }
        return;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}