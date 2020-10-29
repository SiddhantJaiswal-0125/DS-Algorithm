public class test1
{
    public static void main(String[] args) {
        String s1 = "ITER is my College";
        System.out.println("Input String : "+s1);
        s1 = s1.replaceAll("\\s","\t");
        System.out.println("Output String : "+s1);
    }
}
