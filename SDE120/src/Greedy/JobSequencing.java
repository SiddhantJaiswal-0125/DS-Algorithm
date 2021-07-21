package Greedy;

import java.util.*;

public class JobSequencing {
    static class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Job j[] = new Job[n];
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();
            j[i] = new Job(id, deadline, profit);
        }
        int ans []=  new JobSequencing().JobScheduling(j, n);
        System.out.println(ans[0]+"\t"+ans[1]);
        sc.close();
    }

    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        int ans[] = new int[2];
//        Arrays.sort(arr, new Comparator<Job>() {
//            @Override
//            public int compare(Job o1, Job o2)
//            {
//              if(o1.profit<o2.profit)
//                  return 1;
//              else
//                  return  -1;
//            }
//        });
        int maxday = 0;
        for(Job j : arr)
            maxday = Math.max(j.deadline, maxday);
        Arrays.sort(arr, new Comparator<Job>()
                {
                    @Override
                    public int compare(Job j1, Job j2)
                    {
                        if(j1.profit<j2.profit)
                            return 1;
                        return -1;
//                        return j1.profit - j2.profit;


                    }
                }
        );
        for(Job ji : arr)
            System.out.println(ji.id+"\t"+ji.deadline+"\t"+ji.profit);

        int jobs = 0;
        int profit =0;
        int end =  0;
        HashSet<Integer> day = new HashSet<>();


        for(Job j : arr)
        {
            int deadline = j.deadline;
            if(deadline>=maxday  && maxday>0)
            {


               if(j.deadline==maxday)
                maxday--;
               else if (day.contains(deadline))
                    continue;
                profit+=j.profit;
                day.add(deadline);
                jobs++;

            }
//            else
//            {
//                if(day.contains(deadline))
//                continue;
//                else
//                {
//                    profit+=j.profit;
//                    day.add(deadline);
//                    jobs++;
//
//                }
//            }



        }


//        HashMap <Integer, Integer> days = new HashMap<>();
//
//        for(Job j : arr)
//        {
//            if(days.get(j.deadline)==null)
//            {
//                //NO day for this dead line;
//                days.put(j.deadline, j.profit);
//                jobs++;
//                profit+=j.profit;
//
//            }
//            else
//            {
//                int pr = days.get(j.deadline);
//                if(j.profit>pr)
//                {
//                    profit+=(j.profit - pr);
//                    days.put(j.deadline, j.profit);
//                }
//            }
//        }
        ans[0]= jobs;
        ans[1]= profit;
        return ans;
    }

}



//2	27	435
//        14	77	424
//        3	67	401
//        15	68	397
//        16	40	375
//        13	61	370
//        4	64	368
//        6	54	361
//        1	56	288
//        9	73	251
//        5	94	248
//        17	36	218
//        12	78	184
//        10	96	170
//        8	96	167
//        11	14	156
//        7	43	108
//        16	4765