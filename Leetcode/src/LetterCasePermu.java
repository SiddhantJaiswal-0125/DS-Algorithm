import java.util.*;

public class LetterCasePermu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        List<String>  res = new LetterCasePermu().letterCasePermutation(s);
        System.out.println(res);

    }
    public List<String> letterCasePermutation(String s) {


        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        s = new String(s.toLowerCase());
        solve(0, s, sb, res);
        return res;

    }
    private void solve(int ind, String s, StringBuilder sb, List<String> res)
    {
        if(sb.length() == s.length())
        {
            res.add(sb.toString());
            return;
        }
        if(ind>=s.length())
            return;

        char ch = s.charAt(ind);
//        System.out.println("CHAR IS at ind  "+ind+" "+ch);


        if(ch>='0' &&  ch<='9')
        {
            sb.append(""+ch);
//            System.out.println("And Sb inside if "+sb+"  on index "+ind);
            solve(ind+1, s, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        else
        {
            sb.append(""+ch);
//            System.out.println("And Sb inside else "+sb+"  on index "+ind);
            solve(ind+1, s, sb, res);
            sb.deleteCharAt(sb.length()-1);
            char newch = (char) ((ch - 'a') + 'A');
            sb.append(""+newch);
//            System.out.println("And Sb inside else "+sb+"  on index "+ind);
            solve(ind+1, s, sb, res);
        sb =     sb.deleteCharAt(sb.length()-1);

            return;


        }

    }
}
