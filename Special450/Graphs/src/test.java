public class test {
    public static void main(String[] args) {

       int x = 0b11011010;
       x =x ^(x>>4);
        System.out.println(Integer.toBinaryString(x));


    }
}
