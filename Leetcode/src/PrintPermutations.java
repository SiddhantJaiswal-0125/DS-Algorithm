    import java.util.Scanner;

    public class PrintPermutations
    {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            printPermutations(s, "");

            }
        public static void printPermutations(String str, String asf) {
            if(str.length()==0)
            {
                System.out.println(asf);
                return;
            }

            for(int i =0;i<str.length();i++)
            {
                String temp = str.substring(0, i) + str.substring(i + 1);
    //            System.out.println("TEMP is "+temp);
                printPermutations(temp ,asf+""+str.charAt(i));
            }

        }
    }
