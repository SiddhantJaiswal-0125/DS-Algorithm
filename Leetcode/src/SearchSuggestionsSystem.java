import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchSuggestionsSystem
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String products[] = new String[n];
        for(int i=0; i<n; i++)
            products[i] = sc.next();
        String searchWord =  sc.next();


        List<List<String>> res = new SearchSuggestionsSystem().suggestedProducts(products, searchWord);
        System.out.println(res);

    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();

        int l = 0, r = products.length -1;
        for(int i = 0; i<searchWord.length(); i++)
        {
            char c = searchWord.charAt(i);
            while(l<=r && (products[l].length()<=i || products[l].charAt(i) !=  c ) )
                l+=1;

            while(l<=r && (products[r].length()<=i || products[r].charAt(i) !=  c ) )
                r-=1;

            int size = r-l+1;


            int count = 0;
            List<String> temp = new ArrayList<String>();
            for(int j = l; j<=r && count <3; j++,  count++)
                temp.add(products[j]);


            res.add(new ArrayList<>(temp));


        }
        return res;



    }
}
