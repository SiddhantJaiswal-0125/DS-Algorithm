public class EqualsDemo
{
    static  int a= 10, b=20;
    int c ;
    EqualsDemo()
    {
        System.out.println("Adding 10 and 20");
        c = a+b ;
        System.out.println("answer is "+c);
    }

    public static void main(String[] args) {
        System.out.println("1st object created ");
        EqualsDemo obj1 = new EqualsDemo();
        System.out.println("2nd Object created");
        EqualsDemo obj2 = new EqualsDemo();
        EqualsDemo obj3 = obj1;
        System.out.println("Obj1 == Obj2 : "+obj1.equals(obj2));
        System.out.println("Obj1 == Obj3 : "+obj1.equals(obj3));

    }
}
