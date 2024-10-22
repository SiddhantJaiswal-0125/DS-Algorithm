// Question Link :https://leetcode.com/problems/palindrome-number/description/

class Solution {
    public boolean isPalindrome(int n) {
        int reverse = 0;
       
        int temp = n;
        while (temp != 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp = temp / 10;
        }
        
        return (reverse == n);     
    }

    public static void main(String args[])
    {
        Solution s = new Solution();
        System.out.println();
        System.out.println("Answer is "+s.isPalindrome(-121)); 
    }

}