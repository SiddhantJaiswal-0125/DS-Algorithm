import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        ArrayList<Integer> ans = getAns(n);
        for(int i : ans)
            System.out.print(i+" ");
        System.out.println();
    }
    public static ArrayList<Integer> getAns(int range) {
        int distance = 0;
        int nextNumber = 0;
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> numberMap = new HashMap<>();
        for (int i = 0; i < range; i++) {
            if (numberMap.containsKey(nextNumber)) {
                distance = i - numberMap.get(nextNumber);
            } else {
                distance = 0;
            }
            numberMap.put(nextNumber, i);
            res.add(nextNumber);
            nextNumber = distance;
        }
        return res;
    }
}