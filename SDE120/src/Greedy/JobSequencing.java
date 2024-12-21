package Greedy;

import java.util.*;

public class JobSequencing {
    static class Job implements Comparable<Job> {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }

        public int compareTo(Job oth)
        {
                return oth.profit - this.profit;
        }

        @Override
        public String toString() {
            return "ID "+this.id+" -- Deadline "+this.deadline+"  -- Profit "+this.profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int id[] = new int[n];
       int deadline[] = new int[n];
       int profit[] = new int[n];
        for (int i = 0; i < n; i++)
             id[i] = sc.nextInt();




        for (int i = 0; i < n; i++)
            deadline[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            profit[i] = sc.nextInt();
        List<Integer> ans =  new JobSequencing().JobSequencing(id,deadline , profit);

        System.out.println(ans.get(0)+"\t"+ans.get(1));
        sc.close();
    }


    public ArrayList<Integer> JobSequencing(int[] id, int[] deadline, int[] profit) {
        // code here..

        ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;
        int total=0;
        int n = id.length;
        Job j[]= new Job[n];

        for(int i =0; i<n; i++ )

            j[i] = new Job(id[i], deadline[i], profit[i]);



        Arrays.sort(j);

//        System.out.println("AFTER SORTING ");
//        for(Job ji :j )
//            System.out.println("JOB "+ji);


        HashSet<Integer> days = new HashSet<>();
        for(int i= 0;i<n;i++)
        {
//            System.out.println("FOR JOB "+j[i]);
//            System.out.println("PRINT SET "+days );
            if(days.contains(j[i].deadline) == false)
            {


//                System.out.println("DEADLINE  "+j[i].deadline);
                days.add(j[i].deadline);
                cnt++;
                total+= j[i].profit;


//                System.out.println("ADDING THE JOB in 1st IF "+j[i]);
            }
            else
            {
                int dd = j[i].deadline-1;

                while(dd>0 )
                {
                    if(days.contains(dd) == false)
                    {
                        days.add(dd);
                        cnt++;
                        total+= j[i].profit;
                        dd = -1;
//                        System.out.println("ADDING THE JOB in 2nd IF "+j[i]);
                    }
                    else dd--;
                }
            }

        }

        ans.add(cnt);
        ans.add(total);
        return  ans;
    }

    //    int[] JobScheduling(Job arr[], int n) {
//        // Your code here
//        int ans[] = new int[2];
////        Arrays.sort(arr, new Comparator<Job>() {
////            @Override
////            public int compare(Job o1, Job o2)
////            {
////              if(o1.profit<o2.profit)
////                  return 1;
////              else
////                  return  -1;
////            }
////        });
//        int maxday = 0;
//        for(Job j : arr)
//            maxday = Math.max(j.deadline, maxday);
//        Arrays.sort(arr, new Comparator<Job>()
//                {
//                    @Override
//                    public int compare(Job j1, Job j2)
//                    {
//                        if(j1.profit<j2.profit)
//                            return 1;
//                        return -1;
////                        return j1.profit - j2.profit;
//
//
//                    }
//                }
//        );
//        for(Job ji : arr)
//            System.out.println(ji.id+"\t"+ji.deadline+"\t"+ji.profit);
//
//        int jobs = 0;
//        int profit =0;
//        int end =  0;
//        HashSet<Integer> day = new HashSet<>();
//
//
//        for(Job j : arr)
//        {
//            int deadline = j.deadline;
//            if(deadline>=maxday  && maxday>0)
//            {
//
//
//               if(j.deadline==maxday)
//                maxday--;
//               else if (day.contains(deadline))
//                    continue;
//                profit+=j.profit;
//                day.add(deadline);
//                jobs++;
//
//            }
////            else
////            {
////                if(day.contains(deadline))
////                continue;
////                else
////                {
////                    profit+=j.profit;
////                    day.add(deadline);
////                    jobs++;
////
////                }
////            }
//
//
//
//        }
//
//
////        HashMap <Integer, Integer> days = new HashMap<>();
////
////        for(Job j : arr)
////        {
////            if(days.get(j.deadline)==null)
////            {
////                //NO day for this dead line;
////                days.put(j.deadline, j.profit);
////                jobs++;
////                profit+=j.profit;
////
////            }
////            else
////            {
////                int pr = days.get(j.deadline);
////                if(j.profit>pr)
////                {
////                    profit+=(j.profit - pr);
////                    days.put(j.deadline, j.profit);
////                }
////            }
////        }
//        ans[0]= jobs;
//        ans[1]= profit;
//        return ans;
//    }
}


//5
//        1
//        2
//        3
//        4
//        5
//        2
//        1
//        2
//        1
//        1
//        100
//        19
//        27
//        25
//        15





//4
//        1
//        2
//        3
//        4
//        3
//        1
//        2
//        2
//        50
//        10
//        20
//        30
//

