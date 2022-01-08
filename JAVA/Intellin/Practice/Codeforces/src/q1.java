class q1
{
    enum season
    {
a,b,c,d;
    }
    public static void main(String[] args) {

        StringBuffer t = new StringBuffer("HELLo");
        t.deleteCharAt(0);
        System.out.println(t);
        season s = season.a;
        System.out.println(s);
        String s1 = "Technology ";
        System.out.println(s1.substring(1,5));
        String s2 = "JAVA";
        System.out.println(s1.indexOf('k'));
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        String test= "a1b2c3";
        String to [] = test.split("\\d");
        for(String so : to )
            System.out.print(so);

    }
}