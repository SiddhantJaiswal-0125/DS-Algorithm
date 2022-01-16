import java.util.*;

public class test {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int cap = sc.nextInt();
         int vA, wA, vB, wB;
         vA = sc.nextInt();
         vB = sc.nextInt();
         wA = sc.nextInt();
         wB = sc.nextInt();
         double dA = vA / (double) wA;
         double dB = vB / (double) wB;
         long total = 0l;

         if (dA > dB) {
             total = cap / wA;
             total *= vA;
             cap %= wA;
             long total2 = 0l;
             if (cap > wB) {
                 total += ((cap / wB) * vB);
                 cap %= wB;
                 total2 = total - vA;
                 cap += wA;
                 total2 += ((cap / wB) * vB);
             }
             System.out.println(Math.max(total, total2));
         } else {
             total = cap / wB;
             total *= vB;
             cap %= wB;
             long total2 = 0l;
             if (cap > wA) {
                 total += ((cap / wA) * vA);
                 cap %= wA;
                 total2 = total - vB;
                 cap += wB;
                 total2 += ((cap / wA) * vA);
             }
             System.out.println(Math.max(total, total2));
         }
     }
}



