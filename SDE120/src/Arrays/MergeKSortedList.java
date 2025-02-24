package Arrays;

import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class MergeKSortedList {



        public ListNode mergeKLists(ListNode[] lists) {
//            ArrayList<Integer> ans = new ArrayList<>();
            int size = lists.length;
            PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
                @Override
                public int compare(ListNode p1, ListNode p2)
                {
                    return  p1.val - p2.val;
                }
            });
            for(int i=0; i<size; i++ )
            {
                pq.add(lists[i]);
            }

            ListNode head = new ListNode();
            ListNode runner = head;
            while(pq.size() > 0)
            {
                ListNode temp = pq.poll();
                runner.next = new ListNode(temp.val);
                runner = runner.next;
//                ans.add(temp.val);

                if(temp.next!=null)
                    pq.add(temp.next);
            }

            return  head.next;

        }

}
