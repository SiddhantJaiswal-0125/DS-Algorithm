import java.util.Collections;
import java.util.PriorityQueue;

class Solution1 {
    public String frequencySort(String s) {
        int small[] = new int[26];
        int big[] = new int[26];
        int size = s.length();

        for (int i = 0; i < size; i++) {

            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z')
                small[c - 'a']++;
            else
                big[c - 'A']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if(small[i]>0)
            pq.add(new Pair(""+(char)('a'+i), small[i]));
            if(big[i]>0)
            pq.add(new Pair( ""+(char)( i+'A'), big[i]));
        }



        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {

            Pair p = pq.remove();
//            System.out.println(p.ch+ "\t" +p.freq);


            for (int i = 0; i < p.freq; i++) {
                sb.append("" + p.ch);
            }
        }
        return sb.toString();


    }

    class Pair implements Comparable<Pair> {
        String ch;
        int freq;
        Pair(String c , int f)
        {
            ch = c;
            freq = f;
        }
        public int compareTo (Pair oth)
        {
            if (this.freq > oth.freq)
                return -1;
            if (this.freq == oth.freq && this.ch.charAt(0) < oth.ch.charAt(0))
                return -1;
            return 1;
        }

    }


}