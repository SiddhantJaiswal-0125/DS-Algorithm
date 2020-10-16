
//https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/




/* SOLUTION 1:   A simple solution is to sort the given array using a
O(N log N) sorting algorithm like Merge Sort, Heap Sort, etc
and return the element at index k-1 in the sorted array.*/



/*Method 2 (Using Min Heap – HeapSelect)
We can find k’th smallest element in time complexity better than O(N Log N).
A simple optomization is to create a Min Heap of the given n elements
 and call extractMin() k times.
 T(n) :O(n + kLogn).
 */


import java.util.PriorityQueue;
import java.util.Scanner;

public class KthMax_Min
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++)
                pq.add(sc.nextInt());

            for (int i = 0; i < k - 1; i++)
                pq.poll();
            System.out.println(pq.poll());

//            this code has Time Complexity of O(n+klogn)
        }




    }



}

