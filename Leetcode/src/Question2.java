import java.io.BufferedReader;
import java.io.InputStreamReader;

class Question2 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the Number :");
        int n = Integer.parseInt(br.readLine());
        while(n<1 || n>7 )
        {
            System.out.println("Enter the Number between 1 to 7");
            n = Integer.parseInt(br.readLine());
        }
        String res = "";
        if(n==1)
        {
         res = "Violet";
        }
        else if(n==2)
        {
            res = "Indigo";

        }
        else if(n==3)
        {

            res = "Blue";
        }
        else if(n==4)
        {
            res = "Green";
        }
        else if(n==5)
        {
            res = "Yellow";

        }
        else if(n==6)
        {
            res = "Orange";
        }
        else if(n==7)
        {

            res = "Red";
        }


        System.out.println("Corresponding Colour is "+res);


    }


}

