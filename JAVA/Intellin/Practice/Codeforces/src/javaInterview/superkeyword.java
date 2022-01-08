package javaInterview;

public class superkeyword
{
     static void check1(){
        System.out.println("CHECK 1 in SUPERKEYWORD");
        return;

    };

    void check2()
    {
        System.out.println("CHECK 2 in SUPER KEYWORD");
        return;
    }

}
class test extends  superkeyword
{
   static void  check1()
    {

        System.out.println("CHECK 1 IN TEST");
//        super.check1();
    }
    void  check2()
    {
        System.out.println("CHECK 2 IN TEST");
    }
}

class run
{
    public static void main(String[] args) {
        superkeyword si = new test();

        si.check1();
        si.check2();

    }

}