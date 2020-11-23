import java.util.Scanner;

public class countVowelCon
{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        int vowel = 0,con = 0;
        s.toLowerCase();
        for(int i = 0;i<s.length();i++)
        {
            if(s.charAt(i)!=' ') {
                if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                    vowel++;
                else
                    con++;
            }
        }


        System.out.println("No of Vowels : "+vowel);
        System.out.println("No of Consonant : "+con);
    }
}
