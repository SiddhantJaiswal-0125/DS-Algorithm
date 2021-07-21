package StackQueue;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int num1[] = new int[n1];
        for(int i =0;i<num1.length;i++)
            num1[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int num2[] =  new int[n2];
        for(int i =0;i<n2;i++)
            num2[i] = sc.nextInt();
        int ans[] = new Solution().nextGreaterElement(num1, num2);
        for(int i : ans)
            System.out.print(i+"\t");
        System.out.println();

    }

}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        Stack<pair> st = new Stack<pair>();
        for(int i = nums2.length -1;i>=0;i--)
        {
            while(st.isEmpty()==false)
            {
                if(st.peek().ele > nums2[i])
                {


                    System.out.println(hmap);
                    break;
                }
                else
                    st.pop();
            }
            if(st.isEmpty())
                hmap.put(nums2[i], -1);


            st.push(new pair(nums2[i], i));
        }

        System.out.println(hmap);
        int ans [] = new int[nums1.length];

        for(int i =0;i<nums1.length;i++)
        {
            ans[i] = hmap.get(nums1[i]);
        }
        return ans;
    }
    static class pair{
        int ele, ind;
        pair(int a, int b)
        {
            ele = a;
            ind = b;
        }
    }
}