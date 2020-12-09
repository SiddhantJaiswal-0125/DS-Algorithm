import java.util.*;

public class Common_Elements
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1,n2,n3,a[] ,b[],c[];
        n1 =  sc.nextInt();
        a = new int[n1];
        for(int i = 0;i<n1;i++)
            a[i] = sc.nextInt();
        n2 =  sc.nextInt();
        b = new int[n2];
        for(int i = 0;i<n2;i++)
            b[i] = sc.nextInt();
        n3 =  sc.nextInt();
        c = new int[n3];
        for(int i = 0;i<n3;i++)
            c[i] = sc.nextInt();

        ArrayList <Integer> ans = getAns(a,b,c,n1,n2,n3);
        System.out.println(ans);
    }
    static ArrayList<Integer> getAns(int a[],int b[],int c[],int n1,int n2,int n3)
    {
        int i=0,j=0,k=0;
       ArrayList ans = new ArrayList();
       HashSet<Integer> bag = new HashSet<>();
       while(i<n1 && j<n2&& k<n3)
        {
            if(a[i]==b[j] && b[j]==c[k] && !bag.contains(a[i]))
            {
                ans.add(a[i]);
                bag.add(a[i]);
            }
            else if(a[i]<b[j])
                i++;
            else if(b[j]<c[k])
                j++;
            else
                k++;








        }



       return ans;

    }
}
