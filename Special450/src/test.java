import java.util.*;class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList <String> ar = new ArrayList<String>();
        String s = sc.next();
        ar.add(s);
        s= sc.next();
        ar.add(s);
        s= sc.next();
        ar.add(s);
        for(int i = 0;i<ar.size();i++)
        {
            System.out.print(ar.get(i)+" ");
        }
        System.out.println();
        sc.close();
    }
}
