package Arrays;
import java.util.*;

import java.util.*;

 class TaskScheduler {
    public static int maxOptionalTasks(int[] tasksRequired, int[] tasksOptional, int dailyTimeLimit) {
        int n = tasksRequired.length;

        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i:tasksOptional)
            maxpq.add(i);
        for(int i : tasksRequired)
            minpq.add(i);



        int optionalCount = 0;

        for(int i=0;i<n && maxpq.size() > 0;i++)
        {
            int req = minpq.poll();
            int temp = maxpq.peek();
            if(temp+req<=dailyTimeLimit) {
                optionalCount++;
                maxpq.poll();
            }
            else {

                while(temp+req > dailyTimeLimit && maxpq.size() > 0)
                {
                    maxpq.poll();
                    if(maxpq.size()>0)
                        temp = maxpq.peek();
                }

                if(maxpq.size()>0)
                {
                    maxpq.poll();
                    optionalCount++;
                }
            }


        }

        return  optionalCount;
    }

//    public static void main(String[] args) {
//        int dailyTimeLimit = 8;
//        int[] tasksRequired = {3, 5, 6, 5, 7, 1};
//        int[] tasksOptional = {6, 4, 3, 7, 2, 7};
//
//        int result = maxOptionalTasks(tasksRequired, tasksOptional, dailyTimeLimit);
//        System.out.println("Maximum Optional Tasks: " + result);
//    }
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);

        int dailyTimeLimit = sc.nextInt();
        int n = sc.nextInt();

        int [] tasksRequired = new int[n];
        int tasksOptional[] = new int[n];

        for(int i =0; i<n; i++)
            tasksRequired[i] = sc.nextInt();

        for(int i=0 ;i<n;i++)
            tasksOptional[i] = sc.nextInt();


//        int[] tasksRequired = {6, 3, 1, 3, 4};
//        int[] tasksOptional = {6, 2, 5, 5, 2};

        int result = maxOptionalTasks(tasksRequired, tasksOptional, dailyTimeLimit);
        System.out.println("Maximum Optional Tasks: " + result);
    }
}


//8
//6
//3
//5
//6
//5
//7
//1
//6
//4
//3
//7
//2
//7




