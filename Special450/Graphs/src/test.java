public class test {
    public static void main(String[] args) {
        int ar[] = {  3,0,8,1,12,8,9,2,13,10};

        int x,y,z;
        x= ++ar[2];
        y = ar[2]++;
        z = ar[x++];
        System.out.println(x+" "+y+" "+z);
    }
}
