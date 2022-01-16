import java.util.ArrayList;
import java.util.PriorityQueue;

class KthLargest {
    PriorityQueue<Integer> pq;
    int ki ;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        ki = k;
        for(int i :nums)
        {
            pq.add(i);
            if(pq.size()>k)
                pq.remove();

        }


    }

    public int add(int val) {
        pq.add(val);
        if(pq.size()>ki)
            pq.remove();
        ArrayList<Integer> ai = new ArrayList<>();
        int res =0;
        while(pq.isEmpty() == false)
        {
            int j = pq.remove();

            ai.add(j);
            res = j;


        }

        pq = new PriorityQueue(ai);

        return res;



    }
}
