import java.util.*;


public class LetterCombination
{
    static class Solution {
        public List<String> letterCombinations(String digits) {
            String[] mapping = {
                    "", "", "abc", "def",  "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
            };
            List<String> res = new ArrayList<String>();
            if(digits.length()==0)
                return res;

            solve(digits, 0, mapping, res, new StringBuilder(""));


            return res;

        }
        void solve(String digits, int index , String [] map, List <String> res, StringBuilder asf)
        {
            if(index == digits.length())
            {
                res.add(new String(asf));
                return;
            }


            int dig = Integer.parseInt(""+digits.charAt(index));
            String s = map[dig];

            for(int i = 0;i<s.length();i++)
            {
                StringBuilder builder =new StringBuilder(asf);
                builder.append(s.charAt(i));
                solve(digits, index+1, map, res, builder);
            }



            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                pq.remove();
            return;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        List<String> res = new Solution().letterCombinations(in);
        System.out.println(res);
    }

}
