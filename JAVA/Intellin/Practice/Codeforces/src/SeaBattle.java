import java.util.*;
public class SeaBattle
{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) 
    {
        solve();

    }
    static void solve()
    {
    
            long w1,h1,w2,h2;
            w1 = sc.nextLong();
            h1 = sc.nextLong();
            w2 = sc.nextLong();
            h2 = sc.nextLong();
            long peri = 2*((h1+h2) + (w1+2));
            System.out.println(peri);    
    }
}
