import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(7);
        a=plusOne(a);
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i));
        }
    }
    public static ArrayList<Integer> plusOne (ArrayList<Integer> A) {
        int n = A.size() - 1;
        A.set(n, A.get(n) + 1);
        for (int i = n; i > 0 && A.get(i) == 10; --i) {
            A .set (i , 0) ;
            A.set(i - 1, A.get(i - 1) + 1);
        }
        if (A.get (0) == 10) {
            A.set (0 , 0) ;
            A.add (0, 1);
        }
        return A ;
    }

}