package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class JobSequencingProblem
{
    static class Job{
        int id , profit , deadline;
        Job(int a, int b,int c)
        {
            id = a;
            profit = b;
            deadline = c;

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Job j[] = new Job[n];
        for(int i=0;i<n;i++)
        {
            int id = sc.nextInt();
            int dead = sc.nextInt();
            int prof = sc.nextInt();
            j[i] = new Job(id,  prof,dead);
        }
        int ans[] = JobScheduling(j,n);


        System.out.println("ANSWER");
        System.out.println(ans[0]+"\t"+ans[1]);



    }
static     int[] JobScheduling(Job arr[], int n)
    {
        int ans [] = new int[2];
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {

                    if(o1.deadline == o2.deadline)
                    {
                        return  o2.profit - o1.profit;
                    }
                    else
                    return  o1.deadline - o2.deadline;

            }
        });

        int count = 1;
        int prev = arr[0].deadline;
        int totalvalue = arr[0].profit;


        for(Job j : arr)
            System.out.println(j.id+"\t"+j.deadline+"\t"+j.profit);



        for(int i=1;i<n;i++)
        {
            if(arr[i].deadline>prev)
            {
                prev = arr[i].deadline;
                totalvalue+=arr[i].profit;
                count++;
            }
        }
        ans[0] = count;
        ans[1] = totalvalue;
        return  ans;
    }
}



//4
//        1
//        4
//        20
//        2
//        1
//        10
//        3
//        1
//        40
//        4
//        1
//        30