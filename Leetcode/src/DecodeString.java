import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        String res = new DecodeString().decodeString(in);
        System.out.println(res);
    }
    public String decodeString(String s) {

        Stack<Character>  st = new Stack<>();
        int indx = 0;
        int size = s.length();

        while(indx <  size)
        {
            char ch = s.charAt(indx);
            if(ch == ']')
            {
                String inside = "";
                while(st.peek() != '[')
                    inside = st.pop() + inside;
                st.pop();
                //GET THE NUMBER
                String no = "";
                    while(st.size()>0 && st.peek()!='['&& st.peek() <='9' && st.peek()>='0')
                        no = st.pop()+no;

                    int num = Integer.parseInt(no);
                    String insideString = "";
                    for(int i =0;i<num;i++)
                        insideString += inside;
                    for(int i =0;i<insideString.length();i++)
                        st.push(insideString.charAt(i));
            }
            else
                st.push(ch);
          indx++;

        }
        String res = "";
        while(st.isEmpty() == false)
        {
            char t = st.pop();
            res = ""+t + res;
        }
        return  new String(res);

    }
    void print(Stack<Character>  st)
    {
        if(st.isEmpty())
            return;
        char c = st.pop();
        print(st);
        System.out.print(c);
    }






    boolean traversal (int si, int sj, int ei, int ej,
                       int mat[][], boolean vis[][] )
    {
        if(si==ei && sj==ej)
            return  true;
        if(si<0 ||sj<0 || si>=mat.length || sj>mat[si].length)
            return false;
        if(vis[si][sj] == true)
            return  false;
        vis[si][sj] = true;
        boolean checkUp =  traversal(si-1, sj, ei, ej, mat, vis);
        boolean checkDown =  traversal(si+1, sj, ei, ej, mat, vis);
        boolean checkLeft =  traversal(si, sj-1, ei, ej, mat, vis);
        boolean checkRight =  traversal(si, sj+1, ei, ej, mat, vis);
        vis[si][sj]= false;
        return checkUp|| checkDown || checkRight|| checkLeft;
    }
}
